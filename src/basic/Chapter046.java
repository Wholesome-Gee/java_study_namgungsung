package basic; // 46. 커맨드 라인 입력받기

/**
* [핵심 요약]
	1. 커맨드 라인 입력(Command Line Input) (00:00:21)
		- cmd 경로 설정
			- 프로젝트 경로 복사 : C:\Users\jiyon\Desktop\coding\java_study\namgungsung
			- 프로젝트 경로 입력 : cd C:\Users\jiyon\Desktop\coding\java_study\namgungsung
			- dir로 bin폴더 확인 후 bin 폴더로 이동 : cd bin
			- 클래스파일 실행(패키지.클래스파일) : java basic.Chapter046
		- 클래스파일을 실행할 때 클래스 이름 뒤에 공백을 구분자로 하여 여러 개의 문자열을 전달할 수 있습니다.
		- 예: java basic.Chapter046 abc 123 "Hello World"
	2. String[] args의 역할 
		- 사용자가 입력한 값들을 자바 가상머신(JVM)이 `String` 배열로 만들어 `main` 메서드의 매개변수 `args`에 전달합니다.
	3. 길이가 0인 배열
		- 아무 값도 입력하지 않으면 `args`는 `null`이 아니라 **길이가 0인 배열**이 됩니다.
		- 자바에서는 `new String[0]`과 같이 길이가 0인 배열 생성을 허용
*/

public class Chapter046 {
  // 메인 메서드의 String[] args가 바로 커맨드 라인 입력값을 받는 바구니입니다.
  public static void main(String[] args) {
  	
  	// 1. 매개변수의 개수 확인
  	System.out.println("매개변수의 개수: " + args.length);

  	// 2. 입력된 매개변수 내용 출력
  	for (int i = 0; i < args.length; i++) {
  		System.out.println("args[" + i + "]: " + args[i]);
  	}
  }
}

/**
 * [실습 방법 정리]
	1. 이클립스에서 설정하기 (00:04:34)
		- [Run] -> [Run Configurations...] 클릭
		- [Arguments] 탭 선택 -> [Program arguments] 칸에 값 입력 (예: abc 123 "Hello World") [00:05:07]
		- [Run] 버튼 클릭
	
 * [Gemini의 꿀팁 보충수업]
	1. 왜 커맨드 라인을 쓰나요? (00:09:14)
		- 소스 코드를 수정하고 컴파일하지 않아도, 실행 시점에 매번 다른 값을 줄 수 있어 프로그램의 유연성이 높아집니다. 
 */