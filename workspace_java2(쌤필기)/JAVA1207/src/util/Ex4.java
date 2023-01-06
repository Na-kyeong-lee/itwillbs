package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * java.time 패키지
		 * - 날짜 및 시간 정보를 관리하는 클래스들의 모음 패키지 (JDK 8부터 제공됨)
		 *   => Date 및 Calendar 클래스에 비해 직관적이므로 사용하기 쉽다.
		 *   
		 * - LocalDate - 날짜 관련 기능 제공
		 * - LocalTime - 시간 관련 기능 제공
		 * - LocalDateTime - 날짜 및 시간 관련 기능 제공
		 * - Calendar 클래스처럼 객체 생성없이 시스템이 생성한 객체를 리턴받아 사용
		 *   => 생성자가 보이지 않도록 은닉되어 있음 (= 싱글톤 디자인 패턴)
		 * - 각 클래스의 now() 메서드를 호출하여 현재 시스템의 날짜 및 시간 정보 가져오고
		 *   각 클래스의 of() 메서드를 호출하여 날짜 및 시간 정보 설정
		 * - getXXX() 메서드를 호출하여 상세 항목 정보 가져오기 가능
		 *   => (ex. getYear(), getHour())    
		 * 
		 * */
//		LocalDate date = LocalDate.now();
//		LocalDate date2 = LocalDate.now();
//		
//		System.out.println(date == date2);
		
		LocalDate date = LocalDate.now();
		System.out.println(date); // 2022-12-07 출력됨
		
		LocalTime time = LocalTime.now();
		System.out.println(time); // 11:36:12.662683100 (24시간제, 밀리초단위까지 표현)
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		System.out.println("================================");
		
		// 각 객체의 값 설정 XXX.of() 메서드 사용
		LocalDate date2 = LocalDate.of(2000, 1, 1);
		System.out.println(date2);
		
		LocalTime time2 = LocalTime.of(9, 10, 59);
		System.out.println(time2);
		
		LocalDateTime dateTime2 = LocalDateTime.of(1999, 12, 31, 23, 59, 59);
		System.out.println(dateTime2);
		
		System.out.println("---------------------------------------");
		
		// getXXX() 메서드를 사용한 상세 정보 가져오기
		int year = date.getYear();
		int month = date.getMonthValue(); // 주의! getMonth() 메서드는 Month 타입 객체 리턴
		int day = date.getDayOfMonth();
		System.out.println(year + "/" + month + "/" + day);
		
		Month eMonth = date.getMonth();
		System.out.println(eMonth);
		// => 대한민국 기준 표현법으로 변환할 경우
		//    Month 타입 객체의 getDisplayName() 메서드를 호출하여
		//    표기방식(TextStyle.XXX)과 국가언어(Locale.XXX) 전달
		System.out.println(eMonth.getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		
		System.out.println("--------------------------------------------");
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		// 연도 연산(2년뒤)
		System.out.println(now.plusYears(2));
		
		// 월 연산(2개월 뒤)
		System.out.println(now.plusMonths(2));
		// => 연도 및 일자에 영향 있음
		
		System.out.println(now.withMonth(2));
		// => 연도 및 일자에 영향 없음
		
		// 일 연산(20일 뒤)
		System.out.println(now.plusDays(30));
		
		// 2년 2개월 20일 뒤의 날짜 연산
		System.out.println(now.plusYears(2).plusMonths(2).plusDays(20));
		// 빌더 패턴(Builder Pattern)을 활용하여 메서드를 연쇄적으로 호출 가능
		
		/*
		 * Builder Pattern 이란? (자바스크립트 -> 체이닝기법)
		 * - 어떤 객체의 메서드 리턴타입이 자기자신일때
		 *   리턴값을 전달받아 다시 다른 메서드를 연쇄적으로 호출하는 형태의 코드 작성 기법
		 * - ex) String 클래스의 메서드 리턴타입이 대부분 String 타입이므로  
		 * 		 str.trim().replace().split()
		 * */
		
	}

}
