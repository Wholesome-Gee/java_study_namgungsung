package basic; // 65. static메서드와 인스턴스 메서드

/**
* [핵심 요약]
	1. 인스턴스 메서드 (00:00:48)
		- `static`이 붙지 않은 메서드입니다.
		- 반드시 객체를 생성한 후, '참조변수.메서드명()'으로 호출
		- 인스턴스 변수(iv)를 사용하는 작업을 할 때 주로 만듭니다.
	2. static 메서드 (클래스 메서드) 
		- `static`이 붙은 메서드입니다. 
		- 객체 생성 없이 '클래스이름.메서드명()'으로 바로 호출
		- 인스턴스 변수(iv)를 사용하지 않는 작업을 할 때 만듭니다.
	3. 핵심 차이점 
		- iv(인스턴스 변수) 사용 여부가 가장 큰 기준
		- static 메서드는 iv를 사용할 수 없습니다.
*/

class MyMath1 {
  long a, b; // iv (인스턴스 변수)

  long add() {	  // 인스턴스 메서드 (iv를 사용)
  	return a + b; 
  }

  static long add(long x, long y) {   // static 메서드 (iv를 사용안함)
  	return x + y; 
  }
}

public class Chapter065 {
  public static void main(String[] args) {
  	// static 메서드 호출
  	System.out.println(MyMath1.add(100L, 200L)); 

  	// 인스턴스 메서드 호출
  	MyMath1 mm = new MyMath1();
  	mm.a = 1L;
  	mm.b = 2L;
  	System.out.println(mm.add()); 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 호출 관계 
		- 인스턴스 메서드는 static 메서드를 호출 가능, static 메서드는 인스턴스 메서드를 호출 불가능
 */