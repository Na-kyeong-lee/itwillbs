package variable;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * printf(), println() 활용하여 구구단 출력
		 * 구구단 2단을 다음과 같이 출력
		 * 
		 * < 2단 >
		 * 2 * 1 =1
		 * 2 * 2 =4
		 * 2 * 3 =6
		 * ...
		 * 2 *9 =18
		 * 
		 * => 제목 출력, 단이 바뀔 때마다 제목 바뀌게
		 *
		 */
		
		int dan = 3;  //숫자를 변경해서 다른 단(2,3,4..)으로 바꿀 수 있음
		
		//printf() version
		System.out.printf("< %d단 >\n", dan); //숫자니까 %d
		System.out.printf("%d * 1 = 2\n", dan);
		System.out.printf("%d * 2 =4\n", dan);
		System.out.printf("%d * 3 =6\n", dan);
		System.out.printf("%d * 4 =8\n", dan);
		System.out.printf("%d * 5 =10\n", dan);
		System.out.printf("%d * 6 =12\n", dan);
		System.out.printf("%d * 7 =14\n", dan);
		System.out.printf("%d * 8 =16\n", dan);
		System.out.printf("%d * 9 =18\n", dan);
		
		System.out.println("=================");
		
		System.out.printf("< %d단 >\n", dan);
		System.out.printf("< %d * 1 = 3\n>", dan);
		System.out.printf("%d * 2 =6\n", dan);
		System.out.printf("%d * 3 =9\n", dan);
		System.out.printf("%d * 4 =12\n", dan);
		System.out.printf("%d * 5 =15\n", dan);
		System.out.printf("%d * 6 =18\n", dan);
		System.out.printf("%d * 7 =21\n", dan);
		System.out.printf("%d * 8 =24\n", dan);
		System.out.printf("%d * 9 =27\n", dan);
		
		System.out.println("=================");
		
		//println() version
		System.out.println(" < " + dan + "단 >");
		System.out.println(dan + " * 1 = " + dan*1);
		System.out.println(dan + " * 2 = " + dan*2);
		System.out.println(dan + " * 3 = " + dan*3);
		System.out.println(dan + " * 4 = " + dan*4);
		System.out.println(dan + " * 5 = " + dan*5);
		System.out.println(dan + " * 6 = " + dan*6);
		System.out.println(dan + " * 7 = " + dan*7);
		System.out.println(dan + " * 8 = " + dan*8);
		System.out.println(dan + " * 9 = " + dan*9);
		
		
	}

}
