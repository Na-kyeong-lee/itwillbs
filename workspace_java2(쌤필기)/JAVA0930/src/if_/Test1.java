package if_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 정수형 변수 num에 대한 절대값을 계산하여 출력
		 * => ex) num이 5일때 -> "변수 num = 5"
		 * 	  ex2) num이 -10일때 -> "변수 num = 10"
		 * */
		int num = -128;
		
		if(num < 0) {	// 음수이면
//			num = -num;
//			num = num * (-1);
//			num *= -1;
		}
		
		// 삼항연산자
//		num = (num < 0) ? -num : num;
		num *= (num < 0) ? -1 : 1;
		
		System.out.println("변수 num = " + num);
		
		// 변수의 범위 (scope, Life Cycle)
		int num2 = 10;
		int result = num2;
		if(num2 < 0) {
//			int result = -num2;
			result = -num2;
		}
		
		System.out.println(result);
		
		// 중괄호 안에서 선언된 변수는
		// 해당 중괄호가 끝나는 시점에서 사라지기 때문에
		// 중괄호 밖에서 사용(접근)할 수 없음!
		
		
		// 문자 ch가 대문자일 때, 소문자로 변환하여 출력
		// char는 정수형 대문자 + 32 -> 소문자
		// 출력형식 : "ch = g"
		char ch = 'a';
		
//		if('A' <= ch && ch <= 'Z') { // 대문자이면
////			ch = (char)(ch + 32);
//			ch += 32;
//		}
		
		// 삼항연산자
//		ch = ('A' <= ch && ch <= 'Z') ? (char)(ch + 32) : ch;
		ch += ('A' <= ch && ch <= 'Z') ? 32 : 0;
//		ch += 32;
//		ch += 0;
		
		System.out.println("ch = " + ch);
		
		
		
		
		
		
		
		
	}

}
