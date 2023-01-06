package lang;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * java.lang.Math 클래스
		 * - 수학적인 다양한 기능을 상수와 static 메서드로 제공
		 * - 모든 멤버가 static 으로 선언되어 있으므로 클래스명만으로 접근 가능
		 *   ex) Math.PI, Math.random()
		 * 
		 * */
		// Math 클래스의 상수
		System.out.println("PI 값: " + Math.PI); 
		
		int num = -10;
		// Math 클래스의 static 메서드
		System.out.println("num 의 절대값: " + Math.abs(num));
		System.out.println("num 과 20 중 큰 값: " + Math.max(num, 20));
		System.out.println("num 과 20 중 작은 값: " + Math.min(num, 20));
		System.out.println("4의 제곱근: " + Math.sqrt(4));
		
		// ---------------------------------------------------------
		double dNum = 3.141592;
		System.out.println("실수 dNum의 소수점 첫째자리 반올림값 : " + Math.round(dNum));
		System.out.println("실수 dNum의 소수점 넷짜자리 반올림값 : " 
		     + Math.round(dNum * 1000) / 1000.0);
		
		// ---------------------------------------------------------
		/*
		 * Math.random()
		 * - 난수(임의의 수) 발생을 위한 메서드
		 * - Math.random() : 0.0 <= x < 1.0 범위의 double 타입 난수 발생
		 * */
		for(int i = 0; i < 10; i++) {
//			System.out.println(Math.random()); // 0.0 <= x < 1.0
			
			// 정수 1자리 범위의 난수 발생시키기 위해서는
			// math.random() 결과를 원하는 자릿수만큼 정수로 이동시키고
			// 남은 자리 숫자들을 제거
//			System.out.println((int)(Math.random() * 10)); // 0 <= x < 10
			
			// 0을 제외하고 1부터 상한값까지의 난수 발생을 위해서는
			// 난수 발생 결과에 +1을 수행
			System.out.println((int)(Math.random() * 10) + 1); 
			// 1 <= x < 11 (1 ~ 10)
		}

	}

}
