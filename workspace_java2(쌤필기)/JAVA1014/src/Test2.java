
public class Test2 {

	public static void main(String[] args) {
		/*
		 * 파스칼에 삼각형
		 * 크기 N을 입력받고 N크기의 파스칼 삼각형을 출력 하시오.
		 * 
		 * 입력) 6
		 * 출력)
		 * 1
		 * 1 1
		 * 1 2 1
		 * 1 3 3 1
		 * 1 4 6 4 1
		 * 1 5 10 10 5 1
		 * 
		 * */
		
		int N = 10;
		int[][] pascal = new int[N][];
		
		for(int i = 0 ; i < N; i++) {
			pascal[i] = new int[i+1];
		}
		
		for(int i = 0; i < pascal.length; i++) {
			for(int j = 0; j < pascal[i].length; j++) {

				if(j == 0 || i == j) {
					pascal[i][j] = 1;
				} else {
					pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
				}
				
			}
		}
		
		// 향상된 for문
		for(int[] arr : pascal) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
//		for(int i=0; i < pascal.length; i++) {
//			for(int j=0; j < pascal[i].length; j++) {
//				System.out.print(pascal[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
