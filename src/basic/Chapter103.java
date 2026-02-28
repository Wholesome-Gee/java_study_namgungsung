package basic; // 103. 연결된 예외(Chained Exception)

/**
* [핵심 요약]
	1. 연결된 예외란?
		- 한 예외가 다른 예외를 발생시키는 원인이 될 때, 이들을 서로 연결하는 것.
		- 발생한 예외 A가 예외 B의 원인이 되면, A를 '원인 예외(cause exception)'라고 한다.
		- 즉, 예외B는 예외 A를 포함한다.
		
	2. 주요 메서드 (00:00:42)
		- `initCause(Throwable A)`: 지정한 예외를 원인 예외로 등록. [00:00:52]
		- `getCause()`: 원인 예외를 반환. [00:01:10]
	
	3. 사용하는 이유 (00:07:27)
		- 여러 예외를 하나의 큰 예외로 묶어서 관리하기 위함.(추상화) [00:07:37]
		- Checked 예외를 Unchecked 예외로 변경하고 싶을 때 사용. [00:14:07]
*/

public class Chapter103 {
  public static void main(String[] args) {
  	try {
  	  install();
  	} catch (InstallException e) { // throws한 InstallException ie 를 e 참조변수에 담음
  	  e.printStackTrace(); // 발생한 예외와 원인 예외를 모두 출력 [00:11:33]
  	}
  }

  static void install() throws InstallException {
  	try {
  	  throw new SpaceException("공간 부족");
  	} catch (SpaceException se) {
  	  InstallException ie = new InstallException("설치 중 예외 발생");   
  	  ie.initCause(se); // ie 원인은 se다 → ie는 se를 포함한다  [00:05:06]
  	  throw ie; // 연결된 예외를 던짐 (ln28. throws InstallException)
  	}
  }
}

class InstallException extends Exception {
  InstallException(String msg) { super(msg); }
}

class SpaceException extends Exception {
  SpaceException(String msg) { super(msg); }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. Checked를 Unchecked로 변경하기 (00:14:18)
		- throw new RuntimeException(new Exception클래스들)


* [학습 포인트]
	- "예외 안에 다른 예외를 포함시킨다"는 개념을 잡으면 된다.
	- 세부적인 에러 정보를 유지하면서도, 상위 수준에서는 단순하게 예외를 다룰 수 있게 해주는 아주 유용한 기술.
*/