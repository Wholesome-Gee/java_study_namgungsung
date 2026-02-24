package basic; // 86. 추상 클래스와 추상 메서드

/**
* [핵심 요약]
	1. 추상 클래스 (abstract class)
		- 추상 메서드를 포함하고 있는 클래스.
		- 객체 생성이 불가능.

	2. 추상 메서드 (abstract method)
		- 구현부(몸통, {})가 없는 메서드.
		- 선언 : abstract void drive();
		
	3. 사용 이유
		- 자손마다 중복되는 메서드를 추상화하여 공통 조상을 만듬. (각 자손마다 메서드 구현부 내용이 다름)
		- 자손 클래스에서 반드시 구현해야 할 기능을 강제하기 위함.
*/

// 추상 클래스 정의 
abstract class Player {
  boolean pause;
  int currentPos;

  Player() {
  	pause = false;
  	currentPos = 0;
  }

  // 추상 메서드
  abstract void play(int pos);
  abstract void stop();

  // 일반 메서드 포함가능
  void play() {
  	play(currentPos); // 일반 메서드에서 추상 메서드를 호출할 수 있음!
  }
}

// 추상 클래스를 상속받아 완성한 클래스
class AudioPlayer extends Player {
  // 추상 메서드 구현
	@Override
	void play(int pos) { 
  	System.out.println(pos + "부터 재생."); 
  }
	@Override
  void stop() { 
  	System.out.println("정지."); 
  }
}

// 일부 추상 메서드만 구현한 경우, 여전히 추상 클래스여야 함
abstract class AbstractPlayer extends Player {
  void play(int pos) { 
  	System.out.println(pos + "부터 재생.");
  }
  // stop()을 구현하지 않았으므로 abstract 클래스
}

public class Chapter086 {
  public static void main(String[] args) {
  	// Player p = new Player(); → 추상 클래스는 객체 생성 불가
  	
  	AudioPlayer ap = new AudioPlayer();
  	
  	// 다형성 활용
  	Player p = ap; 
  	p.play(100); // AudioPlayer에서 오버라이딩으로 구현된 play 메소드가 실행됨
  	p.stop();
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 추상 메서드 호출의 비밀
		- `Player` 클래스의 `play()` 메서드 안에서 아직 구현되지 않은 `play(int pos)`를 호출하는 것이 가능.
			실제 객체는 이를 구현한 `AudioPlayer`일 것이므로,
			런타임에 구현된 메서드가 연결되어 실행되기 때문
			
	2. abstract 키워드는 단순히 빈 몸통 `{}`을 만드는 것보다 
		 자손 클래스에게 "이 기능을 반드시 구현해!"라고 명시적으로 시키는 것.


* [실무 꿀팁 - 추상 클래스 활용]
	1. 리모컨의 규격 
		- `Player p`라는 참조변수는 `play`와 `stop` 버튼이 있는 리모컨이다. 
			실제 기기가 CD인지 DVD인지 몰라도 이 리모컨 하나로 제어할 수 있는 표준 규격이다.
			
	2. 에러 예방
		- 구현부가 비어있는 일반 메서드를 호출하면 아무 일도 안 일어나서 버그를 찾기 힘들지만, 
			추상 메서드는 구현을 안 하면 컴파일 에러가 나기 때문에 안전하다.
	
	3. 점진적 구현
		- 복잡한 기능을 한 번에 구현하기 힘들 때, 
			`AbstractPlayer`처럼 중간 단계를 두어 일부만 먼저 구현하는 방식으로 설계를 확장할 수 있다.
*/