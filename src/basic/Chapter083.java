package basic; // 83. instanceof 연산자

/**
* [핵심 요약]
	1. instanceof 연산자란? (00:00:06)
		- 참조변수가 참조하고 있는 인스턴스의 실제 타입을 확인하는 데 사용합니다. [00:00:16]
		- 형변환 가능 여부를 true/false로 반환합니다. [00:00:23]
	2. 사용 목적 (00:00:39)
		- 조상 타입의 참조변수가 어떤 자손 인스턴스를 가리키고 있는지 알 수 없을 때, 안전하게 형변환하기 위해 사용합니다. [00:01:14]
	3. 결과의 의미 (00:05:43)
		- `참조변수 instanceof 클래스명`의 결과가 true이면, 해당 클래스명으로 형변환이 가능하다는 뜻입니다. [00:06:15]
		- 자기 자신뿐만 아니라 조상 타입에 대해서도 true를 반환합니다. [00:06:08]
*/

class Car {}
class FireEngine extends Car {}
class Ambulance extends Car {}

public class Chapter083 {
  public static void main(String[] args) {
  	FireEngine fe = new FireEngine();
  	
  	// 1. 자기 자신에 대한 확인 (00:05:32)
  	if (fe instanceof FireEngine) {
  	  System.out.println("This is a FireEngine instance."); // true
  	}
  	
  	// 2. 조상 타입에 대한 확인 (00:05:18)
  	if (fe instanceof Car) {
  	  System.out.println("This is a Car instance."); // true (형변환 가능) [00:07:25]
  	}
  	
  	// 3. 최고 조상에 대한 확인 (00:05:15)
  	if (fe instanceof Object) {
  	  System.out.println("This is an Object instance."); // true [00:06:53]
  	}
  	
  	doWork(new FireEngine());
  	doWork(new Ambulance());
  }
  
  // 메서드 매개변수로 다형성 활용 시 유용 (00:01:37)
  static void doWork(Car c) {
  	// 4. 안전한 형변환 확인 절차 (00:03:10)
  	if (c instanceof FireEngine) { // c가 가리키는 실제 객체가 소방차인지 확인 [00:03:01]
  	  FireEngine fe = (FireEngine)c; // 확인 후 안전하게 형변환 [00:03:25]
  	  fe.drive();
  	} else if (c instanceof Ambulance) {
  	  Ambulance a = (Ambulance)c;
  	  a.stop();
  	}
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 조상들도 true인 이유 (00:06:07)
		- `instanceof`는 단순히 "너 이거야?"라고 묻는 게 아니라 "너 이 타입으로 형변환(리모컨 교체) 해도 안전해?"라고 묻는 것이기 때문입니다. [00:08:32]
		- 소방차는 자동차이기도 하고 객체(Object)이기도 하므로 모두 true가 나옵니다. [00:08:06]
	2. 형변환 전 필수 코스 (00:04:18)
		- 실제 어떤 객체가 들어올지 모르는 상황에서 무턱대고 형변환을 하면 지난번에 배운 `ClassCastException`이 발생합니다. `instanceof`로 먼저 확인하는 것이 정석입니다. [00:11:51]
	3. 바뀌지 않는 것들 (00:10:31)
		- 형변환을 해도 실제 객체(인스턴스)의 주소값이나 내용은 절대 변하지 않습니다. 오직 '사용 가능한 멤버의 개수'를 정하는 리모컨의 타입만 바뀔 뿐입니다. [00:10:59]
 */

/**
* [실무 꿀팁 - instanceof 활용]
	1. if-else 구조 (00:03:44)
		- 여러 자손 타입을 처리할 때는 `instanceof`를 사용한 `if-else` 문을 통해 각 타입에 맞는 전용 기능을 호출하도록 설계합니다. [00:04:05]
	2. 검사 순서 주의
		- 조상 타입을 먼저 검사하면 자손 타입도 true가 되어버리므로, 보통 가장 구체적인 자손 타입부터 검사하는 것이 좋습니다. [00:05:47]
	3. 암기 코드
		- "형변환 하기 전에는? 반드시 instanceof로 확인하자!" [00:07:45]
*/