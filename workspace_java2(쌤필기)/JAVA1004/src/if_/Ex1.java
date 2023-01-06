package if_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 중첩 if문
		 * - if문 블록 내에서 또 다른 if문을 기술하는 것
		 *   (else 블록 내에서 기술해도 됨)
		 * - 중첩 횟수에는 제한이 없음
		 * 
		 * < 기본 문법 >
		 * if(조건식1){
		 * 
		 * 		if(조건식 1-1){
		 * 			if(조건식 1-1-1){
		 * 
		 * 			}
		 * 		}
		 * 
		 * 		if(조건식 1-2){
		 * 
		 * 		} else {
		 * 			
		 * 		}
		 * 
		 * } else {
		 * 
		 * }
		 *   
		 * 
		 * */
		
		
		/*
		 * 학생 점수(score)에 대한 학점(grade) 판별
		 * A학점: 90 ~ 100점
		 * B학점: 80 ~ 89점
		 * C학점: 70 ~ 79점
		 * D학점: 60 ~ 69점
		 * F학점: 0 ~ 59점
		 * 그 외: "점수입력 오류!"
		 * 
		 * "X학점" 라고 출력
		 * (단, score에는 int형에 저장될 수 있는 범위의 데이터가 저장되어있다고 가정)
		 * */
		
//		int score = 120;
//		if(90 <= score && score <= 100) {
//			System.out.println("A학점");
//		} else if(80 <= score && score <= 89) {
//			System.out.println("B학점");
//		} else if(70 <= score && score <= 79) {
//			System.out.println("C학점");
//		} else if(60 <= score && score <= 69) {
//			System.out.println("D학점");
//		} else if(0 <= score && score <= 59) {
//			System.out.println("F학점");
//		} else {
//			System.out.println("점수입력 오류!");
//		}
		
		int score = 70;
		if(0 <= score && score <= 100) {
			
			if(score >= 90) {
				System.out.println("A학점");
			} else if(score >= 80) {
				System.out.println("B학점");
			} else if(score >= 70) {
				System.out.println("C학점");
			} else if(score >= 60) {
				System.out.println("D학점");
			} else {
				System.out.println("F학점");
			}
			
		} else {
			System.out.println("점수입력 오류!");
		}
		
		
		
		
		
	}

}
