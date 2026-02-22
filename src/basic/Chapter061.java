package basic; // 61. return문, 반환값

/**
* [핵심 요약]
	1. return문의 역할
		- 현재 실행 중인 메서드를 종료하고 호출한 곳으로 되돌아갑니다.
		- 반환값이 있는 경우 'return 반환값;' 형태로 작성합니다.
	2. 조건문과 return문 사용 시 주의사항 (00:03:51)
		- 조건문(if) 내부에만 return문이 있으면, 조건이 거짓일 때 반환할 값이 없어 에러가 발생합니다.
		- 따라서 모든 경우(참/거짓)에 return문이 실행되도록 작성해야 합니다.
*/

class MyMath2 {
  void gugudan(int number) {
  	if ( number < 2 || 9 < number ) {
  		return; // 2~9단 아니면 호출한 곳으로 되돌아감
  	}

  	for (int i = 1; i <= 9; i++) {
  		System.out.printf("%d * %d = %d%n", number, i, number * i);
  	}
  }

  long max(long a, long b) {
  	if (a > b) {
  		return a; // 참일 때 반환
  	} else {
  		return b; // 거짓일 때도 반드시 반환값이 있어야 함
  	}
  }
}

public class Chapter061 {
  public static void main(String[] args) {
  	MyMath2 mm2 = new MyMath2();

  	mm2.gugudan(12); // 범위밖이라 return 
  	mm2.gugudan(3);  // 구구단 3단

  	long result = mm2.max(5, 10);
  	System.out.println(result); // 10
  }
}


/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 유효성 검사(Validation)와 return (00:01:24)
		- 메서드 시작 부분에서 입력값이 적절한지 확인하고, 아닐 경우 return으로 미리 끊어주는 방식은 실무에서도 자주 쓰이는 좋은 습관입니다.
 */