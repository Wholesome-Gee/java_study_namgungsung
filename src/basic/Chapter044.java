package basic; // 44. 배열의 활용(3)~(4)

import java.util.Arrays;

/**
* [핵심 요약]
	1. 배열의 요소 섞기 (Shuffle)
		- arr[n]을 arr[0]으로 옮기기
			- arr[0]을 tmp에 담고, 
			- arr[n]을 arr[0]에 담고, 
			- tmp를 arr[n]에 담는다.
		- n은 Math.random()을 활용해서 랜덤값으로 설정해준다.
	2. 로또 번호 생성 예제 (00:11:27)
		- 1~45의 숫자가 든 배열을 만들고
		- 앞의 6개만 임의의 위치와 섞어 출력합니다.
*/

public class Chapter044 {
  public static void main(String[] args) {

  	// --- [예제 5-4] 0~9까지 숫자를 무작위로 섞기 (00:06:20) ---
  	System.out.println(">> [Ex 5-4] 배열 섞기");
  	int[] arr = new int[10];

  	for (int i = 0; i < arr.length; i++) {
  		arr[i] = i; // 0~9로 초기화
  	}
  	
  	System.out.println("섞기 전: " + Arrays.toString(arr));

  	for (int i = 0; i < 100; i++) { // 100번 섞기 
  		int random = (int)(Math.random() * 10); // 0~9 중 임의의 인덱스 선택
  		int tmp = arr[0];
  		
  		arr[0] = arr[random];
  		arr[random] = tmp; 
  	}
  	System.out.println("섞은 후: " + Arrays.toString(arr));


  	// --- [예제 5-5] 로또 번호 생성기 (00:11:27) ---
  	System.out.println("\n>> [Ex 5-5] 로또 번호 생성");
  	int[] arr2 = new int[45];

  	// arr2에 1~45 숫자 담기
  	for (int i = 1; i <= arr2.length; i++) {
  		arr2[i] = i ;
  	}
  	// arr2 섞기
  	for (int i = 0; i < 6; i++) {
  		int j = (int)(Math.random() * 45); // 0~44 중 임의의 인덱스
  		int tmp = arr2[i];
  		
  		arr2[i] = arr2[j];
  		arr2[j] = tmp;
  	}
  	// 3. 앞의 6개 번호만 출력
  	System.out.print("로또 번호: ");
  	for (int i = 0; i < 6; i++) {
  		System.out.printf("%d ", arr2[i]);
  	}
  	System.out.println();
  }
}