package for_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * for문
		 * 
		 * < 기본 문법 >
		 * 
		 * for(초기식; 조건식; 증감식){
		 * 		// 조건식이 true일때 반복 실행할 문장들....
		 * }
		 *
		 * => 초기식(1): 반복 횟수를 제어할 제어변수를 선언하고 필요에 따라 초기화 수행
		 * => 조건식(2): 제어변수를 사용하여 반복문을 반복(종료)하는 조건식 지정
		 * 				(조건식 결과가 true일 동안 계속 반복 수행하고, false이면 종료)
		 * => 실행문(3): 조건식 결과가 true일 동안 반복 실행항 문장을 기술
		 * 			    (한문장 또는 여러문장)
		 * => 증감식(4): 실행문 실행 후 조건식으로 이동하기 전 제어변수를 증감시킴
		 * 
		 * => 초기식 -> 조건식 -> 실행문 -> 증감식 -> 조건식 -> 실행문 ... 순으로 반복
		 * */
		
		// Hellow, World! 10번 출력
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + ": Hello, World!");
		}
		
		System.out.println("-----------------------------------");
		
		// 2 ~ 10 까지 2씩 증가하면서 i값을 출력
		for(int i = 2; i <= 10; i += 2) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("-----------------------------------");
		
		// 10 ~ 1까지 1씩 감소하면서 i값 출력 (10 9 8 ... 2 1)
		for(int i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("-----------------------------------");
		
		// for문에서 구성요소 제외 가능 예
		int i = 1;
		for(; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("for문 종료 후 제어변수 i = " + i);
		
		// 제어변수 i 중복 선언 불가!
		// 만약, 제어변수 i의 값만 변경하려면 선언 코드만 제외하고 사용
		for(i = 1; i <= 10; i++) {
			
		}
		
		// for문 무한반복 (잘 사용하지 않음)
		for(;;) {
			
		}
		
		
		
		
	}

}
