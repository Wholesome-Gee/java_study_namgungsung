package basic; // 114. 날짜와 시간, Calendar 클래스

import java.util.Calendar;

/**
* [강의 필기]
	1. 날짜와 시간에 관한 클래스는 'Date', 'Calendar', 'java.time 패키지'가 있다.
		- `Date`클래스 (JDK 1.0): 초기에 급히 만들어져 단점이 많음. 대부분 메서드가 'deprecated'(사용 권장 안 함)
		- `Calendar`클래스 (JDK 1.1): Date를 개선하여 등장함. 오랜 기간 표준으로 쓰였으나 여전히 불편한 점이 존재함.
		- `java.time` 패키지 (JDK 1.8): 날짜와 시간을 분리하고(LocalDate, LocalTime) 단점을 완전히 개선한 최신 방식.
		- 실무에서는 여전히 `Calendar`를 사용하는 곳이 많아 학습이 필수적임.

	2. Calendar 클래스의 특징 
		- 추상 클래스, `new` 연산자로 객체를 생성 불가
		- `Calendar.getInstance()` 메서드를 통해 시스템의 국가/지역 설정을 확인하여 적절한 인스턴스를 반환받아야 한다.
		- 보통 서양력을 사용하는 `GregorianCalendar` 객체가 반환.

	3. 주요 필드와 get() 메서드
		- `YEAR`: 연도
		- `MONTH`: 월 (1월은 0 .. 12월은 11)
		- `DATE` / `DAY_OF_MONTH`: 일
		- `DAY_OF_WEEK`: 요일 (1:일요일 ... 7:토요일)
		- `AM_PM`: 오전/오후 구분 (0:오전, 1:오후)
		- `HOUR`: 12시간제 시 / `HOUR_OF_DAY`: 24시간제 시 
*/

public class Chapter114 {
  public static void main(String[] args) {
  	// 1. Calendar 객체 생성 (현재 날짜와 시간으로 설정됨) [00:11:57]
  	Calendar now = Calendar.getInstance();

  	// 2. 날짜 정보 출력 [00:18:22]
  	int year = now.get(Calendar.YEAR);
  	int month = now.get(Calendar.MONTH) + 1; // 월은 0부터 시작
  	int date = now.get(Calendar.DATE);
  	
  	System.out.println(year + "년 " + month + "월 " + date + "일");

  	// 3. 요일 정보 출력 [00:16:11]
  	// 1(일) ~ 7(토) 값을 반환하므로 배열 등을 활용하면 좋다.
  	String[] week = {"", "일", "월", "화", "수", "목", "금", "토"};
  	System.out.println(week[now.get(Calendar.DAY_OF_WEEK)] + "요일");

  	// 4. 시간 정보 출력 [00:16:34]
  	System.out.println("0은 오전, 1은 오후: " + now.get(Calendar.AM_PM));
  	System.out.println("시간(0~11): " + now.get(Calendar.HOUR));
  	System.out.println("시간(0~23): " + now.get(Calendar.HOUR_OF_DAY));
  	System.out.println("분(0~59): " + now.get(Calendar.MINUTE));
  	System.out.println("초(0~59): " + now.get(Calendar.SECOND));

  	// 5. 특정 달의 마지막 날 구하기 [00:12:43]
  	// Calnedar.getInstance().getActualMaximum은 이 달의 마지막날을 반환
  	int lastDay = now.getActualMaximum(Calendar.DATE);  
  	System.out.println("이 달의 마지막 날: " + lastDay + "일");
  }
  
}

/**
* [Gemini의 보충수업]
	1. 왜 getInstance()를 사용하는가?
		- 국가마다 달력 체계가 다르기 때문
		- 특정 클래스를 직접 명시하지 않고 메서드를 통해 객체를 얻는 것이 '추상화'이며 변경에 유리한 코드이다.

	2. 월(Month) 계산 주의점 (00:14:07)
		- 자바 설계 당시의 실수 혹은 다른 언어(C언어 등)와의 호환성 때문에 0부터 시작하도록 설계되었다.
		- 출력하거나 계산할 때 반드시 `+1`을 하는 습관을 들여야 한다.

	3. 실무 팁
		- 최신 프로젝트라면 `java.time` 패키지(LocalDate 등)를 쓰는 것이 훨씬 편하고 안전하다.
		- 하지만 기존 시스템 유지보수나 레거시 코드 연동 시 `Calendar`는 반드시 마주치게 되므로 사용법을 숙지해야 한다. [00:07:37]
*/