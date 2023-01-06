package try_catch;

public class Ex5 {

	public static void main(String[] args) {
		/*
		 * try ~ catch ~ finally 구문
		 * - 기본적으로 try, catch 블록의 역할은 동일하나
		 *   finally 블록에 기술된 코드들은 예외 발생 여부와 관계없이 실행됨
		 * - 일반적인 try 구문 바깥의 코드도 예외 발생여부와 관계없이 실행되는 것은 동일하나
		 *   try ~ catch 블록 내에서 return 문의 사용으로 인해 메서드 수행이 종료되더라도
		 *   반드시 finally 블록의 코드를 실행한 후에 메서드가 종료된다!
		 * - 주로, 데이터베이스 작업 (JDBC) 이나 파일 작업을 위해 DB 서버 등의 자원 사용시
		 *   예외가 발생하더라도 자원을 반환하기 위한 코드는 무조건 실행되어야 하므로
		 *   finally 블록 내에 자원 반환 코드를 기술하면 예외 발생 여부와 관계없이 실행됨
		 *   
		 * < 기본 문법 >
		 * try {
		 * 
		 * } catch (예외클래스명 변수명){
		 * 
		 * } finally {
		 * 		// 예외 발생 여부와 관계없이 실행할 코드들...
		 * }
		 * */
		
		try {
			System.out.println("1 - try 블록 시작!");
			
			int num1 = 3;
			int num2 = 0;
			System.out.println(num1 / num2);
			
			System.out.println("2 - 예외 미발생. try 블록 끝!");
			
		} catch (Exception e) {
			System.out.println("3 - catch 블록 시작! 원인 :" + e.getMessage());
		} finally {
			System.out.println("4 - finally 블록 시작! 언제나 실행되는 코드!");
		}
		
		System.out.println("5 - try 구문 끝!");
		
		System.out.println("=========================================");
		
		System.out.println("메서드 호출 시작!");
		
		method();
		
		System.out.println("메서드 호출 종료!");
		
	}
	
	public static void method() {
		try {
			System.out.println("1 - try 블록 시작!");
			
			int num1 = 3;
			int num2 = 1;
			System.out.println(num1 / num2);
			
			System.out.println("2 - 예외 미발생. try 블록 끝!");
			
			return;
			
		} catch (Exception e) {
			System.out.println("3 - catch 블록 시작! 원인 :" + e.getMessage());
		} finally {
			System.out.println("4 - finally 블록 시작! 언제나 실행되는 코드!");
		}
		
		System.out.println("5 - try 구문 끝!");
	}
	

}
