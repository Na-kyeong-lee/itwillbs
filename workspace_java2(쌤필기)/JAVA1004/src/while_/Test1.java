package while_;

public class Test1 {

	public static void main(String[] args) {
		// 1 ~ 10 까지 정수의 합 sum을 계산하여 출력
		// 출력: 1 ~ 10 까지의 합: xxx
//		int sum = 0;
//		
//		int i = 1;
//		while(i <= 1000) 
//			sum += i;
//			i++;
//		}
//		System.out.println("1 ~ 10 까지의 합: " + sum);
		
		// 구구단 출력 (예는 2단이라고 가정)
		// < 2단 >
		// 2 * 1 = 2
		// 2 * 2 = 4
		// ...
		// 2 * 9 = 18
//		int dan = 3;
//		
//		System.out.println("< " + dan + "단 >");
//		
//		i = 1;
//		while(i <= 9) {
//			System.out.println(dan + " * " + i + " = " + dan*i);
//			i++;
//		}
		
		/*
		 * 1 ~ 100 까지 짝수/홀수의 합을 출력
		 * odd(홀수), even(짝수)
		 * 출력: 1~100까지 짝수의 합: XX
		 * 		1~100까지 홀수의 합: XX
		 * */
		int odd = 0;	// 홀수
		int even = 0;	// 짝수
		
		int i = 1;
		while(i <= 100) {
			if(i % 2 == 0)	even += i;
			else			odd += i;
			i++;
		}
		
		System.out.println("1~100까지 홀수의 합: " + odd);
		System.out.println("1~100까지 짝수의 합: " + even);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
