package basic;
public class Chapter001 {
    public static void main(String[] args) {
        /*
        [자바 개발 환경 구축 핵심 요약]
        
        1. JDK(Java Development Kit) 설치
            자바 프로그램을 개발하기 위한 필수 도구 세트입니다.
            설치 후에는 반드시 '환경 변수(Path)' 설정이 필요합니다.
            그래야 윈도우 어디서든 자바 컴파일러(javac)를 사용할 수 있습니다.
            
        2. 이클립스(Eclipse) 설치 및 설정
            이클립스는 코드 작성을 편리하게 도와주는 도구(IDE)입니다.
            강의에서는 C드라이브 등 접근이 쉬운 곳에 압축을 풀고 실행하는 방식을 권장합니다.
            처음 실행 시 워크스페이스(Workspace) 경로를 지정하는데, 
            지용 님이 공부한 내용이 저장될 '작업실'이라고 생각하면 됩니다.
            
        3. 첫 번째 프로그램 실행 (Hello World)
            프로젝트 생성: File -> New -> Java Project
            클래스 생성: src 폴더 우클릭 -> New -> Class
            클래스 이름은 반드시 대문자로 시작해야 합니다 (예: Hello).
            
        4. 학습 팁
            남궁성 선생님의 카페나 GitHub를 통해 예제 소스와 연습문제 답안을 얻을 수 있습니다.
            에러가 나면 하단 Console 창의 메시지를 읽는 연습을 하세요.
        */

        // 콘솔에 문장을 출력하는 가장 기본적인 코드입니다.
        System.out.println("Hello, Java!"); 
        System.out.println("지용 님의 자바 학습 시작을 응원합니다!");
    }
}