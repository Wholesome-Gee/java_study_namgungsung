package basic; // 83. instanceof 연산자

/**
* [핵심 요약]
	1. instanceof 연산자란? 
		- car instanceof Car → car는 Car객체이거나 자손객체인가?
		- 참조변수가 참조하고 있는 인스턴스의 실제 타입을 확인하는 데 사용.
		- 형변환 가능 여부를 true/false로 반환합니다.
		
	2. 사용 목적 
		- 조상 타입의 참조변수가 어떤 자손 인스턴스를 가리키고 있는지 알 수 없을 때, 
			안전하게 형변환하기 위해 사용합니다.
			
	3. 결과의 의미
		- `참조변수 instanceof 클래스명`의 결과가 true이면, 해당 클래스명으로 형변환이 가능하다는 뜻.
		- 자기 자신뿐만 아니라 조상 타입에 대해서도 true를 반환.
*/

class Car4 {}
class FireEngine3 extends Car4 {}
class Ambulance extends Car4 {}

public class Chapter083 {
  public static void main(String[] args) {
  	FireEngine3 fe = new FireEngine3();
  	
  	// 자기 자신에 대한 확인
  	if (fe instanceof FireEngine3) {
  	  System.out.println("fe는 FireEngine객체이거나 자손객체이다."); // true
  	}
  	
  	// 조상 타입에 대한 확인
  	if (fe instanceof Car4) {
  	  System.out.println("fe는 Car객체이거나 자손객체이다."); // true (형변환 가능)
  	}
  	
  	// 최고 조상에 대한 확인
  	if (fe instanceof Object) {
  	  System.out.println("fe는 Object객체이거나 자손객체이다."); // true
  	}
  	
  	doWork(new Car4());
  	doWork(new FireEngine3());
  	doWork(new Ambulance());
  }
  
  // doWork메소드는 Car4타입의 참조변수를 매개변수로 받는다.
  static void doWork(Car4 c) {
  	// 안전한 형변환 확인 절차
  	if (c instanceof FireEngine3) { 	 // 매개변수 c가 FireEngine3이거나 자손객체인지 확인
  	  FireEngine3 fe = (FireEngine3)c; 
  	  System.out.println("FireEngine");
  	} else if (c instanceof Ambulance) {
  	  Ambulance a = (Ambulance)c;
  	  System.out.println("Ambulance");
  	}
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 형변환 전 필수 코스
		- 어떤 객체가 들어올지 모르는 상황에서 형변환을 하면 `ClassCastException`이 발생.
		 `instanceof`로 먼저 확인하는 것이 정석이다.


* [실무 꿀팁 - instanceof 활용]
	1. if-else 구조 
		- 여러 자손 타입을 처리할 때는 `instanceof`를 사용한 `if-else` 문을 통해 각 타입에 맞는 전용 기능을 호출하도록 설계.
	
	2. 조상 타입을 먼저 검사하면 자손 타입도 true가 되어버리므로, 가장 아랫 자손 타입부터 검사하는 것이 좋다.
*/