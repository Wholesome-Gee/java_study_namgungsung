package basic; // 40. 배열의 생성과 선언, 배열의 인덱스

/**
* [핵심 요약]
	1. 배열이란?
		- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것입니다.
	2. 배열의 선언과 생성 
		- 선언: 배열을 다루기 위한 참조변수를 만드는 것 (int[] arr;)
		- 생성: 실제 저장공간을 만드는 것 (arr = new int[5];)
		- 즉, int[] arr = new int[5]
	3. 배열의 인덱스
		- 각 요소에 접근할 때 사용하는 번호로, 범위는 0부터 '배열길이-1'까지입니다.
	4. 배열의 길이
		- arr.length, 이 값은 상수라 변경이 불가능합니다.
*/

public class Chapter040 {
  public static void main(String[] args) {
  	
  	// --- [예제 5-1] 배열의 선언, 생성, 초기화와 출력 (00:15:30) ---
  	System.out.println(">> [Ex 5-1] 배열 기본 예제");
  	
  	int[] score = new int[5]; // 크기가 5인 int형 배열 생성
  	int k = 1;

  	// 2. 배열 요소에 값 저장
  	score[0] = 50;
  	score[1] = 60;
  	score[k+1] = 70; // score[2] = 70; 과 동일
  	score[3] = 80;
  	score[4] = 90;

  	// 3. 배열의 값 읽어오기
  	int tmp = score[k+2] + score[4]; // score[3] + score[4]
  	// System.out.println(score[5]);  // error : ArrayIndexOutOfBoundsException  

  	// 4. for문으로 배열의 모든 요소 출력
  	for (int i = 0; i < 5; i++) {
  		System.out.printf("score[%d]: %d%n", i, score[i]);
  	}
  	System.out.printf("tmp: %d%n", tmp);


  	// --- [예제 5-2] 배열의 길이 활용 (00:13:00) ---
  	System.out.println("\n>> [Ex 5-2] 배열 길이(length) 활용");
  	int[] arr = new int[10];
  	System.out.println("arr.length = " + arr.length); // 10

  	// 배열 길이를 사용하면 배열 크기가 바뀌어도 for문을 수정할 필요가 없습니다.
  	for (int i = 0; i < arr.length; i++) {
  		arr[i] = i + 1;
  		System.out.print(arr[i] + ", ");
  	}
  	System.out.println();
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 배열 길이(length)는 상수 (00:12:40)
		- `score.length`는 값을 읽기만 할 수 있고, 코드로 `score.length = 10;` 처럼 직접 변경할 수는 없습니다.
		- 배열의 크기를 변경하고 싶다면 더 큰 배열을 새로 만들고 기존 값을 복사해야 합니다.
 */