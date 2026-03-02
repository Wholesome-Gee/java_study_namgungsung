package basic; // 108. StringJoiner, 문자열과 기본형 변환

import java.util.StringJoiner;

/**
* [강의 필기]
	1. String.join()
		- String.join("구분자",str1,str2...)은 여러 문자열을 하나의 문자열로 만든다. 
		- 배열이나 리스트에 담긴 문자열들을 합칠 때 아주 유용함.
		- 내부적으로 `StringBuffer`를 써서 `+` 연산자로 합치는 것보다 성능이 더 좋다.
			* String.join("+","apple","banana","cherry") → "apple+banana+cherry"

	2. 숫자를 문자열로 바꾸기
		- 100 + "" → "100"  					// 속도가 약간 더 느림.
		- String.valueOf(100) → "100" // 속도가 약간 더 빠름.
		- 보통은 1번을 쓰고, 성능이 진짜 중요한 곳에서만 2번을 사용.

	3. 문자열을 숫자로 바꾸기
		- Integer.parseInt("100") → 100 
		- Integer.valueOf(문자열) → 100 (최근에 권장되는 방식)
		- `valueOf()`는 반환 타입이 참조형(Integer)이지만, '오토박싱' 덕분에 기본형(int)에 바로 담을 수 있다.

	4. 변환 메서드 통일
		- 어떤 데이터든 타입 변경 할 땐 `래퍼클래스.valueOf()`
*/

public class Chapter108 {
  public static void main(String[] args) {
  	// 1. String.join()
  	String fruits = "apple,banana,cherry";
  	String[] furitsArr = fruits.split(","); 					// {"apple","banana","cherry"}
  	System.out.println(String.join("/", furitsArr));  // "apple/banana/cherry"

  	// 2. 숫자를 문자열로
  	System.out.println(100 + "");							// "100" → 편리함(보편적 사용)
  	System.out.println(String.valueOf(100));  // "100" → 빠름(선택적 사용)

  	// 3. 문자열을 숫자로
  	System.out.println(Double.parseDouble("3.14"));	// 3.14 → 옛날 방식
  	System.out.println(Double.valueOf("3.14"));			// 3.14 → 권장 방식(래퍼클래스.valueOf()로 통일)

  	// 4. 복합 변환 예제
  	System.out.println(String.join("", String.valueOf(100),"+", String.valueOf(200))); // "100+200"
  	
  	// 구분자를 넣으면?
  	String joinedWithStar = String.join("_", String.valueOf(100),"+",String.valueOf(200));
  	System.out.println(joinedWithStar); // "100_+_200"
  	
  	// 보충수업 1. StringJoiner("구분자","좌측 감싸는 기호","우측 감싸는 기호" 
  	StringJoiner fruitsArr = new StringJoiner(",","[","]");  // []
  	StringJoiner fruitsArr2 = new StringJoiner(",","{","}");  // {}
  	
  	fruitsArr.add("apple").add("banana").add("cherry"); 	
  	fruitsArr2.add("apple").add("banana").add("cherry");
  	
  	System.out.println(fruitsArr);	// [apple,banana,cherry]
  	System.out.println(fruitsArr2);	// {apple,banana,cherry}
  	
  	// System.out.println(new StringJoiner(",","[","]").add("apple").add("banana").add("cherry"));
  }
}

/**
* [Gemini의 보충수업]
	1. StringJoiner는 뭐야?
		- `new StringJoiner(",", "[", "]")` 처럼 쓰면 앞뒤에 대괄호를 붙이고 사이에 콤마를 넣는 작업을 아주 쉽게 할 수 있지.

	2. 래퍼 클래스(Wrapper Class)란?
		- 자바의 기본형(int, double 등)을 객체로 만들어주는 클래스 (Integer, Double, Boolean 등)

	3. 오토박싱(Autoboxing)이 뭐야?
		- `Integer` 객체를 `int` 변수에 바로 넣으면 안 되지만, 자바가 형변환을 자동으로 해주는 것. 
		- int i = Integer.valueOf("100"); → int i = Integer.valueOf("100").intValue();

	4. 가독성 vs 성능 (00:09:10)
		- 코드는 성능보다 가독성이 좋은 것이 1순위. 
		- 100 + ""가 성능이 아주 조금 느려도 훨씬 직관적.
*/