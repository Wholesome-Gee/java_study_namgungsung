package basic; // 96. 익명 클래스

///import java.awt.Button;

/**
* [핵심 요약]
	1. 익명 클래스란?
		- 이름이 없는 일회용 클래스.
		- 클래스의 정의와 객체의 생성을 동시에 한 번에 처리.
		
	2. 특징
		- 오직 하나의 객체만을 생성할 수 있는 일회용 클래스.
		- 생성자를 가질 수 없으며, 단 하나의 클래스를 상속받거나 단 하나의 인터페이스만을 구현할 수 있다.
		
	3. 문법
		- 'new 조상클래스명() { ... }' 
		  'new 인터페이스명() { ... }'
		- 이름이 없기 때문에 자기 자신의 이름 대신 조상 클래스나 인터페이스의 이름을 빌려 씀.
*/


public class Chapter096 {
  public static void main(String[] args) {
///  	Button b = new Button("Start");

  	// [일반적인 방법] 별도의 클래스를 정의하고 객체를 생성함
  	/*
  	class EventHandler implements ActionListener {
  	  public void actionPerformed(ActionEvent e) {
  	  	System.out.println("ActionEvent occurred!");
  	  }
  	}
  	b.addActionListener(new EventHandler());
  	*/

  	// [익명 클래스 방법] 정의와 생성을 동시에! (00:06:21)
///  	b.addActionListener(new ActionListener() { // 조상인 인터페이스 이름을 사용 [00:07:19]
///  	  public void actionPerformed(ActionEvent e) {
///  	  	System.out.println("ActionEvent occurred!");
///  	  }
///  	}); // 익명 클래스의 끝 [00:06:56]
  }
}

/**
 * [Gemini의 꼼꼼한 보충수업]
	1. 왜 익명 클래스를 쓰나요?
		- 윈도우 프로그래밍(AWT, Swing)이나 안드로이드 앱 개발 시, 특정 버튼 클릭 등에 반응하는 코드는 보통 해당 위치에서만 한 번 쓰이고 마는 경우가 많다. [00:05:30]
		- 이런 '일회성' 코드를 위해 굳이 클래스 이름을 짓고 별도로 선언하는 번거로움을 줄이기 위해 사용.
	
	2. 컴파일 결과
		- 익명 클래스는 이름이 없어서 숫자로 구분. (예: Outer$1.class)


* [실무 꿀팁 - 7장을 마치며]
	1. 익명 클래스에서 람다로 (00:10:45)
		- 나중에 배우게 될 '람다식(Lambda Expression)'은 이 익명 클래스를 더욱 간결하게 표현한 형태다.
		  오늘 익명 클래스를 잘 이해해 두시면 람다가 아주 쉬워진다.
*/