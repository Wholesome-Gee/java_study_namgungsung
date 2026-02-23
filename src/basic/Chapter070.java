package basic; // 70. 상속

/**
* [핵심 요약]
	1. 상속(Inheritance)이란?
		- 기존의 클래스를 재사용하여 새로운 클래스를 작성
		- `extends` 키워드를 사용
	
	2. 상속의 특징
		- 자손은 조상의 모든 멤버를 상속받습니다. (생성자와 초기화 블록은 제외)
		- 자손의 멤버 개수는 조상의 멤버 개수보다 항상 같거나 많다.
		- 조상의 변경은 자손에게 영향을 미치지만, 자손의 변경은 조상에게 영향을 주지 않습니다.
	
	3. 포함 vs 상속 (영상 후반부 예고)
		- 상속은 '확장(extends)'의 개념이므로, 부모의 기능을 그대로 쓰면서 새로운 기능을 추가할 때 매우 유리합니다. 
*/

class Tv2 {
  boolean power; 
  int channel;

  void power() { power = !power; }
  void channelUp() { ++channel; }
  void channelDown() { --channel; }
}

// Tv2 클래스를 상속받은 SmartTv
class SmartTv extends Tv2 { 
  void showYoutube() {
  	  System.out.println("Youtube ON!");
  }
}

public class Chapter070 {
  public static void main(String[] args) {
  	SmartTv stv = new SmartTv();
  	
  	// 부모(Tv)로부터 상속받은 멤버들 사용 가능 
  	stv.channel = 10;
  	stv.channelUp();
  	System.out.println(stv.channel);
  	
  	// 자식(SmartTv)만의 고유 멤버 사용
  	stv.showYoutube();
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 왜 상속을 쓰나요?
		- 코드의 중복이 줄어들고, 공통적인 코드는 부모 클래스에서 한 번에 관리할 수 있어 유지보수가 편해집니다.

 * [실무 꿀팁 - 객체지향 설계 편]
	1. 'IS-A' 관계를 확인하세요
		- 상속은 "자식은 부모이다(SmartTv is a Tv)"라는 관계가 성립할 때만 사용.
		- 억지로 코드를 재사용하려고 상속을 남발하면 클래스 간 결합도가 너무 높아져 나중에 수정하기 힘들어집니다.
	
	2. 상속 깊이는 적당히
		- 조상의 조상의 조상... 식으로 상속 계층이 너무 깊어지면 코드를 추적하기 매우 어려워집니다. 보통 2~3단계 정도가 적당합니다.
	
	3. 생성자는 상속되지 않습니다!
		- 부모의 생성자는 상속되지 않으므로 자식 클래스에서 필요하다면 `super()` 등을 통해 직접 처리해줘야 합니다.
*/