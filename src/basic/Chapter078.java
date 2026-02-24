package basic; // 78. 접근 제어자

/**
* [핵심 요약]
	1. 접근 제어자란?
		- 멤버나 클래스에 사용되며, 
			외부로부터의 접근을 제한하는 역할.
			
	2. 접근 범위 (넓은 순서)
		- public: 모두 접근 가능
		- protected: 같은 패키지 + 다른 패키지의 자손 클래스에서 접근 가능.
		- (default): 같은 패키지만 접근 가능.
		- private: 같은 클래스만 접근 가능.
*/

public class Chapter078 { // 클래스는 public 또는 default 만 가능
  private   int pri = 10; // 같은 클래스만 OK
  int dft = 20;           // (default) 같은 패키지만 OK
  protected int pro = 30; // 같은 패키지 + 자손 클래스 OK
  public    int pub = 40; // 누구나 OK

  public void printMembers() {
  	// 같은 클래스 내부이므로 모든 제어자에 접근 가능
  	System.out.println(pri);
  	System.out.println(dft);
  	System.out.println(pro);
  	System.out.println(pub);
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 클래스에 붙일 수 있는 제어자
		- 클래스는 `public`과 `(default)`만 가능. 
		- 하나의 소스 파일에는 `public` 클래스가 단 하나만 존재하고, 클래스명 파일명과 일치.
		
	2. 가시성 가이드
		- private: "이 파일(클래스) 안에서만 쓸 거야!" 
		- default: "우리 폴더(패키지) 사람들끼리만 쓰자!"
		- protected: "우리 폴더 사람들이랑, 나를 따라 하는 자손들까지는 허용해 줄게!"


* [실무 꿀팁 - 캡슐화 편]
	1. 최대한 좁게 시작하세요
		- 처음에는 모든 멤버 변수를 `private`으로 선언하고, 
			외부에서 필요할 때만 `public` 메서드(Getter/Setter)를 통해 공개.
			
	2. 패키지 설계의 중요성
		- `default` 제어자를 잘 활용하면, 같은 기능을 수행하는 클래스들끼리만 데이터를 공유하고 외부에는 숨길 수 있어 응집도 높은 설계가 가능
*/