package basic; // 113. 오토박싱 & 언박싱, 진법 변환

import java.util.ArrayList;

/**
* [강의 필기]
	1. 문자열을 숫자로 변환하는 방법 
		- `Integer.parseInt("100")`: 문자열을 기본형 int로 변환. (가장 많이 쓰임)
		- `Integer.valueOf("100")`: 문자열을 래퍼 클래스 Integer로 변환.
		- 오토박싱 덕에 아무거나 써도 결과는 같다.

	2. n진법 문자열 변환
		- parseInt("100", 2) → 2진수 "100"을 10진수 4로 변환
		- parseInt("100", 8) → 8진수 "100"를 8진수 64로 변환
		- parseInt("FF", 16) → 16진수 "FF"를 10진수 255로 변환

	3. 오토박싱(Autoboxing) & 언박싱(Unboxing) 
		- 오토박싱: int -> Integer
		- 언박싱: Integer -> int
		- 원칙대로면 기본형과 참조형은 연산 불가, 하지만 컴파일러가 중간에 코드를 자동으로 추가해주는 거야.
*/

public class Chapter113 {
  public static void main(String[] args) {
  	// 진법 변환 실습
  	int x = Integer.parseInt("100", 2); // 100을 2진수로
  	int y = Integer.parseInt("FF", 16); // FF를 16진수로
  	System.out.println(x); 							// 4
  	System.out.println(y);							// 255

  	// 오토박싱 & 언박싱 예시
  	Integer a = 100; // 오토박싱 → 원래는 Integer a = new Integer(100);
  	int b = a;       // 언박싱 → 원래는 a.intValue();
  	
  	// 참조형과 기본형의 연산이 가능해짐!
  	int result = a + b; // 컴파일러가 a를 언박싱해서 더해줌 → a.intValue() + b
  	System.out.println(result); // 200

  	// ArrayList(가변 배열)에서의 활용 (<Integer>는 '제네릭'이라고 하며, 가변배열의 데이터의 타입을 지정)
  	ArrayList<Integer> list = new ArrayList<>(); // ArrayList<Integer>는 Integer타입만 받는 가변배열 이라는 뜻
  	list.add(10); // 오토박싱: list.add(new Integer(10))과 같음 , ArrayList는 객체만 담을 수 있다.
  	
  	int value = list.get(0); // 언박싱: list.get(0).intValue()와 같음, ArrayList의 값을 불러오는 메서드 = ArrayList.get(n)
  	System.out.println(value);  // 10
  }
}

/**
* [Gemini의 보충수업]
	1. 왜 오토박싱을 만들었을까?
		- 개발자가 일일이 `intValue()`를 호출하거나 객체를 생성하는 번거로움을 줄여주기 위해서.
		- 코드가 훨씬 간결해지고 가독성을 위해서.

	2. 주의할 점
		- `parseInt("FF", 10)`처럼 진법에 맞지 않는 문자가 포함되면 `NumberFormatException` 에러 발생.

	3. 성능 고려
		- 오토박싱은 편리하지만, 루프 안에서 수만 번 일어나면 객체를 계속 생성하느라 성능이 느려질 수 있다. 
		- 아주 정밀한 성능이 필요한 구간에선 기본형을 직접 쓰는 게 좋다.

	4. 컴파일러의 마법
		- Integer i = 10; 이라고 쓰면, 컴파일러는 Integer i = Integer.valueOf(10); 로 코드를 바꿔서 실행. 
		- 자바 언어 자체의 규칙을 깬 게 아니라, 기계가 대신 일해주는 거라고 생각하면 됌.
*/