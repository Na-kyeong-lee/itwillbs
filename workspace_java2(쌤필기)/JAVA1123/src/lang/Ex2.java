package lang;

import java.util.Arrays;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * *** String 클래스의 메서드
		 * - 문자열 수정, 검색, 치환 등 다양한 작업을 수행하는 메서드를 제공
		 * - String 객체는 불변 객체이므로 원본 문자열에 대한 수정이 불가능하며,
		 *   수정, 치환 등 변경 작업 수행 시 원본 데이터가 아닌 변경된 문자열에 대한
		 *   새로운 문자열을 생성하여 관리함
		 *   => 따라서, 문자열 수정이 빈번할 경우 메모리 낭비가 심하므로
		 *      StringBuilder 또는 StringBuffer 객체를 활용 해야한다.
		 * */
		String s1 = "Java Programming";
		String s2 = "		아이티윌	   부산 교육센터     ";
					// tab		tab + space		 space
		String s3 = "자바/JSP/안드로이드";
		
		// length() : 문자열 길이 리턴
		System.out.println("s1.length(): " + s1.length());
		
		// equals() : 문자열 비교 (대소문자 구별하여 비교)
		System.out.println("s1.equals(JAVA PROGRAMMING): " + s1.equals("JAVA PROGRAMMING"));
		// equalsIgnoreCase() : 문자열 비교 (대소문자 구별하지 않고 비교)
		System.out.println("s1.equalsIgnoreCase(JAVA PROGRAMMING): " 
					+ s1.equalsIgnoreCase("JAVA PROGRAMMING"));
		
		// charAt() : 특정 인덱스에 위치한 문자 1개 리턴
		System.out.println("s1.chatAt(5) : " + s1.charAt(5));
		
		// substring() : 특정 범위 문자열(부분 문자열)을 추출
		// 1) substring(int beginIndex) : 시작 인덱스부터 모든 문자열 추출
		System.out.println("s1.substring(5) : " + s1.substring(5));
		// 2) substring(int beginIndex, int endIndex) : 시작인덱스부터 끝인덱스 - 1 까지 추출
		System.out.println("s1.substring(5, 12) : " + s1.substring(5, 12));
		// => 5번 인덱스 위치가 대문자 P이므모 5번인덱스 부터 12-1(11번) 인데긋 까지 추출 : Program
		
		// concat() : 문자열 결합(결합연산자(+) 보다 연산 속도가 빠르다)
		System.out.println("s1.concat(!) : " + s1.concat("!"));
		
		// indexOf() : 문자열의 앞쪽(첫인덱스) 부터 찾고자 하는 문자 또는 문자열의 인덱스 리턴
		// => 탐색할 문자 또는 문자열이 없을 경우 -1
		System.out.println(s1.indexOf('a'));
		System.out.println(s1.indexOf('x'));
		System.out.println(s1.indexOf("a"));
		System.out.println(s1.indexOf("Program")); // 문자열의 시작위치 5리턴
		
		// lastIndexOf() : 문자열의 뒷쪽(끝인덱스) 부터 찾고자 하는 문자 또는 문자열의 인덱스 리턴
		// => 탐색을 거꾸로할 뿐, 인덱스 번호 자체가 변하지는 않는다!
		System.out.println(s1.lastIndexOf("a"));
		
		// replace() : 특정 문자 또는 문자열에 대한 치환 기능을 제공
		// => 동일한 문자 또는 문자열이 여러개 있을 경우 모두 치환
		System.out.println(s1.replace('a', '@')); // char 타입 또는
		System.out.println(s1.replace("a", "@")); // String 타입 모두 사용 가능
		System.out.println(s1.replace("Java", "Android")); // 자릿수가 달라도 무관
		
		// toUpperCase(), toLowerCase() : 대소문자 변환 기능
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		
		
//		String s2 = "		아이티윌	   부산 교육센터     ";
		// 				tab		tab + space		 space
		// trim() : 문자열 앞 뒤 공백을 제거 (주의! 문자열 사이의 공백은 제거하지 않음)
		// => 문자열 입력 시 의도치 않은 불필요한 공백이 삽입되는 것을 방지할 때 사용
		System.out.println(s2.trim());
		// 공백 완벽하게 제거
		System.out.println(s2.replace(" ", "").replace("\t", "").trim());
		
		// ------------------------------------------------------------------
		// String s3 = "자바/JSP/안드로이드";
		// split() : 문자열을 특정 기준으로 분리하여 분리된 문자열을 "배열" 리턴
		String[] subjects = s3.split("/");
		for(int i = 0; i  < subjects.length; i++) {
			System.out.println(subjects[i]);
		}
		
		// split() 메서드 사용하여 문자열 분리할 때 주의사항
		// => 문자열의 구분자로 마침표(.)를 사용할 경우
		//    "." 기호 대신 "\\." 형태로 사용해야함
		// => 만약, "." 기호를 구분자로 지정하면 정규표현식에서는
		//    모든 문자로를 기준으로 삼기때문에 모든 문자가 기준이 되어 모든 문자가 제거됨
		String s4 = "안녕하세요. 자바 프로그래밍 수업입니다.";
		String[] strArr = s4.split(".");
		System.out.println(Arrays.toString(strArr)); 
		// 따라서, "." 기호 대신 "\\." 기호를 사용해야만 문장 단위 분리가 가능함
		String[] strArr2 = s4.split("\\.");
		System.out.println(Arrays.toString(strArr2));
		
		// -------------------------------------------------------
		// contains() 메서드 : 특정 문자열 포함 여부 확인 (boolean 타입 리턴)
		System.out.println("문자열 자바가 포함되어 있는가? " + s1.contains("자바"));
		System.out.println("문자열 Java가 포함되어 있는가? " + s1.contains("Java"));
		if(s1.contains("Java")) {
			
		}
		
		if(s1.indexOf("Java") > -1) {
			
		}
		
		// -------------------------------------------------------
		// String.format() 메서드 : 특정 문자열을 형식 지정 문자와 결합하여 형식을 부여
		// => System.out.printf() 메서드 역할과 동일하나 출력을 위한 것이 아니라
		//    문자열을 생성할 때 형식을 지정하기 위함
		String name = "홍길동";
		int age = 20;
		double height = 180.587;
		// => 위의 세가지 데이터를 다음과 같이 문자열로 결합하여 변수 total에 저장
		//    (이름: 홍길동, 나이: 20, 키: 180.5)
		
		System.out.println("이름: " + name + ", 나이: " + age + ", 키: " + height);
		
		// println() 메서드 대신 printf() 메서드를 사용할 경우
		System.out.printf("이름: %s, 나이: %d, 키: %.1f\n", name, age, height);
		
	 	String formatStr = 
	 			String.format("이름: %s, 나이: %d, 키: %.1f\n", name, age, height);
		System.out.println(formatStr);
		
		// String 클래스는 불변 객체이므로 원본 문자열을 변경되지 않는다!
		// => 항상 변경 결과를 새로운 문자열로 생성하게 되기 때문
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
		
		
	}

}
