package basic; // 26. 형변환 연산자, 자동 형변환

/**
* [형변환 요약]
	1. 형변환이란?
    - 변수나 상수의 타입을 다른 타입으로 바꾸는 것 (예: double -> int)
	2. 형변환 방법
    - (int)85.4,  
	3. 자동 형변환 (Implicit Casting)
    - 작은 타입 → 큰 타입으로 컴파일러가 자동으로 형변환을 해주는 것
	4. 수동 형변환 (Explicit Casting) 
    - 큰 타입 → 작은 타입으로 개발자가 직접 명시하는 것 (값 손실 발생 우려)
*/

public class Chapter026 {
  public static void main(String[] args) {
  	// 실수형을 정수형으로 형변환 (큰 타입 → 작은 타입)
  	double d = 85.4;
  	int score = (int)d;  
  	System.out.println(score); // 85 (0.4 값손실)
  	System.out.println(d); // 85.4 (원본 유지)

  	// 문자와 숫자의 형변환 (작은 타입 → 큰 타입)
  	char ch = 'A';
  	int code = (int)ch; // (int)생략가능
  	System.out.println(code); // 65

  	// 자동 형변환 예시 (작은 타입 → 큰 타입)
  	float f = 1234; // int를 float에 저장. 자동 형변환 됨
  	
  	// 수동 형변환 예시 (큰 타입 → 작은 타입) 
  	// int i = 3.14f; // error!
  	int i = (int)3.14f; // 직접 형변환
  	System.out.println(i);  // 3
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
   1. 값 손실(Loss of Data) 주의! 
 	    - 큰 타입에서 작은 타입으로 갈 때 데이터가 잘려나가서 엉뚱한 값이 나올 수 있습니다. (예: (byte)257 → 1)
 	 2. 유니코드의 규칙성
 	    - '0'~'9', 'A'~'Z', 'a'~'z'는 코드값이 연속적으로 배치되어 있습니다. 
 	    	이 성질을 이용하면 나중에 문자를 숫자로 다루는 코딩이 아주 쉬워집니다.
 	 3. 자동 형변환의 방향
 	    - byte(1byte) -> short/char(2byte) -> int(4byte) -> long(8byte) -> float(4byte) -> double(8byte)
 	    - 화살표 방향으로 갈 때는 생략 가능하지만, 반대로 올 때는 반드시 명시해야 합니다!
 */