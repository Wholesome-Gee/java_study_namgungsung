package basic; // 101. 예외 선언하기와 finally 블럭

/**
* [핵심 요약]
	1. 메서드에 예외 선언하기 (예외처리 떠넘기기)
		- `throws` 키워드를 사용하여 메서드 호출 시 발생할 수 있는 예외를 미리 알리는 것.
		  즉, 호출한 메서드에게 예외 처리를 떠넘기는것.
		- Checked 예외는 반드시 선언하거나 처리해야 하며, Unchecked 예외는 생략하는 것이 정석.
		
	2. 예외 처리의 3가지 전략
		- 직접 처리: try-catch 문을 사용하여 그 자리에서 해결.
		- 떠넘기기: `throws`를 통해 호출자가 처리.
		- 은폐(무시): catch 블럭을 비워두어 예외를 무시(권장되지 않음).
		
	3. finally 블럭
		- 예외 발생과 관계없이 무조건 실행하는 코드를 작성.
		- 주로 자원 반납(파일 닫기, 네트워크 연결 해제 등)과 같은 마무리 작업에 사용.
*/

public class Chapter101 {
  public static void main(String[] args) {
  	// method이 throws한 예외를 try-catch로 처리
  	try {
  	  method(); 
  	} catch (Exception e) {
  	  System.out.println(e.getMessage());
  	} finally {
  	  System.out.println("마무리 작업 실행");
  	}
  }

  // 예외를 호출한 쪽(main)으로 throws
  static void method() throws Exception {
  	System.out.println("method() 실행 중...");
  	throw new Exception("Exception 예외 발생");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. Throws vs Throw 
		- `throw`: 예외를 발생시킬 때 사용
		- `throws`: 메서드 선언부에 사용, 예외를 떠넘기는 용도
		
	2. finally 블럭의 장점
		- try 블럭과 catch 블럭에 중복으로 들어가는 마무리 코드를 하나로 합쳐 코드 중복을 제거.
*/