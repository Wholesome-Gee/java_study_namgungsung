package basic; // 93. 디폴트 메서드와 static 메서드

/**
* [핵심 요약]
	1. 인터페이스의 default 메서드와 static 메서드
		- JDK 1.8부터 인터페이스에 디폴트 메서드와 static 메서드 추가가 가능.
		- 원래 인터페이스는 추상 메서드만 가질 수 있으나, 유지보수의 편의를 기능이 추가됨.
	
	2. 디폴트 메서드가 필요한 이유
		- 인터페이스 i 에 새로운 추상 메서드를 추가하면, i 인터페이스를 구현한 n개의 클래스에 새로운 메서드를 구현해야 하는 큰 부담이 생김.
		  이를 해결하기 위해 '몸통({})'이 있는 default 메서드를 만들 수 있게 한 것.
	
	3. 이름 충돌 해결 규칙 
		- 다른 인터페이스의 디폴트 메서드와 이름 충돌: 오버라이딩하면 해결.
		- 조상 클래스의 메서드와 디폴트 메서드 간 충돌: 조상 클래스의 메서드가 우선.
*/

interface MyInterface {
	//추상 메서드
	void method1(); 
  
  // 디폴트 메서드
  default void method2() {
  	System.out.println("default method 2 from Interface");
  }
  
  // static 메서드: MyInterface.method3로 직접 호출 가능
  static void method3() {
  	System.out.println("static method 3");
  }
}

class Parent1 {
  public void method2() {
  	System.out.println("method2 from Parent1");
  }
}

class Child1 extends Parent1 implements MyInterface {
	// 조상 클래스의 메서드와 디폴트 메서드가 겹치면 조상 클래스의 메서드가 우선
	// 오버라이딩하면 오버라이딩이 우선
  @Override
  public void method1() {
  	System.out.println("method1");
  }
}

public class Chapter093 {
  public static void main(String[] args) {
  	Child1 c = new Child1();
  	c.method1();
  	c.method2(); // MyInterface의 method2()와 Parent1 클래스의 method2가 이름 충돌! Parent1 클래스의 method2가 호출됨

  	// 인터페이스의 static 메서드 호출
  	MyInterface.method3(); 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. static 메서드의 독립성
		- static 메서드는 인스턴스 변수와 관계없다.


* [실무 꿀팁 - 객체지향 대장정을 마치며]
	1. 원칙과 예외의 조화
		- 디폴트 메서드는 원칙(추상 메서드만!)을 깼지만, 대규모 프로젝트에서 인터페이스 수정 시 발생하는 '구현 지옥'을 막아주는 현실적인 해결책.
*/