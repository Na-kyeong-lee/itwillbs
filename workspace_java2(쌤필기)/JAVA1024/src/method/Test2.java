package method;

/*
 * 계산기 (Calculator2) 클래스 정의
 * - 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 모두 calc() 메서드로 처리
 *   => 첫번째 파림터로 연산자(기호, char 타입 opr)를 전달하고
 *      두번째 파라미터로부터 피연산자(숫자, int 타입 가변인자 nums)을 2개 이상 전달하여
 *      연산자에 따라 각각의 연산을 누적하여 결과를 출력
 * */
class Calculator2 {
	
	// 1번 방법
//	public void calc(char opr, int...nums) {
//		if(opr == '+') {
//			int result = nums[0];
//			System.out.print(nums[0]);
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" + " + nums[i]);
//				result += nums[i];
//			}
//			
//			System.out.println(" = " + result);
//			
//		} else if(opr == '-') {
//			
//			int result = nums[0];
//			System.out.print(nums[0]);
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" - " + nums[i]);
//				result -= nums[i];
//			}
//			
//			System.out.println(" = " + result);
//			
//			
//		} else if(opr == '*') {
//			
//			int result = nums[0];
//			System.out.print(nums[0]);
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" * " + nums[i]);
//				result *= nums[i];
//			}
//			
//			System.out.println(" = " + result);
//			
//		} else if(opr == '/') {
//			
//			int result = nums[0];
//			System.out.print(nums[0]);
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" / " + nums[i]);
//				result /= nums[i];
//			}
//			
//			System.out.println(" = " + result);
//		}
//	}
	
	// 2번 방법 (수식만들기, 계산하기)
	public void calc(char opr, int...nums) {
//		String result = makeStr(opr, nums);
//		int result2 = sum(opr, nums);
		System.out.println(makeStr(opr, nums) + sum(opr, nums));
	}
	
	// 수식만들기 makeStr
	public String makeStr(char opr, int...nums) {
		String result = nums[0] + ""; // 빈문자열 (null 스트링)을 연결하여 String으로 변환
		for(int i = 1; i < nums.length; i++) {
			result += " " + opr + " " + nums[i];
		}
		result += " = ";
		return result;
	}
	
	// 계산하기 sum
	public int sum(char opr, int...nums) {
		int result = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			switch (opr) {
			case '+':	result += nums[i];	break;
			case '-':	result -= nums[i];	break;
			case '*':	result *= nums[i];	break;
			case '/':	result /= nums[i];	break;
			}
		}
		
		return result;
	}
	
	
}

public class Test2 {

	public static void main(String[] args) {
		Calculator2 cal = new Calculator2();
 		cal.calc('+', 10, 20); 			// 10 + 20 = 30
 		cal.calc('+', 10, 20, 30); 		// 10 + 20 + 30 = 60
 		cal.calc('+', 10, 20, 30, 40); 	// 10 + 20 + 30 + 40 = 100
 		cal.calc('+', 10, 20, 30, 40, 10, 20, 30, 40);
 		System.out.println("---------------------------");
 		cal.calc('-', 100, 10);  		// 100 - 10 = 90
 		cal.calc('-', 100, 10, 20);  	// 100 - 10 - 20 = 70
 		cal.calc('-', 100, 10, 20, 30); // 100 - 10 - 20 - 30 = 40
 		System.out.println("---------------------------");
 		cal.calc('*', 1, 2);		// 1 * 2 = 2
 		cal.calc('*', 1, 2, 3);		// 1 * 2 * 3 = 6
 		cal.calc('*', 1, 2, 3, 4);  // 1 * 2 * 3 * 4 = 24
 		System.out.println("---------------------------");
 		cal.calc('/', 100, 10);		// 100 / 10 = 10
 		cal.calc('/', 100, 10, 2);  // 100 / 10 / 2 = 5
 		
 		
 		
	}

}
