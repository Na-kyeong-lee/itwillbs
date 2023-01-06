package for_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 구구단 출력
		 * 
		 * < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * ...
		 * 2 * 9 = 18
		 * 
		 * */
		int dan = 2;
		System.out.println("< " + dan + "단 >");
		for(int i = 1; i <= 9; i++)	{
			System.out.println(dan + " * " + i + " = " + dan*i);
		}
		System.out.println("-------------------------------------------");
		// 두 정수 a ~ b 까지 3의 배수의 합
		// 출력: X ~ X 까지 3의 배수의 합: XX
		int a = 290, b = 12340;
		int sum = 0; // 누적변수
		for(int i = a; i <= b; i++) {
			if(i % 3 == 0)	sum += i;
		}
		System.out.println(a + " ~ " + b + " 까지 3의 배수의 합: " + sum);
		
		System.out.println("-------------------------------------------");
		
		/*
		 * 간단한 3, 6, 9 게임
		 * - 정수 1 ~ 100 까지 1씩 증가하면서 반복
		 * - 각 정수를 화면에 출력
		 * - 단, 정수의 "일의 자리가" 3, 6, 9 중 하나일 경우 숫자 출력 대신에 "짝" 출력
		 * 
		 * ex) 1 2 짝 4 5 짝 7 8 짝 10 11 ... 90 91 92 짝 94 95 짝 97 98 짝 100
		 * */
		
		for(int i = 1; i <= 100; i++) {
			int num = i%10;
			if(num == 3 || num == 6 || num == 9) {
				System.out.print("짝 ");
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		// switch ~ case
		for(int i = 1; i <= 100; i++) {
			
			switch (i%10) {	// 일의 자리가
			case 3: case 6: case 9:
				System.out.print("짝 ");
				break;
			default:
				System.out.print(i + " ");
				break;
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------------------");
		
		// 7의 갯수를 카운트 해보자!
		// int n = 247427723
		// 출력: 7의 갯수: XX
		
		int n = 222222722;
		int count = 0;
		while(n != 0) {
			if(n%10 == 7) count++; 
			n /= 10;
		}
		System.out.println("7의 갯수: " + count);
		
		System.out.println("==========================================");
		
//		int count = 0;
//		for(int n = 2772722; n != 0; n /= 10) {
//			if(n%10 == 7) count++; 
//		}
//		System.out.println("7의 갯수: " + count);
		
		
		
		
		
		
		
		
	}

}
