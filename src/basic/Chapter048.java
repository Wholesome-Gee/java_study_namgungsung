package basic; // 48. 2차원 배열 예제

import java.util.Scanner;

/**
* [핵심 요약]
	1. 2차원 배열의 .length
		- `score.length` : 행(Row)의 개수
		- `score[i].length` : i번째 행의 열(Column) 개수
	2. 성적 처리 예제 (00:09:04)
		- 각 행을 학생으로, 각 열을 과목으로 보고 합계와 평균을 구합니다.
		- 평균을 구할 때는 정확한 소수점을 위해 `float` 형변환이 필요합니다. 
	3. 영단어 퀴즈 예제 (00:13:54)
*/

public class Chapter048 {
  public static void main(String[] args) {

  	// --- [예제 1] 2차원 배열의 합계와 평균 (00:00:08) ---
  	System.out.println(">> [Ex 1] 성적 계산기");
  	int[][] arr = {
  		{100, 100, 100},
  		{20, 20, 20},
  		{30, 30, 30},
  		{40, 40, 40}
  	};
  	int totalSum = 0;

  	// 이중 for문의 정석 (00:03:14)
  	for (int i = 0; i < arr.length; i++) { // 행 반복
  		for (int j = 0; j < arr[i].length; j++) { // 열 반복
  			totalSum += arr[i][j];
  		}
  	}
  	
  	System.out.println("전체 총점: " + totalSum);


  	// --- [예제 2] 영단어 퀴즈 (00:13:54) ---
  	System.out.println("\n>> [Ex 2] 영단어 퀴즈");
  	String[][] words = {
  		{"chair", "의자"},
  		{"computer", "컴퓨터"},
  		{"integer", "정수"}
  	};

  	Scanner scanner = new Scanner(System.in);

  	for (int i = 0; i < words.length; i++) {
  		System.out.printf("Q%d. %s의 뜻은? ", i + 1, words[i][0]);
  		String tmp = scanner.nextLine();

  		if (tmp.equals(words[i][1])) {
  			System.out.println("정답입니다!\n");
  		} else {
  			System.out.printf("틀렸습니다. 정답은 %s입니다.\n\n", words[i][1]);
  		}
  	}
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 가변 배열의 이해 (00:07:23)
		- 자바에서는 각 행의 길이가 다른 '가변 배열'도 가능합니다. 
		- 그래서 `score[0].length`라고 고정하기보다 `score[i].length`라고 쓰는 것이 훨씬 안전하고 좋은 코드입니다. [00:08:03]
 */