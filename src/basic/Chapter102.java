package basic; // 102. 사용자 정의 예외와 예외 되던지기

/**
* [핵심 요약]
	1. 사용자 정의 예외 클래스
		- 개발자가 예외 클래스를 직접 만듬.
		- Exception 또는 RuntimeException을 상속받음.
		- 예외 메시지를 전달받는 생성자를 만들고, 생성자 내부에 `super(message);`필수 작성.
		
	2. 예외 되던지기
		- 예외를 메서드와 메서드호출자가 분담하여 처리하는 기법. [00:06:00]
		- 메서드측에서 catch 블럭 내에서 예외를 1차 처리한 후, 다시 `throw e;`를 사용하여 호출자에게 예외를 넘김.
*/

// 사용자 정의 예외 클래스 정의
class MyException extends Exception {
  private final int ERR_CODE; 

  MyException(String msg, int errCode) {
  	super(msg); 
  	this.ERR_CODE = errCode;
  }

  public int getErrCode() { return ERR_CODE; }
}

public class Chapter102 {
  public static void main(String[] args) {
  	// 2차 처리 (method 호출자)
  	try {
  	  method(); 
  	} catch (MyException e) {
  	  System.out.println("main에서 2차 처리 완료: " + e.getMessage());
  	}
  }

  static void method() throws MyException {
  	try {
  	  throw new MyException("MyException 발생!", 100); // MyException!
  	} catch (MyException e) {
  		// 메서드에서 1차처리
  	  System.out.println("method1에서 1차 처리: " + e.getMessage());
  	  throw e; // 예외 되던지기
  	}
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 상속 선택 가이드
		- RuntimeException을 상속받아 선택적으로 처리하게 만드는 것이 추세.


* [학습 포인트]
	- 사용자 정의 예외는 에러 메시지 커스텀뿐만 아니라
	  에러 코드 같은 추가 정보를 담을 수 있어 디버깅에 유리
*/