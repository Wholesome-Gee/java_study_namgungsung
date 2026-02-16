package basic; // 29. 비교 연산자, 문자열의 비교

/**
* [핵심 요약]
	1. 비교 연산자
    - 비교연산자는 'true' 와 'false'를 반환합니다.
    - >, <, >=, <=, ==, !=
	2. 문자열의 비교: String.equals()
*/

public class Chapter029 {
  public static void main(String[] args) {
  	// 문자 비교
  	System.out.println('A' > 'B'); // false (65 > 66)

  	// 문자열 비교 예시
  	String str1 = "abc";
  	String str2 = "abc";
  	String str3 = new String("abc");

  	// 1. == 연산자 (주소값을 비교)
  	System.out.println(str1 == str2); // true
  	System.out.println(str1 == str3); // false (내용은 같지만 메모리주소가 다름!)

  	// 2. equals() 메서드 (내용 자체를 비교) - 권장 방법
  	System.out.println(str1.equals(str2)); // true
  	System.out.println(str1.equals(str3)); // true
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
 	 1. 대소문자 구분 없이 비교하고 싶을 때
 	    - 강의에는 나오지 않았지만, `str1.equalsIgnoreCase(str2)`를 사용하면 
 	    	'ABC'와 'abc'를 같다고 판단해 줍니다. 꿀팁으로 챙겨두세요!
 */