package basic; // 97. 프로그램 오류와 예외 클래스의 계층구조

/**
* [핵심 요약]
	1. 프로그램 오류의 종류 (00:00:23)
		- 컴파일 에러: 컴파일 시 오류.
		- 런타임 에러: 실행 시 오류, '에러'와 '예외'로 나뉨.
		- 논리적 에러: 실행은 되지만 의도와 다른 결과 (예: 갤러그에서 총알을 맞았는데 안 죽는 경우).
		
	2. 에러(Error) vs 예외(Exception)
		- 에러: 메모리 부족(OOM)처럼 프로그램 코드에 의해 수습될 수 없는 심각한 오류.
		- 예외: 프로그래머가 코드를 수정하여 수습할 수 있는 미약한 오류입니다.
*/

public class Chapter097 {
  public static void main(String[] args) {
  	// 런타임 에러 예시 (00:07:53)
  	try {
  	  System.out.println(args[0]);  // 컴파일은 성공하지만 실행 시 ArrayIndexOutOfBoundsException이 발생 
  	} catch (ArrayIndexOutOfBoundsException e) {
  	  System.out.println("매개변수를 입력하지 않아 예외가 발생했지만 수습되었습니다."); // 예외 처리
  	} 	
  }
}


/**
 * [예외 클래스의 계층 구조]
	- Exception 클래스들: 외적인 요인(파일 없음, 클래스 없음 등)으로 발생하며 반드시 처리가 필요(Checked).
	- RuntimeException 클래스들: 프로그래머의 실수(0으로 나누기, null 참조 등)로 발생하며 처리가 선택적(Unchecked).
	 	* ArithmeticException → 0으로 나누기
	 	* NullPointerException → null을 참조 ( String s = null;  s.length();)  
		* ClassCastException → 잘못된 형변환


 * [Gemini의 꼼꼼한 보충수업]
	1. 컴파일러의 역할 [00:05:39]
		- 문법 체크,
		  최적화(단순 계산 수행),
		  생략된 코드 추가(기본 생성자나 super() 등)
*/