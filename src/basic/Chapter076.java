package basic; // 76. import문, static import문

/**
* [핵심 요약]
	1. import문 (00:00:09)
		- 클래스를 사용할 때 패키지 이름을 생략할 수 있게 해줍니다.
		- 컴파일러에게 클래스가 어느 패키지에 있는지 정보를 제공하는 역할을 합니다. [00:01:26]
		- 위치: `package`문 다음, `class` 선언문 이전에 작성해야 합니다. [00:06:01]
	2. java.lang 패키지 (00:03:00)
		- 자바의 기본 패키지로, `String`, `System` 등 핵심 클래스들이 포함되어 있습니다.
		- 이 패키지의 클래스들은 `import`문 없이도 사용할 수 있도록 자동으로 처리됩니다. [00:04:25]
	3. static import문 (00:10:05)
		- static 멤버(변수, 메서드)를 사용할 때 클래스 이름까지 생략할 수 있게 해줍니다. [00:10:15]
		- 코드를 매우 간결하게 만들 수 있지만, 남용하면 클래스 이름을 알기 어려워지므로 주의해야 합니다. [00:13:50]
*/

import java.util.Date;       // Date 클래스만 사용 [00:05:12]
import java.util.*;          // java.util 패키지의 모든 클래스 사용 [00:05:23]
import static java.lang.Math.*;      // Math 클래스의 모든 static 멤버 생략 가능 [00:10:21]
import static java.lang.System.out; // System.out을 out으로 생략 가능 [00:10:42]

public class Chapter076 {
  public static void main(String[] args) {
  	// 1. import문 덕분에 패키지명(java.util.Date) 생략 가능 [00:00:44]
  	Date today = new Date();
  	
  	// 2. static import 덕분에 Math.random() 대신 random() 사용 [00:12:44]
  	// 3. static import 덕분에 System.out.println() 대신 out.println() 사용 [00:12:44]
  	out.println("랜덤 숫자: " + random()); 
  	out.println("PI 값: " + PI); // Math.PI 생략 [00:12:56]
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 이클립스 꿀팁 (00:02:06)
		- 단축키 `Ctrl + Shift + O`를 누르면 필요한 import문은 추가하고, 안 쓰는 건 자동으로 지워줍니다. [00:02:21]
	2. 성능에는 지장이 없나요? (00:07:21)
		- `import 패키지.*`를 쓴다고 해서 실행 시 성능이 떨어지지 않습니다. 컴파일 타임에만 아주 약간의 시간이 더 걸릴 뿐입니다. [00:07:44]
	3. 이름이 겹칠 때 (00:09:23)
		- 서로 다른 패키지에 이름이 같은 클래스(예: java.util.Date, java.sql.Date)가 있다면, 하나는 패키지명을 포함한 풀네임을 써줘야 합니다. [00:10:01]
 */

/**
* [실무 꿀팁 - 코드 스타일 편]
	1. 명시적인 import 선언
		- `import java.util.*` 보다는 실제 쓰는 클래스만 `import java.util.List` 처럼 적어주는 것이 코드 가독성(어떤 클래스를 쓰는지 명확히 알 수 있음) 측면에서 권장되기도 합니다. [00:07:52]
	2. static import 사용 시기
		- JUnit 테스트 코드나 Math 클래스의 함수를 수없이 많이 써야 할 때 가독성을 위해 주로 사용합니다. 
	3. package - import - class 순서
		- 이 순서가 바뀌면 컴파일 에러가 나므로 꼭 기억하세요! (소스 파일 구성: 패임클) [00:06:28]
*/