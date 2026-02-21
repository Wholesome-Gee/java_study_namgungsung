package basic; // 60. 메서드호출

/**
* [핵심 요약]
	1. 메서드 호출 방법
		- 메서드이름(값1, 값2, ...); 
		- 인자(Argument): 호출할 때 괄호 안에 넣는 값들을 말합니다.
	2. 매개변수(Parameter)
		- 매개변수의 타입과 개수는 선언부와 일치해야 하지만, 자동 형변환이 가능하면 타입이 달라도 됩니다. 
	3. 메서드 실행 흐름 
		- 호출 -> arguments -> parameters -> 메서드 내부 문장 실행 -> return(결과 반환) -> 호출한 곳으로 복귀.
*/

class MyMath {
  long add(long a, long b) {
  	return a + b;
  }
  long max(long a, long b) {
  	return (a > b) ? a : b; 
  }
}

public class Chapter060 {
  public static void main(String[] args) {
  	MyMath mm = new MyMath();
  	long result = mm.add(5L, 3L);
  	
  	System.out.println(result); // 8
  	System.out.println(mm.max(5, 3)); // 5
  }
}