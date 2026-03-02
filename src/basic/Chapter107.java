package basic; // 107. String 생성자와 메서드

import java.util.Date;

/**
* [강의 필기]
	1. String 생성자
		- `String(char[] value)`: 캐릭터 배열을 문자열로 바꿀 때 씀.
		- `String(StringBuffer sb)`: StringBuffer를 `String`으로 바꿀 때 씀.

	2. 문자 추출 및 비교 메서드
		- str.charAt(int index): 지정된 위치의 문자 하나를 가져옴. 
		- str.compareTo(str2): 두 문자열을 사전순으로 비교. 같으면 0, 왼쪽이 작으면 음수, 오른쪽이 작으면 양수 반환.
		- str.equals(obj): 두 문자열의 내용 비교 
		- str.equalsIgnoreCase(str2): 두 문자열의 내용 비교 (대소문자 무시)

	3. 문자열 탐색 및 검사 메서드
		- str.contains(str2): 지정된 문자열이 포함되어 있는지 검사 (true/false).
		- str.startsWith(str2): 특정 문자열로 시작하는지 검사.
		- str.endsWith(str2): 특정 문자열로 끝나는지 검사.
		- str.indexOf(char): 앞에서부터 문자의 위치 탐색. 없으면 -1.  
		- str.indexOf(str): 앞에서부터 문자의 위치 탐색. 없으면 -1. 
		- str.lastIndexOf(int ch)`: 뒤에서부터 문자의 위치 탐색. 인덱스 번호는 원래대로 고정.

	4. 문자열 조작 및 변환 메서드 
		- str.length(): 문자열의 길이를 반환.
		- str.replace(char, char2): 기존 문자(char)를 다른 문자(char2)로 바꾼 '새 문자열' 반환.
		- str.split(","): 정규식(구분자)을 기준으로 문자열을 잘라 배열에 담음.
		- str.substring(2, 5): index 2부터 5전까지 잘라냄.
		- str.toLowerCase(): 소문자로 변환.
		- str.toUpperCase(): 대문자로 변환.
		- str.trim(): 문자열 양 끝의 공백 제거 (가운데 공백은 안 건드림).

	5. 기본형 변환
		- String.valueOf(): 모든 기본형(int, boolean 등)을 문자열로 변환. `+ ""` 보다 성능이 약간 더 빠름.
*/

public class Chapter107 {
  public static void main(String[] args) {
  	// 1. char 배열을 String으로 변환
  	char[] cha = {'a', 'p', 'p', 'l', 'e'};
  	String apple = new String(cha); 
  	String fruits = "apple,banana,cherry";

  	// 문자 추출 및 비교 메서드
  	System.out.println(apple.charAt(0)); // 'a'
  	System.out.println(apple.compareTo("apple")); // 0
  	System.out.println(apple.compareTo("bpple")); // -1
  	System.out.println(apple.compareTo("Apple")); // 32
  	System.out.println(apple.compareTo("Bpple")); // 31
  	System.out.println(apple.equals("apple")); // true
  	System.out.println(apple.equals("Apple")); // false
  	System.out.println(apple.equalsIgnoreCase("Apple")); // true
  	
  	// 문자열 탐색 및 검사 메서드
  	System.out.println(apple.contains("apple")); // true
  	System.out.println(apple.startsWith("ap")); // true
  	System.out.println(apple.endsWith("ple")); // true
  	System.out.println(apple.indexOf("p")); // 1
  	System.out.println(apple.indexOf("ple")); // 2
  	System.out.println(apple.lastIndexOf("p")); // 2
  	
  	// 문자열 조작 및 변환 메서드
  	System.out.println(apple.length()); // 5
  	System.out.println(apple.replace("pp","ff")); // affle
  	System.out.println(fruits.split(",")); // "apple,banana,cherry" → {"apple","banana","cherry"}
  	System.out.println(fruits.split(",")[0]); // apple
  	System.out.println(fruits.split(",")[1]); // banana
  	System.out.println(fruits.split(",")[2]); // cherry
  	System.out.println(apple.substring(1)); // pple
  	System.out.println(apple.substring(1,4)); // ppl
  	System.out.println(apple.toUpperCase()); // APPLE
  	System.out.println("APPLE".toLowerCase()); // apple
  	System.out.println("  AP PLE  ".trim()); // AP PLE (가운데 제외 공백제거) 
  	
  	// 기본형 변환
  	System.out.println(String.valueOf(true)); // "true"
  	System.out.println(String.valueOf(100L)); // "100"
  	System.out.println(String.valueOf(100.0f)); // "100.0"
  }
}

/**
* [Gemini의 보충수업]
	1. CharSequence란 또 뭐야?
		- `contains`나 `replace`의 매개변수 타입은 `CharSequence`라고 되어 있다.
		  charSequence는 인터페이스인데, `String`, `StringBuffer`, `StringBuilder` 타입들을 하나로 묶어준다. 
			( *인터페이스의 장점 : 관계없는것들을 관계지어준다 )

	3. split() 사용 시 주의점
		- `split`의 매개변수는 '정규식(regex)'이다.
		- str.split(".") 이라고 쓰면 정규식에서 점은 "모든 문자"를 의미하기 때문에 원하는 대로 안 잘린다. 
		  이럴 땐 str.split("\\.") 처럼 이스케이프 처리를 해줘야 한다.

	4. 실무 꿀팁: valueOf() vs + "" 
		- `10 + ""` 처럼 빈 문자열을 더해서 숫자를 문자로 바꾸는 게 코드 짜기엔 훨씬 편하지만 
		  성능은 `String.valueOf(10)`이 미세하게 더 빠르다. 
		- 엄청난 양의 데이터를 처리하는 루프 안이라면 `valueOf()`를 쓰고, 일반적인 상황에선 가독성 좋은 쪽을 택하면 된다.

	5. compareTo()는 언제 써?
		- 단순히 "둘이 같냐?"를 물을 땐 `equals()`를 쓰면 되지만, "누가 더 앞에 있냐(정렬)?"를 따질 땐 `compareTo()`가 필수.
		- 데이터 정렬(Sorting) 기능을 직접 구현할 때 이 메서드를 아주 요긴하게 쓰게 된다.
*/