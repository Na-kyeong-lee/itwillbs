package operator;

public class Ex5 {

	public static void main(String[] args) {
		/*
		 * 비교연산자(=관계연산자) (>, >=, <=, <, ==, !=)
		 * - 두 피연산자 간의 대소관계 등을 비교하여 true 또는 false값 반환
		 * */
		int a = 10, b = 5;
		
		System.out.println("a > b 인가? " + (a > b));
		System.out.println("a < b 인가? " + (a < b));
		System.out.println("a >= b 인가? " + (a >= b));
		System.out.println("a <= b 인가? " + (a <= b));
		System.out.println("a == b 인가? " + (a == b));
		System.out.println("a != b 인가? " + (a != b));
		
		boolean bool = a > b;
		System.out.println(bool);
		
		System.out.println("----------------------------------");
		// char 타입을 비교연산자에 사용시 정수(유니코드)값을 비교
		System.out.println('A' > 'B');
		System.out.println('A' == 65);
//		System.out.println("A" > "B"); // 문자열은 비교불가!
		
		System.out.println(3 == 3.0);
		
		System.out.println("======================");
		
		System.out.println(0.1 == 0.1f);
		// 근사치 표현에 의해 서로 다른값으로 취급됨!
		System.out.println((float)0.1 == 0.1f);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
