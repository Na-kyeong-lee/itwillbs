package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 2. Matcher 클래스
		 * - 정규표현식에 해당하는 패턴 해석 및 문자열 일치 여부 파악
		 * - Pattern 클래스는 문자열 전체에 대한 검증만 수행하지만,
		 *   Matcher 클래스는 부분 검증도 가능
		 * - Pattern 클래스의 compile() 메서드를 통해 Pattern 객체를 생성하고
		 *   matcher() 메서드를 호출하여 Matcher 타입 객체 리턴 받아 사용 가능
		 * */
		String source = "Java and Javascript has no relation"; // 검사할 문자열
		String regex = "Java"; // 패턴 문자열
		
		// 1. 정규표현식 패턴 문자열을 Pattern 객체로 변환
		Pattern pattern = Pattern.compile(regex);
		
		// 2. 정규표현식이 포함된 Pattern 객체의 matcher() 메서드를 호출하여
		//    원본 문자열을 파라미터로 전달한 뒤 Matcher 타입 객체 리턴 받음
		Matcher matcher = pattern.matcher(source);
		
		// 3. Matcher 객체의 다양한 메서드를 통해 정규표현식 검사 수행
		System.out.println("문자열이 정규표현식에 완전히 부합되는가? " + matcher.matches());
		// => 정규 표현식 "Java"는 원본 문자열과 완전히 일치하지 않으므로 false 리턴됨
		System.out.println("문자열이 정규표현식으로 시작되는가? " + matcher.lookingAt());
		// => 정규표현식 "Java" 문자열이 원본 문자열 시작과 같으므로 true 리턴됨
		
		// 주의사항!
		// 만약, lookingAt() 메서드 등을 사용하여 부분 검색 수행 후에는
		// 시작 인덱스 번호가 변경되므로 인덱스 리셋 필요함 => reset() 메서드 호출 필요
		matcher.reset();
		System.out.println("문자열이 정규표현식을 포함하는가? " + matcher.find());
		// => 0번 인덱스 부터 검사하므로 "Java" 문자열 포함되어 true 리턴됨
		System.out.println("문자열이 정규표현식을 포함하는가? " + matcher.find());
		// => 이미 앞에서 "Java" 문자열을 검사했으므로 해당 위치 뒷부분부터 검사됨
		//    따라서, 뒷부분 문자열에 "Javascript" 의 "Java" 가 존재하므로 true
		System.out.println("문자열이 정규표현식을 포함하는가? " + matcher.find());
		// => 이제는 "Java" 가 존재하지 않으므로 false
		
		// 만약, reset() 메서드를 호출하지 않을 경우에는
		// find() 메서드 파라미터로 검색할 인덱스 번호를 첫 인덱스 번호인 0 지정가능
		System.out.println("문자열이 정규표현식을 포함하는가? " + matcher.find(0));
		
		System.out.println("Java -> 자바 replaceFirst() : " + matcher.replaceFirst("자바"));
		// => 처음 일치하는 Java만 자바로 치환
		System.out.println("Java -> 자바 replaceAll() : " + matcher.replaceAll("자바"));
		// => 일치하는 모든 Java를 자바로 치환
		
		
		
		
	}

}
