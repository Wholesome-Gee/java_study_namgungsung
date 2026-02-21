package basic; // 56. 클래스의 정의

/**
* [핵심 요약]
	1. 클래스의 세 가지 정의 
		- 변수와 함수(메서드)를 하나로 묶은 것.
	2. 데이터 저장 공간의 발전
		- 변수: 하나의 데이터를 저장.
		- 배열: 같은 타입의 여러 데이터를 저장.
		- 구조체: 여러 타입의 데이터를 저장.
		- 클래스: 구조체에 함수(메서드)까지 결합한 것. 
	3. 사용자 정의 타입 (User-defined type) 
		- 자바와 같은 객체지향 언어에서는 클래스가 곧 사용자 정의 타입입니다.
		- 기본형 8개 외에 개발자가 원하는 형태의 타입을 직접 만들 수 있습니다.
*/

// 클래스 = 사용자 정의 타입
class Time1 {
int hour;
int minute;
int second;
}

public class Chapter056 {
  public static void main(String[] args) {
  	Time1 t = new Time1();
  	t.hour = 12;
  	t.minute = 34;
  	t.second = 56;
  	System.out.println(t.hour + "시 " + t.minute + "분 " + t.second + "초");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 제약 조건 추가 
		- 클래스를 사용하면 시(hour)는 0~23 사이여야 한다는 등의 논리적인 제약 조건을 메서드를 통해 쉽게 구현할 수 있습니다.
 */