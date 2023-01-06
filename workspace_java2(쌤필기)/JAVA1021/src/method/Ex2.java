package method;

// 메서드 오버로딩을 사용하여 클래스 정의
// => 매개변수의 데이터타입이 다른 오버로딩 메서드 정의
class OverloadingAbsNum {
	
//	이름이 같은데도 가능 : 매개변수 타입(int, double등)이 다르기 때문
	public int abs(int num) {
		return num < 0 ? -num : num;
	}
	
	// 매개변수의 타입 또는 갯수가 아닌 매개변수 이름만 다른 것은 오버로딩이 아님!!
//	public int abs(int num2) {}
	// 리턴타입만 다른 것은 오버로딩이 아님!!
//	public double abs(double num) {}
	
	public double abs(double num) {
		return num < 0 ? -num : num;
	}
	
	public long abs(long num) {
		return num < 0 ? -num : num;
	}
	
	
	
}

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 메서드 오버로딩(Method Overloading) = 메서드 다중 정의
		 * - 동일한 이름의 매개변수가 다른 메서드를 여러개 정의하는 것
		 * - 동일한 이름으로 서로 다른 파라미터를 전달받아 다른 작업을 처리하도록 하는 것
		 * - 규칙1. 메서드명은 동일 
		 * 	 규칙2. 매개변수의 타입이나 갯수가 달라야함(순서)
		 *   규칙3. 리턴타입은 무관함
		 *   규칙4. 매개변수의 변수명만 다른 것은 오버로딩과 무관함
		 *   => 즉, 메서드 호출 시점에서 전달되는 데이터에 따라
		 *      각각 다른 메서드를 호출하도록 "구분"이 되어야 함!!
		 */
		
		OverloadingAbsNum oan = new OverloadingAbsNum();
		System.out.println("정수 10의 절대값: " + oan.abs(10));
		System.out.println("정수 3.14의 절대값: " + oan.abs(3.14));
		System.out.println("정수 100L의 절대값: " + oan.abs(100L));
		
		
		
		
		
		
	}

}
