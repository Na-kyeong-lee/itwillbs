package ex01_04;

public class Ex4_Q2 {

	public static void main(String[] args) {
		// p.123
		
		//Q2)
		// 구구단을 짝수 단만 출력하도록 프로그램을 만들어 보세요.
		// 단, continue문을 사용!
		// 제목, 줄바꿈까지!!
		
		
		for(int dan = 2; dan <= 9; dan++) {	//단
			
			if(dan % 2 == 1) continue;		//나머지가 1인 것 = 홀수 는 건너뛰고 continue
			
			System.out.println("< " + dan + "단 >");
			for(int i = 1; i <= 9; i++) {	//곱해지는 수
				System.out.println(dan + " * " + i + " = " + dan*i);
			}
			System.out.println();
			
		}
		
		
		
		//메서드 version
		for(int dan = 2; dan <= 9; dan++) {
			if(dan % 2 == 1) continue;
			printGugudan(dan);

		}
				
		
	}
	
		// 단을 전달받아 구구단을 출력하는 메서드
		public static void printGugudan(int dan) {
			System.out.println("<" + dan + "단 >");
			for(int i = 1; i <= 9; i++) {	
				System.out.println(dan + " * " + i + " = " + dan*i);
		}
			System.out.println();
		}
	
	
	
	
	
	
	
	

}
