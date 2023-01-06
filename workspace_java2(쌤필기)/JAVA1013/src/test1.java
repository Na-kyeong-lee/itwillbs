
public class test1 {

	public static void main(String[] args) {
		/*
		 * n개의 숫자가 입력되면
		 * n개의 숫자를 왼쪽으로 하나씩 돌려서 출력하시오.
		 * 
		 * 입력예시)
		 * 5
		 * 1 2 3 4 5
		 * 
		 * 
		 * 출력예시)
		 * 1 2 3 4 5
		 * 2 3 4 5 1
		 * 3 4 5 1 2
		 * 4 5 1 2 3
		 * 3 1 2 3 4
		 */
		int[] arr = {1, 2, 3, 4, 5};				//int형의 arr변수의 배열에 값 넣어줌
		int len = 5;								//배열 길이를 len(gth)라는 변수에 넣어줌
		
		for (int i = 0; i < len; i++) {				//배열길이인 len보다 
			
			for (int j = 0; j < len; j++) {			
				System.out.print(arr[j] + " ");		//배열 arr에 윗줄의 j증가식을 넣은것
			}
			System.out.println();
		}
		
			
			
		int temp = arr[0];
		
		for (int j = 1; j < len; j++) {
			
			arr[j - 1] = arr[j];
			
			if (j == len - 1) arr[len - 1] = temp; 
		}
			
		}
		
		
		
		
		
		
	}

}
