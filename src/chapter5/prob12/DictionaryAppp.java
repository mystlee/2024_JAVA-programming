abstract class PairMap {
	protected String keyArray []; // 키 문자열을 저장하는 배열
	protected String valueArray []; // 값 문자열을 저장하는배열
	abstract public String get(String key); // key 값으로 value 검색
	abstract public void put(String key, String value); // key와 value를 쌍으로 저장. 
							// key가 이미 저장되어 있으면 값을 value로 수정
	abstract public String delete(String key); // key 값을 가진 아이템(value와 함께) 삭제. 
							// 삭제된 value 값 리턴
	abstract public int length(); // 현재 저장된 아이템 개수 리턴
}

class Dictionary extends PairMap {
	protected int count = 0; // 현재 저장된 아이템의 개수
	
	public Dictionary(int capacity) { // 생성자. 내부 배열 생성
		keyArray = new String [capacity];
		valueArray = new String [capacity];
	}
	
	@Override
	public String get(String key) {
		for(int i=0; i<count; i++) { // 현재 배열에 저장된 원소 개수만큼 반복
			if(keyArray[i].equals(key)) // 저장된 키가 있으면
				return valueArray[i]; // 값 리턴
		}
		return null; // key를 발견할 수 없다면 null 리턴
	}

	@Override
	public void put(String key, String value) {
		int i=0;
		// key가 이미 배열에 존재하는지 검사
		for(i=0; i<count; i++) { // 현재 배열에 저장된 원소 개수만큼 반복
			if(keyArray[i].equals(key))	{
				break;  // 현재 배열에 이미 key가 존재함
			}
		}

		// i는 key가 발견된 배열의 인덱스거나 현재 최종 저장된 아이템의 다음 인덱스
		if(i == count) { // key를 배열에 존재하지 않는다면 
			if(i < keyArray.length) { // 배열이 꽉차지 않은 경우에만 저장, count 값 증가
				keyArray[i] = key;
				valueArray[i] = value;
				count++;
			}
			// key가 배열에 존재하지 않지만, 배열이 꽉 찬 경우, 그냥 리턴
		}
		else { // key를 발견하고 value가 수정되는 경우, count는 증가시키지 않는다.
			keyArray[i] = key;
			valueArray[i] = value;			
		}
	}

	@Override
	public String delete(String key) { // 배열에서 key를 검색하고 값과 함께 삭제
		int i=0;
		// key가 이미 배열에 존재하는지 검사
		for(i=0; i<count; i++) { // 현재 배열에 저장된 원소 개수만큼 반복
			if(keyArray[i].equals(key))
				break; // 현재 배열에 이미 key가 존재함
		}

		if(i==count) // 발견 안됨
			return null;
		
		String value = valueArray[i];
		
		// 앞으로 한 자리씩 이동
		int last = count-1;
		for(int j=i; j<last; j++) {
			keyArray[j] = keyArray[j+1];
			valueArray[j] = valueArray[j+1];
		}
		
		count--;
		return value;
	}

	
	@Override
	public int length() { return count; }

}

public class DictionaryAppp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정		
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");		
		System.out.println("황기태의 값은 " + dic.get("황기태"));	
	}

}
