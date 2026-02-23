package basic; // 74. 참조변수 super, 생성자 super()

/**
* [핵심 요약]
	1. 참조 변수 super
		- 조상 객체를 가리키는 참조 변수.
		- 조상의 멤버와 자신의 멤버를 구별할 때 사용.
		- 인스턴스 메서드(또는 생성자) 내에서만 존재.
		
	2. 생성자 super()
		- 조상의 생성자를 호출할 때 사용.
		- 조상의 멤버는 super()로 초기화하도록 하는 것이 좋은 설계.
		- 모든 생성자의 첫 줄에는 반드시 `this()` 또는 `super()` 생성자를 호출.
		- 호출하지 않으면 컴파일러가 생성자 첫 줄에 자동으로 `super();`를 삽입합니다. [00:12:10]
*/

class Parent {
  int x = 10; 
  // 클래스 정의 시 기본 생성자 정의는 필수!  
  Parent() {};
}

class Child extends Parent {
  int x = 20; 

  Child() {};
  
  void method() {
  	System.out.println(x);       // 20
  	System.out.println(this.x);  // 20
  	System.out.println(super.x); // 10
  }
}

class Point {
  int x, y;

  Point() {
  	this(0,0); // Point(0,0)
  } 

  Point(int x, int y) {
  	this.x = x;	// Point.x = x
  	this.y = y; // Point.y = y
  	System.out.println(x + ", " + y);
  }
}

class Point3D extends Point {
  int z;

  Point3D() {};
  
  Point3D(int x, int y, int z) {
  	// 조상의 멤버는 super()를 이용해 조상의 생성자에게 맡김.
  	super(x, y); // Point(x,y) 
  	this.z = z;  // Point3D.z = z
  	System.out.println(x + ", " + y + ", " + z);
  }
}

public class Chapter074 {
  public static void main(String[] args) {
  	Child c = new Child();
  	c.method();
  	
  	///////////////////////////////////////

  	Point p = new Point();
  	Point p2 = new Point(1,2);
  	Point p3 = new Point3D(1,2,3); 
  	Point3D p4 = new Point3D(1,2,3);
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 컴파일 에러의 주범: 기본 생성자
		- 자식 생성자에서 `super()`가 생략되면 조상의 '기본 생성자'를 찾는다.
			이때, 조상 클래스에 매개변수가 있는 생성자만 있고 기본 생성자가 없다면 컴파일 에러가 발생.
	
	2. 초기화의 원칙 
		- 자식 생성자가 조상의 변수까지 직접 초기화하는 것은 가능은 하지만 지양. 
			각자의 멤버는 각자의 생성자가 책임지는 것이 가장 깔끔한 객체지향 코드.


* [실무 꿀팁 - 생성자 설계 편]
	1. 기본 생성자를 항상 만들것.
		- 예상치 못한 `super();` 호출로 인한 에러를 막아준다.
	
	2. super() 호출의 순서
		- 자바 객체가 생성될 때는 최상위 조상인 `Object`부터 순차적으로 생성자가 실행. 
		- 내 코드가 실행되기 전에 조상의 상태가 먼저 준비되어야 하기 때문에 `super()`는 반드시 첫 줄에 와야한다.
	
	3. 라이브러리 확장 시 주의
		- 외부 라이브러리 클래스를 상속받을 때, 부모 클래스에 기본 생성자가 없는 경우가 종종 있다. 
			이때는 명시적으로 `super(args);`를 호출해 줘야 컴파일 에러를 피할 수 있다.
*/