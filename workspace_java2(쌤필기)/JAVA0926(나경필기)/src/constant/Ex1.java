
public class Ex1 {

	public static void main(String[] args) {
//		상수 
//		- 변수의 반대 개념으로 항상 고정된데이터(변하지 않느 데이터)
//		- 실제 사용하는 데이터(상수)를 리터럴(literal)이라고도 한다
//		 ex) 정수형 리터럴 1, 실수형 리터럴3.14 등
//		
//		
		System.out.println(1);  //정수형(기본형 = int형) 리터럴
		System.out.println(3.14);  //실수형(기본형 = double형) 리터럴
		
		System.out.println('A');  //문자형 리터럴(직은따옴표로 둘러싼 1개의 문자)
//		System.out.println('AB');  //오류!문자형은 1개의 문자만 입력할 수 있다.
		
		System.out.println(true);  //논리형(boolean형)리터럴 (true 또는 false)
		System.out.println(false); 
		/* System.out.println(TRUE); */ //오류! 예약어 true는 무조건 소문자로 써야함.
									//대문자 TRUE는 예약어 아님!
		
		System.out.println(100L); // 정수형(long형) 리터럴, (접미사 L(구분하기 위함) 붙는다)
		System.out.println(1.5f); //실수형(float형) 리터럴 (접미사 f 또는 F 뿥는다)
		System.out.println(100l); // 소문자도 가능함 / 하지만 대부분 대문자를 사용함
		System.out.println(1.5F); // 대문자도 가능함
		System.out.println("Hello, world!"); //문자열형 리터럴 ( 큰 따옴표로 둘러싼 문자들)
		
		
		System.out.println("");  //큰따옴표만 적고 아무것도 안적어도됨
		/*
		 * System.out.println(''); //무조건 1개의 문자를 적어줘야함
		 */		
		
	}

}
