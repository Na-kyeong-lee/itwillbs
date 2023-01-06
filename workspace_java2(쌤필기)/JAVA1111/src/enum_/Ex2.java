package enum_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * enum에 속성 추가
		 * 
		 * 1. ordinal은 마치 배열처럼 0부터 시작한다.
		 *    그리고, ordinal은 정수 데이터 이다.
		 *    => 특정 데이터를 지정해 주고 싶다!
		 *    예) 지역번호: (서울: 02, 경기도: 031, 인천: 032, 부산: 051...)
		 *    	 URL: NAVER("https://www.naver.com")
		 *    		  DAUM("https://www.daum.net")
		 *    		  GOOGLE("https://www.google.com")
		 * 
		 * 2. 시스템 유지보수중 enum의 멤버가 추가되거나 변경된다면?
		 * - 기존 ordinal 이 깨질 수 있다
		 *   => ordinal로 계한하고 있던 모든 로직을 찾아 수정해야한다.
		 *   예) 평일만 관리하고 있었다. (월 화 수 목 금 -> 0 1 2 3 4)
		 *   	 주말도 관리해야 할것같다 (일 월 화 수 목 금 토 -> 0 1 2 3 4 5 6)
		 * 
		 * 3. 모두 같은 뜻인데 DB의 테이블마다 다른 데이터로 관리되고 있다.
		 * 예) 학교데이터 (졸업여부: Y/N)
		 * 	   공장 생상관리 데이터 (입고완료여부: 1/0)
		 * 					   (출고완료여부: true/false)
		 *     배민 (결재완료여부: T/F)
		 * */
		// 1. 지역번호 & 사이트
		Area 부산 = Area.부산;
		System.out.println(부산.number);
		
		Site 구글 = Site.GOOGLE;
		System.out.println(구글.url);
		
		// 3. 같은 뜻인데 다른 데이터로 관리되고 있을 경우
		Status s = Status.Y;
		System.out.println(s.value1);
		System.out.println(s.value2);
		System.out.println(s.value3);
		
		if(s.value2) {
			
		}
		
	}

}

// 1. 특정 데이터를 지정해 주소싶다!
//class Area {
//	public static final Area 서울 = new Area("02");
//	public static final Area 부산 = new Area();
//	
//	String name;
//
//	public Area(String name) {
//		this.name = name;
//	}
//}

enum Area {
	서울("02"), 경기도("031"), 인천("032"), 부산("051"); 
	
	String number;

	private Area(String number) {
		this.number = number;
	}
	
}

enum Site {
	NAVER("https://www.naver.com"), 
	DAUM("https://www.daum.net"), 
	GOOGLE("https://www.google.com");
	
	String url;

	private Site(String url) {
		this.url = url;
	}
}

// 3. 모두 같은 뜻인데 DB의 테이블마다 다른 데이터로 관리되고 있다.
enum Status {
	Y(1, true, "T"), N(0, false, "F");
	
	int value1;
	boolean value2;
	String value3;
	
	private Status(int value1, boolean value2, String value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
}








