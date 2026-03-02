package basic; // 111. StringBuilder와 Math 클래스

import static java.lang.Math.*; // Math 메서드를 클래스 이름 없이 쓰기 위해 import

/**
* [강의 필기]
	1. StringBuilder 클래스
		- StringBuffer와 100% 똑같은 기능.
		- 차이점: '동기화(Synchronization)'가 안됌
		- 멀티쓰레드 환경이 아닐 땐 동기화가 성능만 깎아먹기 때문에 StringBuilder를 쓰는 게 더 효율적.
			즉, 멀티쓰레드(여러작업자) 환경 = StringBuffer / 싱글쓰레드(솔로작업자) 환경 = StringBuilder

	2. Math 클래스
		- 상수 2개: `E`(자연로그의 밑), `PI`(원주율).

	3. 주요 Math 메서드 
		- abs(): 절대값 반환.			(10 → 10 ,   -10 → 10,   -10.5 → 10.5 )
		- ceil(): 올림.					(1.1 → 2,    2.9 → 3)
		- floor(): 내림. 				(1.9 → 1,    1.1 → 1)
		- max(): 두 값 중 큰 것		(2 , 5  →  5)
		- min(): 두 값 중 작은 것 (2 , 5  →  2)
		- rint(): 반올림인데, 0.5일 로 끝날 때 짝수로 반올림 	(0.5 → 0,    1.5 → 2,    2.5 → 2,    3.5 → 4) 
		- round(): 반올림 														(0.5 → 1,    1.5 → 2,    2.5 → 3,    3.5 → 4)
*/

public class Chapter111 {
  public static void main(String[] args) {
  	// StringBuilder 사용법 (StringBuffer와 동일)
  	StringBuilder str = new StringBuilder("hello");
  	str.append(" world");
  	
  	System.out.println(str); 				// "hello world"
  	
  	
  	// Math 메서드 실습
  	double val = 11.1;
  	double val2 = 55.5;
  	double val3 = 66.5;
  	
  	System.out.printf("%d, %d, %.1f %n", abs(10), abs(-10), abs(10.5)); 	// 10, 10, 10.5
  	System.out.println(ceil(val));  // 12 (올림)
  	System.out.println(floor(val)); // 11 (내림)
  	System.out.println(round(val)); // 11 (반올림) 
  	System.out.println(round(val2)); // 56 (반올림)
  	System.out.println(rint(val2)); // 56 (rint) (56과 54중 가까운 짝수인 56으로 반올림 됌.)
  	System.out.println(rint(val3)); // 66 (rint) (66과 68중 가까운 짝수인 66으로 반올림 됌.)

  	// 소수점 n번째 자리 반올림 팁 (Gemini 보충수업 4번)
  	System.out.println(round(PI*10000)/10000f);	// 3.1416
  }
}

/**
* [Gemini의 보충수업]
	1. 싱글쓰레드 vs 멀티쓰레드
		- 싱글쓰레드는 혼자서 일하는 일꾼, 멀티쓰레드는 여럿이서 동시에 일하는 일꾼.
		- 여럿이서 한 상자(`StringBuffer`)를 같이 쓸 땐 '동기화(자물쇠)'가 필요한데, 
		  혼자 쓸 땐 자물쇠를 채우고 여는 시간조차 낭비이다.
		- 혼자 쓸 땐(싱글쓰레드) 자물쇠 없는 `StringBuilder`가 더 빠른 거야.

	2. Math.rint()는 왜 써?
		- 반올림은 데이터가 많아지면 올림 시 전체 합계가 실제보다 커지는 오차가 발생. (0.n이 쌓여서 n만큼의 오차가 생김)
		  rint()는 올리고 내리는 식(짝수 쪽으로)이라서 대량의 데이터를 합산할 때 오차가 적다.

	3. static import 활용
		- import static java.lang.Math.*; 는 Math 메서드 사용시 Math호출을 생략해준다.  

	4. 소수점 n번째 자리 반올림 팁
		- number에 10의 n승을 곱한다 → `round()` → 다시 10의 n승(실수형)으로 나눈다.
		- 예: 소수점 넷째 자리까지 → round(Math.PI * 10000) / 10000.0
*/