package for_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 중첩 for문
		 * 
		 * < 기본 문법 >
		 * for(초기식1; 조건식1; 증감식1;){
		 * 
		 * 		for(초기식2; 조건식2; 증감식2){
		 * 
		 * 		}
		 * 
		 * }
		 *  
		 * */
		
		// 중첩 for문을 활용한 시계 구현
		// => 0분 ~ 59분 까지 1씩 증가할 동안 각 분마다 0초 ~ 59초 까지 1씩 증가
		for(int min = 0; min <= 59; min++) {
			for(int sec = 0; sec <= 59; sec++) {
				System.out.println(min + "분" + sec + "초");
			}
		}
		
		
	}

}
