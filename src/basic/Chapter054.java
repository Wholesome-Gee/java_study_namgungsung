package basic; // 54. 객체의 생성과 사용

/**
* [핵심 요약]
	1. 객체의 생성 방법
		Tv t; // 클래스명 참조변수명, 객체를 다루기 위한 참조변수 선언 
		tv = new Tv(); // 참조변수명 = new 클래스명(), 객체 생성 후 참조변수에 연결
		예: Tv t = new Tv(); [00:01:39]
	2. 객체의 사용
		객체의 변수 사용: t.channel = 7; 
		객체의 메서드 사용: t.channelDown();
	3. 참조변수와 객체의 관계 
		참조변수는 객체의 주소를 가리킵니다. 
		하나의 객체주소를 여러 참조변수가 가리키는 것은 가능하지만,
		하나의 참조변수가 여러 객체주소를 가리키는 것은 불가능합니다.
*/
class Tv {
  String color;
  boolean power;
  int channel;

  void power() { power = !power; }
  void channelUp() { ++channel; }
  void channelDown() { --channel; }
}

public class Chapter054 {
  public static void main(String[] args) {
  	// Tv t; 
  	// t = new Tv();
  	Tv t = new Tv();

  	t.channel = 7; 
  	t.channelDown(); 
  	System.out.println("현재 채널은 " + t.channel + "입니다."); // 결과: 6 [00:12:13]
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 참조변수의 중요성 
		자바에서는 참조변수 없이는 객체를 다룰 방법이 없습니다. 
		
	2. 객체마다 별도의 저장공간
		Tv t1 = new Tv();
		Tv t2 = new Tv();  
		t1과 t2는 서로 다른 저장공간을 가집니다. t1의 채널을 바꿔도 t2에는 영향이 없습니다.
	3. 참조변수의 대입
		t2 = t1; 
		t2가 가리키던 객체는 가비지 컬렉터(GC)에 의해 메모리에서 삭제되고 t1이 가리키던 객체주소를 함께 가리키게 됩니다.
 */