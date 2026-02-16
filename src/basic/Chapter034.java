package basic; // 34. switch문

import java.util.Scanner;

/**
* [핵심 요약]
	1. switch문의 특징 
		경우의 수가 많을 때 사용합니다.
		조건식을 딱 한 번만 계산하므로 성능 면에서도 유리합니다.
	2. switch문의 제약 조건 
		조건식의 결과는 반드시 정수 또는 문자열이어야 합니다.
		case문의 값은 반드시 '상수'여야 하며, 변수는 사용할 수 없습니다.
	3. break문의 역할
		각 case를 실행한 후 switch문을 완전히 빠져나가게 합니다. 
		없으면 다음 case들까지 브레이크를 만날 때까지 쭉 실행됩니다.
*/

public class Chapter034 {
  public static void main(String[] args) {
  	System.out.print("현재 월을 입력하세요: ");
  	Scanner sc = new Scanner(System.in);
  	int month = sc.nextInt();

  	// switch문 실습
  	switch(month) {
  		case 3: case 4: case 5: // 여러 case를 한 줄에
  			System.out.println("현재 계절은 봄입니다.");
  			break;
  		case 6: case 7: case 8:
  			System.out.println("현재 계절은 여름입니다.");
  			break;
  		case 9: case 10: case 11:
  			System.out.println("현재 계절은 가을입니다.");
  			break;
  		default: // 일치하는 case가 없을 때
  			System.out.println("현재 계절은 겨울입니다.");
  	}
  }
}

/**
 * [Gemini의 꿀팁 보충수업]
	1. break문을 이용한 '의도적인' 생략 기술
		일부러 break를 안 써서 여러 조건을 하나로 묶는 기법을 'Fall-through'라고 합니다. 
		권한 체크(관리자면 A, B, C 다 수행, 일반유저는 C만 수행) 같은 로직에서 아주 유용하게 쓰입니다. 
		단, 실수로 빼먹는 것과는 구분해야 하니 주석으로 `// fall-through `라고 써주는 게 매너입니다!
	2. 왜 case문에는 변수를 못 쓰나요?
		자바 컴파일러는 switch문을 매우 빠르게 처리하기 위해 미리 표(Jump Table)를 만들어둡니다. 
		값이 변해버리면 이 표를 미리 만들 수 없어서 반드시 '상수(final 변수 포함)'만 허용하는 것입니다.
	3. if-else if vs switch 선택 기준
		비교할 값이 '범위(예: score >= 90)'라면 if문 
		비교할 값이 '특정 값(예: grade == 'A')'이면서 개수가 많다면 switch문
 */