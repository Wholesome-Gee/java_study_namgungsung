package basic; // 116. Calendar의 연산(add, roll)과 달력 예제

import java.util.Calendar;

/**
* [강의 필기]
	1. 날짜 수정하기: add()와 roll()
		- `add(field, amount)`: 특정 필드의 값을 증가/감소시킨다. **다른 필드에 영향을 준다.**
		- `roll(field, amount)`: 특정 필드의 값을 증가/감소시킨다. **다른 필드에 영향을 주지 않는다.**

	2. 달력 출력 로직의 핵심
		- 해당 월의 **1일이 무슨 요일인지** 알아야 한다. (앞에 공백을 몇 칸 찍을지 결정)
		- 해당 월의 **말일이 며칠인지** 알아야 한다. (언제까지 숫자를 찍을지 결정)
		- **말일 구하는 팁**: 다음 달의 1일에서 하루(`add(DATE, -1)`)를 빼면 이번 달의 마지막 날이 나온다.

	3. Date와 Calendar 간의 변환
		- `Date`는 JDK 1.0부터 있었으나 메서드 대부분이 사용 권장 안 함(deprecated) 상태임.
		- 변환 방법 :
			- Calendar -> Date: `new Date(cal.getTimeInMillis());`
			- Date -> Calendar: `cal.setTime(date);`
*/

public class Chapter116 {
  public static void main(String[] args) {
  	Calendar cal = Calendar.getInstance();
  	cal.clear();
  	cal.set(2020, 7, 31); // 2020년 8월 31일

  	// 1. add(): 다른 필드에 영향을 줌
  	cal.add(Calendar.DATE, 1); // 1일 더하기
  	System.out.println(getStrDate(cal)); // 9월 1일 출력

  	// 2. roll(): 다른 필드에 영향 없음
  	cal.set(2020, 7, 31); // 2020년 8월 31일
  	cal.roll(Calendar.DATE, 1); // 1일 더하기
  	System.out.println(getStrDate(cal)); // 8월 1일 출력

  	// 3. 달력 만들기 핵심 로직 예시
  	printCalendar(2026, 3); // 2020년 7월 달력 출력 시뮬레이션
  }

  // 날짜 출력을 위한 보조 메서드 [00:04:35]
  public static String getStrDate(Calendar cal) {
  	return cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DATE) + "일";
  }

  // 달력 출력 로직 요약
  public static void printCalendar(int year, int month) {
  	Calendar start = Calendar.getInstance();
  	start.clear();
  	start.set(year, month - 1, 1); // 해당 월의 1일로 설정

  	int startDayOfWeek = start.get(Calendar.DAY_OF_WEEK); // 1일의 요일 (1:일, 2:월...)
  	
  	// 말일 구하기: 다음 달 1일에서 1일 빼기 [00:12:31]
  	Calendar end = Calendar.getInstance();
  	end.clear();
  	end.set(year, month, 1); // 다음 달 1일
  	end.add(Calendar.DATE, -1); // 하루 빼면 이번 달 말일
  	int lastDate = end.get(Calendar.DATE);

  	System.out.println("\n   === " + year + "년 " + month + "월 ===");
  	System.out.println("  일  월  화  수  목  금  토");

  	// 1일의 요일까지 공백 출력 [00:14:32]
  	for (int i = 1; i < startDayOfWeek; i++) {
  		System.out.print("    ");
  	}

  	// 날짜 출력 및 토요일마다 줄바꿈 [00:15:16]
  	for (int i = 1, n = startDayOfWeek; i <= lastDate; i++, n++) {
  		System.out.print((i < 10 ? "  " : " ") + i);
  		if (n % 7 == 0) System.out.println(); // 토요일이면 줄바꿈
  	}
  	System.out.println();
  }
}

/**
* [Gemini의 보충수업]
	1. add() vs roll() 실무 활용 
		- 보통은 `add()`를 훨씬 많이 쓴다.
		- `roll()`은 화면 UI에서 시계의 분 단위만 돌리거나, 특정 월 내에서만 날짜를 변경하고 싶을 때 특수하게 사용한다.

	2. 하위 호환성(Backward Compatibility)
		- 자바가 발전 속도가 느려 보일 수 있지만, 20년 전 코드가 최신 자바에서도 돌아가게 만드는 '안정성'이 자바의 최대 강점이다. 
		- `Date`를 없애지 않고 `deprecated`로 두는 것도 바로 이 때문이다. 

	3. 달력 계산 시 주의사항 [00:11:32]
		- `Month`는 항상 `0~11`이라는 것을 잊지 말 것. 달력 출력 로직에서 사용자 입력값이 `9`라면 실제 세팅은 `8`로 해야 한다.
*/