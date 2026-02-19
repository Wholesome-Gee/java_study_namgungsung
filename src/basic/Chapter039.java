package basic; // 39. break문, continue문, 이름 붙은 반복문

import java.util.Scanner;

/**
* [핵심 요약]
	1. break문 
		- 자신이 속한 가장 가까운 반복문을 완전히 벗어납니다.
		- 주로 무한 루프와 if문을 결합하여 특정 조건 시 반복을 멈출 때 사용합니다. 
	2. continue문
		- 반복을 멈추지 않고, '다음 반복'으로 건너뜁니다.
		- for문의 경우 증감식으로 이동하고, while문은 조건식으로 이동합니다.
	3. 이름 붙은 반복문 (00:11:40) (예제 4-19)
		- 중첩 반복문 앞에 이름을 붙여(예: Loop1:), 특정 반복문을 직접 지칭하여 break Loop1하거나 continue Loop1할 수 있습니다.
		- 여러 개의 반복문을 한꺼번에 탈출할 때 필수적입니다. [00:12:14]
*/

public class Chapter039 {
  public static void main(String[] args) {
  	
  	// --- [예제 4-16] break문: 합계가 100을 넘으면 탈출 (00:02:33) ---
  	System.out.println(">> [Ex 4-16] break 예제");
  	int sum = 0;
  	int i = 0;

  	while (true) { // 무한 루프
  		if (sum > 100) break; // sum이 100을 넘는 순간 while문을 빠져나감
  		++i;
  		sum += i;
  	}
  	System.out.println("i=" + i + ", sum=" + sum);

  	// --- [예제 4-17] continue문: 3의 배수 건너뛰기 (00:07:24) ---
  	System.out.println("\n>> [Ex 4-17] continue 예제");
  	for (int j = 0; j <= 10; j++) {
  		if (j % 3 == 0) continue; // j가 0,3,6,9 일 떈, 실행문을 skip하고 다음 증감식으로 넘어간다.  
  		System.out.print(j + " "); // 실행문
  	}
  	System.out.println();

  	// --- [예제 4-18] 메뉴 선택 시스템 (break & continue 조합) (00:08:18) ---
  	System.out.println("\n>> [Ex 4-18] 메뉴 선택 시스템");
  	Scanner scanner = new Scanner(System.in);
  	
  	while (true) {
  		// continue(도돌이표) 시작위치
  		System.out.println("(1) square  (2) square root  (3) log (종료:0)");
  		System.out.print("원하는 메뉴를 선택하세요: ");
  		int menu = scanner.nextInt();

  		if (menu == 0) {
  			System.out.println("프로그램을 종료합니다.");
  			break; // 전체 while문 탈출 (가정문을 벗어나는게 아닌 조건문을 벗어나는것)
  		} else if (!(1 <= menu && menu <= 3)) {
  			System.out.println("메뉴를 잘못 선택하셨습니다. (종료는 0)");
  			continue; // 도돌이표 시작위치로 이동
  		}
  		System.out.println("선택하신 메뉴는 " + menu + "번입니다.");
  	}

  	// --- [예제 4-19] 이름 붙은 반복문: 구구단 특정 조건 탈출 (00:14:25) ---
  	System.out.println("\n>> [Ex 4-19] 이름 붙은 반복문 (Loop1)");
  	Loop1: for (int dan = 2; dan <= 9; dan++) { // 바깥 for문에 Loop1 이름 부여 [00:12:49]
  		for (int su = 1; su <= 9; su++) {
  			if (su == 5) break Loop1; // su가 5가 되면 Loop1 전체를 탈출 [00:16:02]
  			// 만약 그냥 break; 라면 su가 5일 때 안쪽 for문만 나가고 dan은 계속 증가함 [00:15:31]
  			System.out.printf("%d * %d = %d%n", dan, su, dan * su);
  		}
  	}

  	// --- [예제 4-20] 종합: 중첩 메뉴와 전체 탈출 (00:16:22) ---
  	System.out.println("\n>> [Ex 4-20] 종합 예제 (아우터 루프 탈출)");
  	outer: while (true) { 
  		System.out.println("(1) 계산기 (종료:0, 전체종료:99)");
  		int menu = scanner.nextInt();

  		if (menu == 0) break; 
  		if (menu == 99) break outer; // outer로 붙인 전체 루프 탈출 [00:18:56]

  		if (menu == 1) {
  			while (true) { // 계산 루프
  				System.out.print("계산할 값을 입력 (계산종료:0, 전체종료:99): ");
  				int val = scanner.nextInt();
  				if (val == 0) break; // 계산 루프만 탈출 (상위 메뉴로 이동) [00:19:56]
  				if (val == 99) break outer; // 전체 프로그램 종료 [00:19:41]
  				System.out.println("결과: " + (val * val));
  			}
  		}
  	}
  	System.out.println("프로그램이 완전히 종료되었습니다.");
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. for vs while 무한 루프 표기법 [00:01:24]
		- `for(;;)`와 `while(true)`는 동일한 무한 루프입니다.
		- 단, `while()`은 괄호 안에 반드시 `true`를 써야 하지만, `for`는 생략이 가능합니다.
	2. continue의 핵심
		- "나머지 코드는 무시하고 다음 바퀴로 가라!"는 뜻입니다.
		- 특정 조건을 제외(Filtering)하고 싶을 때 사용하면 코드가 훨씬 깔끔해집니다.
	3. 이름 붙은 반복문을 쓰는 이유
		- `break;`는 딱 하나의 문만 열고 나가는 것이라면, 
		- `break 이름;`은 건물의 옥상까지 한꺼번에 뚫고 나가는 비상구와 같습니다. [00:13:10]
	4. 가독성 팁 (00:17:40)
		- 루프에 이름을 붙일 때는 `outer:`, `Loop1:` 처럼 대문자나 의미 있는 단어를 사용하면 
		  나중에 코드를 다시 볼 때 훨씬 이해하기 좋습니다.
 */