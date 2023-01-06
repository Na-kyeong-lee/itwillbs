package regex;

import java.util.regex.Pattern;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * java.util.regex 패키지의 클래스를 활용하여 "정규표현식" 활용 가능
		 * 
		 * 1. Pattern 클래스
		 * - 정규표현식에 사용되는 패턴 문자열을 객체로 관리하는 클래스
		 * - compile() 메서드를 사용하여 정규표현식 패턴 문자열을 갖는 객체 생성
		 *   matches() 메서드를 사용하여 특정 문자열을 대상으로 정규표현식 패턴 검사
		 * */
		
		// 정규표현식으로 사용할 패턴 문자열 작성
		// => 주의! 패턴에 사용되는 \ 기호 사용 시 문자열 내에서 이스케이프 문자로 인식되므로
		//    반드시 \\ 형태로 사용해야만 패턴 문자열로 인식 됨
		
		// 1. 전화번호(휴대폰) 형식 검증
		// 	1) ^(010|011) : 010 또는 011로 시작
		//  2) [-\\s]? : - 기호 또는 공백이 포함될 수도 있고, 포함되지 않을 수도 있음
		//	3) \d{3,4} : 숫자 3자리 또는 4자리
		// 	4) \d{4}$ : 숫자 4자리로 끝
		String regex = "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$";
		
//		String phone = "011-1234-5678"; // 검사에 사용할 문자열
		
		// Pattern 클래스의 static 메서드인 matches() 메서드를 호출하여 검사 수행
		// 파라미터로 정규표현식 패턴 문자열과 검사할 문자열 전달 => 리턴타입 boolean
//		boolean result = Pattern.matches(regex, phone);
//		System.out.println(phone + " 번호는 유효한 전화번호 인가? " + result);
		
		String[] phoneNumbers = {
			"010-1234-5678", "010-1234-56789", "010-1234 5678", "01012345678",
			"010-1234-567a", "010)1234-5678"
		};
		
		for(String phone : phoneNumbers) {
//			boolean result = Pattern.matches(regex, phone);
			boolean result = phone.matches(regex);
			System.out.println(phone + " 번호는 유요한 전화번호 인가? " + result);
		}
		
		
		
		
		
	}

}
