package lang;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * StringBuilder & StringBuffer
		 * 
		 * - StringBuffer : 문자열이 안전하게 변경되도록 보장 (O)
		 * - StringBuilder: 문자열이 안전하게 변경되도록 보장 (X)
		 *   (멀티 쓰레드 프로그램이 아니라면 속도가 좀더 빠름)
		 * */
		String javaStr = new String("Java");
		System.out.println("javaStr 문자열 주소: " + System.identityHashCode(javaStr)); 
		 
		StringBuilder buffer = new StringBuilder(javaStr);
		System.out.println("연산 전 buffer 메모리 주소: " + System.identityHashCode(buffer));
		
		// 문자열 추가
		buffer.append(" and");
		buffer.append(" android");
		buffer.append(" programming is fun!!");
		System.out.println("연산 후 buffer 메모리 주소: " + System.identityHashCode(buffer));
		
		// String 클래스로 변환
		javaStr = buffer.toString();
		System.out.println(javaStr);
		System.out.println("새로 만들어진 문자열 주소: " + System.identityHashCode(javaStr));
		
		System.out.println("-----------------------------------------------");
		
		String str1 = "abc";		// abc (리터럴)
		String str2 = str1 + "de";	// abcde (변수 + 리터럴)
		String str3 = "a" + "bc";	// abc (리터럴 + 리터럴)
		String str4 = "a";			
		String str5 = str4 + "bc";	// abc (변수 + 리터럴)
		str4 += "bc";				// abc (변수에 리터럴 누적)
		
		System.out.println("---------------------------------");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		System.out.println(System.identityHashCode(str5));
		
		System.out.println("---------------------------------");
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);
		System.out.println(str1 == str5);
		
	}

}
