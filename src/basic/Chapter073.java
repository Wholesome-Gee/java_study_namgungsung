package basic; // 73. 오버라이딩

/**
* [핵심 요약]
	1. 오버라이딩(Overriding)이란?
		- 조상 클래스로부터 상속받은 메서드의 내용을 덮어쓰기.
		
	2. 오버라이딩의 조건
		- 오버라이딩하는 메서드는 조상 클래스의 메서드와 선언부가 일치해야 함.
			* 메서드 이름, 매개변수 목록, 반환 타입이 모두 같아야 함.
		- 접근 제어자는 조상 클래스의 메서드와 같거나 넓어야함. 
		  * 조상클래스의 메서드가 default면 오버라이딩하는 메서드는 protected 혹은 public. 
		- 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.

	3. 오버로딩 vs 오버라이딩
		- 오버로딩: 기존에 없는 새로운 메서드를 정의하는 것 (선언부 中 매개변수의 타입 혹은 개수가 달라짐)(New)
		- 오버라이딩: 상속받은 메서드의 내용을 변경하는 것 (구현부가 달라짐)(Change/Modify)
*/

class MyPoint1 {
  int x, y;

  MyPoint1(int x, int y) {
  	this.x = x;
  	this.y = y;
  }

  
  @Override
	public String toString() {
		return "MyPoint1 [x=" + x + ", y=" + y + "]";
	}
  
}

public class Chapter073 {
  public static void main(String[] args) {
  	MyPoint1 p = new MyPoint1(1, 2);
  	
  	System.out.println(p.toString()); // "x: 1, y: 2"
  	
  	// 참조변수만 출력해도 자동으로 toString() 호출
  	System.out.println(p); // "x: 1, y: 2"
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. toString() 오버라이딩의 편리함
		- 오버라이딩 전에는 멤버 변수 값을 확인하려면 `p.x`, `p.y`를 일일이 찍어야 했지만, 재정의 후에는 객체 이름만 출력하면 한 번에 확인이 가능.

	2. 호출의 우선순위
		- 상속 관계에서 메서드가 호출되면, 항상 '가장 하위 자식'에서 오버라이딩된 메서드가 우선적으로 실행.


* [실무 꿀팁 - 메서드 재정의 편]
	1. @Override 애너테이션을 꼭 사용
		- 실무에서는 메서드 위에 `@Override`를 붙인다. 
		- 만약 오타를 내서 선언부가 달라지면 컴파일러가 "이건 오버라이딩이 아니야!"라고 즉시 알려줌.
		
	2. IDE의 자동 생성 기능을 활용.
		- IntelliJ나 Eclipse에서 단축키로 `toString()`, `equals()` 등을 완벽하게 자동 오버라이딩해준다.
			* Eclipse = 클래스 내부에서 alt + shift + S
			* intelliJ = alt + insert

	3. 조상의 기능을 완전히 버리지 마세요 (super)
		- 조상의 메서드를 오버라이드할 때, 조상의 메서드 내부의 코드(로직)를 유지하면서 덮어쓸 내용을 추가하고 싶을 때는 
			`super.메서드이름()`을 사용하여 조상의 코드를 호출한 뒤 코드를 덧붙이는 방식을 자주 쓴다.
*/