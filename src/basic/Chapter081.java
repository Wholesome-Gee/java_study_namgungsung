package basic; // 81. 참조변수의 형변환

/**
* [핵심 요약]
	1. 참조변수의 형변환이란?
		- 사용할 수 있는 멤버의 개수를 조절하는 것.
		- 주소값이나 객체 자체는 전혀 변하지 않음.
		- Car car = (Car) fireEngine; 
		
	2. 형변환은 서로 상속관계에 있는 클래스 사이에서만 가능.

	3. 업캐스팅 vs 다운캐스팅
		- 업캐스팅(자손타입 → 조상타입): 멤버 개수가 줄어들므로 안전하여 형변환 생략이 가능.
		- 다운캐스팅(조상타입 → 자손타입): 멤버 개수가 늘어날 수 있으므로 형변환을 명시.
*/

class Car {
  String color;
  int door;
  void drive() { System.out.println("drive()"); }
  void stop() { System.out.println("stop()"); }
}

class FireEngine extends Car {
  void water() { System.out.println("water()"); }
}

public class Chapter081 {
  public static void main(String[] args) {
  	Car car = null;
  	FireEngine fe = new FireEngine();
  	FireEngine fe2 = null;

  	// 1. 업캐스팅 (자손타입 → 조상타입): 형변환 생략 가능
  	car = fe; // == (Car)fe;  fe가 참조하는 객체의 멤버 5개중 Car클래스와 공통멤버 4개만 사용가능.

  	fe.water();
  	// car.water(); → 에러
  	

  	// 2. 다운캐스팅 (조상타입 → 자손타입): 형변환 생략 불가
  	fe2 = (FireEngine)car;	// car가 참조하는 fe변수, fe변수가 참조하는 객체의 멤버 5개 모두 사용가능. 
  	fe2.water(); 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 왜 멤버 개수를 조절하나? 
		- 똑같은 객체를 가리키더라도, 어떤 타입의 참조변수를 쓰느냐에 따라 사용할 수 있는 기능의 범위가 달라짐.
		
	2. 형변환 연산자 (Type)
		- 명시적 형변환에 사용 
		- 보통 조상타입을 자손 타입으로 변환할 때 사용.
*/