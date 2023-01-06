package break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * UP & DOWN 게임 만들기
		 * 1 ~ 999 사이의 난수 하나를 target에 저장
		 * 20번 반복하면서 정수를 입력받는다.
		 * 	- target 보다 작은수를 입력받았을 경우 "UP" 출력
		 * 	- target 보다 큰수를 입력받았을 경우 "DOWN" 출력
		 *  - 일치하는 숫자를 입력받았을 경우 target과 몇회만에 맞췄는지 출력 후 반복 종료
		 *    정답: XXX, 횟수: XXX
		 *  - 20번 안에 정답을 맞추지 못한 경우 "실패! 정답: XXX" 출력  
		 * 
		 * 추가) 난이도를 선택할 수 있도록 프로그램변경
		 * 상(2), 중(1), 하(0) 중 하나를 입력받기
		 * => 단, 이외 숫자가 입력될 경우 "입력오류: 상(2)/중(1)/하(0) 중에 하나 입력!"
		 *    출력 후 난이도가 정상 입력될 때까지 무한반복
		 * 상: 반복횟수 8번
		 * 중: 반복횟수 12번
		 * 하: 반복횟수 20번
		 * */
//		Random r = new Random();
//		int target = r.nextInt(999) + 1;
//		System.out.println(target);
		
		Random r = new Random();
		int target = r.nextInt(999) + 1;
		Scanner sc = new Scanner(System.in);

		System.out.println("< Up & DOWN GAME >");
		
		int count = 0;
		LOOP:
		while(true) {
			System.out.print("난이도를 선택하세요. 상(2)/중(1)/하(0) : ");
			int mode = sc.nextInt(); // 난이도 입력받기
			
			switch (mode) {
			case 2:
				count = 8;
				break LOOP;
			case 1:
				count = 12;
				break LOOP;
			case 0:
				count = 20;
				break LOOP;

			default:
				System.out.println("입력오류! [상(2)/중(1)/하(0)] 중에 하나 입력!");
			}
			
//			if(mode == 0) { // 20
//				count = 20;
//				break;
//			} else if(mode == 1) { // 12
//				count = 12;
//				break;
//			} else if(mode == 2) { // 8
//				count = 8;
//				break;
//			} else {
//				System.out.println("입력오류! [상(2)/중(1)/하(0)] 중에 하나 입력!");
//			}
		}
		
		boolean isSuccess = false;
		for(int i = 1; i <= count; i++) {
			System.out.print("1 ~ 999 사이 정수를 입력: ");
			int num = sc.nextInt();
			
			if(target > num) {
				System.out.println("UP");
			} else if(target < num) {
				System.out.println("DOWN");
			} else {
				System.out.println("정답: " + target + ", 횟수: " + i);
				isSuccess = true;
				break;
			}
		}
		
		if(!isSuccess) {
			System.out.println("실패 (정답: " + target + ") ^^;");
		}
		
		
		
		
		
		
	}

}
