package basic; // 84. 매개변수의 다형성

/**
* [핵심 요약]
	1. 매개변수의 다형성이란? (00:02:40)
		- 메서드의 매개변수 타입을 조상 클래스 타입으로 정의하는 것입니다. [00:05:27]
		- 이렇게 하면 해당 조상의 모든 자손 타입 객체를 매개변수로 받을 수 있습니다. [00:05:56]
	2. 장점 (00:06:28)
		- 제품(자손)이 추가될 때마다 메서드를 새로 만들(오버로딩) 필요가 없습니다. [00:05:06]
		- 코드의 중복이 줄어들고 관리가 매우 편리해집니다. [00:06:23]
	3. 동작 원리 (00:05:48)
		- `Product p = new Tv();`와 같은 다형성 원리가 메서드 호출 시 매개변수 전달 과정에서 그대로 적용됩니다. [00:13:06]
*/

class Product {
  int price;
  int bonusPoint;

  Product(int price) {
  	this.price = price;
  	this.bonusPoint = (int)(price / 10.0); // 보너스 점수는 가격의 10% [00:10:54]
  }
}

class Tv extends Product {
  Tv() { super(100); } // 조상 생성자 Product(100) 호출 [00:09:53]
  public String toString() { return "Tv"; }
}

class Computer extends Product {
  Computer() { super(200); }
  public String toString() { return "Computer"; }
}

class Buyer {
  int money = 1000;
  int bonusPoint = 0;

  // 매개변수 다형성 적용: Product와 그 자손들 모두 수용 가능 [00:05:27]
  void buy(Product p) {
  	if (money < p.price) {
  	  System.out.println("잔액이 부족합니다.");
  	  return;
  	}
  	money -= p.price;
  	bonusPoint += p.bonusPoint;
  	System.out.println(p + "을/를 구입하셨습니다."); // p.toString() 호출 [00:08:36]
  }
}

public class Chapter084 {
  public static void main(String[] args) {
  	Buyer b = new Buyer();

  	// 참조변수 없이 직접 객체 생성하여 전달 가능 [00:13:51]
  	b.buy(new Tv());       // buy(Product p = new Tv()) 와 같음 [00:13:06]
  	b.buy(new Computer()); // buy(Product p = new Computer()) 와 같음

  	System.out.println("현재 남은 돈: " + b.money + "만원");
  	System.out.println("현재 보너스점수: " + b.bonusPoint + "점");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 메서드 하나로 해결 (00:06:12)
		- 만약 다형성이 없다면 `buy(Tv t)`, `buy(Computer c)` 등 수많은 메서드를 오버로딩해야 했을 것입니다. 하지만 `buy(Product p)` 하나면 충분합니다! [00:05:08]
	2. 참조변수 생략의 의미 (00:13:28)
		- `b.buy(new Tv());` 처럼 쓰면 코드는 간결해지지만, `main` 메서드 안에서 해당 Tv 객체를 다시 사용할 리모컨이 없다는 점을 기억하세요. [00:13:39]
	3. toString()의 마법 (00:08:30)
		- `System.out.println(p)`는 내부적으로 `p.toString()`을 호출합니다. 자손 클래스에서 `toString()`을 오버라이딩해두면 각 제품의 이름이 정확히 출력됩니다. [00:09:37]
 */

/**
* [실무 꿀팁 - 다형성의 확장성]
	1. 새로운 제품 추가 (00:05:06)
		- 나중에 `Audio` 클래스가 추가되어도 `Buyer` 클래스의 `buy` 메서드는 전혀 수정할 필요가 없습니다. 이것이 객체지향 설계의 핵심입니다. [00:06:25]
	2. 형변환 복습 (00:01:39)
		- `buy(Product p)` 내부에서 전달받은 객체가 실제 `Tv`인지 확인하고 싶다면 지난 시간에 배운 `instanceof`를 활용하면 되겠죠? [00:02:15]
	3. 부모의 힘
		- 모든 클래스의 부모인 `Object` 타입을 매개변수로 쓰면 세상의 모든 객체를 다 받을 수 있게 됩니다. (실제로 자바의 많은 라이브러리가 이렇게 설계되어 있습니다.) [00:07:08]
*/