package try_catch;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 예외 클래스
		 * - 자바에서 제공하는 예외가 아닌 사용자가 직접 예외를 발생시키는 경우
		 *   자바의 예외 이름은 어울리지 않는 경우가 발생함
		 *   ex) 점수 입력 오류를 Exception 클래스 타입으로 예외 발생 시
		 *   	 => InvalidScoreInputException 이라는 이름 사용하면 더 직관적이나
		 *   	    해당 예외 클래스는 자바에서 존재하지 않는다!
		 * - 사용자가 직접 해당 이름을 가진 예외 클래스를 정의 가능
		 * - 반드시 Exception 클래스(또는 계열)를 상속받아 예외 클래스를 정의하며
		 *   생성자 내에서 슈퍼클래스에 예외 메세지를 전달하여 메세지 초기화 수행  
		 * */
		
		int score = 180;
		// 1. 기존에 존재하는 예외 클래스를 활용하는 경우
		try {
			grade(score);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-------------------------");
		
		// 2. 사용자 정의 예외 클래스를 활용하는 경우
		try {
			grade2(score);
		} catch (InvalidScoreInputException e) {
			e.printStackTrace();
		}
		
		
	}
	// 1. 기존에 존재하는 예외 클래스를 활용하는 경우
	public static void grade(int score) throws Exception {
		if(score < 0 || score > 100) {
			throw new Exception("점수 입력 오류! " + score);
		}
	}
	
	// 2. 사용자 정의 예외 클래스를 활용하는 경우
	public static void grade2(int score) throws InvalidScoreInputException {
		if(score < 0 || score > 100) {
//			new InvalidScoreInputException("점수 입력 오류! " + score);
			throw new InvalidScoreInputException("점수 입력 오류! " + score);
		}
	}
}

class InvalidScoreInputException extends Exception {
//	String message;
//
//	public InvalidScoreInputException(String message) {
//		super();
//		this.message = message;
//	}
	
	// 슈퍼클래스인 Exception 클래스의 생성자를 통해 자동 생성
	public InvalidScoreInputException(String message) {
		// 메세지를 입력받아 슈퍼클래스의 생성자에 전달하면 예외 메세지 초기화 가능함
		super(message);
	}
	
}





