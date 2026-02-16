package basic; // 31. 조건 연산자, 대입 연산자

/**
* [핵심 요약]
	1. 조건 연산자 (삼항 연산자)
    - `조건식 ? ture 실행문 : false 실행문;`
	2. 대입 연산자 (=)
    - 오른쪽 값을 왼쪽(저장공간)에 저장합니다.
    - L-value(왼쪽)는 반드시 값을 변경할 수 있는 '변수'여야 합니다. (final 안돼) 
	3. 복합 대입 연산자
    - 'i+=3' → 'i=i+3'
*/

public class Chapter031 {
  public static void main(String[] args) {
  	// 조건 연산자 활용 (최댓값 구하기)
  	int x = 5, y = 3;
  	int max = (x > y) ? x : y; 
  	System.out.println(max); // 5 

  	// L-value와 R-value
  	int a = 10; // a는 L-value(변수), 10은 R-value(값)
  	
  	// final 상수
  	final int MAX_SIZE = 100; // 상수
  	// MAX_SIZE = 200; // error!

  	// 복합 대입 연산자
  	int i = 0;
  	i += 3; 
  	i *= 10 + 2; // i = i * (10 + 2) 
  	System.out.println(i); // 36
  }
}
/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
 	 3. 복합 대입 연산자 꿀팁!
 	    - `i += 1`은 우리가 앞에서 배운 `i++`와 결과가 같습니다. 
 	    	실무에서는 `i += 1`보다 `i++`를 더 즐겨 쓴답니다.
 */