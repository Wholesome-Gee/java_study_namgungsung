package basic; // 38. while문, do-while문

import java.util.Scanner;

/**
* [핵심 요약]
	1. while문 (00:00:42)
		- 조건식이 참(true)인 동안 블록을 반복합니다.
		- 조건이 맞지 않으면 한 번도 실행되지 않을 수 있습니다.
	2. do-while문 (00:14:09)
		- 블록을 무조건 '한 번' 실행한 후에 조건을 검사합니다.
		- 사용자 입력이나 메뉴 선택처럼 "일단 실행하고 확인"해야 할 때 적합합니다.
	3. 주요 알고리즘 (00:06:55)
		- 10으로 나눈 나머지(%)와 몫(/)을 이용하면 숫자의 각 자리수를 분리할 수 있습니다.
*/

public class Chapter038 {
  public static void main(String[] args) {

  	// --- [예제 4-11] while문을 이용한 카운트다운 (00:02:26) ---
  	System.out.println(">> [Ex 4-11] 카운트다운 시작");
  	int i = 5;

  	while (i-- != 0) { 
  		System.out.println(i + "초");
  	}

  	// --- [예제 4-13] 합계가 100을 넘는 시점 찾기 (00:04:31) ---
  	System.out.println("\n>> [Ex 4-13] 합계 누적 알고리즘");
  	int sum = 0;
  	int j = 0;

  	while (sum <= 100) {
  		System.out.printf("%d - %d%n", j, sum);
  		sum += ++j; 
  	}
  	System.out.println("최종 결과: " + j + "까지 더했을 때 합계 " + sum + "으로 100 초과!");

  	// --- [예제 4-14] 숫자의 각 자리수 합 구하기 (00:06:12) ---
  	System.out.println("\n>> [Ex 4-14] 자리수 합산 알고리즘");
  	Scanner scanner = new Scanner(System.in);
  	System.out.print("숫자를 입력하세요 (예: 12345): ");
  	String inputStr = scanner.nextLine();
  	int num = Integer.parseInt(inputStr); // 문자열을 숫자로 변환 (00:07:51)
  	int digitSum = 0;

  	while (num != 0) {
  		// 1. 10으로 나눈 나머지는 항상 '마지막 자리수'입니다. (00:08:52)
  		int lastDigit = num % 10; 
  		digitSum += lastDigit;
  		System.out.printf("추출된 자리수: %d, 현재 합계: %d%n", lastDigit, digitSum);

  		// 2. 10으로 나눈 몫을 저장하여 마지막 자리를 제거합니다. (00:11:05)
  		num /= 10; 
  	}
  	System.out.println("각 자리수의 최종 합: " + digitSum);

  	// --- [예제 4-15] 숫자 맞추기 게임 (00:15:44) ---
  	System.out.println("\n>> [Ex 4-15] Up & Down 게임 (do-while)");
  	int answer = (int)(Math.random() * 100) + 1; // 1~100 난수
  	int userInput = 0;

  	do {
  		System.out.print("1과 100 사이의 정수를 입력하세요: ");
  		userInput = scanner.nextInt();

  		if (userInput > answer) {
  			System.out.println("더 작은 수로 시도해보세요. (Down)");
  		} else if (userInput < answer) {
  			System.out.println("더 큰 수로 시도해보세요. (Up)");
  		}
  	} while (userInput != answer); // 입력값과 정답이 다르면 계속 반복 (00:18:24)

  	System.out.println("축하합니다! 정답입니다.");
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 숫자를 문자로, 문자를 숫자로 (00:07:31)
		- `Integer.parseInt(문자열)`: 숫자로 된 문자열을 실제 계산 가능한 `int`형으로 바꿉니다.
		- 스캐너의 `nextLine()`으로 받은 값은 일단 문자열이므로, 계산을 위해선 이 변환이 필수입니다.
	2. 자리수 추출의 수학적 원리 (00:09:40)
		- 1234 % 10 = 4 (나머지 연산으로 끝자리 획득)
		- 1234 / 10 = 123 (나눗셈 연산으로 끝자리 탈락)
		- 이 두 과정을 반복하면 숫자가 몇 자리든 상관없이 모든 숫자를 하나씩 끄집어낼 수 있습니다.
	4. do-while문의 세미콜론(;) (00:15:31)
		- 초보자들이 가장 많이 하는 실수입니다! `while(조건)` 뒤에 반드시 `;`를 붙여야 문장이 끝난 것으로 간주됩니다. 
		- 반면, 일반 `while`문은 조건 뒤에 중괄호 `{}`가 오기 때문에 `;`을 붙이지 않습니다.
 */