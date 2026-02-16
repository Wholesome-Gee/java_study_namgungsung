package basic; // 36. for문

/**
* [핵심 요약]
	1. for문의 구조 
		for(초기화; 조건식; 증감식) { 반복될 문장 }
	2. 무한 루프(Infinite Loop) 
		조건식을 생략하거나 항상 참으로 만들면 무한히 반복됩니다. 
		중단하려면 콘솔창의 빨간색 'Stop' 버튼을 눌러야 합니다! 
*/

public class Chapter036 {
  public static void main(String[] args) {
  	// 1부터 5까지의 합 구하기 예제
  	int sum = 0;

  	for(int i = 1; i <= 5; i++) { 
  		sum += i; 
  		System.out.printf("1부터 %d까지의 합: %02d%n", i, sum);
  	}

  	// 변수 2개를 사용하는 for문
  	for (int i = 1, j = 10; i <= 10; i++, j--) {
  		System.out.printf("i=%d, j=%d%n", i, j);
  	}
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 반복 횟수를 알 때 vs 모를 때 
		반복 횟수가 정해져 있을 때 `for`문 
		"사용자가 0을 입력할 때까지"처럼 횟수를 모를 때 `while`문
	2. 증감식은 생각보다 다양합니다! 
		`i++`, 
		`i += 2`(2씩 증가),
		`i *= 3`(3배씩 증가),
		`i--`(감소) 
 */