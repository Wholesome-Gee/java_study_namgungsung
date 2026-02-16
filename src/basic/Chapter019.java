 package basic; // 19. printf를 이용한 출력

/**
* [printf() 핵심 가이드]
	1. 왜 printf를 쓰나요? 
    - 출력 형식을 지정할 수 있기 때문입니다. (예: 소수점 n자리까지, 진법 변환 등)
    - `println()`은 형식을 지정할 수 없어 실수가 너무 길게 출력되는 단점이 있습니다. 
	2. 자주 쓰이는 지시자 (Specifier)
    - %b: boolean 형식으로 출력 
    - %d: 10진 정수  
    - %o: 8진 정수  
    - %x: 16진 정수 
    - %f: 부동 소수점 (실수)
    - %e: 지수표현식 (실수)
    - %c: 문자  
    - %s: 문자열 
	3. 줄바꿈의 차이
    - `printf()`는 자동으로 줄을 바꾸지 않습니다. 
    - 마지막에 `%n` 또는 `\n`을 직접 써줘야 줄이 바뀝니다. (가급적 `%n` 권장)
*/

public class Chapter019 {
  public static void main(String[] args) {
  	System.out.println("---진법별 지시자---");
  	System.out.printf("%d%n",15); // 15 (10진수 출력)
  	System.out.printf("%o%n",15); // 17 (8진수 출력, 일 칠 이라고 읽음)
  	System.out.printf("%x%n",15); // f (16진수 출력, 1 2 3 4 5 6 7 8 9 a b c d e f)
  	System.out.printf("%s%n",Integer.toBinaryString(15)); // 1111 (2진수 출력, 15의 이진법은 1111)
  	// (toBinaryString이 1111을 String으로 변환하여 반환하기 때문에 지시자 %s를 사용)
  	
  	System.out.println("--- # 지시자 ---");
  	// 지시자 앞에 #을 붙히면 출력값에 접두사가 붙혀져서 나온다.
  	System.out.printf("%#o%n",15); // 017 (8진수 접두사 0)
  	System.out.printf("%#x%n",15); // 0xf (16진수 접두사 0x)
  	
  	System.out.println("---실수 출력 지시자---");
  	// 실수 출력 지시자 %f, %e, %g
  	float f = 123.456789f;
  	double d = 123.456789;
  	System.out.printf("%f%n", f); // 123.456787 (%f는 소수점아래 6자리까지 출력된다. 정밀도는 앞에서 7자리까지 보장된다. )
  	System.out.printf("%e%n", f); // 1.234568e+02 (%e는 지수형식으로 출력된다. e+02는 10의 2제곱을 의미)
  	System.out.printf("%g%n", f); // 123.457 (%g는 소수점포함 7자리까지 반올림해서 간략한 형식으로 출력된다. 떄에따라 지수형식으로 출력되기도한다.)
  	System.out.printf("%f%n", d); // 123.456789 (float의 정밀도는 앞에서 7자리까지, double의 정밀도는 앞에서 15자리까지 보장된다.)
  	System.out.printf("%.2f%n", f); // 123.46 (%.2f는 소수점아래 2자리까지 부동소수점으로 출력해달라는 의미)
  	
  	System.out.println("---printf()의 지시자---");
  	// printf()의 지시자
  	System.out.printf("%5d%n",10); // ...10 (%5d는 10진수 5자리로 우측정렬 출력해달라는 의미, 남는 자리수는 공백처리)
  	System.out.printf("%-5d%n",10); // 10... (%-5d는 10진수 5자리로 좌측정렬 출력해달라는 의미, 남는 자리수는 공백처리)
  	System.out.printf("%05d%n",10); // 00010 (%05d는 10진수 5자리로 우측정렬 출력해달라는 의미, 남는 자리수는 0처리)
  	System.out.printf("%14.10f%n",d); // 123.4567890000 (%14.10f는 소수점포함 총 14자리로 출력해주고, 소수점아래 10자리까지는 0처리)
  	
  	
  	System.out.println("---다중 지시자 사용---");
  	// 여러 지시자 함께 사용하기
  	int age = 20;
  	int year = 2026;
  	System.out.printf("연도: %d, 나이: %d%n", year, age); // 첫번째 %d = year, 두번째 %d = age가 매칭

  	System.out.println("---문자열 지시자---");
  	// 문자열 일부 출력
  	String url = "www.codechobo.com";
  	System.out.printf("%s%n", url); // www.codechobo.com 
  	System.out.printf("%20s%n", url); // ...www.codechobo.com (20자리로 우측정렬, 남는자리는 공백처리) 
  	System.out.printf("%-20s%n", url); // www.codechobo.com... (20자리로 좌측정렬, 남는자리는 공백처리)
  	System.out.printf("%.8s%n", url); // www.code (왼쪽에서 8글자만 출력)
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
 	 1. 이진수 출력은? [00:08:13]
 	    - 아쉽게도 이진수 지시자는 없습니다. `Integer.toBinaryString(숫자)`를 
 	    	사용해 문자열(%s)로 변환해서 출력해야 합니다. [00:08:24]
 */