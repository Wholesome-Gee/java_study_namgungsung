package basic; // 88. 추상 클래스의 작성 2

/**
* [핵심 요약]
	1. 추상 클래스의 장점
		- 중복 제거: 공통 기능을 조상에서 관리하여 코드 중복을 제거.
		- 관리 용이: 조상 클래스만 수정하면 상속받은 모든 자손 클래스에 자동 반영.
		- 작성 편의: 미완성 설계도를 바탕으로 새로운 모델을 빠르게 만들 수 있다.
		
	2. 단계별 추상화
		- 추상 클래스를 여러 단계로 구성하여, 필요에 따라 원하는 단계를 선택해 상속받을 수 있다.

	3. 추상화는 구체화의 반대개념

	4. 추상화의 위력
		- 추상적인 코드는 구체적인 코드보다 훨씬 유연.
		- 호출하는 쪽에서는 어떤 객체가 올지 애매해도 사용법만 알면 된다.
*/

import java.util.Calendar;
import java.util.GregorianCalendar;

// 추상 클래스의 단계별 관리 예시
abstract class Electronics { // 1단계: 전자제품 공통기능
  abstract void on();
}

abstract class Tv7 extends Electronics { // 2단계: 전자제품 中 TV제품 공통기능 추가
  abstract void channelUp();
}

class SmartTv7 extends Tv7 { // 3단계: 전자제품 中 TV제품 中 SmartTV제품의 구체적인 완성
  void on() { System.out.println("TV on."); }
  void channelUp() { System.out.println("채널 up."); }
}

public class Chapter088 {
  public static void main(String[] args) {
  	// 1. 구체적인 코드: 인스턴스와 참조변수타입 등.. 굉장히 명확함
  	GregorianCalendar cal1 = new GregorianCalendar();
  	
  	// 2. 추상적인 코드: 사용할   
  	Calendar cal2 = Calendar.getInstance(); 
  	System.out.println(cal2);
  	System.out.println("현재 연도: " + cal2.get(Calendar.YEAR));
  	
  	/// 
  	/// Calendar는 추상클래스
  	/// Calendar.getInstance()는 Calendar의 자손 객체를 반환 (서양력/불교력/일본력..등 사용자 환경에 따라 반환)
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. "애매한 게 좋다?" (00:07:11)
		- 프로그래밍에서는 코드를 너무 구체적으로 짜놓으면 수정할 때 수만 줄의 코드를 다 고쳐야 한다.
			추상화를 통해 "뭐가 올진 모르겠지만, 이런 기능은 있을 거야"라고 약속만 해두면 나중에 알맹이(객체)를 바꿔 끼우기 매우 쉬워진다.
			
	2. 추상화와 다형성 
		- `Calendar.getInstance()`가 자손 객체(서양력, 불교력 등)를 반환해도 `Calendar` 타입으로 받을 수 있는 이유는 바로 '다형성' 덕분이다.


* [실무 꿀팁 - 추상화의 실체]
	1. 캡슐화와 변경
		- `getInstance()` 내부 로직이 바뀌어도, 이 메서드를 가져다 쓰는 `main` 코드는 단 한 줄도 고칠 필요가 없습니다. 
			이것이 추상화가 주는 최고의 선물입니다. [00:12:55]
	2. 라이브러리 설계 (00:11:19)
		- 자바 표준 라이브러리의 많은 부분이 이런 추상화 원리를 이용해 설계되어 있습니다. 사용자는 복잡한 내부 구현을 몰라도 추상화된 메서드만 알면 됩니다. [00:11:35]
	3. 반복과 실습 (00:14:13)
		- 이해가 안 갈수록 코드를 직접 타이핑해 보며 손에 익히는 것이 가장 빠른 지름길입니다. [00:14:17]
*/