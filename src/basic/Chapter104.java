package basic; // 104. Object 클래스와 equals()

/**
* [핵심 요약]
	1. Object 클래스 
		- 모든 클래스의 최고 조상, 11개의 메서드만을 가지고 있다.
		- 주요 메서드 
				* equals(),
				  hashCode(),
				  toString(),
				  getClass() 등
				  
	2. equals(Object obj)
		- 기본 구현: 객체 자신과 매개변수로 받은 객체의 '주소값'을 비교. (`this == obj`)

	3. getClass() (00:02:52)
		- 객체 자신의 클래스 정보를 담고 있는 Class 객체를 반환
*/

class Person {
  long id;

  Person(long id) { this.id = id; }

  // equals() 오버라이딩: 주소값이 아닌 id값을 비교하도록 변경
  @Override
  public boolean equals(Object obj) {
  	if (!(obj instanceof Person)) return false;  // obj가 Person 타입인지 확인 (instanceof)
  	
  	Person p = (Person)obj;  // Person 타입으로 형변환하여 id값 비교
  	return this.id == p.id;
  }
}


public class Chapter104 {
  public static void main(String[] args) {
  	Person p1 = new Person(8011081111222L);
  	Person p2 = new Person(8011081111222L);

  	// 주소값 비교 (==): 서로 다른 객체이므로 false
  	if (p1 == p2) System.out.println("p1과 p2는 같은 객체입니다.");
  	else System.out.println("p1과 p2는 다른 객체입니다.");

  	// 값 비교 (equals): 오버라이딩 덕분에 id가 같으면 true
  	if (p1.equals(p2)) System.out.println("p1과 p2는 같은 사람입니다.");
  	else System.out.println("p1과 p2는 다른 사람입니다.");
  }
}


/**
* [Gemini의 꼼꼼한 보충수업]
	1. getClass()
		- `getClass()`는 객체의 클래스 정보(설계도)를 담은 Class 객체를 반환
		- 이 설계도를 통해 실행 중에 객체를 생성하거나 정보를 얻는 '리플렉션'이 가능해진다.
		
	2. 파이널라이저(finalize)는 쓰지말자.(메모리 정리 과정에서 성능 문제 유발)
	
	3. 프로텍티드 메서드 오버라이딩
		- clone()이나 finalize()는 접근 제어자가 protected이므로, 외부에서 쓰려면 public으로 오버라이딩


* [실무 꿀팁]
	- 실무에서 새로운 클래스를 만들 때, 해당 객체들이 논리적으로 같음을 정의해야 한다면 `equals()` 오버라이딩은 필수
	- 이때 `equals()`를 오버라이딩하면 반드시 `hashCode()`도 같이 오버라이딩해야 한다는 규칙이 있다.
	- `getClass()`를 이용한 리플렉션(Reflection) 기술은 실행 중에 객체의 정보를 알아내고 생성할 수 있게 해주어,
	  유연한 프레임워크 설계에 핵심적으로 사용
*/