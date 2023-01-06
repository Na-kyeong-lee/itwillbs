package format;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		// Date 객체를 생성하여 오늘 날짜 및 현재 시간을 다음과같이 변환하여 출력
		// ex) 2022년 12월 08일(금) [오전] 10시 35분 40초
		Date now = new Date();
		String pattern = "yyyy년 MM월 dd일(E) [a] hh시 mm분 ss초";
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String strNow = sdf.format(now);
		System.out.println(strNow);
		
		// ----------------------------------
		String pattern2 = "yyyy년 MM월 dd일(E) [a] hh시 mm분 ss초";
		
		System.out.println(new SimpleDateFormat(pattern2).format(new Date()));
		
		// ----------------------------------
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern2))); 
		
		
		
	}

}
