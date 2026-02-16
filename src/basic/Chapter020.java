package basic; // 20. 화면으로부터 입력받기 (Scanner)

import java.util.Scanner; // Scanner를 import

/**
* [Scanner 클래스 사용 3단계]
	1. 임포트(import) 추가 
    - `import java.util.Scanner;`
	2. 스캐너 객체 생성 
    - `Scanner scanner = new Scanner(System.in);`
    - `System.in`은 화면(키보드)으로부터 입력을 받겠다는 의미입니다.
	3. 값 입력받기
    - `int num = scanner.nextInt();` // 입력받은 정수를 num에 저장
    - `String input = scanner.nextLine();` // 입력받은 한 줄의 문자열을 input에 저장
*/

public class Chapter020 {
  public static void main(String[] args) {
  	// 1. 스캐너 객체 생성(입력기능생성)
  	Scanner scanner = new Scanner(System.in);
  	System.out.print("정수를 입력하세요: ");
  	
  	// 2. 정수 입력받기 ( 100 200 )
  	int num = scanner.nextInt();
  	int num2 = scanner.nextInt();
  	System.out.println(num); // 100
  	System.out.println(num2); // 200
  	

  	// 3. 문자열로 입력받아 숫자로 변환하기
//  	String input = scanner.nextLine(); // 입력받은 한 줄을 문자열로 input에 담음 
//  	int num3 = Integer.parseInt(input); // String타입의 input을 Integer타입으로 변환 (Integer.parseInt())
//  	System.out.println(num3);
  	
  	// scanner를 사용후 닫아줄것!
  	scanner.close();
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
 	 2. nextInt() vs nextLine()
 	    - `nextInt()`: 숫자만 쏙 골라 먹습니다. 간편하지만 한 줄에 여러 값을 받을 때 꼬일 수 있어요.
 	    - `nextLine()`: 한 줄 전체를 통째로 가져옵니다. 보통 이걸로 받고 숫자로 변환하는 게 실무에서는 더 안전할 때가 많습니다.
 	 3. 문자를 숫자로 바꾸는 마법
 	    - `Integer.parseInt(문자열)`은 문자열을 숫자로 바꿔줍니다. 
 	    -	숫자를 문자로 바꿀 때는 `숫자 + ""`를 하면 됩니다.
 */