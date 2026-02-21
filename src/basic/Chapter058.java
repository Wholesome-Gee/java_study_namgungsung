package basic; // 58. 클래스변수 인스턴스변수

/**
* [핵심 요약]
	1. 인스턴스 변수 (iv - Instance Variable)
		- 개별 속성: 객체마다 서로 다른 값을 유지해야 할 때 사용합니다.
		- 예: 카드의 무늬(Kind), 숫자(Number) 등. 
		- 생성 시기: 객체가 생성될 때마다 메모리에 각각 만들어집니다. 
	2. 클래스 변수 (cv - Class Variable)
		- 공통 속성: 모든 객체가 공통적으로 갖는 값.
		- 선언 방법: iv 앞에 'static' 키워드를 붙입니다.
		- 예: 카드의 폭(Width), 높이(Height) 등.
		- 생성 시기: 클래스가 메모리에 올라갈 때 딱 한 번만 생성되며, 모든 객체가 공유합니다.
	3. 사용 방법의 차이
		- iv: 반드시 객체를 생성한 후 '참조변수.iv'
		- cv: 객체 생성 없이 '클래스이름.cv'
*/

class Card {
  // 인스턴스 변수 (개별 속성)
  String kind;
  int number;
  // 클래스 변수 (공통 속성) 
  static int width = 100;
  static int height = 250;
}

public class Chapter058 {
  public static void main(String[] args) {
  	// 클래스 변수(cv)는 객체 생성 없이 바로 사용 가능
  	System.out.println(Card.width);
  	System.out.println(Card.height);

  	// 인스턴스 변수(iv)는 객체를 생성해야 사용 가능
  	Card c1 = new Card();
  	c1.kind = "Heart";
  	c1.number = 7;

  	System.out.println(c1.kind); 
  	System.out.println(c1.number); 
  	
  	// cv 값을 변경하면 모든 객체에 영향을 미침
  	System.out.println("--cv변경--");
  	Card.width = 50; 
  	Card.height = 80;
  	System.out.println(c1.width);
  	System.out.println(c1.height);
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 왜 cv는 '클래스명.변수명'을 쓰나요? 
		- 참조변수(c1.width)를 사용하면 iv로 오해하기 쉽기 때문입니다.
		- 클래스 이름(Card.width)을 사용하면 "아, 이건 모든 카드가 공유하는 공통 변수구나!"라고 명확히 알 수 있습니다.
 */