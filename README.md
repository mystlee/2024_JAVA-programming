## How to run it?   

### Replit에서 어떻게 하면 실행해볼 수 있을까?

1. chapter 또는 workspace 폴더 생성 (chapter마다 문제 풀이를 원한다면 chapter 추천!)
2. 해당 src/chapter 폴더에서 c코드 작성
   - 예시)   
├── chapter6   
│   ├── prob01   
│   ├── prob02   
│   ├── ...   
│   └── prob12   
├── main-debug   
├── Makefile   
├── replit.nix   
└── run.sh   
3. tool 중에 shell을 클릭하여, 터미널 접속
4. 터미널에서 ./run.sh 다음에 작성된 java코드 입력
   - 예시) java 코드가 단일인 경우   
     $ ./run.sh src/chapter6/prob01/StudentApp.java
   - 예시) java 코드가 package 등으로 여러개 존재하는 경우  
     $ ./run.sh chpater13/problem1.c
   - 예시) java 코드가 package 등으로 여러개 존재하며, main application이 무엇인지 지정해줘야하는 경우
     $ ./run.sh chpater13/problem1.c
     
<img src="./replit_example.png" width=“80%” height=“80%”>

