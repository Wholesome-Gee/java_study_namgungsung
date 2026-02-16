package basic; // 17. 기본형과 참조형

/**
* [변수의 타입 이분법]
	1. 기본형 (Primitive Type)
    - 종류: 8개 (boolean, char, byte, short, int, long, float, double)
    - 특징: 실제 값(Data)을 변수에 직접 저장합니다. 
    - 저장 용량이 정해져 있으며, 더 이상 추가할 수 없습니다.
	2. 참조형 (Reference Type) 
    - 종류: 기본형 8개를 제외한 나머지 모든 타입 (String, Date, 직접 만든 클래스 등)
    - 특징: 실제 값이 위치한 메모리 주소(Address)를 저장합니다.
    - 프로그래머가 원하는 만큼 얼마든지 새로운 타입을 추가할 수 있습니다.
	3. 참조형 변수의 크기
    - 32bit JVM: 4 byte (약 4GB 메모리 주소 표현 가능)
    - 64bit JVM: 8 byte (어마어마하게 큰 메모리 주소 표현 가능)
    - 강의에서는 이해를 돕기 위해 4 byte 기준으로 설명합니다.
*/

import java.util.Date;

public class Chapter017 {
  public static void main(String[] args) {
  	// 기본형: 변수에 10이라는 값이 직접 들어감
  	int age = 10; 

  	// 참조형: 변수 today에는 객체가 생성된 '메모리 주소'가 들어감
  	Date today = new Date(); 

  	System.out.println(age);   // 10 출력
  	System.out.println(today); // 현재 날짜 정보 출력 (내부 주소를 통해 값을 가져옴)
  }
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
 	 1. 왜 주소를 저장하나요?
 	    - 기본형 데이터는 크기가 작고 뻔하지만, 참조형(객체)은 덩치가 아주 클 수 있습니다. 
 	    	덩치 큰 데이터를 변수에 직접 담기보다, 주소만 관리하는 게 메모리 관리에 훨씬 효율적이기 때문입니다.
 */