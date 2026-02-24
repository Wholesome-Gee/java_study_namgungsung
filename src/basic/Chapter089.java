package basic; // 89. 인터페이스의 선언, 상속, 구현

/**
* [핵심 요약]
	1. 인터페이스란?
		- '추상 메서드의 집합'
		- 구현된 것이 하나도 없는 '껍데기'
		- 모든 멤버가 `public`이며, 본질적으로 추상 메서드 위주로 구성.
		
	2. 인터페이스 vs 추상 클래스
		- 추상 클래스: 일반 클래스인데 추상 메서드를 가진 것 (iv, 생성자 가질 수 있음).
		- 인터페이스: iv를 가질 수 없으며, 오직 추상 메서드와 상수만 가질 수 있음.
		
	3. 인터페이스의 상속
		- 인터페이스의 조상은 인터페이스만 가능.
		- 다중 상속이 가능. (추상 메서드는 충돌 문제가 없기 때문).
		 
	4. 인터페이스의 구현 
		- `implements` 키워드를 사용.
*/

/// 인터페이스 선언 
interface Fightable {
	// public abstract 생략가능
  public abstract void move(int x, int y); 
  public abstract void attack(Unit u);
}

interface Movable { 
	public abstract void move(int x, int y); 
}

interface Attackable { 
	public abstract void attack(Unit u); 
}

// 인터페이스 간의 다중 상속
interface Playable extends Movable, Attackable { }


/// 인터페이스 구현
class Fighter implements Fightable {
  // 인터페이스의 모든 메서드는 public이므로 구현 시 public을 붙여야 함
  public void move(int x, int y) {
  	System.out.println(x + "," + y + "로 이동");
  }
  public void attack(Unit u) {
  	System.out.println(u + "을/를 공격");
  }
}

// 일부만 구현할 경우 클래스 앞에 abstract를 붙여야 함
abstract class PartialFighter implements Fightable {
  public void move(int x, int y) {
  	System.out.println(x + "," + y + "로 이동");
  }
  // public abstract void attack(Unit u); 
}


public class Chapter089 {
  public static void main(String[] args) {
  	Fighter f = new Fighter();
  	f.move(100, 200);
  	
  	// 인터페이스로 객체 생성은 불가
  	// Fightable f2 = new Fightable();
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 생략의 마법 
		- 인터페이스의 상수는 `public static final`, 메서드는 `public abstract`가 항상 붙기 때문에 생략이 가능.
	
	2. 왜 다중 상속이 되나요?
		- 인터페이스는 어차피 구현부가 없어서 충돌할 일이 없기 때문에 여러 개를 상속받아도 안전.
		
	3. 캡슐화와 인터페이스 
		- 인터페이스는 객체의 가장 바깥쪽 껍데기다.
		  내부 구현을 감추고 외부와의 소통 창구 역할만 수행.


* [실무 꿀팁 - 인터페이스 설계]
	1. 핵심에 집중하기 
		- 최근 자바에서는 디폴트 메서드 등이 추가되었지만, 
		  인터페이스의 본질은 여전히 '추상 메서드 집합'이다.
		  
	2. 면접 단골 질문
		- "추상 클래스와 인터페이스의 차이가 뭐죠?"라는 질문에 
		  "iv(멤버 변수)를 가질 수 있느냐 없느냐의 차이가 가장 큽니다"라고 답변.
*/