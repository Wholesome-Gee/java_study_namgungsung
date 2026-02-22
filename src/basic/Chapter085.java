package basic; // 85. 여러 종류의 객체를 배열로 다루기

/**
* [핵심 요약]
	1. 다형성 배열의 개념 (00:01:03)
		- 조상 타입의 참조변수 배열을 생성하면, 그 자손 타입의 객체들을 한 배열에 담을 수 있습니다. [00:01:14]
		- 원래 배열은 같은 타입만 담을 수 있지만, 다형성 덕분에 "여러 종류의 제품"을 하나로 묶을 수 있습니다. [00:04:50]
	2. 활용 사례: 장바구니 (00:05:03)
		- `Product[] cart = new Product[10];` 과 같이 선언하여 TV, Computer, Audio 등을 모두 담습니다. [00:06:03]
	3. 가변 배열 Vector (00:08:22)
		- 배열의 크기가 고정된 단점을 보완하기 위해 자바에서 제공하는 클래스입니다. [00:08:31]
		- `Object[]` 배열을 가지고 있어 모든 종류의 객체 저장이 가능하며, 크기를 자동으로 관리해 줍니다. [00:09:59]
*/

import java.util.Vector; // Vector를 사용하기 위해 임포트 [00:10:06]

class Product {
  int price;
  int bonusPoint;
  Product(int price) {
  	this.price = price;
  	this.bonusPoint = (int)(price / 10.0);
  }
}

class Tv extends Product {
  Tv() { super(100); }
  public String toString() { return "Tv"; }
}

class Computer extends Product {
  Computer() { super(200); }
  public String toString() { return "Computer"; }
}

class Audio extends Product {
  Audio() { super(50); }
  public String toString() { return "Audio"; }
}

class Buyer {
  int money = 1000;
  int bonusPoint = 0;
  // 1. 고정 크기 배열을 이용한 장바구니 (00:05:16)
  Product[] cart = new Product[10]; 
  int i = 0;

  void buy(Product p) {
  	if (money < p.price) {
  	  System.out.println("잔액 부족");
  	  return;
  	}
  	money -= p.price;
  	bonusPoint += p.bonusPoint;
  	cart[i++] = p; // 배열에 객체 저장 및 인덱스 증가 [00:07:20]
  	System.out.println(p + "을/를 구입하셨습니다.");
  }

  void summary() { // 구매 목록 합계 및 목록 출력 (00:12:40)
  	int sum = 0;
  	String itemList = "";
  	for (int i = 0; i < cart.length; i++) {
  	  if (cart[i] == null) break; // 널이면 반복문 탈출 [00:13:32]
  	  sum += cart[i].price;
  	  itemList += cart[i] + ", "; // p.toString() 호출 효과 [00:14:19]
  	}
  	System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
  	System.out.println("구입하신 제품은 " + itemList + "입니다.");
  }
}

public class Chapter085 {
  public static void main(String[] args) {
  	Buyer b = new Buyer();
  	b.buy(new Tv());
  	b.buy(new Computer());
  	b.buy(new Audio());
  	b.summary();
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 그림으로 이해하기 (00:03:00)
		- `cart[0]`에는 Tv 인스턴스의 주소값이, `cart[1]`에는 Computer 인스턴스의 주소값이 저장됩니다. [00:02:47]
		- 남궁성 선생님 말씀대로 이 참조 관계를 직접 그려보는 것이 설계 능력을 키우는 지름길입니다! [00:03:31]
	2. 널(null) 체크의 중요성 (00:13:27)
		- 배열 10개를 만들었지만 물건을 3개만 샀다면 나머지 7개는 null입니다. 반복문에서 null을 만나면 `break` 하거나 체크해줘야 `NullPointerException`을 피할 수 있습니다. [00:13:32]
	3. Vector 클래스 예고 (00:08:22)
		- 배열의 크기가 10개를 넘어가면 에러가 나겠죠? 이때 사용하는 `Vector`는 내부적으로 `Object[]` 배열을 관리하여 모든 객체를 수용하고 크기도 유동적입니다. [00:09:49]
 */

/**
* [실무 꿀팁 - 컬렉션 프레임워크 맛보기]
	1. 왜 Vector인가? (00:08:48)
		- `Vector`는 모든 객체의 조상인 `Object` 배열을 멤버로 가집니다. 그래서 어떤 객체든 담을 수 있는 만능 바구니가 됩니다. [00:10:15]
	2. 리모컨의 형변환 (00:15:32)
		- 배열에서 객체를 꺼내올 때, 부모 타입(`Product`)으로 꺼내게 됩니다. 자손만의 기능을 쓰려면 다시 자손 타입으로 형변환이 필요할 수 있습니다. [00:15:40]
	3. 객체지향의 유연성
		- 제품이 수천 개로 늘어나도 `Buyer` 클래스의 `cart` 배열 구조는 변하지 않습니다. 이것이 다형성이 주는 유지보수의 편리함입니다. [00:05:52]
*/