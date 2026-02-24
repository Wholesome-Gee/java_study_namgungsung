package basic; // 90. 인터페이스와 다형성

/**
* [핵심 요약]
	1. 인터페이스와 다형성
		- 인터페이스도 조상 타입의 참조 변수로 자손 객체를 가리킬 수 있다.
			* `Fightable f = new Fighter();`
		- 단, 인터페이스 타입 리모컨에는 인터페이스에 선언된 메서드 버튼만 있다.
		
	2. 매개변수 타입이 인터페이스인 경우
		- 해당 인터페이스를 구현한 인스턴스만 매개변수로 넘길 수 있다는 뜻.
		
	3. 리턴 타입이 인터페이스인 경우 
		- 해당 인터페이스를 구현한 인스턴스를 반환한다는 뜻.
		
	4. 주의사항: 오버라이딩과 접근 제어자
		- 인터페이스 메서드를 구현할 때는 반드시 `public`을 붙여야 한다.
		- 조상(인터페이스)보다 접근 범위가 좁으면 안 되기 때문.
*/

// 추상클래스 선언
abstract class Unit2 {
  int x, y;
  abstract void move(int x, int y);
  void stop() { System.out.println("stop"); }
}

// 인터페이스 선언
interface Fightable2 {
  public abstract void move(int x, int y); // public abstract 생략가능.
  public abstract void attack(Fightable2 f); // 매개변수로 인터페이스 사용
}

/** Fighter2 인스턴스는 x, y, move(), stop(), attack(), getFightable() 을 멤버로 갖는다.*/ 
class Fighter2 extends Unit2 implements Fightable2 {
  // 반드시 public을 붙여야 함 
  public void move(int x, int y) { 
  	System.out.println(x + "," + y + " 으로 이동"); 
  }
  public void attack(Fightable2 f) { 
  	System.out.println(f + "를 공격"); 
  }
  
  // 리턴 타입이 인터페이스인 메서드
  Fightable2 getFightable() {
  	Fighter2 f = new Fighter2(); // Fighter2는 Fightable을 구현했으므로 반환 가능 
  	return (Fightable2)f; // (Fightable) 형변환 생략 가능 
  }
}


public class Chapter090 {
  public static void main(String[] args) {
  	// 1. 인터페이스 다형성 예시
  	Fightable2 f = new Fighter2();
  	f.move(100, 200);
  	f.attack(new Fighter2()); // 매개변수 다형성
  	// f.stop(); // 에러! Fightable 리모컨에는 stop 버튼이 없음
  	
  	// 2. 리턴 타입 다형성 예시
  	Fighter2 f2 = new Fighter2();
  	Fightable2 f3 = f2.getFightable(); // 리턴 타입이 Fightable이므로 받는 쪽도 일치해야 함
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 리모컨 이론 
		- 실제 객체가 `Fighter`라서 `stop()` 기능을 가지고 있더라도,
		  리모컨이 `Fightable`이면 그 리모컨에 있는 버튼(move, attack)만 누를 수 있다.


* [실무 꿀팁 - 인터페이스 활용]
	1. 접근 제어자 실수 주의
		- 인터페이스 메서드를 구현할 때 `public`을 빼먹는 실수가 아주 잦다. 
		  인터페이스의 모든 메서드는 `public abstract`임을 명심.
		  
	2. 유연한 설계
		- 리턴 타입을 인터페이스(TV)로 두면, 나중에 메서드 내부에서 다른 클래스의 객체(SmartTv, LEDTv, AnalogTv)를 반환하도록 바꿔도
		  외부 코드를 수정할 필요가 없어진다(추상화의 장점).
		  * interface TV { void turnOn(); }
		  * class SmartTV implements TV { public void turnOn(){ "스마트TV켜짐" };
		  * class AnalogTV implements TV { public void turnOn(){ "아날로그TV켜짐" };
		  * class TVStore { 
		  * 	public static TV getTV() { return new SmartTv(); } // 나중에 return new AnalogTV(); 로 바꿔도 외부코드는 수줭안함
		  * }
		  * ----main()-----
		  * TV myTV = TVStore.getTV(); // myTV에 smartTV나 analogTV의 인스턴스가 담김
		  * myTV.turnOn(); // smartTV, analogTV 둘다 turnOn을 갖고있기에 수정할 필요없음 
*/