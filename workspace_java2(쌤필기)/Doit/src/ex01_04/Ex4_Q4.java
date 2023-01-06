package ex01_04;

public class Ex4_Q4 {

	public static void main(String[] args) {
		
		//p.123
		
		/*
		 * Q4) 
		 * 반복문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요.
		 * 
		 * 				*				// 공백3, 별1, 공백3
		 * 			   ***
		 * 			  *****
		 * 			 *******
		 * 공백은 하나씩 줄어가고 별은 두개씩 늘어감
		 * 
		 */
		
//		int line = 4;		//별이 4줄
//		int star = 1;		//별이 하나씩 찍히게
//		int space = line - star; 	//3;		//공백이 3칸
//		
//		for(int i = 0; i < line; i++) {
//			// 좌공백
//			for(int j = 0; j < space; j++) {
//				System.out.print(" ");
//			}
//			// 별
//			for(int j = 0; j < star; j++) {
//				System.out.print("*");
//			}
//			// 우공백		-	안찍어도 되지만 별을 드래그 했을 때 차이는 있음(좌우대칭 맞출땐 해야함)
////			for(int j = 0; j < space; j++) {
////				System.out.print(" ");
////			}
//			System.out.println();
//			
//			star += 2;
//			space--;
//		}
		
		
		// method version
//		int line = 4;		
//		int star = 1;		
//		int space = line - star;
//		
//		for(int i = 0; i < line; i++) {
//			printSpace(space);		//좌공백
//			printSpace(star);		//별
//			printSpace(space);		//우공백
//			System.out.println();	//줄바꿈
//			
//			// 별갯수와 공백갯수 변경
//			star += 2;
//			space--;
//		}
		
		
		// method 통합버전
		int line = 10;		
		int star = 1;		
		int space = line - star;
		
		for(int i = 0; i < line; i++) {
			printStr(space, " ");		//좌공백
			printStr(star, "*");		//별
			printStr(space, " ");		//우공백
			System.out.println();	//줄바꿈
			
			// 별갯수와 공백갯수 변경
			star += 2;
			space--;
		}
		
		
	}	//main() 메서드 끝
	
	
	// 횟수와 문자를 전달받아 그 횟수만큼 문자를 우측으로 출력하는 메서드
	public static void printStr(int count, String str) {
		for(int i = 0; i < count; i++) {
			System.out.print(str);
		}
	}
	

	// 위에꺼 풀어서 쓴 메서드
	public static void printSpace(int count) {
		for(int i = 0; i < count; i++) {
			System.out.print(" ");
		}
	}
	
	
	public static void printStar(int count) {
		for(int i = 0; i < count; i++) {
			System.out.print("*");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
