package basic; // 80. 다형성

/**
* [핵심 요약]
	1. 다형성이란?
		- 여러 가지 형태를 가질 수 있는 능력.
		- 자바에서는 조상 타입의 참조 변수로 자손 타입의 객체를 다루는 것.
		
	2. 타입 불일치 허용
		- 원래는 참조 변수와 객체의 타입이 일치해야 하지만,
		  상속 관계에서는 조상 타입 변수에 자손 객체를 담을 수 있다.
*/

class Tv4 {
  boolean power;
  int channel;
  void power() { power = !power; }
  void channelUp() { ++channel; }
  void channelDown() { --channel; }
}

class SmartTv2 extends Tv4 {
  void showYoutube() { /* 유튜브 보여주는 기능 */ }
}

public class Chapter080 {
  public static void main(String[] args) {
  	// 일반적인 경우: 타입 일치
  	SmartTv2 s = new SmartTv2(); // 멤버 7개 사용 가능
  	
  	// 다형성의 경우: 타입 불일치 (조상 변수 = 자손 객체)
  	Tv4 t = new SmartTv2(); // 실제 객체는 SmartTv(멤버 7개)지만, Tv클래스의 멤버변수만 사용가능 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 리모컨 이론 
		- 다형성은 기능을 다 쓰는 게 목적이 아니라, 다양한 객체를 하나의 조상 타입으로 다루기 위해 사용함.
	
	2. 멤버 개수의 차이
		- 조상 변수로 자손 객체를 가리키면, 
			자손 객체가 가진 멤버가 많더라도
			조상과 자손의 공통멤버만 사용할 수 있다.
	
	3. 반대로 자손 변수에 조상 객체를 담을 수 없다.
*/