package basic; // 99. 예외 정보 확인과 멀티 catch블럭

/**
* [핵심 요약]
	1. 예외 인스턴스와 정보 (00:00:24)
		- 예외 발생 시 예외 인스턴스가 생성되며, 발생 원인과 위치 정보가 담김.
		- catch 블럭의 참조 변수(e)를 통해 인스턴스에 접근할 수 있다.
		
	2. 주요 메서드
		- printStackTrace(): 예외 발생 당시의 호출 스택(Call Stack) 정보와 예외 메시지를 화면에 출력
		- getMessage(): 예외 인스턴스에 저장된 메시지를 반환함.
		 
	3. 멀티 catch 블럭
		- 내용이 같은 여러 catch 블럭을 '|' 기호를 이용해 하나로 합친 것
		- 주의 1: 상속 관계인 클래스를 같이 쓰면 컴파일 에러.
		- 주의 2: 합쳐진 예외들의 공통 멤버만 사용할 수 있다.
*/

public class Chapter099 {
  public static void main(String[] args) {
  	System.out.println(1);
  	try {
  	  System.out.println(2);
  	  System.out.println(0 / 0); // ArithmeticException!
  	  System.out.println(3);
  	} catch (ArithmeticException | IllegalStateException e) { // 멀티 catch 블럭
  	  e.printStackTrace(); // 호출 스택 정보 출력
  	  System.out.println("메시지: " + e.getMessage()); // 예외 메시지 출력
  	} catch (Exception e) {
  	  e.printStackTrace();
  	}
  	System.out.println(6);
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. printStackTrace()의 위력
		- 어떤 파일의 몇 번째 줄에서 에러가 났는지 정확히 짚어준다.
		  디버깅 시 가장 먼저 확인해야 할 도구
		  
	2. 멀티 catch 블럭에서 특정 메서드 호출하기 (00:13:15)
		- 만약 멀티 catch 블럭내에서 한 예외 클래스만의 메서드를 쓰고 싶다면 'instanceof'로 확인 후 형변환을 해야 하지만,
		  이럴 바엔 catch 블럭을 나누는 게 낫다. [00:15:06]
*/