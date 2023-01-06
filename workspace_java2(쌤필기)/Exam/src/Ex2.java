
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * for <--> while 전환
		 * 무엇을 수행하는 코드인지 설명
		 * */
		int dan = 4;
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
		
		/*
		 * 형변환 (원인 및 해결책)
		 * int i = 10 + 1.0;
		 * 정답: int i = (int)(10 + 1.0);
		 * 
		 * char ch = 'A';
		 * ch = ch + 2;
		 * 
		 * 정답: ch = (char)(ch + 2);
		 * 		ch += 2;
		 *      => 복합 대입연산자는 자동 형변환이 일어나지 않는다
		 * */
		
		/*
		 * 배열 선언 및 초기화
		 * int[] arr; // 임의의 정수 3개로 초기화
		 * 
		 * int[] arr = {1, 2, 3}		O (선언과 동시에 초기화 즉, 한줄에 표현할때)
		 * arr = {1, 2, 3}				X
		 * arr = new int[3];			O		
		 * arr = new int[3]{1, 2, 3}	X
		 * arr = new int[]{1, 2, 3}		O
		 * 
		 * */
		
	}

}
