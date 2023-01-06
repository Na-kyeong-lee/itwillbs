package if_;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * 문자 ch가 대문자 -> 소문자,
		 * 			소문자 -> 대문자
		 * 		    아니면 "ch는 영문자가 아닙니다!" 출력
		 * 1) 대문자: ch = a
		 * 2) 소문자: ch = A
		 * 3) 알파벳이 아닐경우 : ch는 영문자가 아닙니다!
		 * */
//		char ch = 'A';
		/*
		String result = "ch = ";
		
		if('A' <= ch && ch <= 'Z') { 

//			result += (char)(ch + 32);
			ch += 32;		// 소문자로바꿈
			result += ch;	// 누적
			
		} else if('a' <= ch && ch <= 'z') { 
			
			result += (char)(ch - 32);
			
		} else { 
			
			result = "ch는 영문자가 아닙니다!";
			
		}
		*/
		
		// {} 블록 안에 실행문이 1개면 {} 블록 생략 가능!
//		char ch = 'A';
//		String result = "ch는 영문자가 아닙니다!";
//		if('A' <= ch && ch <= 'Z')	result = "ch = " + (ch += 32);
//		if('a' <= ch && ch <= 'z')	result = "ch = " + (ch -= 32);
		
		// 삼항연산자
		char ch = '8';
		boolean isUpperCase = 'A' <= ch && ch <= 'Z';
		boolean isLowerCase = 'a' <= ch && ch <= 'z';
		
		String result = isUpperCase ? "ch = " + (ch += 32) :
						isLowerCase ? "ch = " + (ch -= 32) : "ch는 영문자가 아닙니다!";
		
		System.out.println(result);
		
		/*
		 * 학생 점수(score)에 대한 학점(grade) 판별
		 * A학점: 90 ~ 100점
		 * B학점: 80 ~ 89점
		 * C학점: 70 ~ 79점
		 * D학점: 60 ~ 69점
		 * F학점: 0 ~ 59점
		 * 
		 * "X학점" 라고 출력
		 * (단, score에는 0 ~ 100사이 데이터만 저장되어 있다고 가정)
		 * */
		
		
	}

}
