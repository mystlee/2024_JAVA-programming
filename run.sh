#!/bin/bash

# 스크립트가 하나 이상의 인자를 받았는지 확인
if [ "$#" -lt 1 ]; then
    echo "사용법: $0 <source_file1.java> [source_file2.java ...]"
    exit 1
fi

# 모든 인자에 대해 반복
for SOURCE_FILE in "$@"; do
    # 파일이 존재하는지 확인
    if [ ! -f "$SOURCE_FILE" ]; then
        echo "오류: 파일 '$SOURCE_FILE'이(가) 존재하지 않습니다."
        continue
    fi

    # 파일 확장자가 .java인지 확인
    if [[ "$SOURCE_FILE" != *.java ]]; then
        echo "오류: '$SOURCE_FILE'은(는) Java 소스 파일이 아닙니다."
        continue
    fi

    # 파일의 디렉토리 경로 추출
    DIR_PATH=$(dirname "$SOURCE_FILE")

    # 파일 이름에서 확장자를 제외한 기본 이름 추출
    BASENAME=$(basename "$SOURCE_FILE" .java)

    echo "컴파일 중: $SOURCE_FILE..."

    # Java 소스 파일 컴파일
    javac "$SOURCE_FILE"

    # 컴파일이 성공했는지 확인
    if [ $? -ne 0 ]; then
        echo "오류: '$SOURCE_FILE'의 컴파일에 실패했습니다."
        continue
    fi

    echo "실행 중: $BASENAME"

    # 컴파일된 클래스 파일 실행
    # 클래스 파일이 있는 디렉토리로 이동하여 'java' 명령 실행
    (cd "$DIR_PATH" && java "$BASENAME")

    echo "-----------------------------------"
done
