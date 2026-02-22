package basic; // 66. 오버로딩

/**
* [핵심 요약]
	1. 오버로딩의 정의 
		- 한 클래스 내에 매개변수의 타입/개수만 다른 같은 이름의 메서드를 여러 개 정의하는 것
		- 대표적인 예로 `println` 메서드가 있으며, 매개변수 타입에 따라 적절한 메서드가 호출됩니다. [00:01:22]
	2. 장점
		- 이름 하나로 여러 타입을 처리할 수 있어 기억하기 쉽고 오류를 줄일 수 있습니다.
*/

class MyMath3 {
  int add(int a, int b) {
  	System.out.print("int add(int a, int b) - ");
  	return a + b;
  }

  long add(long a, long b) {
  	System.out.print("long add(long a, long b) - ");
  	return a + b;
  }

  int add(int[] a) {
  	System.out.print("int add(int[] a) - ");
  	int result = 0;
  	for (int i : a) result += i;
  	return result;
  }
}

public class Chapter066 {
  public static void main(String[] args) {
  	MyMath3 mm = new MyMath3();

  	System.out.println("결과: " + mm.add(3, 3));      // 1번 호출 
  	System.out.println("결과: " + mm.add(3L, 3L));    // 2번 호출 
  	System.out.println("결과: " + mm.add(new int[]{100, 200, 300})); // 3번 호출 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	3. 호출 순서의 비밀
		- `println("결과: " + mm.add(3, 3))`처럼 메서드 안에 메서드가 있는 경우, 안쪽의 `add`가 먼저 실행되어 결과값을 반환해야 `println`이 최종 출력될 수 있습니다.
 */