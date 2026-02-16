package basic; // 33. if-else if문, 중첩 if문

import java.util.Scanner;

public class Chapter033 {
  public static void main(String[] args) {
  	int score = 0;
  	char grade = 'D'; // 기본값을 설정해두면 else 블럭을 생략할 수 있어요!
  	char opt = '0';   // +, -를 붙이기 위한 옵션 변수

  	Scanner scanner = new Scanner(System.in);
  	System.out.print("점수를 입력하세요(0~100): ");
  	score = scanner.nextInt();

  	// 중첩 if문을 활용한 학점 계산기
  	if(score >= 90) {
  		grade = 'A';
  		if(score > 95) {
  			opt = '+';
  		} else if(score < 95) {
  			opt = '-';
  		} 
  	} else if (score >= 80) {
  		grade = 'B';
  		if(score > 85) {
  			opt = '+';
  		} else if(score < 85) {
  			opt = '-';
  		} 
  	} else if (score >= 70) {
  		grade = 'C';
  		if(score > 75) {
  			opt = '+';
  		} else if(score < 75) {
  			opt = '-';
  		}
  	}
  	System.out.printf("당신의 학점은 %c%c입니다.%n", grade, opt);
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. 리팩토링(Refactoring) 맛보기
		강의에서 'else 블럭 쓰지 말라'는 조언이 있었죠? 
		변수에 '기본값'을 먼저 넣어두면 굳이 else문을 안 써도 되어 코드가 훨씬 깔끔해진다는 뜻입니다. 
	2. 조건의 순서가 성능을 결정합니다!
		if-else if문은 위에서부터 순서대로 검사합니다. 
		'가장 자주 발생할 것 같은 조건'을 위쪽에 배치하면 컴퓨터가 검사를 덜 해도 되니 조금 더 빨라지겠죠?
	3. 중첩의 늪에 빠지지 마세요
		중첩 if문은 3단계(if 안에 if 안에 if)를 넘어가면 읽기가 매우 힘들어집니다. 
		그럴 땐 지난 시간에 배운 논리 연산자(&&)를 써서 조건을 하나로 합치거나, 나중에 배울 '메서드'로 분리하는 게 좋습니다.
 */