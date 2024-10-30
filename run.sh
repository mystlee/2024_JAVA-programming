#!/bin/bash

# 스크립트가 최소 하나 이상의 인자를 받았는지 확인
if [ "$#" -lt 1 ]; then
    echo "사용법:"
    echo "  $0 <source_file1.java> [source_file2.java ...] [MainClass]"
    echo "예시 1 (메인 클래스명 자동 지정):"
    echo "  $0 /path/to/FirstFile.java /path/to/SecondFile.java"
    echo "예시 2 (메인 클래스명 수동 지정):"
    echo "  $0 /path/to/ColorPoint.java /path/to/PositivePoint.java PositivePoint"
    exit 1
fi

# 모든 인자를 배열로 저장
ARGS=("$@")

# 마지막 인자를 확인하여 .java 파일인지 검사
LAST_ARG="${ARGS[-1]}"
if [[ "$LAST_ARG" == *.java ]]; then
    # 마지막 인자가 .java 파일인 경우
    MAIN_CLASS=""
    # 모든 인자를 소스 파일로 설정
    SOURCE_FILES=("${ARGS[@]}")
    # 최소 하나의 소스 파일이 있어야 함
    if [ "${#SOURCE_FILES[@]}" -lt 1 ]; then
        echo "오류: 최소 하나 이상의 .java 파일이 필요합니다."
        exit 1
    fi
    # 첫 번째 소스 파일의 기본 이름을 메인 클래스로 설정
    FIRST_SOURCE_FILE="${SOURCE_FILES[0]}"
    BASENAME=$(basename "$FIRST_SOURCE_FILE" .java)
    MAIN_CLASS="$BASENAME"
else
    # 마지막 인자가 .java 파일이 아닌 경우, 메인 클래스명으로 설정
    MAIN_CLASS="$LAST_ARG"
    # 나머지 인자들을 소스 파일로 설정
    SOURCE_FILES=("${ARGS[@]:0:$#-1}")
    # 최소 하나의 소스 파일이 있어야 함
    if [ "${#SOURCE_FILES[@]}" -lt 1 ]; then
        echo "오류: 최소 하나 이상의 .java 파일이 필요합니다."
        exit 1
    fi
fi

# 클래스파일을 저장할 디렉토리 설정 (예: 컴파일된 .class 파일을 out 디렉토리에 저장)
OUTPUT_DIR="./out"

# 출력 디렉토리가 존재하지 않으면 생성
mkdir -p "$OUTPUT_DIR"

# 모든 소스 파일이 존재하고 .java 확장자인지 확인
for SOURCE_FILE in "${SOURCE_FILES[@]}"; do
    if [ ! -f "$SOURCE_FILE" ]; then
        echo "오류: 파일 '$SOURCE_FILE'이(가) 존재하지 않습니다."
        exit 1
    fi
    if [[ "$SOURCE_FILE" != *.java ]]; then
        echo "오류: '$SOURCE_FILE'은(는) Java 소스 파일이 아닙니다."
        exit 1
    fi
done

# 모든 소스 파일 컴파일
echo "컴파일 중..."
javac -d "$OUTPUT_DIR" "${SOURCE_FILES[@]}"
# 컴파일 성공 여부 확인
if [ $? -ne 0 ]; then
    echo "오류: 컴파일에 실패했습니다."
    exit 1
fi

# 메인 클래스 실행
echo "실행 중: $MAIN_CLASS"
java -cp "$OUTPUT_DIR" "$MAIN_CLASS"

echo "-----------------------------------"
