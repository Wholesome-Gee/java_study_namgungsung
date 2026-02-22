package basic; // 79. 캡슐화

/**
* [핵심 요약]
	1. 접근 제어자를 사용하는 이유 (00:00:18)
		- 외부로부터 데이터를 보호하기 위해서입니다. (캡슐화) [00:00:22]
		- 외부에는 불필요하고 내부적으로만 사용되는 부분을 감추기 위해서입니다. [00:04:47]
	2. 캡슐화 구현 방법 (00:01:48)
		- 멤버 변수(iv)는 `private`으로 설정하여 직접 접근을 막습니다. [00:01:54]
		- 대신 `public` 메서드(Getter/Setter)를 통해 간접적으로 접근하게 합니다. [00:02:20]
	3. 간접 접근의 장점 (00:03:42)
		- 메서드 내부에 조건문을 추가하여 유효하지 않은 값이 저장되는 것을 막을 수 있습니다. [00:03:51]
*/

class Time {
  private int hour;   // 외부 접근 차단 [00:01:54]
  private int minute;
  private int second;

  // hour 값을 안전하게 변경하는 메서드 (Setter) [00:07:34]
  public void setHour(int hour) {
  	if (isInvalidHour(hour)) return; // 유효성 검사 [00:07:53]
  	this.hour = hour;
  }

  // 내부에서만 사용하는 로직은 private으로 숨깁니다. [00:11:16]
  private boolean isInvalidHour(int hour) {
  	return hour < 0 || hour > 23;
  }

  // hour 값을 읽어오는 메서드 (Getter) [00:08:11]
  public int getHour() {
  	return hour;
  }
}

public class Chapter079 {
  public static void main(String[] args) {
  	Time t = new Time();
  	
  	// t.hour = 25; // 에러! private 멤버라 직접 접근 불가 [00:02:45]
  	
  	t.setHour(21); // 메서드를 통한 안전한 값 변경 [00:08:44]
  	System.out.println("현재 시간: " + t.getHour() + "시");
  	
  	t.setHour(100); // 유효하지 않은 값이므로 무시됨 [00:09:08]
  	System.out.println("잘못된 값 입력 후 시간: " + t.getHour() + "시");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 데이터 보호 (00:01:44)
		- 변수를 public으로 두면 엉뚱한 값(예: 시간인데 -100)이 들어와도 막을 방법이 없습니다. 
		- private과 Setter를 쓰면 "필터"를 거쳐서 올바른 데이터만 남게 됩니다. [00:04:32]
	2. 복잡성 감소 (00:05:20)
		- 외부에서 굳이 몰라도 되는 내부 동작용 메서드들을 `private`으로 숨기면, 클래스 사용자가 봐야 할 정보가 줄어들어 사용하기 편해집니다. [00:11:40]
	3. 유지보수 범위 축소 (00:11:51)
		- `private` 메서드를 수정할 때는 이 클래스 내부만 확인하면 됩니다. 
		- 하지만 `public` 메서드를 수정하려면 이 메서드를 쓰는 모든 외부 코드를 다 찾아야 하므로 일이 커집니다. [00:12:34]
 */

/**
* [실무 꿀팁 - 캡슐화와 설계 편]
	1. 기본 원칙: 좁게 시작하기
		- 모든 멤버는 일단 `private`으로 시작하고, 꼭 필요한 것만 최소한의 범위로 공개하는 것이 좋은 설계입니다. [00:05:20]
	2. Getter/Setter 이름 규칙
		- 멤버 변수명이 `name`이면 `getName()`, `setName()`으로 짓는 것이 관례(JavaBeans 패턴)입니다.
	3. 도메인 지식의 내재화
		- "시간은 0~23 사이여야 한다"는 규칙을 클래스 내부에 넣어두면, 외부에서 이 규칙을 일일이 신경 쓰지 않아도 됩니다. (객체 스스로를 책임지는 설계) [00:04:20]
*/