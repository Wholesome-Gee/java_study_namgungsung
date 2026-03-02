package basic; // 110. StringBuffer 클래스의 메서드

/**
* [강의 필기]
	1. StringBuffer 생성자
		- StringBuffer(): 기본 16칸의 배열이 생성.
		- StringBuffer(9): 9칸 문자열 배열 생성. (성능 최적화에 권장)
		- StringBuffer("abc"): 3+16칸 생성.

	2. 어펜드와 정보 확인 메서드
		- strBuffer.append(): 문자열을 끝에 추가.
		- strBuffer.capacity(): 버퍼의 전체 길이 반환.
		- strBuffer.length(): 버퍼 내부 문자열의 길이 반환.

	3. 문자 삭제 및 삽입 메서드
		- strBuffer.delete(2, 6): 2부터 6전까지 삭제.
		- strBuffer.deleteCharAt(2): index 2의 문자 삭제.
		- strBuffer.insert(2, str): index 2앞에 문자열(str) 삽입.

	4. 문자 변경 및 조작 메서드
		- strBuffer.replace(2, 6, str): 2부터 6전까지 문자열을 다른 문자열(str)로 치환.
		- strBuffer.setCharAt(2, 'a')`: index 2의 문자를 'a'로 변경.
		- strBuffer.setLength(25)`: 버퍼의 전체 길이를 25로 변경. 더 길게 하면 널 문자(`\u0000`)로 채워지고, 짧게 하면 잘림.
		- strBuffer.reverse(): 저장된 문자의 순서를 거꾸로 뒤집음.

	5. 추출 및 변환 메서드
		- strBuffer.toString(): StringBuffer를 String으로 변환.
		- strBuffer.substring(2, 6): 2부터 6전까지 문자열을 추출해서 String으로 변환.
*/

public class Chapter110 {
  public static void main(String[] args) {
  	// StringBuffer 생성
   	StringBuffer x = new StringBuffer();					// 16칸 문자열배열 생성
   	StringBuffer y = new StringBuffer(10); 				// 10칸 문자열배열 생성
   	StringBuffer str = new StringBuffer("hello"); // 5+16칸 문자열배열 생성
   	
   	// StringBuffer 크기 및 길이
   	System.out.println(str.length());		// 5
   	System.out.println(str.capacity());	// 21
   	
   	// StringBuffer 문자열 추가(맨 뒤)
   	str.append(" 전").append("지").append("용"); 	// 메서드체이닝 (새 객체 생성 X, 기존 객체 변경)
   	System.out.println(str);										// "hello 전지용" 

   	// StringBuffer 문자열 제거 (문자 제거는 deleteCharAt(index))
   	str.delete(6, 8);					//  6부터 8전까지 index에 해당하는 문자 삭제
   	System.out.println(str);  //  "hello 용" 
   	
   	
   	// StringBuffer 문자열 추가(위치 지정)
   	str.insert(6, "전지");		 // index 6번칸부터 "전지"삽입
   	System.out.println(str); //	"hello 전지용"
   	
   	// StringBuffer 문자열 교체(치환)
   	str.replace(6, str.length(), "김찬우");	// index 6번칸부터 끝까지(str.length()) 범위를 "김찬우"로 교체
   	System.out.println(str);							// "hello 김찬우"
   	
   	// StringBuffer 문자열 뒤집기
   	System.out.println(str.reverse());		// "우찬김 olleh"
   	

   	// 내용 비교 (틀린 예)
   	StringBuffer str2 = new StringBuffer("전지용"); 
   	StringBuffer str3 = new StringBuffer("전지용");
   	System.out.println(str2.equals(str3)); // false (오버라이딩 안 돼서 주소값을 비교함)

   	// 내용 비교 (맞는 예)
   	String str4 = new StringBuffer("전지용").toString();
   	String str5 = new StringBuffer("전지용").toString();
   	System.out.println(str4.equals(str5)); // true (String으로 변환 후 내용 비교)


  }
}

/**
* [Gemini의 보충수업]
	1. 왜 setCharAt()은 반환 타입이 void일까?
		- append()나 insert()는 체이닝을 위해 자기 자신을 반환하지만,
		  setCharAt()이나 setLength()는 상태만 바꾸고 끝나는 `void` 타입임. (체이닝 중간에 넣을 수 없음.)

	2. 그림 그려보기
		- 인덱스 번호를 써놓고 문자가 어떻게 밀리고 당겨지는지 직접 그려보는 것도 실력 향상에 도움이 된다.
*/