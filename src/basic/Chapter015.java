 package basic; // 15. 문자, 문자열 리터럴, 문자열 결합

/**
* [문자와 문자열]
	1. 문자(char)와 문자열(String)의 차이
    - char: ''와 같이 홑따옴표로 감싼 한 글자입니다.
    - String: "ABC"와 같이 큰따옴표로 감싼 여러 글자(문자열)입니다.
	2. 빈 문자열과 빈 문자 에러
    - String: 빈문자열 가능
    - char: 빈문자 에러
	3. 문자열 결합 (+)
    - 문자열에 숫자를 더하면 숫자가 문자열로 바뀐 뒤 결합됩니다.
    - 예1: "" + 7 + 7 -> "77"
    - 예2: 7 + 7 + "" -> "14" 
*/

public class Chapter015 {
  public static void main(String[] args) {
  	char ch = 'A'; // char 타입은 홑따옴표 사용
  	String str = "ABC"; // String 타입은 큰따옴표 사용
  	String s1 = "" + 10; // 숫자를 문자열로 변환
  	System.out.println(ch); // 'A'
  	System.out.println(str); // "ABC"
  	System.out.println(s1); // "10"
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
   1. String은 사실 클래스입니다 
 	    - String은 객체를 만드는 '클래스'입니다. 
 	    	원래는 `String s = new String("ABC");`라고 써야 합니다.
 	 2. char에 담긴 숫자의 비밀
 	    - 문자 'A'를 숫자 변수(int)에 넣으면 문자 코드인 65가 출력됩니다. 
 */