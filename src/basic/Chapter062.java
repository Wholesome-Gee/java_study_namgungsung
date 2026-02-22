package basic; // 62. 호출스택

/**
* [핵심 요약]
	1. 스택(Stack)의 특징
		- 밑이 막힌 상자 구조로, 먼저 들어간 것이 나중에 나오고(LIFO, Last In First Out), 나중에 들어간 것이 먼저 나옵니다. 
		- 데이터는 항상 맨 위로만 넣고 뺄 수 있습니다.
	2. 호출 스택(Call Stack)의 정의 (00:02:43)
		- 메서드 수행에 필요한 메모리가 제공되는 공간입니다.
		- 메서드가 호출되면 스택에 메모리가 할당되고, 종료되면 할당되었던 메모리는 반환되어 사라집니다. 
	3. 호출 스택의 실행 흐름 (00:03:22)
		- 스택의 맨 위에 있는 메서드가 현재 실행 중인 메서드입니다.
		- 아래에 있는 메서드는 위에 있는 메서드를 호출한 메서드이며, 대기 상태가 됩니다. 
*/

public class Chapter062 {
  public static void main(String[] args) {
  	// 1. 프로그램 시작 시 main 메서드가 스택에 쌓임
  	System.out.println("main 시작");
  	
  	// 2. firstMethod 호출 -> main은 대기, firstMethod가 실행 상태가 됨
  	firstMethod(); 
  	
  	// 5. firstMethod 종료 후 다시 main으로 돌아와 실행 재개 
  	System.out.println("main 종료");
  }

  static void firstMethod() {
  	// 3. secondMethod 호출 -> firstMethod는 대기, secondMethod가 실행 상태가 됨
  	secondMethod(); 
  }

  static void secondMethod() {
  	// 4. secondMethod 실행 및 종료 -> 스택에서 사라짐 
  	System.out.println("secondMethod 실행 중...");
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 호출 스택으로 알 수 있는 것 
		- 스택을 보면 어떤 메서드가 어떤 메서드를 호출했는지 그 선후 관계를 명확히 알 수 있습니다.
	2. 싱글 스레드 환경
		- 자바의 기본 실행 환경(싱글 스레드)에서는 호출 스택이 하나이므로, 
			한 번에 단 하나의 메서드만 실행될 수 있습니다. 나머지는 모두 자기 차례를 기다리는 대기 상태입니다.
	3. 학습 팁
		- 코드를 분석할 때 머릿속으로만 생각하지 말고, 
			종이에 스택 상자를 그려서 메서드가 쌓이고 빠지는 과정을 시각화. 
 */