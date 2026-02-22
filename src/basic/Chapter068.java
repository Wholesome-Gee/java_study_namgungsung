package basic; // 68. 생성자 this(), 참조변수 this

/**
* [핵심 요약]
	1. 생성자 `this()`
		- 같은 클래스 내의 다른 생성자를 호출할 때 사용
		- 반드시 생성자의 첫 번째 줄에서만 사용
		- 클래스 이름 대신 `this()`를 사용하며, 코드의 중복을 제거하기 위해 씁니다.

	2. 참조변수 `this`
		- 인스턴스 자신을 가리키는 참조변수
		- 인스턴스 변수(iv)와 지역 변수(lv)의 이름이 같을 때 이를 구별하기 위해 사용
		- 인스턴스 메서드와 생성자 내에서만 사용하며, `static` 메서드에서는 사용불가.
*/

class Car2 {
  String color;
  String gearType;
  int door;

  // 기본 생성자: 다른 생성자 this()를 호출하여 코드 중복 제거
  Car2() {
  	this("white", "auto", 4); // == Car2("white", "auto", 4);
  }

  Car2(String color, String gearType, int door) {
  	// 참조변수 this를 사용하여 iv와 lv를 구별
  	this.color = color;   
  	this.gearType = gearType;
  	this.door = door;
  }
}

public class Chapter068 {
  public static void main(String[] args) {
  	Car2 c1 = new Car2();
  	System.out.println("c1: " + c1.color + ", " + c1.gearType + ", " + c1.door);
  }
}