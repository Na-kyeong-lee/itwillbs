package array;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 학생 5명의 점수를 배열 score에 저장하고
		 * 각 학생 점수의 총점과 평균을 계산하여 출력
		 * 
		 * < 추가 항목 >
		 * 1. 학생 이름을 저장하는 배열 names를 생성하여
		 *    이순신, 홍길동, 김태희, 변기태, 전지현 문자열 5개를 저장한 후
		 *    이름과 점수를 함께 출력
		 * 2. 학생 점수 중 최고점수와 최저점수를 찾아 출력
		 * 
		 * < 출력예시 >
		 * 이순신: 80점
		 * 홍길동: 100점
		 * 김태희: 50점
		 * 변기태: 90점
		 * 전지현: 77점
		 * ----------
		 * 총점: 397점
		 * 평균: 79.4점
		 * 최고점수: 100점
		 * 최저점수: 50점
		 * 
		 * */
		
		int[] score = 	 {80	,  100	 , 	50	  , 90	  ,   77};
		String[] names = {"이순신", "홍길동", "김태희", "변기태", "전지현"};
		
		int sum = 0;
//		for(int i = 0; i < score.length; i++) {
//			System.out.println(names[i] + ": " + score[i] + "점");
//			sum += score[i];
//		}
		
		// 향상된 for문 (안어울림)
		int index = 0;
		for(int num : score) {
			System.out.println(names[index] + ": " + num + "점");
			index++;
			sum += num;
		}
		
		System.out.println("----------");
		double avg = (double)sum / score.length;
		
		System.out.println("총점: " + sum);
		System.out.println("평균: " + avg);
		
		// 최고점수 최저점수
		int max = score[0];
		int min = score[0];
//		for(int i = 1; i < score.length; i++) {
//			max = max > score[i] ? max : score[i];
//			min = min < score[i] ? min : score[i];
//		}
		
//		for(int i = 1; i < score.length; i++) {
//			int num = score[i];
//			max = max > num ? max : num;
//			min = min < num ? min : num;
//		}
		
		// 향상된 for문
		// => 배열의 요소를 하나씩 꺼내서 변수에 저장하는 코드가 생략된 버전
		for(int num : score) { 
			max = max > num ? max : num;
			min = min < num ? min : num;
		}
		
		System.out.println("최고점수: " + max);
		System.out.println("최저점수: " + min);
		
		
		
		
	}

}
