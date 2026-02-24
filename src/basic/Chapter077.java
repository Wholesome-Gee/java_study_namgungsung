package basic; // 77. 제어자, static, final, abstract

/**
* [핵심 요약]
	1. 제어자(Modifier)
		- 접근 제어자(`public`, `protected`, `default`, `private`)
		- 일반 제어자(`static`, `final`, `abstract` ...)
		 
	2. static (클래스화)
		- static 멤버 변수: 모든 인스턴스에 공통적으로 사용되는 클래스 변수.
		- 메서드: 인스턴스 생성 없이 '클래스이름.메서드명'으로 호출 가능.
		
	3. final (상수화)
		- final 클래스: 상속이 불가능함. (예: String, Math)
		- final 메서드: 오버라이딩이 불가능함.
		- final 변수: 값의 변경이 불가능함.
		
	4. abstract (추상화) 
		- abstract 메서드: 구현부(몸통)가 없는 메서드.
		- abstract 클래스: 추상 메서드를 포함하고 클래스 (인스턴스 생성불가)
*/

// final 클래스는 상속 계층도의 마지막. (더는 상속 불가)
final class FinalTest { 
  final int MAX_SIZE = 10; // 상수 
  
  final void getMaxSize() { // 오버라이딩 불가
  	final int LV = MAX_SIZE; // 지역 변수 상수
  }
}

// 추상 클래스는 인스턴스 생성 불가.
abstract class AbstractTest { 
  abstract void move(); // 추상 메서드
}

public class Chapter077 {
  public static void main(String[] args) {
  	System.out.println("제어자 학습 중...");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 제어자 조합 규칙
		- 하나의 대상에 여러 제어자를 쓸 수 있다.(public static final int x;) 
		- 관례적으로 접근 제어자를 가장 왼쪽에 작성.
		
	2. abstract 클래스의 존재 이유
		- 자손 클래스에서 반드시 특정 메서드를 구현하도록 강제하기 위함.

	3. static 초기화 블록
		- `static { ... }`을 이용해 클래스 변수의 복잡한 초기화 작업을 수행할 수 있습니다. 


* [실무 꿀팁 - 제어자 활용 편]
	1. 보안과 final
		- String 클래스가 final인 이유는 보안 때문,
		  누군가 String을 상속받아 시스템의 중요한 문자열 정보를 가로채거나 변경하는 것을 막기 위함.
		  
	2. 유틸리티 클래스와 static
		- Math 클래스처럼 객체 생성 없이 기능만 제공하는 경우, 
			모든 메서드를 static으로 만들고 클래스 자체는 final로 선언.
			
	3. 추상 클래스 설계
		- 프로젝트 초기에 공통적인 부분을 추상 클래스로 만들어두면, 
			새로운 기능을 추가할 때 표준화된 가이드라인 역할을 해줌.
*/