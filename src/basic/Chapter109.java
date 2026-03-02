package basic; // 109. StringBuffer 클래스

/**
* [강의 필기]
	1. StringBuffer 클래스란?
		- 가변 문자열 클래스.
		- 내부에 문자 배열(`char[]`)을 가지고 있고, 편집 시 이 배열을 직접 조작함.

	2. StringBuffer의 크기(Capacity) 
		- 기본 16칸의 배열이 생성.
		- new StringBuffer(8) → 8칸 배열 생성 (적절한 크기를 지정해주는 게 좋음.)
		- new StringBuffer("abc") → 3칸 + 16칸 배열 생성 (총 19칸)

	3. StringBuffer의 특징과 조작
		- `append()`: 문자열을 끝에 추가.
		- `delete()`: 특정 범위 문자 삭제. 
		- `insert()`: 특정 위치에 문자 삽입.
		- 메서드체이닝 가능: StringBuffer().append().append().append()

	4. 비교 시 주의사항 (중요!)
		- StringBuffer는 `equals()` 메서드가 오버라이딩 되어 있지 않음.
		  equals()를 써도 내용 비교가 아닌 주소 비교(`==`)를 함.
		- 내용 비교를 하려면 무조건 `toString()`으로 String으로 바꾼 다음에 `equals()`를 써야 함.
*/

public class Chapter109 {
  public static void main(String[] args) {
  	// 1. StringBuffer 생성 및 크기
  	StringBuffer x = new StringBuffer();					// 16칸 문자열배열 생성
  	StringBuffer y = new StringBuffer(10); 				// 10칸 문자열배열 생성
  	StringBuffer str = new StringBuffer("hello"); // 5+16칸 문자열배열 생성
  	
  	System.out.println(str.length());		// 5
  	System.out.println(str.capacity());	// 21
  	
  	// StringBuffer 문자열 추가(맨 뒤)
  	str.append(" 전").append("지").append("용"); 	// 메서드체이닝 (새 객체 생성 X, 기존 객체 변경)
  	System.out.println(str);										// "hello 전지용" 

  	// StringBuffer 문자열 제거
  	str.delete(6, 8);					//  6부터 8전까지 index에 해당하는 문자 삭제
  	System.out.println(str);  //  "hello 용" 
  	
  	// StringBuffer 문자열 추가(위치 지정)
  	str.insert(6, "전지");		 // index 6번칸부터 "전지"삽입
  	System.out.println(str); //	"hello 전지용"
  	

  	// 3. 내용 비교 (틀린 예)
  	StringBuffer str2 = new StringBuffer("전지용"); 
  	StringBuffer str3 = new StringBuffer("전지용");
  	System.out.println(str2.equals(str3)); // false (오버라이딩 안 돼서 주소값을 비교함)

  	// 4. 내용 비교 (맞는 예)
  	String str4 = new StringBuffer("전지용").toString();
  	String str5 = new StringBuffer("전지용").toString();
  	System.out.println(str4.equals(str5)); // true (String으로 변환 후 내용 비교)
  }
}

/**
* [Gemini의 보충수업]
	1. 가변(Mutable)이 왜 좋아? 
		- String은 수정 시 매번 새 객체를 만들어서 쓰레기(GC 대상)를 남기지만,
		  StringBuffer는 기존 주소값에 수정된 데이터를 집어넣는다.
		  여러차례 글자를 합쳐야 할 땐 `StringBuffer`가 훨씬 빠르고 메모리도 적게 쓰임.

	2. StringBuilder랑은 뭐가 달라?
		- StringBuffer는 데이터 동기화가 됨
			* 멀티쓰레드 환경에서 유리
			* 상대적으로 느림
		- StringBuilder는 데이터 동기화가 되지 않음
			* 단일쓰레드 환경에서 유리
			* 상대적으로 빠름
		- 동기화는 한 번에 하나의 쓰레드(일꾼)만 접근할 수 있도록 잠금을 거는 것.
			단일 쓰레드에서는 잠금을 걸 필요가 없기에 잠금 과정이 생략되어 상대적으로 빠름.

	3. 적절한 크기는 어떻게 정해?
		- 다룰 문자열이 대략 100글자 정도라면 `new StringBuffer(110)` 정도로 약간 여유 있게 잡아주는 게 좋다. 
		- 너무 작으면 배열 복사하느라 느려지고, 너무 크면 메모리가 낭비되니까 적당히 균형을 맞춰야 함.

	4. equals() 조심해!
		- 실무에서 가장 많이 실수하는 부분. 
		- "내용이 똑같은데 왜 false가 나오지?" 싶으면 열에 아홉은 `StringBuffer` 상태에서 `equals()`를 쓴 것. 
		- 무조건 toString() 작업을 한 후 비교 할 것.
*/