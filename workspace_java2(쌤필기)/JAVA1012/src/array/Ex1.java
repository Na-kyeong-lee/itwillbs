package array;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 다차원 배열
		 * - 1차원 배열 여러개가 모여 2차원 이상의 배열을 이루는 것
		 * - 일반적으로 다차원 배열 = 2차원 배열을 의미
		 * 
		 * 2차원 배열
		 * - 행, 열의 구조로 이루어진 배열
		 * - 실제 데이터가 저장되는 공간 = 열
		 *   열 공간의 주소를 저장하는 공간 = 행
		 * - 배열 크기
		 *   1) 행 크기: arr.length
		 *   2) 열 크기: arr[index].length  
		 *   
		 * < 2차원 배열 선언 기본 문법 >
		 * 데이터타입[][] 변수명;
		 * 
		 * < 2차원 배열 생성 기본 문법 >
		 * 변수명 = new 데이터타입[행크기][열크기];
		 * 
		 * < 2차원 배열 인덱스 접근 기본 문법 >
		 * 변수명[행인덱스][열인덱스]
		 * 
		 * < 2차원 배열 선언 및 생성, 초기화를 한꺼번에 수행하는 방법 >
		 * 데이터타입[][] 변수명 = { 
		 * 		{1, 2, 3}, 
		 * 		{4, 5, 6} 
		 * };
		 *   
		 * */
		
		int[][] arr;
		arr = new int[2][3];
		
		arr[0][0] = 1; arr[0][1] = 2; arr[0][2] = 3;
		arr[1][0] = 4; arr[1][1] = 5; arr[1][2] = 6;
		
		System.out.println(arr[0][0] + " " + arr[0][1] + " " + arr[0][2]);
		System.out.println(arr[1][0] + " " + arr[1][1] + " " + arr[1][2]);
		System.out.println("--------------------------------------------");
		
		// 반목문을 사용하여 2차원 배열 출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		// 배열의 크기
		System.out.println("배열 arr의 행 크기: " + arr.length);
		System.out.println("배열 arr의 0번 행의 열크기: " + arr[0].length);
		System.out.println("배열 arr의 1번 행의 열크기: " + arr[1].length);
		
		System.out.println("---------------------------------------------");
		
		int[][] arr2 = { 
				{1, 2, 3}, 
				{4, 5, 6} 
		};
		
		for(int i = 0; i < arr2.length; i++) {
			
			for(int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("=============================================");
		
//		int[][] arr3 = {
//				{1, 2, 3},
//				{4, 5},
//				{6, 7, 8, 9, 10}
//		};
		
		System.out.println("===========================================");
		
		int[][] arr3 = new int[3][];
		arr3[0] = new int[] {1, 2, 3};
		arr3[1] = new int[] {4, 5};
		arr3[2] = new int[] {6, 7, 8, 9, 10};
		
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
