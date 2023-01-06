package if_;

public class Test1 {

	public static void main(String[] args) {
		// 세 정수 n1, n2, n3 중 최대값 출력
//		int n1 = 70, n2 = 30, n3 = 20;
		
		// 중첩 if (O)
//		if(n1 > n2) {
//			if(n1 > n3) System.out.println(n1);
//			else		System.out.println(n3);
//		} else {
//			if(n2 > n3) System.out.println(n2);
//			else 		System.out.println(n3);
//		}
		
//		int n1 = 70, n2 = 80, n3 = 90;
		// 중첩 if (X)
//		if(n1 >= n2 && n1 >= n3) {
//			System.out.println(n1);
//		} else if(n2 >= n1 && n2 >= n3) {
//			System.out.println(n2);
//		} else {
//			System.out.println(n3);
//		}
		
		
//		int n1 = 700, n2 = 100, n3 = 90;
		
		// 변수 활용
//		int max;
//		
//		if(n1 > n2)	max = n1;
//		else		max = n2;
//		
//		if(max < n3) max = n3;
//		
//		System.out.println(max);
		
		
		int n1 = 700, n2 = 800, n3 = 90;
		// 변수 활용 (삼항연산자)
		
		int max;
		
		max = (n1 > n2)  ? n1	: n2;
		max = (max > n3) ? max	: n3;
		
		System.out.println(max);
		
	}

}
