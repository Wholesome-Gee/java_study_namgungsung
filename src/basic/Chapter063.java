package basic; // 63. 기본형매개변수

/**
* [핵심 요약]
	1. 기본형 매개변수
		- 메서드의 매개변수 타입이 기본형(int, long, char 등 8개)인 경우를 말합니다.
		- 호출 시 값이 '복사'되어 전달되기 때문에, 메서드 내에서 값을 변경해도 원본에는 영향을 주지 않습니다.
		- 오직 '읽기(Read)'만 가능합니다.
*/

class Data { int x; }

public class Chapter063 {
  public static void main(String[] args) {
  	Data d = new Data();
  	d.x = 10;
  	
  	System.out.println(d.x); // 10

  	change(d.x); // == change(10); 
  	
  	System.out.println("After change(d.x)");
  	System.out.println(d.x); // 10
  }

  static void change(int x) {  // x = 10  
  	x = 1000;  // x = 1000
  	System.out.println(x); // 1000 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 복사의 개념 
		- `change(d.x);`라고 쓸 때, `d.x`라는 변수 자체가 넘어가는 게 아니라 그 안에 들어있는 '숫자 10'이 복사되어 넘어가는 것입니다.
	2. 지역변수의 독립성 
		- main의 `d.x`와 change의 `x`는 이름이 같거나 비슷해 보여도 메모리상에서는 전혀 다른 별개의 공간입니다. [00:05:33]
	3. 학습 팁 
		- 남궁성 선생님이 강조하신 것처럼, 코드만 보고 단계별로 호출 스택(Stack) 그림을 그려보세요.
		- "값이 복사된다"는 말이 그림으로 어떻게 표현되는지 이해하는 것이 이번 강의의 성패를 좌우합니다!
 */