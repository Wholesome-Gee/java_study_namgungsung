package basic; // 28. 반올림 Math.round(), 나머지 연산자

/**
* [핵심 요약]
	1. 반올림: Math.round() 
    - 소수점 첫째 자리에서 반올림하여 정수(long)를 반환합니다.
	2. 나머지 연산자 (%)
    - 왼쪽 값을 오른쪽 값으로 나누고 남은 '나머지'를 구합니다.
    - 몫을 구할 때는 `/`, 나머지를 구할 때는 `%`를 사용합니다.
*/

public class Chapter028 {
  public static void main(String[] args) {
  	// 소수점 4째 자리에서 반올림하여 3째 자리까지 만들기
  	double pi = 3.141592;
  	double shortPi = Math.round(pi * 1000) / 1000.0; 
  	/* 단계별 과정 :
  	   1. pi * 1000 -> 3141.592
  	   2. Math.round(3141.592) -> 3142 (첫째 자리에서 반올림)
  	   3. 3142 / 1000.0 -> 3.142
  	*/
  	System.out.println(+ shortPi);

  	// 특정 자리에서 '버림' 하기
  	double truncatedPi = (int)(pi * 1000) / 1000.0;
  	/* 1. pi * 1000 -> 3141.592
  	   2. (int)3141.592 -> 3141 (소수점 이하 버림)
  	   3. 3141 / 1000.0 -> 3.141
  	*/
  	System.out.println(truncatedPi);

  	// 나머지 연산자 활용
  	int x = 10;
  	int y = 8;
  	System.out.println(x / y); // 1
  	System.out.println(x % y); // 2
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
 	 1. Math.round()의 특징 [00:00:24]
 	    - 이 친구는 무조건 '소수점 첫째 자리'만 봅니다. 
 	    	그래서 우리가 원하는 자리로 소수점을 옮겨놓고(곱하기) 얘를 부른 뒤, 다시 돌려놓는(나누기) 작업을 하는 것입니다. [00:04:46]
 */