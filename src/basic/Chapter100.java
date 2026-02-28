package basic; // 100. 예외 발생시키기와 예외의 종류(Checked/Unchecked)

/**
* [핵심 요약]
	1. 예외 발생시키는 방법
		- Exception e = new Excetion("예외 발생") 
		- RuntimeException e = new RuntimeException("예외 발생")
		- throw e
		
	2. Checked 예외 vs Unchecked 예외 
		- Checked 예외 → Exception 클래스들
		- Unchecked 예외 → RuntimeException 클래스들
*/

public class Chapter100 {
  public static void main(String[] args) {
  	/**
  	Unchecked 예외 예시 (컴파일은 성공, 런타임 시 예외발생)
  	
  	throw new RuntimeException("런타임 예외 발생시키기");
  	*/
  	
  	// Checked 예외 예시 (컴파일 시 예외발생, try-catch 강제)
  	try {
  	  Exception e = new Exception("컴파일 예외 발생시키기");
  	  throw e; 
  	} catch (Exception e) {
  	  System.out.println(e.getMessage()); // 컴파일 예외 발생시키기
  	  System.out.println("----------------"); 
  	  e.printStackTrace();
  	}

  	System.out.println("예외처리 후 프로그램 정상 종료"); 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 한 줄로 예외 던지기
		- throw new Exception("Exception 에러 발생");


 * [학습 포인트]
	- Checked는 컴파일러가 체크하는 예외, Unchecked는 체크 안하는 예외.
	- 실무에서는 비즈니스 로직에 맞게 적절한 예외를 골라 직접 던지는(throw) 기술이 자주 쓰임.
*/