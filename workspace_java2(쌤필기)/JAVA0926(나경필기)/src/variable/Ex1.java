package variable;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 기본 데이터 타입(기본형, Primitive Type)
		 * 메모리에 효율적인 사용을 위해 사이즈별로 나누어 놓음
		 *  - 자바에서 기본적으로 사용하는 데이터 타입은 8가지
		 *  
		 *  	1Byte  2Byte  4Byte  8Byte
		 * 		=8 bit
		 * --------------------------------
		 * 1. 정수형: byte	short	int		long
		 * 2. 실수형:					float	double
		 * 3. 문자형: 	char( 
		 *   
		 */
		
		byte b = 127;
		System.out.println(b);
		
//		b = 128; //오류가 발생! byte타입은 -128 ~ 127까지 저장할 수 있기 때문
		
		short s = 128;
		System.out.println(s);
		
//		s = 32768; //오류!short 타입 변수에서느 -32768~32767까지의 정수만 저장 가능
		
		int i =32768;
		System.out.println(i);
		
//		i = 2147483648;
		
		long l = 2147483648L; //그래서 정수끝에 L을 붙여줘야됨
		// 정수 리터럴에 접미사가 없을 시 int로 취급됨
		//최대 표현 가능한 숫자가 2147483647 까지
		//따라서, 그 이상의 숫자를 표현하려면
		//접미사, L을 붙여서 long 타입을 사용해야한다!
		System.out.println(l);
		
//		i = 100L;
		// 접미사 L이 붙으면 int타입으로 저장 가능한 숫자라 하더라도 저장불가!
		
		System.out.println("-----------------------------");
		
		float f = 3.14f;
		//float 타입은 접미사 f 또는 F를 붙여줘야함
		System.out.println(f);
		
		double d = 3.14;
		System.out.println(d);
		
		char c = 'A' + 1;  //char는 연산이 됨(정수형)
		System.out.println(c);
		
		boolean bool = true;  // 다른 언어에서는 1을 true로 판단하는 경우가 있음
		System.out.println(bool);
		bool = false;   // 다른언어에서는 0을 false로 판단하는 경우가 있음
		System.out.println(bool);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
