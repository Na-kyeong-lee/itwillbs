import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * 마방진(magic square)이란 가로, 세로, 대각선의 합이 같은 사각형을 말한다.
		 * 홀수 n을 입력으로 받아 n*n마방진을 만들어보자.
		 * 
		 * 구현방법:
		 * 1. 시작은 첫 행, 한가운데 열에 1을 둔다.
		 * 2. 행을 감소, 열을 증가하면서 순차적으로 수를 넣어갑니다.
		 * 3. 행은 감소하므로 첫행보다 작아지는 경우에는 마지막 행으로 넘어간다.
		 * 4. 열은 증가하므로 마지막 열보다 커지는 경우에는 첫 열로 넘어간다.
		 * 5. 넣은 수가 n의 배수이면 행만 증가한다. 열은 변화없음
		 * 
		 * 8 1 6
		 * 3 5 7
		 * 4 9 2
		 * 
		 * */
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		int n = 3;
		int[][] arr = new int[n][n];
		
		int row = 0;   // 행
		int col = n/2; // 열
		
		for(int i = 1; i <= n*n; i++) { // i는 넣는 수 / n*n =>
			arr[row][col] = i;			// i를 arr배열에 대입?
			
			if(i % n == 0) {		//n의 배수
				row++;
			} else {
				row--;
				col++;
			}
			
			if(row < 0)		row = n-1;		//넘어가면 
			if(col > n-1)	col = 0;
		}
		
		// 배열의 모든요소 출력 / 향상된for문
		for(int[] a : arr) {					//배열 a랑 배열arr을 비교함
			for(int num : a) {					//int num을 배열 a에 넣고(위로)
				System.out.print(num + "\t");
			}
			System.out.println();
		}
		
		
	} // main() 메서드 끝
	
	// 홀수 하나를 전달받아 이차원배열(마방진)을 리턴하는 makeMagicSquare() 메서드
	public static int[][] makeMagicSquare(int n){
		int[][] arr = new int[n][n];
		
		
		return arr;
	}
	
	
	
	
	

}
