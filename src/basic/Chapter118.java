package basic; // 118. 형식화 클래스 - SimpleDateFormat

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* [강의 필기]
	1. SimpleDateFormat이란?
		- 날짜와 시간을 다양한 형식으로 출력할 수 있게 해주는 클래스다.
		- `format(Date)`: Date 객체를 지정된 패턴의 문자열로 변환한다.
		- `parse(String)`: 특정 형식의 문자열을 Date 객체로 변환한다.

	2. 주요 패턴 기호
		- `y`: 연도 (yyyy: 2024, yy: 24)
		- `M`: 월 (MM: 01~12, M: 1~12) **(대문자 주의!)**
		- `d`: 일 (dd: 01~31)
		- `E`: 요일 (E: 월, EEEE: 월요일)
		- `a`: 오전/오후 (AM/PM) 
		- `H`: 시간 (0~23시) / `h`: 시간 (1~12시) 
		- `m`: 분 (mm: 00~59) **(소문자 주의!)**
		- `s`: 초 (ss: 00~59)
		- `S`: 밀리초 (1/1000초)

	3. 문자열 변환 프로세스
		- "2024-03-01" -> "2024/03/01"로 형식을 바꾸고 싶다면?
		- 직접 문자열을 자르는 것보다 **[문자열 -> parse() -> Date -> format() -> 새로운 문자열]** 과정을 거치는 것이 안전하고 정확하다.
*/

public class Chapter118 {
  public static void main(String[] args) {
  	// 1. 현재 날짜를 원하는 형식으로 출력 (format)
  	Date now = new Date(); // 현재 시간
  	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	System.out.println(sdf1.format(now));

  	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
  	System.out.println(sdf2.format(now));

  	// 2. 문자열을 Date 객체로 변환 (parse) [00:07:14]
  	String strDate = "2024-12-25";
  	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
  	
  	try {
  		Date xmas = sdf3.parse(strDate); // 문자열을 날짜 객체로!
  		
  		// 변환된 Date 객체를 다른 형식으로 출력해보기
  		SimpleDateFormat sdf4 = new SimpleDateFormat("E요일인 크리스마스");
  		System.out.println(sdf4.format(xmas)); // 수요일인 크리스마스 (예시)
  	} catch (Exception e) {
  		System.out.println("날짜 형식이 맞지 않습니다.");
  	}
  }
}

/**
* [Gemini의 보충수업]
	1. 대소문자 구분 필수! (00:01:33)
		- `M`은 Month(월)이고, `m`은 minute(분)이다. 이를 헷갈리면 7월이 나와야 할 곳에 45분 같은 숫자가 찍히니 주의해야 함. [00:01:40]
		- 연도는 소문자 `y`, 시는 대문자 `H`(24시) 또는 소문자 `h`(12시)를 주로 쓴다.

	2. 예외 처리(try-catch) 필수! (00:07:14)
		- `parse()`는 문자열이 정해진 패턴과 조금이라도 다르면 `ParseException`을 던진다.
		  실무에서는 사용자가 날짜를 잘못 입력할 가능성이 높으므로 반드시 예외 처리를 해줘야 한다.

	3. 날짜 계산과의 연계 [00:08:29]
		- `SimpleDateFormat`으로 사용자의 입력을 받아 `Date`로 바꾼 뒤, 
		  이를 `Calendar`의 `setTime(Date)`에 넣어 날짜 연산을 수행하는 방식이 흔히 쓰인다.
*/