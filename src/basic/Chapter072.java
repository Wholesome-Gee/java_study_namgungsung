package basic; // 72. 단일상속, Object클래스

/**
* [핵심 요약]
	1. 단일 상속(Single Inheritance)
		- 자바에서 자식클래스는 오직 하나의 부모클래스만 상속.
		- 다중 상속 시 '메서드 이름 충돌' 발생 우려.
		- 비중이 높은 클래스는 상속, 나머지는 포함(HAS-A) 관계로 처리하여 다중 상속의 효과를 낼 수 있다.
	2. Object 클래스 - 모든 클래스의 조상
		- 조상이 없는 클래스는 컴파일러가 자동으로 `extends Object`를 추가.
		- 자바의 모든 클래스는 Object에 정의된 11개의 메서드(toString, equals 등)를 상속받는다.
	3. toString() 메서드
		- 객체의 정보를 문자열로 반환합니다. (기본값: 클래스이름@해쉬코드)
		- `System.out.println(obj);`는 내부적으로 `obj.toString();`을 호출합니다.
*/

class Tv3 {
  void power() { System.out.println("TV On!"); }
  public String toString() {
  	return "TV";
  }
}

class Dvd {
  void power() { System.out.println("DVD On!"); }
  public String toString() {
  	return "DVD";
  }
}

// 자바는 다중 상속이 안 되므로 하나는 상속, 하나는 포함으로 구성
class TvDvd extends Tv3 { // Tv는 상속
  Dvd dvd = new Dvd();    // Dvd는 포함
  
  void play() {
  	dvd.power();
  }
  public String toString() {
  	return "TvDvD";
  }
}

public class Chapter072 {
  public static void main(String[] args) {
  	TvDvd td = new TvDvd();
  	
  	// 1. 상속과 포함의 조화
  	td.power(); // 조상 Tv의 메서드
  	td.play();  // 포함된 Dvd의 메서드 호출
  	
  	// 2. Object 클래스의 toString() 사용
  	// TvDvD 클래스에 toString을 오버라이딩 안했다면 Tv클래스에 있는 toString이 실행됨
  	System.out.println("td.toString()은 " + td.toString()); // TvDvD 
  	System.out.println("td는 " + td); // TvDvD
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 다중 상속의 문제점(충돌)
		- 만약 두 부모 클래스에 이름이 같은 메서드가 있다면, 자식은 어느 쪽의 내용을 써야 할지 결정할 수 없다. 이를 '다이아몬드 문제'라고도 함.
		
	2. 인터페이스(Interface) 예고
		- 자바는 단일 상속만 허용하지만, '인터페이스'를 사용하면 다중 상속과 같은 유연함을 안전하게 얻을 수 있다.
		
	3. 모든 길은 Object로 통한다
		- 자바의 상속 계층도를 계속 올라가면 결국 최상위에는 `Object`가 있다. 모든 클래스의 공통 기능을 한곳에서 관리하기 위한 설계이다.


 * [실무 꿀팁 - 클래스 계층 설계 편]
	1. toString() 오버라이딩은 필수
		- 실무에선 클래스의 `toString()`을 오버라이딩하여 멤버 변수들의 값을 보여주도록 설정한다.
	2. 다중 상속이 필요해 보일 때
		- "A이기도 하고 B이기도 한" 클래스를 설계한다면, 핵심 클래스를 상속(extends), 나머지는 인터페이스(implements)로 구현하는 것이 정석.
	3. Object 클래스의 equals() 주의
		- `Object`의 `equals()`는 기본적으로 주소값을 비교한다. 
		- 문자열이나 데이터 객체처럼 '값' 자체를 비교해야 하는 클래스라면 반드시 `equals()`를 재정의해서 써야 한다.
*/