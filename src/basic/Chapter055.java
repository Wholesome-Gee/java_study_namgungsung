package basic; // 55. 객체배열

/**
* [핵심 요약]
	1. 객체 배열의 정의
		- 객체 배열은 '참조 변수들의 배열'입니다. 
		- 객체를 직접 저장하는 것이 아니라, 객체주소가 담긴 변수들을 묶어놓은 것입니다.
	2. 객체 배열의 생성과 초기화
			Tv[] tvArr = new Tv[3]; // 참조 변수 3개가 만들어지고 null로 초기화됨 
			tvArr[0] = new Tv();
			tvArr[1] = new Tv();
			tvArr[2] = new Tv();
	3. 한 줄로 초기화하는 방법 
		- Tv[] tvArr = { new Tv(), new Tv(), new Tv() };
*/
class Tv1 {}

public class Chapter055 {
  public static void main(String[] args) {
  	Tv1[] tvArr = new Tv1[3]; 

  	for (int i = 0; i < tvArr.length; i++) {
  		tvArr[i] = new Tv1();
  	}
  	System.out.println("객체 배열 생성 및 초기화 완료");
  }
}