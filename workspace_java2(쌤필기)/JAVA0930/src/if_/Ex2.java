package if_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * if ~ else 문
		 * 
		 * < 기본 문법 >
		 * 문장1;
		 * if(조건식){
		 * 		문장2;
		 * } else {
		 * 		문장3;
		 * }
		 * 문장4;
		 * 
		 * => 조건식 true : 문장1 > 문장2 > 문장4
		 *    조건식 false: 문장1 > 문장3 > 문장4
		 *    (주의! 문장2와 문장3은 절대로 동시에 실행됤 없다!!!)
		 * 
		 * */
		
		int num = 10;
		
		// 정수형 변수 num이 10보다 크거나 같으면 "너무크다" 라고 출력
		// 아니면 "적당함" 출력
		
		if(num >= 10) {
			System.out.println("너무크다!");
		} else {
			System.out.println("적당함!");
		}
		
		
		
		
		
		
		
		
	}

}
