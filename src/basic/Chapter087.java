package basic; // 87. 추상 클래스의 작성 1

/**
* [핵심 요약]
	1. 추상화(Abstraction)와 구체화
		- 추상화: 클래스간의 공통점을 찾아내서 조상을 만드는 것
		- 구체화: 상속을 통해 클래스를 구현, 확장하는 작업
		
	2. 추상 클래스로 공통 관리하기
		- 여러 클래스(Marine, Tank, Dropship)에 중복된 코드(x, y, stop)를 뽑아 조상 클래스(`Unit`)로 만든다.
		- 이동 방식(`move`)은 유닛마다 다르므로 선언부만 공통으로 뽑아 추상 메서드로 정의.
		
	3. 다형성 배열의 위력 
		- `Unit[] group = new Unit[3];` 와 같이 조상 타입 배열에 서로 다른 자손 객체들을 담을 수 있다.
		- 공통 조상의 리모컨(`Unit`)에 `move` 버튼이 있기 때문에, 한 번의 반복문으로 모든 유닛을 이동시킬 수 있다.
*/

abstract class Unit {
  int x, y;
  
  abstract void move(int x, int y);
  
  void stop() { System.out.println("정지");}
}

class Marine extends Unit {
  void move(int x, int y) {
  	System.out.println("Marine " + x + "," + y + " 으로 이동");
  }
  void stimPack() { System.out.println("Marine 스킬사용"); }
}

class Tank extends Unit { 
  void move(int x, int y) {
  	System.out.println("Tank " + x + "," + y + " 으로 이동");
  }
  void changeMode() { System.out.println("Tank 스킬사용"); }
}

class Dropship extends Unit { 
  void move(int x, int y) {
  	System.out.println("Dropship " + x + "," + y + " 으로 이동");
  }
  void load() { System.out.println("Dropship 스킬사용"); }
}

public class Chapter087 {
  public static void main(String[] args) {
  	// 1. 객체 배열 생성 및 초기화
  	Unit[] units = { new Marine(), new Tank(), new Dropship() };
  	
  	// 2. 모든 유닛을 (100, 200) 좌표로 이동
  	for (int i = 0; i < units.length; i++) {
  	  units[i].move(100, 200);	// units[0].move(100,200); → new Marine().move(100,200) 
  	}
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. Object 배열은 안 되는가?
		- `Object[] units`에 유닛을 담을 수는 있지만, `Object` 리모컨에는 `move()`라는 버튼이 없다.
			`units[i].move()`라고 호출하면 컴파일 에러가 발생.
	
	2. 추상 메서드가 리모컨 버튼이 된다
		- 조상 클래스에서 `abstract void move(...)`라고 선언해 두는 것은 
			"내 자손들은 모두 move 버튼을 가지고 있다"고 보장하는 것과 같다.
			
	3. 중복 제거의 미학
		- 공통 부분을 조상으로 옮기면 코드가 간결해지고,
		  나중에 공통 기능을 수정할 때 조상 클래스 한 곳만 고치면 되므로 유지보수가 매우 편리.


* [실무 꿀팁 - 추상 클래스 설계]
	1. 선언부의 중요성 
		- 몸통이 달라도 "이름, 매개변수, 리턴타입"인 선언부가 같으면 조상으로 묶을 수 있다.
		  이것이 다형성의 핵심 인터페이스가 된다.
*/