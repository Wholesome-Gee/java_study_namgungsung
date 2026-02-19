package basic; // 45. String 배열

/**
* [핵심 요약]
	1. String 배열이란?
		- 여러 개의 문자열을 저장할 수 있는 배열입니다.
		- `String[] name = new String[3];` 처럼 선언합니다.
	2. 참조형 배열의 기본값 
		- int 배열은 `0`으로 초기화, String 같은 참조형 배열은 `null`로 초기화
	3. String 배열의 메모리 구조 (00:01:50)
		- 실제 문자열이 배열에 들어가는 것이 아니라, 문자열이 저장된 메모리 주소(참조값)가 배열 칸에 저장
*/

public class Chapter045 {
  public static void main(String[] args) {

  	// --- [예제 5-1-1] String 배열의 선언과 초기화 (00:02:42) ---
  	System.out.println(">> [Ex 5-1-1] String 배열 기본");
  	
  	// 초기화 방법 1
  	// String[] arr = new String[3];
  	// arr[0] = "가위";
  	// arr[1] = "바위";
  	// arr[2] = "보";

  	// 초기화 방법 2 (더 간편함)
  	String[] arr = {"가위", "바위", "보"};
  	
  	for (int i = 0; i < arr.length; i++) {
  		System.out.println("arr[" + i + "]: " + arr[i]);
  	}

  	// --- [예제 5-1-2] 랜덤 가위바위보 로직 활용 (00:03:10) ---
  	System.out.println("\n>> [Ex 5-1-2] 랜덤 가위바위보 (10회 반복)");
  	
  	for (int i = 1; i <= 10; i++) {
  		int tmp = (int)(Math.random() * 3); // 0 or 1 or 2 
  		System.out.println(i + "번째 결과: " + arr[tmp]);
  	}
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. null의 의미
		- `null`은 "어떠한 객체도 가리키고 있지 않다"는 뜻입니다. 
		- String 배열을 만들고 값을 넣지 않은 상태에서 `arr[0].length()` 같은 메서드를 호출하면 에러가 발생하니 주의해야 합니다.
	3. 가위바위보 게임 만들기 팁
		- 사용자의 입력값(Scanner 활용)과 이 랜덤 결과를 비교하면 훌륭한 게임이 됩니다. 
		- 숫자로 비교하는 것보다 문자열 배열을 통하는 것이 코드가 훨씬 깔끔해집니다. [00:06:28]
 */