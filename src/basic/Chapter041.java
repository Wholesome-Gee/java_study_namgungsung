package basic; // 41. 배열의 길이, 배열의 초기화

import java.util.Arrays; // 배열 출력을 위한 import

/**
* [핵심 요약]
	1. 배열의 길이 (arr.length) 
		- 배열 이름 뒤에 `.length`를 붙여 배열의 크기를 얻을 수 있습니다.
		- 배열은 한 번 생성하면 실행 중에 그 길이를 바꿀 수 없습니다.
	2. 배열의 초기화 
		- 생성된 배열의 각 요소에 처음으로 값을 저장하는 것입니다.
		- 생성만 하면 기본값(0)으로 자동 초기화됩니다.
	3. 효율적인 초기화 방법
		- 일일이 `score[0]=10;` 하는 대신, 중괄호 `{}`를 사용해 한 번에 값을 넣을 수 있습니다.
		- int[] arr;  arr = new int[]{ 1,2,3,4,5 };  // 잘 안씀
		- int[] arr = { 1,2,3,4,5 };
*/

public class Chapter041 {
  public static void main(String[] args) {

  	// --- [예제 5-1-1] 배열의 길이 확인과 에러 사례 (00:07:42) ---
  	System.out.println(">> [Ex 5-1-1] 배열 길이와 인덱스 범위");
  	int[] arr = new int[5]; // 길이가 5인 배열 생성
  	int len = arr.length;   // len에 5가 저장됨 [00:00:42]
  	System.out.println("arr.length = " + len);

  	// --- [예제 5-1-2] 변경에 유리한 코드 작성 (00:11:04) ---
  	System.out.println("\n>> [Ex 5-1-2] .length 활용 권장");
  	int[] score = new int[6]; 
  	
  	// 조건식에 6 대신 score.length!
  	for (int i = 0; i < score.length; i++) {
  		System.out.printf("score[%d]: %d%n", i, score[i]);
  	}

  	// --- [예제 5-1-3] 다양한 초기화 방법 (00:13:52) ---
  	System.out.println("\n>> [Ex 5-1-3] 중괄호를 이용한 초기화");
  	
  	// 방법 1 (권장 - 99% 사용) [00:14:19]
  	int[] score2 = {50, 60, 70, 80, 90}; 
  	
  	// 방법 2 (선언과 초기화를 나눠야 할 때만 사용) [00:14:02]
  	int[] score3;
  	score3 = new int[]{100, 200, 300}; 

  	// 출력 확인
  	System.out.println("score2: " + Arrays.toString(score2));
  	System.out.println("score3: " + Arrays.toString(score3));
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 배열의 길이를 바꿀 수 없는 이유
		- 배열은 메모리상에 연속적으로 자리를 잡아야 합니다.
		- 만약 길이를 늘리려는데 바로 옆 칸에 여유 자리가 없을 수도 있습니다.
		- 자리가 부족하면 더 큰 배열을 새로 만들고 기존 내용을 복사하는 것이 정석입니다.
	2. ArrayIndexOutOfBoundsException 
		- "배열 인덱스 범위를 벗어났다"는 뜻이며, 보통 반복문의 조건식에서 `<` 대신 `<=`를 썼을 때 자주 발생합니다.
 */