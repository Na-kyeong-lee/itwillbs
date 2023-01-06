package operator;

public class Ex7 {

	public static void main(String[] args) {
		/*
		 * 삼항연산자 (조건연산자)
		 * - 연산에 참여하는 항이 3개인 연산자
		 * - 특정 조건에 따라 다른 값을 실행하는 연산자
		 *   => if ~ else 문과 동일한 기능을 수행
		 * - 2가지 경우의 수 (true 또는 false) 에 대한 결과를 수행
		 * 
		 * < 기본 문법 >
		 * 연산식 ? 값1 : 값2
		 * => 연산식에는 결과값이 boolean 타입 (true 또는 false)인 식만 올 수 있다.
		 * => 연산식 판별 결과가 true일 경우 값1 부분을 반환, false일 경우 값2 부분을 반환
		 * 
		 * */
		
		int a = 11;
		String result = a % 2 == 0 ? "짝수" : "홀수";
		System.out.println(result);
		
//		result = a % 2 == 0 ? "짝수" : 12; 
		// : 기준으로 좌우 데이터타입이 다르면 안됨!!
		
//	    a % 2 == 0 ? System.out.println("짝수") : System.out.println("홀수");
		// : 기준 좌우 실행문이 오면안됨!!
		
		
		a = 30;
		int b = 40;
		
		int min = a > b ? b : a;
		int max = a > b ? a : b;
		
		System.out.println("최소값: " + min);
		System.out.println("최대값: " + max);
		
		System.out.println("---------------------------");
		
		double d = 96.3;
//		boolean bool = d * 10 % 10 > 5; // 반올림판단 변수 
//		int round = bool ? (int)(d+1) : (int)d;
		
		int round = (int)d;
		round += (d * 10 % 10 > 5) ? 1 : 0;
//		round += 1;
//		round += 0;
		System.out.println(round);
		
		
		
		
	}

}
