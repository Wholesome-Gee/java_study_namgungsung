package basic; // 82. 참조변수의 형변환(2)

/**
* [핵심 요약]
	1. 컴파일 타임 vs 런타임
		- 컴파일러는 타입 간의 상속 관계만 확인하여 형변환 가능 여부를 판단.
		- 런타임에는 실제 가리키는 객체의 멤버 개수가 중요합니다.
	2. 형변환의 한계 (00:08:33)
		- 실제 인스턴스가 가진 멤버 개수보다 더 많은 기능을 가진 리모컨으로 형변환하는 것은 불가능합니다. [00:12:58]
	3. 주의해야 할 예외 (00:10:30)
		- ClassCastException: 형변환은 성공했으나 실제 객체에 해당 기능이 없을 때 발생합니다. [00:10:33]
		- NullPointerException: 참조변수가 null인 상태에서 메서드를 호출할 때 발생합니다. [00:04:23]
*/

class Car3 {
  String color;
  int door;
  void drive() { System.out.println("drive()"); }
  void stop() { System.out.println("stop()"); }
}

class FireEngine2 extends Car3 {
  void water() { System.out.println("water()"); }
}

public class Chapter082 {
  public static void main(String[] args) {
  	// 객체가 없는 경우
  	Car3 c1 = null;
  	FireEngine2 fe1 = (FireEngine2)c1; // 형변환은 OK
  	// fe1.water(); // 런타임 에러: NullPointerException 발생

  	
  	// 조상 인스턴스를 자손 타입으로 형변환하는 경우
  	Car3 c2 = new Car3(); // 실제 객체는 Car (멤버 4개)
  	// FireEngine fe2 = (FireEngine)c2; // 컴파일은 OK, 실행 시 ClassCastException!! 
  	

  	// 안전한 형변환
  	Car3 c3 = new FireEngine2(); // 실제 객체는 FireEngine (멤버 5개)
  	FireEngine2 fe3 = (FireEngine2)c3; // OK! 실제 객체에 5개 기능이 다 있음.
  	fe3.water(); // 정상 작동
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 컴파일러는 "둘이 부모 자식 사이야? 그럼 형변환 써줬으니까 일단 통과!"라고만 생각한다. 실제 객체가 무엇인지는 실행해 봐야 알 수 있다. 
		
	2. 에러 방지 전략
		- 형변환을 하기 전에 항상 이 변수가 가리키는 실제 객체가 내가 바꾸려는 타입이 맞는지 확인하는 습관이 필요함. (instanceof)


* [실무 꿀팁 - 런타임 에러 예방]
	1. 인스턴스 확인 
		- 형변환을 시도할 때 `instanceof` 연산자(다음 강의 주제)를 사용하여 실제 객체 타입을 확인.
		
	2. 조상 객체 생성 자제
		- `Car c = new Car();` 처럼 조상 타입의 객체를 직접 생성해서 자손으로 형변환하는 경우는 실무에서 거의 없다.
		
	3. 디버깅 포인트
		- `ClassCastException`이 발생했다면, "참조변수 타입의 멤버 개수 > 실제 객체의 멤버 개수"라고 즉시 판단하고 객체 생성 부분을 확인.
*/