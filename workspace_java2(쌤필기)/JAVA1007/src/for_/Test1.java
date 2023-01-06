package for_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 		*		i=1 : j = 1 ~ 1
		 * 		**		i=2 : j = 1 ~ 2
		 * 		***		i=3 : j = 1 ~ 3
		 * 		****	i=4 : j = 1 ~ 4
		 * 		*****	i=5 : j = 1 ~ 5
		 * */
		
//		for(int i = 1; i <= 15; i++) {	
//			
//			for(int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
		
//		String str = "*";
//		for(int i = 1; i<= 5; i++) {
//			System.out.println(str);
//			str += "*";
//		}
		
		/*
		 * 		*****	i=5 : j = 1 ~ 5
		 * 		****	i=4 : j = 1 ~ 4
		 * 		***		i=3 : j = 1 ~ 3
		 * 		**		i=2 : j = 1 ~ 2
		 * 		*		i=1 : j = 1 ~ 1
		 * 
		 * */
		
//		for(int i = 5; i >= 1; i--) {	// 줄바꿈
//			
//			for(int j = 1; j <= i; j++) { // 별갯수
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
//		int line = 40;
//		int star = line;
//		for(int i = 1; i <= line; i++) {	// 줄바꿈
//			
//			for(int j = 1; j <= star; j++) { // 별갯수
//				System.out.print("*");
//			}
//			
//			System.out.println();
//			star--;
//		}
		
		/*
		 * 
		 * 		    *
		 * 		   **
		 * 		  ***
		 * 		 ****
		 * 		*****
		 * 
		 * */
		
//		int line = 20;
//		int star = 1;
//		int space = line - star;
//		
//		for(int i = 1; i <= line; i++) {	// 줄바꿈
//			
//			for(int j=1; j <= space; j++) { // 공백찌기
//				System.out.print(" ");
//			}
//			
//			for(int j = 1; j <= star; j++) {	// 별찍기
//				System.out.print("*");
//			}
//			
//			System.out.println();
//			star++;
//			space--;
//		}
		
		
		/*
		 * 
		 *		*****
		 *		 ****
		 *		  ***
		 *		   **
		 *		    *
		 * 
		 * */
		
		int line = 20;
		int star = line;
		int space = 0;
		
		for(int i = 1; i <= line; i++) { // 줄바꿈
			
			for(int j = 1; j <= space; j++) { // 공백
				System.out.print(" ");
			}
			
			for(int j = 1; j <= star; j++) { // 별찍기
				System.out.print("*");
			}
			
			System.out.println();
			star--;
			space++;
		}
		
		
		
		
		
	}

}
