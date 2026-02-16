package basic; // 32. 조건문 if문과 if-else문

/**
* [핵심 요약]
	1. if문 
		if(조건식){true 실행문}
	2. if-else문
		if(조건식){true 실행문} else {false 실행문}
*/

public class Chapter032 {
	public static void main(String[] args) {
		int score = 75;

		if (score > 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
	}
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. Null-Safe한 문자열 비교 팁
		str.equals("yes") → str이 null일 경우 error!
		"yes".equals(str) → 문자열 리터럴을 앞에 두면 str이 null이어도 에러 없이 false를 반환합니다. 실무 필살기예요!
	2. 복잡한 조건은 변수로 빼기
		if (score >= 60 && age < 20 && isStudent) 처럼 조건이 길어지면 읽기 힘듭니다.
		boolean isPass = (score >= 60 && age < 20 && isStudent);
		if (isPass) { ... } 처럼 변수에 담아 사용하면 코드의 의미가 훨씬 명확해집니다.
 */