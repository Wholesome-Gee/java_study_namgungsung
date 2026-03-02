package basic; // 112. 래퍼 클래스와 Number 클래스

/**
* [강의 필기]
	1. 래퍼 클래스란?
		- 8개의 기본형데이터를 객체로 감싸는 클래스야.
		- 자바는 객체지향 언어지만 성능 때문에 기본형을 남겨둠, 가끔 객체만 받는 메서드 등을 쓸 때 필요.
		- 종류: Boolean, Byte, Short, Character, Integer, Long, Float, Double

	2. 특징
		- 객체이므로 생성 시 힙(Heap) 메모리에 저장.
		- equals()가 오버라이딩 되어 있어서 주소가 아닌 객체간의 '내용(값)'을 비교할 수 있다.
		- toString()이 오버라이딩 되어 있어 객체의 값을 문자열로 바로 반환.
		- MAX_VALUE,  MIN_VALUE,  SIZE,  TYPE 같은 유용한 상수들을 가지고 있다.

	3. Number 클래스
		- 모든 숫자 관련 래퍼 클래스(Byte, Short, Integer, Long, Float, Double)의 조상.
		- 추상 클래스이며, 객체의 값을 기본형으로 변환하는 메서드들을 정의하고 있음.
		- 메서드 예: intValue(),  longValue(),  floatValue(),  doubleValue()

	4. 큰 숫자 다루기
		- BigInteger: long으로도 부족한 아주 큰 정수를 다룰 때 사용. [00:09:59]
		- BigDecimal: double의 정밀도를 넘어서는 아주 정확한 실수를 다룰 때 사용. [00:10:21]
*/

public class Chapter112 {
  public static void main(String[] args) {
  	// 래퍼 클래스 생성 
  	Boolean a = new Boolean(true);
  	Byte b = new Byte((byte)10);
  	Short c = new Short((short)10);
  	Character d = new Character('a');
  	Integer e = new Integer(100);
  	Long f = new Long(100);
  	Float g = new Float(100);
  	Double h = new Double(100);

  	// 비교 연산 
  	Integer x = new Integer(10);
  	Integer y = new Integer(11);
  	System.out.println(x == y);        		// false (주소 비교)
  	System.out.println(x.equals(y));  	  // true (값 비교)
  	System.out.println(x.compareTo(y)); 	// 0 (같으면 0, x가 더 크면 양수, x가 더 작으면 음수)
  	
  	// 래퍼 클래스 특징
  	System.out.println(x); 								// println 내부에서 자동으로 x.toString()으로 바뀜.
  	System.out.println(Boolean.TYPE);					// boolean
  	System.out.println(Integer.MAX_VALUE);		// Integer 최대값 출력
  	System.out.println(Integer.MIN_VALUE);		// Integer 최소값 출력
  	System.out.println(Integer.SIZE);					// 32 → 4byte = 32bits

  	// Number 클래스의 메서드 (객체 -> 기본형)
  	Integer age = new Integer(33);	// age는 Integer 인스턴스
  	int value = age.intValue(); 		// age의 int 값을 value에 담는다.
  	System.out.println(value);			// 33
  }
}

/**
* [Gemini의 보충수업]
	1. 왜 다 객체로 안 만들었을까?
		- 객체는 생성할 때 메모리도 많이 쓰고, 참조 변수를 통해 찾아가는 단계가 하나 더 있어서 기본형보다 느린 속도 때문.

	2. compareTo()는 어디에 써? 
		- "누가 더 큰가?"를 따져서 정렬하는 작업에선 compareTo()가 필수.

	3. BigInteger / BigDecimal 맛보기 (00:09:23)
		- 일반적인 금융 프로그램이나 우주 공학처럼 오차가 절대 허용 안 되거나 숫자가 엄청나게 커지는 곳에서 쓰임. 
		- 얘네는 연산자(`+`, `-`)를 못 쓰고 메서드(`.add()`, `.subtract()`)를 써야 한다.

	4. Wrapper의 불변성
		- String처럼 래퍼 클래스들도 한 번 값이 정해지면 바꿀 수 없다. 
		- 값을 바꾸고 싶으면 새로운 객체를 생성해야 한다.
*/