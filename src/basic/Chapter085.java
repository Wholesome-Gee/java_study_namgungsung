package basic; // 85. 여러 종류의 객체를 배열로 다루기

/**
* [핵심 요약]
	1. 다형성 배열의 개념
		- 조상 타입의 참조변수 배열을 생성하면, 그 자손 타입의 객체들을 한 배열에 담을 수 있다.
			* Car[] carArr = {new FireEngine(), new Ambulance(), new PoliceCar()};
		- 배열은 같은 타입만 담을 수 있지만, 다형성 덕분에 여러 타입의 인스턴스를 하나로 묶을 수 있다.
		
	2. 가변 배열 Vector
		- 배열의 크기가 유동적인 클래스.
		- `Object[]` 배열을 가지고 있어 모든 종류의 객체 저장이 가능하며, 크기를 자동으로 관리해줌.
*/


class Product2 {
  int price;
  int bonusPoint;
  
  Product2() {}
  Product2(int price) {
  	this.price = price;
  	this.bonusPoint = (int)(price / 10.0);
  }
}

class Tv6 extends Product2 {
  Tv6() { super(100); }
  public String toString() { return "Tv"; }
}

class Computer2 extends Product2 {
  Computer2() { super(200); }
  public String toString() { return "Computer"; }
}

class Audio extends Product2 {
  Audio() { super(50); }
  public String toString() { return "Audio"; }
}

class Buyer2 {
  int money = 1000;
  int bonusPoint = 0;
  // 다형성 배열을 이용한 장바구니
  Product2[] cart = new Product2[10]; 
  int i = 0;

  void buy(Product2 p) {
  	if (money < p.price) {
  	  System.out.println("잔액 부족");
  	  return;
  	}
  	money -= p.price;
  	bonusPoint += p.bonusPoint;
  	cart[i++] = p; 
  	System.out.println(p + "을/를 구입하셨습니다.");
  }

  void summary() {
  	int sum = 0;
  	String itemList = "";
  	for (int i = 0; i < cart.length; i++) {
  	  if (cart[i] == null) break; 
  	  sum += cart[i].price;
  	  itemList += cart[i] + ", "; 
  	}
  	System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
  	System.out.println("구입하신 제품은 " + itemList + "입니다.");
  }
}

public class Chapter085 {
  public static void main(String[] args) {
  	Buyer2 b = new Buyer2();
  	b.buy(new Tv6());
  	b.buy(new Computer2());
  	b.buy(new Audio());
  	b.summary();
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 널(null) 체크의 중요성
		- 배열 10개를 만들었지만 물건을 3개만 샀다면 나머지 7개는 null.
		  반복문에서 null을 만나면 `break` 하거나 체크해줘야 `NullPointerException`을 피할 수 있다.
	
	2. Vector 클래스 예고
		- `Vector`는 내부적으로 `Object[]` 배열을 관리하여 모든 객체를 수용하고 크기도 유동적이다.


* [실무 꿀팁 - 컬렉션 프레임워크 맛보기]
	1. 왜 Vector인가?
		- `Vector`는 모든 객체의 조상인 `Object` 배열을 멤버로 가진다.
		  그래서 어떤 객체든 담을 수 있는 만능 바구니가 된다.
		  
	2. 리모컨의 형변환
		- 배열에서 객체를 꺼내올 때, 부모 타입(`Product`)으로 꺼내게 된다.
		  자손클래스의 기능을 쓰려면 다시 자손 타입으로 형변환이 필요.
*/