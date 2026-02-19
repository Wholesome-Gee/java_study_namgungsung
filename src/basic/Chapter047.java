package basic; // 47. 2차원 배열

/**
* [핵심 요약]
	1. 2차원 배열이란?
		- 테이블 형태(행과 열)의 데이터를 저장하기 위한 구조입니다.
	2. 선언과 생성
		- 4행 3열의 2차원 배열을 생성
		- int[][] arr = new int[4][3]; 
		- int[][] arr = { 
											{1,2,3},
											{4,5,6},
											{7,8,9},
											{10,11,12} 
										}
*/

public class Chapter047 {
  public static void main(String[] args) {

  	// --- [방법 1] 2차원 배열 선언 후 수동 값 대입 (00:04:24) ---
  	int[][] arr = new int[4][3]; // 4행 3열
  	arr[0][0] = 100; // 0행 0열에 100 저장
  	
  	System.out.println("arr[0][0] = " + arr[0][0]);


  	// --- [방법 2] 생성과 동시에 초기화 (가장 많이 쓰는 방식) (00:05:46) ---
  	int[][] arr2 = {
  		{100, 100, 100}, // 0행
  		{ 20,  20,  20}, // 1행
  		{ 30,  30,  30}, // 2행
  		{ 40,  40,  40}  // 3행
  	};

  	// 2차원 배열의 길이 확인 (00:07:54)
  	System.out.println("arr.length (행의 길이): " + arr.length);       // 4
  	System.out.println("arr[0].length (0행의 열 길이): " + arr[0].length); // 3

  	// 이중 for문을 이용한 전체 출력 (다음 강의 예고)
  	for (int i = 0; i < arr.length; i++) {
  		for (int j = 0; j < arr[i].length; j++) {
  			System.out.printf("arr[%d][%d]=%d  ", i, j, arr[i][j]);
  		}
  		System.out.println();
  	}
  }
}