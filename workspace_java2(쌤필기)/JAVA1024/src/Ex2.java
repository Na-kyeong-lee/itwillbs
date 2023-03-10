
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 패키지(Package)
		 * - 윈도우에서의 폴더(Folder), 리눅스에서의 디렉토리(Directory)에 해당하는 개념
		 * - 자바에서 클래스 파일들을 모아놓는 공간 (물리적으로 폴더와 동일함)
		 *   => 서로 다른 패키지에는 같은 이름의 클래스가 각각 존재할 수 있다. (= 중복가능)
		 * - 자바에서 패키지를 생성하면, 실제 물리적인 폴더가 생성됨
		 *   (만약, 패키지 생성 생략 시, 물리적 폴더가 없는 default package가 생성됨)
		 * - 특정 클래스 파일은 하나의 패키지에'만' 소속되어야 함
		 * - 원칙적으로 클래스에 접근하는 방법은 패키지명과 클래스명을 동시에 지정하여 접근
		 *   => '패키지명.클래스명' 형태로 지정
		 *   => 만약, 패키지에 계층 구조로 이루어져 잇을 경우에는
		 *      '상위패키지명.하위패키지명.클래스명' 형태로 지정
		 *   => 단, java.lang 패키지는 기본적으로 포함되는 유일한 패키지이므로
		 *      java.lang 패키지 내의 클래스는 클래스 명만으로 접근 가능  
		 *      
		 * - 실제 폴더 구조처럼 상위, 하위로 구분하여 패키지를 작성하며
		 *   이때, 패키지 이름이 중복될 수 있으므로 도메인네임을 사용하여 패키지명을 지정
		 *   itwillbs.co.kr의 도메인일 경우 패키지명을 kr.co.itwillbs
		 *   google.co.kr의 도메인일 경우 패키지명을 kr.co.google
		 *   => 상위 패키지 -> 하위 패키지 순으로 생성되므로
		 *      kr 폴더 내에 co 폴더 내에 itwillbs, google 폴더가 생성됨
		 *      (즉, 동일한 성격에 따라 같은 폴더(패키지)로 관리되므로 유지보수가 용이)
		 *     
		 * package 문 (키워드)
		 * - 특정 클래스 파일의 첫번째 라인에 해당 클래스가 소속된 패키지를 명시하는데 사용
		 *   => 주석을 제외한 소스코드에서 가장 먼저 실행되어야 하는 코드(맨 윗줄에 위치)
		 * - 실제 클래스 파일이 위치한 패키지와 지정된 위치가 다를 경우 오류 발생!    
		 * - 클래스 파일 내에서 단 한번만 사용 가능
		 * - default package 에 위치한 클래스는 실제 패키지가 없으므로 package문 생략
		 * 
		 * < package 키워드 사용 기본 문법 >
		 * 소스코드 첫 번째 라인에서
		 * package 상위패키지명.하위패키지명;       
		 *        
		 * */
		
		java.lang.String str = new java.lang.String("abc");
		System.out.println(str);
		
		String str2 = new String("abc");
		System.out.println(str2);
		
		
		
		
	}

}
