package basic; // 76. import문, static import문

/**
* [핵심 요약]
	1. import문
		- 컴파일러에게 클래스가 어느 패키지에 있는지 정보를 제공하는 역할.
		- `package`문 다음, `class` 선언문 이전에 작성.
		
	2. java.lang 패키지
		- 자바의 기본 패키지로, `String`, `System` 등 핵심 클래스들이 포함.
		- 이 패키지의 클래스들은 `import`문 없이도 사용할 수 있도록 자동으로 처리됨.
		
	3. static import문
		- static 멤버(변수, 메서드)를 사용할 때 클래스 이름까지 생략할 수 있게 해줍니다.
			* static import java.lang.Math.random; → Math.random() → random();
		- 코드를 매우 간결하게 만들 수 있지만, 남용하면 클래스 이름을 알기 어려워지므로 주의.
*/

import java.util.Date;       // java.util 패키지의 Date 클래스만 사용
import java.util.*;          // java.util 패키지의 모든 클래스 사용
import static java.lang.Math.*;    // Math 클래스의 모든 static 멤버 생략 가능(random, PI 등등..)
import static java.lang.System.out; // System.out을 out으로 생략 가능

public class Chapter076 {
  public static void main(String[] args) {
  	// import java.util.Date문 덕분에 패키지명(java.util.Date) 생략 가능
  	Date today = new Date();
  	
  	// static import 덕분에 Math.random() → random();
  	// static import 덕분에 System.out.println() → out.println();
  	out.println(random()); 
  	out.println(PI); 
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. import
		- 단축키 : `Ctrl + Shift + O`
		- `import 패키지.*`를 쓴다고 해서 실행 시 성능이 떨어지지 않음.(컴파일 타임에만 아주 약간의 시간이 지연됨)
		- 서로 다른 패키지에 이름이 같은 클래스(예: java.util.Date, java.sql.Date)가 있다면, 
				import java.util.Date;
				Date d1 = new Date();
				java.sql.Date d2 = new java.sql.Date();


* [실무 꿀팁 - 코드 스타일 편]
	1. 명시적인 import 선언
		- `import java.util.*` 보다는 
			실제 쓰는 클래스만 `import java.util.List` 처럼 적어주는 것을 권장.
		
	2. static import 사용 시기
		- JUnit 테스트 코드나 Math 클래스의 함수를 수없이 많이 써야 할 때 주로 사용. 
*/