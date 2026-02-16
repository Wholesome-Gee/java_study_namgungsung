package basic; // 30. 논리 연산자, 논리 부정 연산자

/**
* [논리 연산자 핵심]
	1. && (AND 연산자)
    - "그리고"의 의미. 조건이 모두 true일 때만 결과가 true입니다.
	2. || (OR 연산자)
    - "또는"의 의미. 조건 중 하나라도 true이면 결과가 true입니다.
	3. ! (논리 부정 연산자) 
    - "아니다"의 의미. true는 false로, false는 true로 바꿉니다.
*/

public class Chapter030 {
  public static void main(String[] args) {
  	int x = 15;
  	boolean result1 = (x > 10 && x < 20); // true
  	
  	// 배수 체크 (OR 활용)
  	int i = 8;
  	boolean result2 = (i % 2 == 0 || i % 3 == 0); // true

  	// 문자가 숫자인지 확인
  	char ch = '5';
  	boolean isDigit = (ch >= '0' && ch <= '9'); // true 

  	// 4. 논리 부정 연산자 (!)
  	boolean b = true;
  	System.out.println(!b);   // false
  	System.out.println(!!b); // true
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
   1. 수학식처럼 쓰면 안 돼요! 
 	    - 자바에서는 `10 < x < 20`과 같은 표현을 이해하지 못합니다. 
 	    	반드시 `x > 10 && x < 20`처럼 연산자로 연결해줘야 합니다.
 	 2. 가독성을 위해 괄호를 쓰세요. [00:04:50]
 	    - `&&`가 `||`보다 우선순위가 높지만, 여러 연산자가 섞여 있으면 헷갈리기 쉽습니다. 
 	    	어느 쪽을 먼저 계산할지 괄호`()`로 묶어주는 것이 좋은 코딩 습관입니다! 
 	 3. '소문자가 아님'을 표현할 때
 	    - `!(ch >= 'a' && ch <= 'z')`라고 쓰면 "ch가 소문자 범위에 있는 것이 아니다"라는 뜻이 되어 
 	    	읽는 사람 입장에서 훨씬 이해하기 편해집니다.
 */