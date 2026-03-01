package basic; // 105. hashCode(), toString()

import java.util.Objects;

/**
* [강의 필기]
	1. hashCode() 메서드
		- 객체의 주소값을 정수값으로 반환하는 메서드
		- 해싱(hashing) 알고리즘을 사용하는 컬렉션(HashSet, HashMap 등)에서 사용
		- 네이티브 메서드(native method): OS의 기능을 직접 호출하며, 주로 C언어로 작성되어 있다. [00:01:08]
		- 객체마다 다른 값을 가지므로 '객체의 지문'이라고도 불림

	2. equals()와 hashCode()의 관계
		- equals()를 오버라이딩 했다면, hashCode()도 오버라이딩해야함.
		- equals()의 결과가 true인 두 객체의 hashCode() 값은 반드시 같아야 함.

	3. System.identityHashCode(Object x) 
		- 오버라이딩 전, Object x의 해시코드가 필요할 때 사용.
		- 모든 객체가 각자 다른 해시코드를 반환함을 보장.(주소 기반)

	4. toString() 메서드
		- 객체를 문자열(String)로 변환하여 반환.
		- 기본 구현: "클래스이름@16진수_해시코드"
		- 일반적으로 객체의 iv(인스턴스 변수) 값들을 문자열로 결합하여 반환하도록 오버라이딩한다.
*/

class Card105 {
  String kind;
  int number;

  Card105() {
  	this("SPADE", 1); // 기본값 set
  }

  Card105(String kind, int number) {
  	this.kind = kind;
  	this.number = number;
  }

  @Override
  public boolean equals(Object obj) {  // equals() 오버라이딩
  	if (!(obj instanceof Card105)) return false;
  	Card105 c = (Card105)obj;
  	return this.kind.equals(c.kind) && this.number == c.number;
  }

  @Override
  public int hashCode() {  // hashCode() 오버라이딩
  	return Objects.hash(kind, number);
  }

  @Override
  public String toString() {  // toString() 오버라이딩
  	return "kind : " + kind + ", number : " + number; 
  }
}


public class Chapter105 {
  public static void main(String[] args) {
  	Card105 c1 = new Card105();
  	Card105 c2 = new Card105();

  	System.out.println(c1.equals(c2)); // true

  	System.out.println(c1.hashCode()); // c2.hashCode()와 같은 값
  	System.out.println(c2.hashCode()); // c1.hashCode()와 같은 값

  	System.out.println(c1.toString());
  	System.out.println(c2.toString());
  }
}

/**
* [Gemini의 보충수업]
	1. 해시 코드(hashCode)를 '지문'에 비유하는 이유
		- 해시 코드는 수많은 객체 중에서 특정 객체를 빠르게 찾아내기 위한 '숫자 번표'이다.
		- 만약 100만 개의 데이터가 있을 때, 각각 `equals()`로 비교하면 문자 하나하나를 다 비교하기때문에 비용적인 측면에서 무겁고 오래걸린다. 
		- `hashCode()`를 이용해서 먼저 숫자 번표를 비교한 다음, 번표가 같은 그룹끼리만 `equals()`를 수행해 속도를 획기적으로 높이는 원리. 
		  (이를 해싱 알고리즘이라 한다.)

	2. 왜 64비트 JVM에서는 해시 코드가 겹칠 수 있나요?
		- 64비트 시스템의 주소값은 8바이트(long)이고, `hashCode()`는 `int`형(4바이트)을 반환하도록 설계되어 있다. (뒷자리 일부 숫자 잘림) 
		  그로인해 낮은 확률로 서로 다른 주소인데 같은 해시 숫자가 나올 수 있다. 

	3. Objects.hash() 가변 인자의 마법
		- JDK 1.8부터 제공되는 `Objects.hash()`는 내부적으로 매우 복잡한 계산을 거쳐 해시값을 만듬.
		- 비교하고 싶은 iv들만 쉼표로 나열하면 되기 때문에 실무에서는 거의 99% 이 방식을 사용.

	4. 실무에서의 toString() 활용법
		- 실무에서 `toString()`은 사용자에게 보여주는 용도보다는 '로그(Log)' 기록용으로 훨씬 많이 쓰임.
		- 에러가 났을 때 `log.info("에러 발생 객체: " + card)`라고 찍으면 오버라이딩된 `toString()` 덕분에 
		  해당 객체가 어떤 멤버를 가졌는지 한눈에 알 수 있어 디버깅이 매우 쉬움.

	5. 실무 꿀팁: IDE 자동 생성 기능
		- (Alt+Insert 또는 마우스 우클릭 -> Generate)
		- Source탭 → Generate HashCode() and equals()
*/