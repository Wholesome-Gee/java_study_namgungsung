package basic; // 10. 화면에 글자 출력하기, 덧셈 뺄셈 계산하기

/**
* [화면 출력과 기초 연산 가이드]
	1. 출력 메서드의 종류와 차이점 [00:08:17]
    - System.out.print(): 내용을 출력한 후 줄바꿈을 하지 않습니다.
    - System.out.println(): 내용을 출력한 후 자동으로 줄을 바꿉니다.
*/

public class Chapter010 {
  public static void main(String[] args) {
  	// 1. 문자열 출력 (따옴표 필수)
  	System.out.print("Hello, ");
  	System.out.println("Jiyong!"); // 결과: Hello, Jiyong! (후 줄바꿈)

  	// 2. 사칙연산 출력 (따옴표 없음) [00:10:18]
  	System.out.println(5 + 3); // 덧셈: 8
  	System.out.println(5 - 3); // 뺄셈: 2
  	System.out.println(5 * 3); // 곱셈: 15
  	System.out.println(5 / 3); // 나눗셈: 1 (정수 나누기) [00:11:31]
  }
}