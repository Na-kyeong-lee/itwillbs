package operator;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 대입 연산자 (=)
		 * - 우변의 데이터를 좌변의 변수에 대입(저장)
		 *   => 연산의 방향이 좌 <- 우 로 진행됨
		 *   ex) x = y = 3; y에 3을 대입하고, x에 y를 대입
		 * 
		 * 확장 대입연산자 (=복합 대입연산자) (+=, -=, *=, /=, %=)
		 * - 대입연산자와 산술연산자가 조합된 연산자
		 * - 좌변과 우변의 데이터 끼리 산순연산을 먼저 수행한 후, 결과값을 좌변에 대입
		 *   ex) a = a + 10;
		 *       a += 10;
		 * */
		
		int a = 10, b = 0;
		
		b += a; // b = b + a;
				// b에 10을 누적
		System.out.println(b);
		// b + a의 결과를 다시 변수 b에 저장 => b에 a값을 "누적" 하는 것과 동일
		System.out.println("=========================");
		
		b += a;
		System.out.println(b);
		
		b -= a;
		System.out.println(b);
		
		b *= a;
		System.out.println(b);
		
		b /= a;
		System.out.println(b);
		
		b %= a;
		System.out.println(b);
		
		
		System.out.println("-------------------------");
		
		// ** 복합 대입연산자는 연산시 자동형변환이 일어나지 않는다!
		short s = 10;
//		s = s + 10;
		s = (short)(s + 10);
		s += 10;
		
		System.out.println(s);
		
		
		
		
		
	}

}
