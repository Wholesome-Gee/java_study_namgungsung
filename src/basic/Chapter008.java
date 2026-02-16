package basic; // 8. 이클립스 단축키, 자동 완성, 주석

/**
 * [이클립스 단축키]
	1. 필수 단축키 [00:00:36]
    - Ctrl + Shift + L: 전체 단축키 목록 보기
    - Ctrl + D: 한 줄 삭제
    - Ctrl + Alt + Down/Up: 행 단위 복사 (윈도우 단축키와 충돌 시 설정 변경 필요)
    - Alt + Up/Down: 행 단위 이동 
    - Ctrl + I: 자동 들여쓰기 (코드를 깔끔하게 정렬)
	2. 멀티 컬럼 편집 (Alt + Shift + A)
    - 여러 줄을 동시에 수정할 때 사용
    - shift + Up/Down으로 영역을 지정한 후 입력
	3. 자동 완성 및 템플릿 (Ctrl + Space) [00:09:54]
    - 'syso' 입력 후 Ctrl + Space를 누르면 System.out.println() 자동 생성
    - Preferences 메뉴에서 자신만의 템플릿(예: sop)을 등록하여 사용할 수 있습니다.
 */

public class Chapter008 {
	public static void main(String[] args) {
		// [00:10:18] sysout 단축키를 가장 많이 쓰게 되실 거예요!
		System.out.println("단축키를 익히면 코딩이 즐거워집니다."); 
		System.out.println("Alt + Shift + A 기능을 꼭 연습해 보세요! [00:04:12]");
	}
}

/**
 * [Gemini의 보충수업] - 꼼꼼한 비전공자 가이드
   1. 단축키 커스터마이징 
 	    Window -> Preferences -> General -> Keys
 	 2. 자동 완성의 마법 
 	    타이핑 할때마다 자동완성추천기능 
 	    Window -> Preferences -> Java -> Editor -> Content Assist -> 'Auto activation triggers for Java' 
 	    -> '.abcdefghijklmnopqrstuvwxyz' 입력
 */