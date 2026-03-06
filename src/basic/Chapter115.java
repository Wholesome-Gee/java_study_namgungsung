package basic; // 115. Calendar의 set() 메서드와 날짜 계산

import java.util.Calendar;

/**
* [강의 필기]
	1. 날짜와 시간 설정하기 (set 메서드)
		- `set(int field, int value)`: 특정 필드(연, 월, 일 등)만 개별적으로 설정한다. 
			* set(Calendar.YEAR, 2030)
			* set(Calendar.MONTH, 11)
			* set(Calendar.DATE, 16)
		- `set(year, month, date)`: 연, 월, 일을 한 번에 설정한다.
		- `set(year, month, date, hourOfDay, minute, second)`: 시, 분, 초까지 설정 가능하다.
		- **주의**: 월(Month)은 0부터 시작하므로 8월을 설정하려면 `7`을 입력해야 한다.

	2. 두 날짜 간의 차이 계산하기
		- 날짜나 시간의 차이를 구할 때는 모든 단위를 **초(또는 밀리초)**로 변환하여 계산한다.
		- `getTimeInMillis()`: 해당 날짜를 1/1000초 단위(밀리세컨드)의 long 값으로 반환한다.
		- 계산 순서: 
			1) 두 날짜를 밀리초로 변환한다.
			2) 두 값의 차이를 구한다.
			3) 구한 차이(밀리초)를 다시 초, 분, 시, 일 단위로 환산한다.

	3. 시간 단위 환산 공식 [00:11:36]
		- 1초 = 1000ms
		- 1분 = 60초 * 1000ms
		- 1시간 = 60분 * 60초 * 1000ms
		- 1일 = 24시간 * 60분 * 60초 * 1000ms

	4. clear() 메서드의 중요성
		- `Calendar.getInstance()`는 호출하는 순간의 현재 시간(밀리초 단위 포함)을 가지고 있다.
		- 특정 날짜만 설정(`set`)하더라도 눈에 보이지 않는 시, 분, 초, 밀리초 단위가 남아있어 계산 결과에 오차가 발생할 수 있다.
		- 따라서 날짜 계산 전에는 `clear()`를 호출하여 모든 필드를 초기화하는 것이 정확하다.
*/

public class Chapter115 {
  public static void main(String[] args) {
  	// 1. 날짜 설정 예시 (date1과 date2는 완전히 같지 않고 약간의 ms단위 오차가 있다.)
  	Calendar date1 = Calendar.getInstance();
  	Calendar date2 = Calendar.getInstance();

  	// date1을 2019년 4월 29일로 설정 (월은 0부터 시작하므로 3이 4월임)
  	date1.clear(); // 정확한 계산을 위해 초기화 필수
  	date1.set(2019, 3, 29); 

  	// date2를 2020년 7월 2일로 설정
  	date2.clear();
  	date2.set(2020, 6, 2);

  	// 2. 두 날짜 사이의 차이 계산 (밀리초 단위) [00:09:41]
  	long diff = date2.getTimeInMillis() - date1.getTimeInMillis();
  	
  	// 3. 밀리초를 일(day) 단위로 변환 [00:10:53]
  	// 차이(ms) / (24시간 * 60분 * 60초 * 1000ms)
  	System.out.println("date1: 2019-04-29");
  	System.out.println("date2: 2020-07-02");
  	System.out.println("두 날짜의 차이는 " + (diff) + " 밀리초.");
  	System.out.println("두 날짜의 차이는 " + (diff/1000) + " 초.");
  	System.out.println("두 날짜의 차이는 " + (diff/1000/60) + " 분.");
  	System.out.println("두 날짜의 차이는 " + (diff/1000/60/60) + " 시간.");
  	System.out.println("두 날짜의 차이는 " + (diff/1000/60/60/24) + " 일.");

  	// 4. 시간 설정 예시 (시, 분, 초) [00:03:02]
  	Calendar time = Calendar.getInstance();
  	time.clear();
  	time.set(Calendar.HOUR_OF_DAY, 10);
  	time.set(Calendar.MINUTE, 20);
  	time.set(Calendar.SECOND, 30);
  	
  	System.out.println("설정된 시간: " + time.get(Calendar.HOUR_OF_DAY) + "시 " 
  						+ time.get(Calendar.MINUTE) + "분 " 
  						+ time.get(Calendar.SECOND) + "초");
  }
}

/**
* [Gemini의 보충수업]
	1. 에포크 타임(Epoch Time)
		- `clear()`를 하면 날짜가 1970년 1월 1일 00:00:00으로 초기화된다.
		- 이를 '유닉스 시간' 혹은 '에포크 타임'이라고 하며, 컴퓨터가 시간을 계산하는 기준점이다.
*/