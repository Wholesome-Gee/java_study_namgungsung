package basic; // 35. 임의의 정수 만들기(Math.random)

/**
* [핵심 요약]
	1. Math.random() 
		0 이상 1 미만 실수(double)를 반환합니다. (0.0 <= x < 1.0)
*/

public class Chapter035 {
  public static void main(String[] args) {
  	// 예: 0~3 사이의 정수 만들기 (int)(랜덤값 x 4)
  	// 예: 1~3 사이의 정수 만들기 (int)(랜덤값 x 3 + 1)
  	// 예: 1~10 사이의 정수 만들기 (int)(랜덤값 x 10 + 1)
  	int num = 0;
  	System.out.printf("금주의 로또1등번호는 : ");
  	
  	for(int i = 1; i <= 6; i++) {
  		num = (int)(Math.random() * 45) + 1;
  		if(i < 6) {
  			System.out.printf(num + ", ");
  		} else {
  			System.out.printf(num + "");
  		}
  	}
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 음수 범위의 난수도 가능해요!
		-5 ~ 5 사이의 난수를 만들고 싶다면? 개수는 11개(-5~-1, 0, 1~5)이고 시작값은 -5입니다.
		공식: (int)(Math.random() * 11) - 5
 */