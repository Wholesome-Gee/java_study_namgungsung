package basic; // 49. String 클래스

/**
* [핵심 요약]
	1. String 클래스의 본질
		- String 클래스 = char 배열(char[]) + 메서드(기능)
	2. 변경 불가능한(immutable) 특징 (00:02:12)
		- 한 번 생성된 String의 내용은 변경할 수 없습니다. (읽기 전용)
		- 문자열 결합("a" + "b") 시, 기존 것이 바뀌는 게 아니라 완전히 새로운 문자열이 만들어집니다.
	3. 주요 메서드 5가지 (00:05:07)
		- charAt(index) : index의 문자 하나를 가져옵니다.
		- length() : 문자열의 길이를 반환합니다. (배열과 달리 괄호 '()'가 붙습니다!)
		- substring(from, to) : from부터 to이전까지 출력
		- equals() : 문자열 비교
		- toCharArray() : 문자열을 char 배열로 변환합니다.
*/

public class Chapter049 {
  public static void main(String[] args) {

  	String str = "ABCDE";

  	// 1. charAt() 예제
  	char ch = str.charAt(2); 
  	System.out.println("str.charAt(2): " + ch); // C

  	// 2. length() 예제 
  	System.out.println("str.length(): " + str.length()); // 5

  	// 3. substring() 예제 
  	String str2 = str.substring(1, 4); 
  	System.out.println("str.substring(1, 4): " + str2); // BCD

  	// from만 지정하면 끝까지 추출
  	String str3 = str.substring(1); 
  	System.out.println("str.substring(1): " + str3); // BCDE

  	// 4. equals() 예제 
  	String input = "ABCDE";
  	if (str.equals(input)) {
  		System.out.println("두 문자열의 내용이 같습니다.");
  	}
  	
  	// 5. toCharArray() 에제
  	char[] str4 = str.toCharArray();
  	System.out.println(str4);
  }
}