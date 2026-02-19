package basic; // 43. 배열의 활용(1)~(2)

/**
* [핵심 요약]
	1. sum과 avg 구하기 
		- 반복문을 이용해 sum을 구합니다.
		- avg를 구할 때는 '나눗셈 연산'의 특성에 주의하여 형변환을 활용
	2. 최대값(max)과 최소값(min) 찾기
		- 배열의 첫 번째 요소(`arr[0]`)를 max와 min의 초기값으로 설정
		- 반복문을 돌며 현재 저장된 값보다 더 큰(혹은 작은) 값이 나오면 변수를 갱신합니다.
*/

public class Chapter043 {
  public static void main(String[] args) {

  	// --- [예제 5-2] 총합과 평균 구하기 (00:02:41) ---
  	System.out.println(">> [Ex 5-2] 총합과 평균");
  	int sum = 0;         
  	float avg = 0f;  

  	int[] score = {100, 88, 100, 100, 90};

  	for (int i = 0; i < score.length; i++) {
  		sum += score[i]; 
  	}

  	avg = sum / (float)score.length; // 소수점까지 구하기 위해 float로 형변환

  	System.out.println("총점: " + sum);
  	System.out.println("평균: " + avg);


  	// --- [예제 5-3] 최대값과 최소값 찾기 (00:04:32) ---
  	System.out.println("\n>> [Ex 5-3] 최대값과 최소값");
  	int[] score2 = {79, 88, 91, 33, 100, 55, 95};

  	// 배열의 첫 번째 값으로 초기화
  	int max = score2[0]; 
  	int min = score2[0];

  	for (int i = 1; i < score2.length; i++) { // 0번째는 이미 초기값으로 썼으니 1부터 시작(최적화)
  		if (score2[i] > max) {
  			max = score2[i]; // 더 큰 값을 만나면 max 업데이트 
  		} else if (score2[i] < min) {
  			min = score2[i]; // 더 작은 값을 만나면 min 업데이트 
  		}
  	}

  	System.out.println("최대값: " + max);
  	System.out.println("최소값: " + min);
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	2. 왜 0번째 요소로 초기화할까? 
		- `max`를 단순히 `0`으로 초기화했다가 배열의 모든 숫자가 음수라면? `max`는 계속 `0`으로 남는 오류가 생깁니다.
		- 그래서 반드시 배열 내부에 존재하는 값(보통 첫 번째 값)으로 기준을 잡는 것이 안전합니다.
 */