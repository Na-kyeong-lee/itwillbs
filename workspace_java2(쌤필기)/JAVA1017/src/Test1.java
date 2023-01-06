import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 정수를 입력받아 구구단을 출력하는 프로그램을 작성하시오.
		 * 단, 0을 입력 시 2 ~ 9단 까지 구구단을 모두 출력
		 *    -1을 입력 시 프로그램 종료
		 * */
		
//		Scanner sc = new Scanner(System.in);
//		int dan = sc.nextInt();
//		while(true) {
//			
//			if(dan != 0) {
//				// 입력받은 단을 출력
//				System.out.println("< " + dan + "단 >");
//				for(int i = 1; i <= 9; i++) {
//					System.out.println(dan + " * " + i + " = " + (dan*i));
//				}
//				System.out.println();
//			} else if(dan == 0) {
//				// 2 ~ 9단 까지 출력
//				for(int i = 2; i <= 9; i++) {
//					System.out.println("< " + i + "단 >");
//					for(int j = 1; j <= 9; j++) {
//						System.out.println(i + " * " + j + " = " + (i*j));
//					}
//					System.out.println();
//				}
//			}
//			
//			if(dan == -1) break;
//			
//			dan = sc.nextInt();
//		}
//		
//		System.out.println("프로그램 종료!");
		
		// method version
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		
		while(true) {
			
			if(dan == -1) break;
			
			if(dan == 0)	gugudan2_9();
			else			gugudan(dan);
			
			dan = sc.nextInt();
		}
		
		System.out.println("프로그램 종료!");
		
		
		
		
		
	}
	
	// 정수 dan을 전달받아 해당 구구단을 출력하는 gugudan() 메서드
	public static void gugudan(int dan) {
		System.out.println("< " + dan + "단 >");
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
		System.out.println();
	}
	
	// 2 ~ 9단 까지 출력하는 gugudan2_9() 메서드
	public static void gugudan2_9() {
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println("< " + dan + "단 >");
			for(int i = 1; i <= 9; i++) {
				System.out.println(dan + " * " + i + " = " + dan*i);
			}
			System.out.println();
		}
	}
	
	

}
