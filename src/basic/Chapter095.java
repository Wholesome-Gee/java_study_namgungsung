package basic; // 95. 내부 클래스의 제어자와 접근성

/**
* [핵심 요약]
	1. 제어자 사용
		- 내부 클래스는 public, protected, default, private 4가지 접근 제어자를 모두 사용할 수 있다.
	
	2. 스태틱 멤버 제한
		- static 멤버는 static 내부 클래스에서만 사용 가능.
		- 단, final static(상수)은 모든 내부 클래스에서 허용.
	
	3. 외부 클래스 멤버 접근
		- 내부 클래스는 외부 클래스의 private 멤버도 직접 접근이 가능.
		
	4. 지역 내부 클래스의 제약
		- 지역 내부 클래스는 해당 메서드의 '상수(final)'만 접근 가능. (해당 메서드의 지역변수 접근 불가)
		- 단, 메서드 생명주기동안 값이 변하지 않는 지역변수도 상수로 간주하여 접근을 허용. (JDK 1.8이후)
	
	5. 이름 충돌 해결
		- 외부 클래스 변수와 내부 클래스 변수 이름이 같을 때: '외부클래스명.this.변수명'으로 구분.
*/

class Outer2 {
	static int value2 = 5;
  private int value = 10; // 외부 클래스 iv

  class InstanceInnerClass {
  	int value = 20; // 내부 클래스 iv
  	
  	void method() {
  	  int value = 30; // 지역 변수 lv
  	  System.out.println("value : " + value); // 30
  	  System.out.println("this.value : " + this.value); // 20
  	  System.out.println("Outer.this.value : " + Outer2.this.value); // 10
  	  // System.out.println("Outer.this.value : " + Outer2.value); → Outer2.value는 외부클래스의 static 변수를 호출
  	}
  }
  
  // 스태틱 내부 클래스만 스태틱 멤버 가능
  static class StaticInnerClass {
  	static int scv = 100; 
  }

  void localMethod(final int constant) {
  	int variable = 40; // 값이 안 변하면 상수로 취급 (JDK1.8 이후)
  	
  	class LocalInnerClass {
  	  void print() {
  	  	System.out.println(constant); // OK
  	  	System.out.println(variable); // OK (값이 안 변했을 때만)
  	  }
  	}
  }
}

public class Chapter095 {
  public static void main(String[] args) {
  	// 외부 클래스 밖에서 내부 클래스 인스턴스 생성하기
  	Outer2 oc = new Outer2(); 	// 외부 클래스 인스턴스 생성
  	Outer2.InstanceInnerClass ii = oc.new InstanceInnerClass(); // 외부 클래스 인스턴스로 내부 클래스 인스턴스 생성
  	ii.method();
  	

  	// 스태틱 내부 클래스는 직접 생성 가능 [00:27:54]
  	Outer2.StaticInnerClass si = new Outer2.StaticInnerClass();
  	System.out.println("StaticInner.scv : " + Outer2.StaticInnerClass.scv);
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 왜 지역 클래스는 상수만 쓰나요?
		- 메서드가 종료되어 지역 변수가 사라져도, 내부 클래스 객체는 힙 메모리에 더 오래 살아남을 수 있다. 
			그래서 사라질 변수를 쓰는 게 아닌, 상수를 사용하여 안전성을 확보함.(상수는 별도의 공간(Constant Pool)에 복사된다.) 
	
	2. 컴파일 결과 파일명
		- 내부 클래스는 '외부클래스$내부클래스.class' 형태로 파일이 생성.
		- 지역 내부 클래스는 이름 중복 방지를 위해 '외부클래스$1지역클래스.class'처럼 숫자가 붙기도 한다.


* [실무 꿀팁 - 스트레스 받지 마세요!]
	1. 기본 원칙만 기억
		- 내부 클래스가 너무 복잡하게 느껴진다면, 딱 두 가지만 기억하자.
			"외부의 private 멤버에 접근 가능", 
			"iv/cv/lv 특징과 동일".
			
	2. 필요할 때 찾아보기 (00:33:21)
		- 이 모든 문법을 다 외우고 있을 필요는 없다.
		  이런 기능이 있다는 것만 알고 나중에 필요할 때 예제를 다시 찾아보는 것으로 충분.
*/