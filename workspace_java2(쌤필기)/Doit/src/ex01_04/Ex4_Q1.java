package ex01_04;

public class Ex4_Q1 {

	public static void main(String[] args) {
		
		// p.123
		//Q1)
		// operator 값이 +, -, *, / 인 경우에 사칙연산을 수행하는
		// 프로그램을 if-else if문과 switch-case문을 사용해 작성해보세요.
		
		
		int num1 = 10;
		int num2 = 2;
		char operator = '+';		// string이면 작은따옴표
		
		//if version
		if(operator == '+') {
			System.out.println(num1 + num2);
		}else if(operator == '-') {
			System.out.println(num1 - num2);
		}else if(operator == '*') {
			System.out.println(num1 * num2);
		}else if(operator == '/') {
			System.out.println(num1 / num2);
		}
		
		
		//switch-case version
		switch (operator) {
		case '+':
			System.out.println(num1 + num2);
			break;

		case '-':
			System.out.println(num1 - num2);
			break;
			
		case '*':
			System.out.println(num1 * num2);
			break;
			
		case '/':
			System.out.println(num1 / num2);
			break;	
		}
		
		
		
		// String 비교 주의사항!
		// String도 참조변수 타입
		
		String str1 = "abc";
		String str2 = "ab" + "c";
		String str3 = "ab";
		str3 += "c";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		System.out.println(str1 == str2);
		
		// str1이랑 str3이 false인 이유: str3는 결과값은 같아도 ab와 c가 저장된 주소가 다르기 때문에 false / ab가 저장된 배열1개, abc가 저장된 배열 1개 따로 생성됨
		System.out.println(str1 == str3);
		
		// equals는 출력된 결과값 그 자체를 비교하지만 ==(비교연산자)는 배열이 저장된 주소값을 비교하기 때문에 equals는 true가 나옴.
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		
		// false 값이 나오게 하려면 출력할 식 앞에 느낌표 써줌!!
		System.out.println(!str1.equals(str3));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
