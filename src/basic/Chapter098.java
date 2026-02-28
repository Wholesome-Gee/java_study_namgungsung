package basic; // 98. 예외 처리하기 - try-catch문의 흐름

/**
* [핵심 요약]
	1. try-catch 문법

	2. Exception 클래스의 활용 (00:10:31)
		- Exception은 모든 예외의 최고 조상, 
			어떤 예외든 다 처리할 수 있기에 마지막 catch 블럭에 두어 예상치 못한 에러를 방어
*/

public class Chapter098 {
  public static void main(String[] args) {
  	System.out.println(1);
  	System.out.println(2);

  	try {
  	  System.out.println(3);
  	  System.out.println(0 / 0); // ArithmeticException 발생!
  	  System.out.println(4); 		 // 실행되지 않음
  	} catch (ArithmeticException ae) {
  	  System.out.println(5);
  	} catch (Exception e) {
  	  // Exception이 처리되지 않은 모든 예외를 처리 (마지막에 위치)
  	  System.out.println("Exception");
  	}

  	System.out.println(6); // try-catch 문을 빠져나와 정상 실행
  }
}

/**
* [학습 포인트]
	- 실무에서는 catch 블럭을 비워두지 말고, 최소한 에러 로그라도 남기는 것이 중요.
*/