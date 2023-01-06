package typecasting;

public class Ex2 {

	public static void main(String[] args) {
		//byte, short, char
		
		byte b =127;
		char c = (char)b;  // char의 그릇이 더 크지만
							///char는 음수표현이 없으므로 오버플로우 발생 가능성이 있음
		System.out.println(c);
		
		short s = 10000;
		c = (char)s;
		System.out.println(c);
		
		System.out.println("===================");
		
		int i = 3;
		float f = 1.0F;
		double d = i + f;  //'d'는 의미없는 변수명이란 뜻, 오류아님
		
		float f2 = (float)100.0;
		//에러 발생! 이유는 접미사'F'를 붙여주거나
		//(float)를 명시해서 형변환을 해주어야함
		
		int i2 = (int)100.28;
		System.out.println(i2);  //소수점을 버려버림
		
		// 실수형 데이터를 정수형 변수에 저장할 경우
		// 소수점 뒷자리가 버려짐
		
		
		
		
 		
		
	}

}
