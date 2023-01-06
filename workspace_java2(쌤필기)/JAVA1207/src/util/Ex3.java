package util;

import java.util.Calendar;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * java.util.Calendar 클래스
		 * - 날짜 및 시간을 관리하는 클래스 (Date 클래스와 유사함)
		 * - 주로 날짜 및 시간 정보를 "조정"하는 용도로 사용
		 *   (과거에는 Calendar 클래스로 날짜 조작, Date 클래스로 날짜 표현함)
		 * - 추상클래스 이므로 인스턴스 생성이 불가능하며
		 *   미리 시스템으로 부터 생성되어 제공되는 인스턴스를 리턴받아 사용  
		 *   => getInstance() 메서드 호출하여 인스턴스를 리턴 받음
		 *   (싱글톤 디자인 패턴(Singleton Design Pattern) 활용 [한 것 처럼])
		 * - toString() 메서드가 오버라이딩 되어 있으나 일반적인 날짜 식별은 어려움
		 * - get() 메서드로 날짜 및 시간 정보에 대한 항목을 지정하여 값을 가져오고
		 *   set() 메서드로 날짜 및 시간 정보에 대한 항목을 지정하여 값을 설정한다.
		 *   => 파라미터로 사용될 대상 항목은 Calendar 클래스의 상수를 활용
		 *   ex) cal.get(Calendar.YEAR) => 연도 정보 가져오기  
		 * */
//		Calendar cal = Calendar.getInstance();
//		Calendar cal2 = Calendar.getInstance();
//		
//		System.out.println(cal == cal2); // true 가 나와야 진짜 싱글톤 패턴
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		System.out.println(year + "년");
		
//		int month = cal.get(Calendar.MONTH); // Date 클래스와 마찬가지로 0 ~ 11월 사용
		int month = cal.get(Calendar.MONTH) + 1; // 따라서, 결과값 + 1 필요
		System.out.println(month + "월");
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(day + "일");
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 일요일: 1 ~ 토요일: 7
		System.out.println(dayOfWeek);
		
		// 오전 / 오후
		int amPm = cal.get(Calendar.AM_PM);
		String strAmPm = "오후";
		if(amPm == Calendar.AM) { 
			strAmPm = "오전";
		} 
//		else {
//			strAmPm = "오후";
//		}
		
		// 삼항연산자 사용 시
		strAmPm = amPm == Calendar.AM ? "오전" : "오후";
		
		System.out.println(strAmPm);
		
		System.out.println("----------------------------------------");
		// 시간(HOUR), 분(MINUTE), 초(SECOND)
//		int hour = cal.get(Calendar.HOUR); // 12시간제
		int hour = cal.get(Calendar.HOUR_OF_DAY); // 24시간제
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.println(hour + "시" + min + "분" + sec + "초");
		
		
		
		
		
	}

}
