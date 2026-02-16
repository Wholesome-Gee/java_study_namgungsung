package basic; // 16. 두 변수 바꾸기

/**
* [두 변수 교환(Swap)]
	3. 자바 코드로 구현하기 
		- int x = 10, y = 20;
    - int tmp; // 임시 저장용 빈 변수 선언 
    - tmp = x; // x의 값을 tmp에 저장 
    - x = y;   // y의 값을 x에 저장 
    - y = tmp; // tmp의 값을 y에 저장
*/

public class Chapter016 {
  public static void main(String[] args) {
  	int x = 10, y = 20;
  	int tmp; // 임시 저장 변수

  	System.out.println("x = " + x + ", y = " + y); // x = 10, y = 20

  	// 두 변수 바꾸기 과정
  	tmp = x; // 1. x의 값(10)을 tmp에 저장
  	x = y;   // 2. y의 값(20)을 x에 저장
  	y = tmp; // 3. tmp의 값(10)을 y에 저장

  	System.out.println("x = " + x + ", y = " + y); // x = 20, y = 10
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
 	 1. 변수 이름 'tmp'의 의미
 	    - 'Temporary(일시적인)'의 약자, 잠깐 값을 보관하는 용도의 변수 이름으로 관습처럼 사용합니다.
 */