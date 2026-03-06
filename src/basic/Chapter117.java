package basic; // 117. 형식화 클래스 - DecimalFormat

import java.text.DecimalFormat;

/**
* [강의 필기]
	1. 형식화 클래스란?
		- 숫자(`DecimalFormat`)나 날짜(`SimpleDateFormat`)를 원하는 형태의 문자열로 변환한다.
		- 반대로, 특정 형식의 문자열을 다시 숫자나 날짜로 역변환할 수도 있다.

	2. DecimalFormat 클래스 (숫자 형식화) 
		- 10진수 숫자를 지수 표현, 금액 표현(콤마) 등 다양한 패턴으로 바꿀 때 사용한다.
		- `format(숫자)`: 숫자를 문자열로 변환.
		- `parse(문자열)`: 문자열을 숫자로 변환.

	3. 주요 패턴 기호
		- `0`: 10진수 한 자리. 값이 없으면 0으로 채움.
		- `#`: 10진수 한 자리. 값이 없으면 비워둠.
		- `.`: 소수점 표시.
		- `,`: 단위 구분자(콤마) 표시.
		- `E`: 지수 형태 표시.
		- `%`: 퍼센트 표시.

	4. parse()의 장점
		- `Integer.parseInt()`나 `Double.parseDouble()`은 콤마(`,`)가 포함된 문자열을 숫자로 바꾸지 못하고 에러가 난다.
		- `DecimalFormat.parse()`는 패턴만 맞춰주면 콤마가 있는 문자열도 아주 쉽게 숫자로 변환해준다.
*/

public class Chapter117 {
  public static void main(String[] args) {
  	// 1. 숫자를 문자열로 변환 (format)
  	DecimalFormat df = new DecimalFormat("#,###.##");
  	String result = df.format(1234567.89);
  	System.out.println(result); // 1,234,567.89

  	// 지수 표현 패턴
  	DecimalFormat df2 = new DecimalFormat("0.0E0");
  	System.out.println("지수 형식: " + df2.format(1234567.89)); // 1.2E6

  	// 2. 문자열을 숫자로 변환 (parse)
  	try {
  		// Double.parseDouble("1,234,567.89"); // <-- 콤마 때문에 에러 발생! [00:10:29]
  		DecimalFormat df3 = new DecimalFormat("#,###.##");
  		// parse()는 Number 타입을 반환하므로 형변환이 필요함 [00:06:06]
  		Number num = df3.parse("1,234,567.89");
  		double d = num.doubleValue();
  		
  		System.out.println("문자열 -> 숫자 변환 성공: " + d);
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  }
}

/**
* [Gemini의 보충수업]
	1. Number 타입
		- `parse()` 메서드가 반환하는 `java.lang.Number`는 `Integer`, `Double`, `Float` 등의 조상 클래스이다.
		- 그래서 `num.intValue()`, `num.doubleValue()` 같은 메서드를 써서 내가 원하는 타입으로 쉽게 바꿀 수 있다.

	2. 실무 팁: 데이터 정제 [00:11:10]
		- 엑셀이나 외부 API에서 넘겨받은 데이터에 콤마(`,`)나 통화 기호(`₩`)가 붙어 있을 때, 
		  이를 일일이 `String.replace()`로 지우는 것보다 `DecimalFormat`을 쓰는 게 훨씬 깔끔하고 안전하다.

	3. 패턴 작성 시 주의점 [00:04:52]
		- `0` 패턴은 남는 자리를 '0'으로 강제 채우기 때문에 자릿수를 맞춰야 하는 코드(예: 계좌번호, 학번 등)를 출력할 때 유리하다.
*/