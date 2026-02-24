package basic; // 92. 인터페이스의 장점 2

/**
* [핵심 요약]
	1. 개발 시간 단축
		- 인터페이스(껍데기)만 있으면 구현부(알맹이)가 완성되지 않아도 사용부(A)를 작성할 수 있다.
		- 두 작업을 동시에 진행할 수 있어 효율적.
		
	2. 표준화 가능
		- JDBC처럼 표준 인터페이스를 정해두면, 
		  어떤 DB(오라클, MySQL 등)를 쓰더라도 자바 코드는 동일하게 유지된다.
		  
	3. 관계없는 클래스들의 관계 맺기
		- 상속 계층도에서 공통 조상이 없는 클래스들을 하나의 인터페이스로 묶어 다형성을 적용할 수 있습니다.
*/

// [예시] 서로 관계없는 기계 유닛들 수리하기
interface Repairable {} // 마커 인터페이스 (내용 없음)

class Unit3 {
  int hitPoint;
  final int MAX_HP;
  Unit3(int hp) { MAX_HP = hp; }
}

class GroundUnit extends Unit3 {
  GroundUnit(int hp) { super(hp); }
}

// 기계 유닛들만 Repairable 인터페이스를 구현함
class Tank2 extends GroundUnit implements Repairable {
  Tank2() { super(150); }
}

class Dropship2 extends Unit3 implements Repairable { // 공중 유닛
  Dropship2() { super(125); }
}

class Marine2 extends GroundUnit { // 보병은 기계가 아니므로 수리 불가 [00:14:42]
  Marine2() { super(40); }
}

class SCV extends GroundUnit {
  SCV() { super(60); }
  
  // 리페어 메서드: Repairable을 구현한 놈들만 들어와라! [00:17:21]
  void repair(Repairable r) {
  	if (r instanceof Unit3) {
  	  Unit3 u = (Unit3)r;
  	  // 수리 로직 실행... 
  	  System.out.println(u + " 수리 완료!");
  	}
  }
}

public class Chapter092 {
  public static void main(String[] args) {
  	SCV scv = new SCV();
  	Tank2 tank = new Tank2();
  	Dropship2 dropship = new Dropship2();
  	Marine2 marine = new Marine2();
  	
  	scv.repair(tank);     // 가능 (Repairable 구현)
  	scv.repair(dropship); // 가능 (Repairable 구현)
  	// scv.repair(marine); // 에러! Marine은 Repairable을 구현하지 않음 [00:14:47]
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. JDBC와 표준화
		- 자바 애플리케이션은 직접 DB에 연결하지 않고 JDBC 인터페이스를 거친다.
		- 덕분에 DB종류가 바뀌어도 자바 코드는 거의 변경되지 않는 '변경에 유리한 설계'가 가능.
		
	2. 마커 인터페이스 (Marker Interface)
		- `Repairable`처럼 아무 내용 없이 '태그' 역할만 하는 인터페이스를 통해 객체의 속성을 구분할 수 있다.


* [실무 꿀팁 - 객체지향의 완성]
	1. 3대 핵심 개념
		- 추상화, 다형성, 인터페이스는 서로 긴밀하게 연결되어 있다.
		  이 셋을 잘 다루는 것이 객체지향의 꽃이다.
*/