package basic; // 75. 패키지, 클래스 패스

/**
* [핵심 요약]
	1. 패키지(Package)
		- 서로 관련된 class들의 묶음.
		- 물리적으로는 하나의 디렉토리(폴더)이며, 
			클래스의 실제 이름(Full Name)은 패키지명을 포함.

	2. 패키지 선언 
		- package basic; (맨 위 작성)
		- 패키지 선언이 없으면 '이름 없는 패키지(default package)'에 속함.
		
	3. 클래스 패스(Classpath)
		- 클래스 파일(`.class`)을 찾기 위한 경로를 OS에 알려주는 설정.
		- 환경 변수 `CLASSPATH`에 패키지의 루트 디렉토리를 등록하여 사용.
*/

public class Chapter075 {
  public static void main(String[] args) {
  	// 현재 클래스가 어떤 패키지에 있는지 확인.
  	System.out.println("현재 클래스의 Full name : " + Chapter075.class.getName());
  	
  	// java.lang 패키지는 자동으로 포함(import)된다.
  	String str = "Hello, Package!"; 
  	System.out.println("String 클래스의 패키지: java.lang.String");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. rt.jar와 모듈화
		- 자바 8까지는 `rt.jar`라는 거대한 압축 파일에 모든 클래스를 모아뒀지만, 
			자바 9부터는 필요한 것만 나눠 쓰는 '모듈' 개념이 도입되며 사라졌다. [00:02:42]
			
	2. 패키지와 폴더의 관계
		- 패키지명이 `com.code.book`이라면, 
			실제 컴퓨터에는 `com/code/book`이라는 계층적인 폴더 구조가 생성된다.
			
	3. 터미널에서의 실행
		- 터미널(CMD)에서 실행할 때는 반드시 패키지의 루트(최상위 폴더)에서 
			`java 패키지명.클래스명` 형식으로 입력해야 한다.
			
			
* [실무 꿀팁 - 패키지 네이밍 편]
	1. 패키지 이름은 도메인의 역순
		- 보통 회사의 웹사이트 주소를 거꾸로 쓴다. (예: `com.google.search`)

	2. 패키지 이름은 관례적으로 모두 소문자로 작성.
		 
		
	3. JAR 파일이란?
		- Java Archive의 약자로, 수많은 클래스 파일과 패키지 구조를 하나로 묶어놓은 압축 파일. 
		- 실무에서는 우리가 만든 프로그램을 배포하거나 외부 라이브러리를 가져올 때 이 JAR 형식을 사용. [00:02:10]
*/