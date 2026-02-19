package basic; // 42. 배열의 출력

import java.util.Arrays; 

/**
* [핵심 요약]
	1. 배열 직접 출력 시 발생하는 문제 (00:00:36)
		- `System.out.println(iArr);` 처럼 배열 이름을 직접 넣으면 `[I@1b6d3586` 같은 주소값이 나옵니다.
		- `[`는 배열을, `I`는 int 타입을 의미하며, 그 뒤는 메모리 주소와 관련된 값입니다.
	2. 캐릭터 배열(char[])의 예외 
		- 유일하게 `char[]` 배열만 `println`으로 출력했을 때 구분자 없이 문자열처럼 내용이 바로 출력됩니다.
		- char[] arr = {'이','클','립','스'};
		- System.out.println(arr); → 이클립스
	3. Arrays.toString() 활용
		- 배열의 모든 요소를 `[값1, 값2, 값3]` 형태로 예쁘게 문자열로 바꿔 반환해 줍니다.
*/

public class Chapter042 {
  public static void main(String[] args) {
  	
  	// char 배열 출력
  	char[] arr = {'이','클','립','스'};
		System.out.println(arr);	// 이클립스
		
  	// --- [예제 5-1] 배열의 다양한 출력 방법 (00:07:16) ---
  	int[] iArr1 = new int[10];
  	int[] iArr2 = new int[10];
  	int[] iArr3 = {100, 95, 80, 70, 60};

  	// 1. iArr1에 1~10까지의 숫자를 저장
  	for (int i = 0; i < iArr1.length; i++) {
  		iArr1[i] = i + 1; 
  	}

  	// 2. iArr2에 1~10 사이의 난수를 저장 
  	for (int i = 0; i < iArr2.length; i++) {
  		iArr2[i] = (int)(Math.random() * 10) + 1;
  	}

  	// 3. 배열 요소 하나씩 출력하기 
  	System.out.print("iArr1 요소 출력: ");
  	for (int i = 0; i < iArr1.length; i++) {
  		System.out.print(iArr1[i] + (i == iArr1.length - 1 ? "" : ","));
  	}
  	System.out.println();

  	// 4. Arrays.toString()을 이용한 간편 출력
  	System.out.println("iArr2 toString: " + Arrays.toString(iArr2));
  	System.out.println("iArr3 toString: " + Arrays.toString(iArr3));

  	// 6. 배열 이름(참조변수) 직접 출력 시
  	System.out.println("iArr3 직접 출력: " + iArr3); // [I@... 주소값 출력
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 왜 char[]만 바로 출력될까? (00:02:11)
		- 자바의 `println` 설계 시, 문자 배열은 단어(String)처럼 취급해서 바로 보여주도록 특별히 만들어졌기 때문입니다.
	3. import 단축키: Ctrl + Shift + O 
	4. 배열 내용 확인용 팁 
		- 실무에서도 디버깅할 때 for문 돌리기보다는 `Arrays.toString()`을 90% 이상 사용합니다. 
		- 훨씬 빠르고 가독성이 좋기 때문이죠.
 */