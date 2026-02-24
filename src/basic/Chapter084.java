package basic; // 84. 매개변수의 다형성

/**
* [핵심 요약]
	1. 매개변수의 다형성이란?
		- 메서드의 매개변수 타입을 조상 클래스 타입으로 정의하는 것.
		- 해당 조상의 모든 자손 타입 객체를 매개변수로 받을 수 있다.
		
	2. 장점
		- 제품(자손)이 추가될 때마다 메서드를 새로 만들(오버로딩) 필요가 없다.
		- 코드의 중복이 줄어들고 관리가 매우 편리.
*/

class Product {
  int price;
  int bonusPoint;

  // 생성자
  Product() {}
  Product(int price) {
  	this.price = price;
  	this.bonusPoint = (int)(price / 10.0); // bonusPoint는 price의 10%
  }
}

class Tv5 extends Product {
  Tv5() { 
  	super(100); 
  } 
  @Override
  public String toString() { return "Tv"; }
}

class Computer extends Product {
  Computer() {
  	super(200); 
  }
  @Override
  public String toString() { return "Computer"; }
}

class Buyer {
  int money = 1000;
  int bonusPoint = 0;

  // 매개변수 다형성 적용: Product와 그 자손들 모두 수용 가능
  void buy(Product p) {
  	if (money < p.price) {
  	  System.out.println("잔액이 부족합니다.");
  	  return;
  	}
  	money -= p.price;
  	bonusPoint += p.bonusPoint;
  	System.out.println(p + "을/를 구입하셨습니다."); // p.toString() 호출
  }
}

public class Chapter084 {
  public static void main(String[] args) {
  	Buyer b = new Buyer();

  	b.buy(new Tv5());      // Tv5는 Product의 자손객체이기 때문에, 파라미터로 전달가능.
  	b.buy(new Computer()); // Computer는 Product의 자손객체이기 때문에, 파라미터로 전달가능.

  	System.out.println("현재 남은 돈: " + b.money + "만원");
  	System.out.println("현재 보너스점수: " + b.bonusPoint + "점");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 메서드 하나로 해결
		- 만약 다형성이 없다면 `buy(Tv t)`, `buy(Computer c)` 등 수많은 메서드를 오버로딩해야 했다.
		  하지만 `buy(Product p)` 이 문장이 그런 수고를 줄였다.
	
	2. toString()의 마법 
		- `System.out.println(p)`는 내부적으로 `p.toString()`을 호출


* [실무 꿀팁 - 다형성의 확장성]
	1. 새로운 제품 추가 
		- 나중에 `Audio` 클래스가 추가되어도 `Buyer` 클래스의 `buy` 메서드는 전혀 수정할 필요가 없다.
			main 메소드에 b.buy(new Audio()); 만 추가하면 된다.
	
	2. 형변환 복습
		- `buy(Product p)` 에서 전달받은 객체가 실제 `Tv`인지 확인하고 싶다면 `instanceof`를 활용.
		
	3. 부모의 힘
		- 모든 클래스의 부모인 `Object` 타입을 매개변수로 쓰면 세상의 모든 객체를 다 받을 수 있게 된다.
		  (실제로 자바의 많은 라이브러리가 이렇게 설계되어 있다.)
*/