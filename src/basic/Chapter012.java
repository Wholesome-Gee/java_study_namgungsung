package basic; // 12. 변수의 타입(기본형 8가지)

/**
* [변수 타입 핵심 가이드]
	1. 변수 타입의 정의 
    - 하나의 변수에는 타입이 일치하는 하나의 값만 저장할 수 있습니다. 
    - int 타입 변수에 실수(3.14)를 저장하려고 하면 에러가 발생합니다.
	2. 기본형(Primitive Type) 8가지
    - 논리형: boolean (True/False 저장)
    - 문자형: char (문자 하나 저장)
    - 정수형: byte, short, int, long (숫자 크기에 따라 선택, 주로 int 사용)
    - 실수형: float, double (소수점 있는 숫자, 주로 double 사용)
	3. 값의 종류와 타입 매칭 
    - 문자: '가', 'A' -> char 
    - 정수: 10, -100 -> int (가장 일반적)
    - 실수: 3.14, -0.1 -> double
    - 참/거짓: true, false -> boolean
*/

public class Chapter012 {
  public static void main(String[] args) {
  	int age = 25; // 정수형
  	double pi = 3.14; // 실수형
  	char ch = 'A'; // 문자형
  	boolean isTrue = true; // 논리형

  	System.out.println(age);
  	System.out.println(pi);
  	System.out.println(ch);
  	System.out.println(isTrue);
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
   1. 왜 타입을 나눠서 쓰나요?
 	    - 컴퓨터 메모리를 효율적으로 쓰기 위해서입니다. 
 	    	작은 숫자는 작은 그릇(byte)에,
 	    	큰 숫자는 큰 그릇(long)에 담는 것이죠.
 	    	하지만 요즘은 보통 정수는 int, 실수는 double을 표준처럼 사용합니다.
 	 2. 정수형이 4개나 되는 이유 
 	    - 메모리가 귀하던 시절에는 아주 작은 숫자(byte)부터 큰 숫자(long)까지 세밀하게 나눠서 썼습니다. 
 	    	지금은 CPU가 가장 효율적으로 처리하는 'int'를 주로 쓴다는 점만 기억하세요!
 	 3. 실수형의 선택
 	    - float보다 double이 더 정밀하게 숫자를 표현할 수 있어서 기본적으로 double을 많이 사용합니다.
 	 4. boolean은 스위치와 같습니다
 	    - 불이 켜졌는지(true), 꺼졌는지(false)처럼 딱 두 가지 상태만 저장할 때 사용합니다. 
 	    	나중에 조건문을 배울 때 아주 중요하게 쓰일 거예요!
 */