package basic; // 71. 클래스 간의 관계, 상속과 포함

/**
* [핵심 요약]
	1. 포함(Composite) 관계란?
		- 한 클래스의 멤버 변수로 다른 클래스 타입의 참조 변수를 선언.
		- 예: 원(Circle)은 점(Point)을 포함한다.
	
	2. 상속 vs 포함 결정하기 (00:07:37)
		- 상속 관계(IS-A): "~은 ~이다." (Circle is a Point? -> 어색함)
		- 포함 관계(HAS-A): "~은 ~을 가지고 있다." (Circle has a Point? -> 자연스러움)
		- 대부분의 경우 '포함' 관계를 사용하는 것이 설계상 유리.
	
	3. 구조적 차이
		- 상속: `c.x`, `c.y`처럼 직접 접근 가능.
		- 포함: `c.p.x`, `c.p.y`처럼 참조 변수를 거쳐 접근.
*/

class MyPoint {
  int x;
  int y;
}

/**
 1. 상속을 이용한 Circle (Circle is a Point)

class Circle extends MyPoint { int r; }
*/

// 2. 포함을 이용한 Circle (Circle has a Point)
class Circle {
  MyPoint p = new MyPoint();
  int r;
}

public class Chapter071 {
  public static void main(String[] args) {
  	Circle c = new Circle();
  	
  	/**
  	 * 상속 관계에서의 값 할당
  	 c.x = 1;
  	 c.y = 2;
  	 c.r = 5;
  	 * */
  	
  	// 포함 관계에서의 값 할당
  	c.p.x = 1;
  	c.p.y = 2;
  	c.r = 5;
  	
  	System.out.println("Circle p.x: " + c.p.x);
  	System.out.println("Circle p.y: " + c.p.y);
  	System.out.println("Circle r  : " + c.r);
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 포함 관계에서 객체 생성은 필수! MyPonint p = new MyPoint()
	2. 설계는 '그리기'다
		- 객체들이 메모리에 어떻게 그려지는지 직접 종이에 그려보는 습관이 설계 능력을 키워줍니다.
	3. 복잡도 줄이기
		- 자동차를 만들 때 엔진, 문 등을 각각 클래스로 만들고 조합(포함)하면 전체적인 복잡도가 훨씬 낮아집니다.

 * [실무 꿀팁 - 클래스 설계 편]
	1. "Prefer Composition over Inheritance"
		- 디자인 패턴의 대원칙 중 하나. 
		  상속은 부모와 자식이 너무 강하게 결합되어 부모를 조금만 바꿔도 자식이 망가지기 쉽다.
			반면 포함은 필요할 때만 다른 객체의 기능을 빌려 쓰는 것이라 훨씬 유연.
	2. NullPointerException 주의
		- 포함 관계의 멤버 변수를 초기화하지 않고 접근하면 발생.
		- 선언 시점에 초기화하거나, 생성자에서 반드시 `new`를 해야함.
	3. 단위 테스트의 용이성
		- 포함 관계를 쓰면 `MyPoint`만 따로 떼어서 테스트하기가 훨씬 쉽다. 
			상속은 부모 클래스까지 엮여 있어 테스트가 복잡해지는 경우가 많다.
*/