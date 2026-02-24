package basic; // 79. 캡슐화

/**
* [핵심 요약]
	1. 접근 제어자를 사용하는 이유
		- 외부로부터 데이터 침공을 보호하기 위해서 (캡슐화)
		- 외부에는 불필요하고 내부적으로만 사용되는 부분을 감추기 위해서
		
	2. 캡슐화 구현 방법
		- 인스턴스 변수(iv)는 `private`으로 설정하여 직접 접근을 막음.
		- `public` 메서드(Getter/Setter)를 통해 간접적으로 접근하게 함.
		
	3. 간접 접근의 장점
		- 메서드 내부에 조건문을 추가하여 유효성 검사를 실시할 수 있음.
*/

class Time {
	// 인스턴스 변수에 외부 접근 차단
  private int hour;   
  private int minute;
  private int second;

  // hour Getter (public) 
  public int getHour() {
  	return hour;
  }
  // hour Setter (public)
  public void setHour(int hour) {
  	if (isInvalidHour(hour)) {
  		this.hour = hour; // 유효성 검사
  	} else {
  		this.hour = 0;
  	}
  }

  // 내부 로직은 private으로 숨김.
  private boolean isInvalidHour(int hour) {
  	return 0 < hour && hour < 24;
  }
}

public class Chapter079 {
  public static void main(String[] args) {
  	Time t = new Time();
  	
  	// t.hour = 25; // private 접근 불가
  	
  	t.setHour(21); 
  	System.out.println(t.getHour());
  	
  	t.setHour(100); 
  	System.out.println(t.getHour());
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 데이터 보호
		- 변수를 public으로 두면 엉뚱한 값(예: 시간인데 -100)이 들어와도 막을 방법이 없음. 
		- private과 Setter를 쓰면 유효성 검사를 실시할 수 있음.
		
	2. 복잡성 감소
		- 외부에서 굳이 몰라도 되는 내부 메서드를 `private`으로 숨긴다.
		
	3. 유지보수 범위 축소
		- `private` 메서드를 수정할 땐 해당 클래스 내부만 확인하면 됨. 
		- `public` 메서드를 수정할 떈 모든 외부 코드를 다 찾아야 하므로 일이 커짐.


* ㄴ[실무 꿀팁 - 캡슐화와 설계 편]
	1. 기본 원칙: 좁게 시작하기
		- 모든 멤버는 `private`으로 시작하고, 
			필요한 것만 최소한의 범위로 공개.
			
	2. Getter/Setter 이름 규칙
		- 멤버 변수명이 `name`이면 `getName()`, `setName()`
		
	3. 도메인 지식의 내재화
		- "시간은 0~23 사이여야 한다"는 규칙을 클래스 내부에 넣어두면, 외부에서 이 규칙을 일일이 신경 쓰지 않아도 된다. (객체 스스로를 책임지는 설계)
*/