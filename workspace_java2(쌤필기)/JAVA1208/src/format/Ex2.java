package format;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Ex2 {

	public static void main(String[] args) throws ParseException {
		/*
		 * 숫자 및 문자 등 기본적인 데이터에 대한 형식화 클래스
		 * 1. DecimalFormat 클래스
		 * 	- 숫자 데이터에 대한 형식화 클래스
		 *    ex) 실수 1234.5 를 1234.50000 형식으로 표현
		 *    	  정수 1234를 ￦1,234 형식으로 표현
		 *  - 숫자 데이터를 패턴에 의해 형식화 된 문자열로 변환 : Formatting
		 *    => format() 메서드 사용
		 *  - 문자열을 지정된 패턴에 의해 숫자데이터로 변환 : Parsing
		 *    => parse() 메서드 사용
		 *    => 리턴타입이 Number 타입이며, 기본적인 형식이 long 또는 double 이므로 주의!
		 *    	 int형으로 변환하거나 float형으로 변환하면 예외 발생!
		 *  - 기존 패턴에 새로운 패턴으로 교체하여 적용
		 *    => applyPattern() 메서드 사용
		 *  - 패턴 기호 문자
		 *  	0 : 0 ~ 9 한자리 (값이 없으면 0으로 채움)
		 *  	# : 0 ~ 9 한자리 (값이 없으면 자리 제거)
		 *  	. : 소수점 기호
		 *  	, : 1000 단위 자릿수 구분
		 *  	- : 음수 표시
		 *  	E : 지수       
		 * 
		 * 2. * MessageFormat 클래스
		 * 	- 문자열과 다른 기본타입 데이터 또는 객체데이터를 연결하는 경우
		 * 	  일반적으로 연결연산자(+)를 사용하지만, 문자열 구조가 복잡해지는 문제 발생
		 *  - MessageFormat 클래스를 사용하면 결합될 데이터를 변수처럼 사용하여
		 *    패턴을 적용한 뒤 문자열 결합을 간편하게 수행할 수 있다.
		 *    => 마치 printf() 메서드를 통해 문자열 결합으로 출력하는 것과 유사함
		 * */
		
		double dNum = 1234.5;
		
//		String pattern = "￦#,###.###"; // 형식을 지정할 패턴 문자열 (￦1,234.5)
//		String pattern = "￦0,000.000"; // 형식을 지정할 패턴 문자열 (￦1,234.500)
		String pattern = "￦#,###.000"; // 형식을 지정할 패턴 문자열 (￦1,234.500) 
		 
		// 1. 기본 데이터타입 숫자데이터 -> 형식화된 문자열
		// => DecimalFormat 클래스의 format() 메서드 사용
		DecimalFormat df = new DecimalFormat(pattern);
		System.out.println(df.format(dNum)); 
		
		// 2. 문자열에 대한 형식 지정 -> 기본데이터타입 숫자데이터
		String strNum = df.format(dNum);
		
		// String -> double 변환 방법을 사용하면 예외 발생!
//		double parsedNum = Double.parseDouble(strNum); // 사용 불가!
		
		// 반드시 DecimalFormat 클래스의 parse() 메서드를 활용해야한다!
		
		double parsedNum = (double)df.parse(strNum);
		System.out.println(parsedNum);
		
		System.out.println("================================");
		
		// 데이터를 결합하여 출력할 포멧을 패턴 문자열로 지정
		// => 실제 데이터가 결합될 부분을 {순서번호} 형태로 표시
		String messagePattern = "이름: {0}, 나이: {1}, 주민번호: {2}";
		
		// 데이터로 사용할 변수 선언
		String name = "홍길동";
		int age = 20;
		String jumin = "901010-1234567";
		
		// 패턴 문자열과 데이터를 결합하기 위해 MessageFormat 클래스의 format() 메서드 호출
		// => MessageFormat.format(패턴문자열, 데이터1, 데이터2, ..., 데이터n);
		// => 이때, 패턴데이터는 각각의 순서번호에 맞게 전달되며
		//    일반 변수가 아닌 데이터가 모두 포함된 배열도 전달 가능함(비정형 인자 사용됨)
		String formatStr = MessageFormat.format(messagePattern, name, age, jumin);
		System.out.println(formatStr);
		
		System.out.println("==============================");
		
		Person[] pArr = {
			new Person("홍길동", 20, "901010-1234567"),
			new Person("이순신", 44, "771122-1212121"),
			new Person("송준기", 30, "950101-1231231")
		};
		
		// 반복문을 사용하여 Person[] 배열을 반복하면서
		// 각각의 Person 객체 내의 이름, 나이, 주민번호 데이터를
		// MessageFormat 클래스의 format() 메서드에 전달하여 형식 지정 출력
		for(Person p : pArr) {
			String formatStr2 = 
					MessageFormat.format(messagePattern, p.getName(), p.getAge(), p.getJumin());
			System.out.println(formatStr2);
		}
		
		// --------------------------------------------------------------
		System.out.println("====================================");
		String orinalData =
				"홍길동:20:901010-1234567,이순신:44:771122-1212121,송준기:30:950101-1231231";
		
		String[] strArrData = orinalData.split(",");
		
		for(int i = 0; i < strArrData.length; i++) {
			// 각각의 문자열을 다시 콜론(:)을 기준으로 분리하여
			// MessageFormat.format() 메서드의 파라미터로 전달 후 형식화된 결과 출력
			String[] splitData = strArrData[i].split(":");
			
//			String formatStr3 = 
//					MessageFormat.format(messagePattern, splitData[0], splitData[1], splitData[2]);
//			String formatStr3 = MessageFormat.format(formatStr, splitData);
			String formatStr3 = MessageFormat.format(formatStr, strArrData[i].split(":"));
			System.out.println(formatStr3);
		}
		System.out.println("====================================");
//		String orinalData =
//				"홍길동:20:901010-1234567,이순신:44:771122-1212121,송준기:30:950101-1231231";
		
		// 향상된 for문 사용하여 배열 출력
		for(String str : orinalData.split(",")) {
			System.out.println(MessageFormat.format(messagePattern, str.split(":")));
		}
		
		System.out.println("====================================");
//		String orinalData =
//				"홍길동:20:901010-1234567,이순신:44:771122-1212121,송준기:30:950101-1231231";
		// StringTokenizer 사용하여 출력
		StringTokenizer st = new StringTokenizer(orinalData, ",:");
		while(st.hasMoreTokens()) {
			Object[] objs = {st.nextToken(), st.nextToken(), st.nextToken()};
			System.out.println(MessageFormat.format(messagePattern, objs)); 
		}
		
	}

}

class Person {
	private String name;
	private int age;
	private String jumin;
	
	public Person(String name, int age, String jumin) {
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getJumin() {
		return jumin;
	}
	
}












