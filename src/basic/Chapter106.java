package basic; // 106. String클래스, 문자열 비교, 빈 문자열

/**
* [강의 필기]
	1. String 클래스의 구조 
		- 데이터(char 배열)와 문자열 관련 메서드가 결합된 형태.
		- 내부적으로 `private final char[] value;`를 가지고 있어 문자열을 저장.

	2. 불변 클래스 (Immutable Class)
		- 한 번 생성된 String 인스턴스가 가진 내용(문자열)은 변경할 수 없다.
		- 문자열 결합(`+`) 시, 기존 문자열이 바뀌는 것이 아니라 완전히 새로운 문자열 객체가 생성.
		- 단점: 잦은 문자열 결합은 새로운 객체를 계속 만들어 성능을 떨어뜨림.
		- 해결: 문자열 변경이 잦은 경우 `StringBuffer`나 `StringBuilder`를 사용.

	3. 문자열 리터럴 vs new String 연산자
		- String s = "abc" : 이미 같은 내용("abc")이 있으면 주소값을 공유. (s1 = "abc", s2 = "abc" 이면 s1,s2는 같은 주소값을 공유)
		- String s = new String("abc") : 항상 새로운 객체를 힙 메모리에 생성. (s1,s2를 이 방식대로 만들면 s1,s2는 다른 주소값을 갖음)
		- 따라서 문자열 비교 시 반드시 `equals()`로 비교.

	4. 문자열 리터럴
		- 프로그램 실행 시 클래스 파일 내의 모든 리터럴은 '상수풀(Constant Pool)'에 자동 생성. [00:11:19]
		- 불변성 덕분에 여러 참조 변수가 안전하게 하나의 문자열을 공유할 수 있다. [00:12:32]

	5. 빈 문자열 (Empty String) (00:13:52)
		- 길이가 0인 배열을 포함하는 문자열입니다. (`""`)
		- 초기화 시 `null`보다는 빈 문자열이나 공백을 사용하는 것이 권장
*/

public class Chapter106 {
  public static void main(String[] args) {
  	// 문자열 결합의 비밀
  	String a = "a";
  	String b = "b";
  	a = a + b; // "a"가 "ab"로 바뀌는 게 아니라, 새 객체 "ab"가 만들어지고 a가 이를 가리킴
  	System.out.println("결합된 a: " + a);

  	// 2. 리터럴 vs new 비교
  	String str1 = "abc";
  	String str2 = "abc";
  	System.out.println(str1 == str2);      // true (주소 같음 - 공유)
  	System.out.println(str1.equals(str2)); // true (내용 같음)

  	String str3 = new String("abc");
  	String str4 = new String("abc");
  	System.out.println(str3 == str4);      // false (주소 다름 - 매번 생성) 
  	System.out.println(str3.equals(str4)); // true (내용 같음)

  	// 3. 빈 문자열과 초기화
  	String s = ""; // 빈 문자열로 초기화
  	char c = ' ';  // 공백으로 초기화
  	
  	// [실무 금지] new 연산자로 문자열 생성 금지 (불필요하게 객체를 계속 생성)
  	String s_bad = new String("");
  }
}

/**
* [Gemini의 보충수업]
	1. '불변(Immutable)'은 왜 좋은가요?
		- 여러 사람이 같은 "abc"를 공유하고 있을 때 한 명만 내용을 바꿔도 모두의 값이 바뀌어 버리는 대참사를 막아줌. 
		  이는 메모리 절약과 멀티쓰레드 환경에서의 안전성으로 이어짐.

	2. 리터럴이 저장되는 공간, 상수풀(Constant Pool)
		- 자바는 메모리 효율을 위해 "똑같은 문자열 리터럴은 딱 하나만 만들자"는 전략을 쓴다. 
		- `String s1 = "Hi"`, `String s2 = "Hi"`는 힙 메모리 안의 특수한 구역인 '상수풀'에 있는 같은 객체를 바라보게 된다.

	3. 실무에서의 문자열 결합 팁
		- 간단한 한두 번의 `+` 연산은 자바 컴파일러가 알아서 최적화해주기도 하지만, 
		  `for`문 같은 반복문 안에서 `+`로 문자열을 붙이는 행위는 절대 금물! 
		- 반복문 안에서는 무조건 `StringBuilder`를 써서 메모리 낭비를 막는다. (면접 단골 질문!!)

	4. 빈 문자열 vs null
		- 문자열을 'null'로 초기화하면 s.length()를 호출할 때 NullPointerException이 터질 위험이 큼. 
		- 문자열을 '빈 문자열'로 초기화하면 s.length()를 호출해도 에러 없이 안전하게 동작하기 때문에 실무에서는 빈 문자열 초기화를 선호합니다.

	5. 주소 비교(==)는 잊어버리세요
		- 비즈니스 로직에서 주소가 같은지 궁금할 일은 거의 없다.
		  우리가 궁금한 건 항상 '글자 내용'이 같은지이므로, 문자열 비교는 무조건 `equals()`라고 머리에 새겨두자!
*/