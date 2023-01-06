package while_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 반복문 (Loop)
		 * - 특정 문장 또는 블럭을 주어진 조건에 따라 반복 실행하는 문
		 * - for문과 while문(do - while)
		 * - for문과 while문은 문법적 구조는 다르지만, 동작 방식이 완전히 동일함
		 *   => 따라서, 상호 100% 전환이 가능
		 * - *for문은 주로 반복 횟수가 정해져 있는 반복문에서 사용하며,
		 *    while문은 주로 반복 횟수가 정해져있지 않은 반복문에 사용
		 *    
		 * < 기본 문법 >
		 * 초기식;
		 * while (조건식) {
		 * 		// 조건식이 true 일 동안 반복할 실행문
		 *		// 증감식;
		 * }
		 * */
		int i=0;
		while(i < 10) {
			System.out.println(i + ": 안녕하세요.");
			i++;
		}
		System.out.println("-----------------------");
		
		// 1 2 3 4 5 6 7 8 9 10 출력
		i = 1;
		while(i < 11) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();
		System.out.println("-----------------------");
		
		// 2 4 6 8 10
		i = 2;
		while(i <= 10) {
			System.out.print(i + " ");
			i += 2;
		}
		System.out.println();
		System.out.println("-----------------------");
		
		// 10 9 8 7 ... 1 로 출력
		i = 10;
		while(i > 0) {
			System.out.print(i + " ");
			i--;
		}
		
		
		
		
		
		
	}

}
