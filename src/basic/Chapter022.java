package basic; // 22. 타입 간의 변환 방법

/**
* [타입 변환 핵심 요약]
	1. 숫자 ↔ 문자 변환 
    - 숫자 → 문자: 3 + '0' = '3'
    - 문자 → 숫자: '3' - '0' =  3
	2. 숫자 ↔ 문자열 변환
    - 숫자 → 문자열: 3 + "" = "3"
	3. 문자열 ↔ 숫자 변환 
    - 문자열 → 숫자: Integer.parseInt("3") = 3
    - 문자열 → 실수: Double.parseDouble("3.14") = 3.14
	4. 문자열 ↔ 문자 변환
    - 문자열 → 문자: "3".charAt(0) = '3' 
*/

public class Chapter022 {
  public static void main(String[] args) {
  	// 문자를 숫자로 변환 ( -'0' )
  	char ch = '3';
  	int num = ch - '0'; 
  	System.out.println(num + 1); // 4

  	// 문자열을 숫자로 변환 ( Integer.parseInt("3") )
  	String str = "3";
  	int num2 = Integer.parseInt(str); 
  	System.out.println(num2 + 1); // 4

  	// 숫자를 문자열로 변환 ( +"" )
  	System.out.println(3 + ""); // "3" (문자열)

  	// 문자열을 문자로 변환( String.charAt(0) )
  	char ch2 = "3".charAt(0);
  	System.out.println(ch2); // '3'
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
   1. 왜 하필 문자 '0'을 더하고 빼나요? 
 	    - 문자 '0'부터 '9'까지는 아스키 코드(컴퓨터의 숫자 약속)상 연속적으로 배치되어 있습니다. 
 	    	따라서 문자 '3'에서 '0'을 빼면 그 간격인 숫자 3이 딱 남게 되는 원리예요!
 */