package array;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * n개의 숫자가 입력되면, 다음과 같이 크기를 비교한 후 양식에 맞춰 출력하시오.
		 * 예를 들어, 1 2 3 2 1 이라는 숫자가 입력되면
		 * 첫번째 1과 나머지 2 3 2 1을 비교하여 < < < = 를 출력한다.
		 * 두번째 2와 나머지 1 3 2 1을 비교하여 > < = > 를 출력한다.
		 * 세번째 3과 나머지 1 2 2 1을 비교하여 > > > > 를 출력한다.
		 * 
		 * < 출력 결과 >
		 * 1: < < < =
		 * 2: > < = >
		 * 3: > > > > 
		 * 4: > = < >
		 * 5: = < < < 
		 * 
		 * */
		
		int[] arr = {1, 2, 3, 2, 1};
		for(int i = 0; i < arr.length; i++) {
			int num = arr[i];
			String result = (i+1) + ": ";
			for(int j = 0; j < 5; j++) {
				
				if(j == i) continue;
				
				// if - else
//				if(num < arr[j]) 		result += "< ";
//				else if(num > arr[j]) 	result += "> ";
//				else 					result += "= ";
				
				// 삼항연산자
				result += num < arr[j] ? "< " :
						  num > arr[j] ? "> " : "= ";
			}
			System.out.println(result);
		}
		
		
		
	}

}
