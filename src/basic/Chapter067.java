package basic; // 67. 생성자, 기본 생성자

/**
* [핵심 요약]
	1. 생성자란?
		- 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'입니다.
		- 주요 목적은 인스턴스 변수(iv)를 초기화
	2. 생성자의 조건 
		- 이름이 클래스의 이름과 같아야 합니다. 
		- 리턴 값이 없습니다. (void도 붙이지 않음)
	3. 기본 생성자 (Default Constructor)
		- 매개변수가 없는 생성자를 말합니다. 
		- 클래스에 생성자가 하나도 없을 때만 컴파일러가 자동으로 추가해 줍니다.
	4. 매개변수가 있는 생성자 
		- 생성과 동시에 원하는 값으로 iv를 초기화할 수 있어 코드가 간결해집니다.
*/

class Dataa1 {
  int value;
  // 생성자가 없으므로 컴파일러가 기본생성자를 자동으로 추가해줌
}

class Dataa2 {
  int value;

  Dataa2() {
  	// 기본 생성자를 직접 추가해줘야 에러가 안 남
  }
  
  Dataa2(int x) { // 매개변수가 있는 생성자
  	value = x;
  }
}

public class Chapter067 {
  public static void main(String[] args) {
  	Dataa1 d1 = new Dataa1();	// 기본 생성자 사용 가능 (자동 생성됨)
  	Dataa2 d2 = new Dataa2(); // 기본생성자를 추가 안했으면 에러 발생!
  	Dataa2 d3 = new Dataa2(10); // 매개변수 있는 생성자 호출
  	
  	System.out.println(d1.value);
  	System.out.println(d2.value);
  	System.out.println(d3.value);
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 생성자가 왜 필요한가요?
		- `new` 연산자가 객체를 만드는 것이라면, 생성자는 만들어진 객체의 속성(iv)을 채우는 역할
 */