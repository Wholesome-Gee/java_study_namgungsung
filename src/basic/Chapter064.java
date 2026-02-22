package basic; // 64. 참조형매개변수, 참조형 반환타입

/**
* [핵심 요약]
	1. 참조형 매개변수
		- 메서드 호출 시 값이 아닌 '객체의 주소'를 복사해서 넘겨줍니다.
		- 호출된 메서드가 주소를 알기 때문에, 원본을 직접 조작(읽기/쓰기)할 수 있습니다.
	2. 참조형 반환 타입
		- 메서드가 작업을 마치고 '객체의 주소'를 반환하는 경우입니다.
		- 반환 타입이 참조형이면 호출한 쪽에서도 동일한 참조형 변수로 그 주소를 받아야 합니다.
	3. 실행 흐름 이해
		- 카피(copy) 메서드 예시: 1.새 객체 생성 -> 2.값 복사 -> 3.주소 반환 순으로 동작합니다. 
*/

class Data2 { int x; }

public class Chapter064 {
  public static void main(String[] args) {
  	Data2 d = new Data2();
  	d.x = 10;
  	
  	System.out.println(d.x);

  	change(d); // d 인스턴스의 메모리주소를 넘겨줌
  	
  	System.out.println("After change(d)");
  	System.out.println(d.x);  // 1000 (변경됨!)

  	// 참조형 반환 타입 활용 (새 객체 생성 후 주소 반환)
  	Data2 d2 = copy(d); 
  	System.out.println(d.x); // 원본 d 인스턴스의 x 값
  	System.out.println(d2.x); // 복사한 d2의 x 값
  }

  static void change(Data2 d) { // d = d 인스턴스의 메모리주소
  	d.x = 1000; // d 인스턴스의 x값을 1000으로 변경
  }

  static Data2 copy(Data2 d) { // 반환 타입이 참조형 (Data2) 
  	Data2 tmp = new Data2(); // 새 객체 생성 
  	tmp.x = d.x;             // 값 복사
  	return tmp;              // 새 객체 반환
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 주소 전달의 의미
		- 기본형이 '복사본'을 준 것이라면, 참조형은 '주소'를 준 것입니다. 
	2. 반환 타입이 참조형이면? 
		- "메서드가 객체의 주소를 돌려준다"고 이해하면 쉽습니다. 
			이 주소를 받아서 저장할 변수도 같은 타입이어야 합니다. 
	3. 스태틱 메서드 호출
		- 예제에서 `change(d)`나 `copy(d)` 앞에 참조 변수가 없는 이유는, 
			같은 클래스 내의 `static` 메서드이기 때문입니다.
 */