package basic; // 27. 사칙 연산자와 산술 변환

/**
* [산술 변환의 2대 규칙]
	1. 큰 타입으로 일치시킨다.
    - 값 손실을 최소화하기 위해 두 피연산자 중 더 큰 타입으로 자동 형변환됩니다.
    - 예: int + double -> double + double -> 결과는 double
	2. int보다 작은 타입은 무조건 int로 변환된다.
    - byte, short, char는 연산 시 무조건 int로 바뀌어 계산됩니다.
    - 이유: 작은 타입은 계산 중에 쉽게 범위를 넘어가(오버플로우) 결과가 틀릴 수 있기 때문입니다.
*/

public class Chapter027 {
  public static void main(String[] args) {
  	// 정수형 나눗셈의 함정
  	int a = 10;
  	int b = 4;
  	System.out.println(a / b); // 결과: 2 (2.5가 아님! int끼리 연산하면 결과도 int)
  	
  	// 소수점 결과를 얻으려면?
  	System.out.println(a / (float)b); // 결과: 2.5 (한쪽을 실수로 형변환)

  	// 오버플로우 주의 예시
  	long l = 1_000_000 * 2_000_000; 
  	System.out.println(l); // 엉뚱한 음수 값이 나옴!
  	// 이유: 100만*200만 계산 시 이미 int 범위를 넘어서 값이 깨진 값을 long타입에 담은것.
  	long l2 = (long)1_000_000 * 2_000_000; // 미리 long타입으로 형변환
  	System.out.println(l2); // 정상 결과 출력
  	
  	// 문자 연산의 원리
  	char c1 = '2';
  	char c2 = '0';
  	System.out.println(c1 - c2); // 2 (유니코드 50 - 48 연산)
  }
}