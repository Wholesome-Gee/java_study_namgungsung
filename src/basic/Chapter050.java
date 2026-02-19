package basic; // 50. Arrays로 배열 다루기

import java.util.Arrays;

/**
* [핵심 요약]
	1. 출력: toString(), deepToString()
		- `toString()`: 1차원 배열의 내용을 문자열로 반환
		- `deepToString()`: 다차원 배열의 내용을 문자열로 반환
	2. 비교: equals(), deepEquals() (00:02:29)
		- `equals()`: 1차원 배열의 내용 비교.
		- `deepEquals()`: 다차원 배열의 내용 비교
	3. 복사: copyOf(), copyOfRange()
		- `copyOf(arr, 개수)`: arr 배열요소를 개수만큼 복사
		- `copyOfRange(arr, from, to)`: arr 배열요소를 from부터 to이전까지 복사
	4. 정렬: sort() 
		- 배열의 요소를 오름차순으로 정렬합니다.
*/

public class Chapter050 {
  public static void main(String[] args) {

  	// 1. 배열의 출력 (toString, deepToString)
  	int[] arr = {4, 2, 0, 1, 3};
  	int[][] arr2D = {{11, 12}, {21, 22}};

  	System.out.println("Arrays.toString(arr): " + Arrays.toString(arr));  // [4, 2, 0, 1, 3]
  	System.out.println("Arrays.deepToString(arr2D): " + Arrays.deepToString(arr2D));  // [[11, 12], [21, 22]]

  	
  	// 2. 배열의 복사 (copyOf, copyCofRange)
  	int[] arr2 = Arrays.copyOf(arr, arr.length); // 전체 복사
  	int[] arr3 = Arrays.copyOfRange(arr, 2, 4);  // 인덱스 2, 3번만 복사

  	System.out.println("arr2 : " + Arrays.toString(arr2)); // [0, 1]
  	System.out.println("arr3 : " + Arrays.toString(arr3)); // [0, 1]


  	// 3. 배열의 비교
  	System.out.println("Arrays.eqauls(arr,arr2): " + Arrays.equals(arr, arr2)); // true

  	// 4. 배열의 정렬
  	Arrays.sort(arr);
  	System.out.println("정렬 후: " + Arrays.toString(arr)); // [0, 1, 2, 3, 4]
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	3. 정렬의 기본 
		- `Arrays.sort()`는 기본적으로 오름차순 정렬입니다. 
		- 내림차순 정렬은 이후 'Comparator'를 배우면 자유자재로 다룰 수 있게 됩니다! [00:14:42]
 */