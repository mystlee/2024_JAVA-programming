import java.util.Scanner;

public class WordShuffleGame {
	private String words [] = { "vibrate", "extract", "nation", "connect", 
			"lovely", "present", "everyday", "terminate", "sunny", "cookie",
			"march", "break"};

	public WordShuffleGame() { }
	
	private String shuffle(String src) {
		char [] chars = src.toCharArray();

		while(true) { // 셔플하여 만든 단어가 우연히도 src와 같은 경우를 위한 루프
			// 2쌍을 랜덤하게 바꾼다. 바꾸는 개수가 많을수록 맞추기 힘드는 단어 생성됨
			for(int k=0; k<2; k++) {
				int i = (int)(Math.random()*chars.length);
				int j = (int)(Math.random()*chars.length);
				char c = chars[i];
				chars[i] = chars[j];
				chars[j] = c;
			}
			String shuffledWord = new String(chars);
			if(shuffledWord.equals(src)) // 셔플된 단어가 만일 같다면 다시 셔플한다.
				continue;
			else
				return shuffledWord;
		}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("10초 안에 단어를 맞추세요!!");
		while(true) {
			int index = (int)(Math.random()*words.length);
			String answerWord = words[index];
			String queryWord = shuffle(answerWord);
			System.out.println(queryWord);
			System.out.print(">>");
			String user = scanner.next();
			if(user.equals("그만"))
				break;
			if(user.equals(answerWord))
				System.out.println("성공!!!");
			else
				System.out.println("실패!!! " + answerWord + " 입니다.");				
		}
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		WordShuffleGame game = new WordShuffleGame();
		game.run();
	}

}
