
public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 순차(비구조적) > 절차(구조적) > 객체지향
		 * 크게 절차(구조) > 객체지향
		 * 
		 * 절차(구조적) 프로그래밍 : C, Pascal
		 * 객체지향 프로그래밍 : C++, JAVA
		 * 
		 * */
		
		/*
		 * 키워드(예약어)
		 * - 이미 자바에 등록되어 있어 의미가 약속되어 있는 단어
		 * - 속성의 변수명, 메서드명 으로 사용할 수 없음!
		 * (abstract, default, package, boolean, 
		 *  goto, do, if, private, this, break, double)
		 * 
		 * 예약어 인지 아닌지 판별하는 문제가 나옴!
		 * */
		
		/*
		 * 변수 선언 및 초기화 문제
		 * 1) 문자열로된 자신의 이름을 저장하는 변수 선언 및 초기화
		 * 2) 문자 A를 저장하는 변수 ch를 선언 및 초기화
		 * 3) 정수 30억을 저장하는 num 변수를 선언 및 초기화
		 * */
		String name = "차동원";
		char ch = 'A';
//		int num = 3000000000; // 30억
		long num = 3000000000L;
		
		/*
		 * 논리연산자 종류
		 * &&, &, ||, |, !, ^(XOR)
		 * &&: 모두 true일 경우 true, 하나라도 false일 경우 false
		 * ||: 모두 false일 경우 false, 하나라도 true일 경우 true
		 * XOR: 좌우 다를 경우 true 좌우가 같으면 false
		 * 
		 * */
		
		/*
		 * 코드를 보고 출력결과를 예상하는 문제
		 * 
		 * int num = 10;
		 * if(num == 0){
		 * 		System.out.println(num + " = 0");
		 * } else if(num % 2 == 0){
		 * 		System.out.println(num + " = 짝수");
		 * } else {
		 * 		System.out.println(num + " = 홀수");
		 * }
		 * 
		 * 정답: 10 = 짝수
		 * */
		
	}

}
