package block;

/*
 * 초기화 블록 (Initialization block)
 * 1. *** 클래스 초기화 블록 ( static {} )
 * 	- 클래스 변수(static으로 선언된 변수)의 복잡한 초기화에 사용된다.
 *  - 클래스가 처음 로딩될때 한번만 수행된다.
 * 
 * 2. 인스턴스 초기화 블록 ( {} )
 * 	- 인스턴스 변수의 복잡한 초기화에 사용된다.
 * 	- 인스턴스가 생성될때 마다 (new 될때마다!) 수행된다.
 * 	- *생성자보다 먼저 수행된다!
 * 	- 일반적으로 인스턴스 멤버의 초기화 코드는 생성자에서 하면 되기때문에 잘 사용되진 않지만
 *    만약, 복잡한 초기화로직이 오버로딩된 생성자에 공통으로 적용되어야 한다면?
 *    인스턴스 초기화 블록을 사용하면 코드의 중복을 줄일 수 있다!
 * */

public class Ex1 {
	
	int a;
	static int b;
	
	// 클래스 초기화 블록
	static {
		// 인스턴스 변수 접근 불가!
//		a = 10; // 인스턴스 변수 접근 불가!
//		System.out.println(a);
		
		b = 20;
		System.out.println(b);
	}
	
	// 인스턴스 블록
	{
		System.out.println("인스턴스 블록 호출됨!");
	}
	
	public Ex1() {
		System.out.println("생성자 호출됨!");
	}
	
	public static void main(String[] args) {

		new Ex1();
		
		// 메서드 내에서의 중괄호 블록
		// => 로컬변수의 범위를 제한하기 위해 사용된다!
		int num1 = 10;
		{
			int num2 = 10;
		}
		
		System.out.println(num1);
//		System.out.println(num2);
		// => 마치 for문에서 선언되고 반복이 종료되면 사라지는 i와 마찬가지로
		//    중괄호 블록 외부에서는 접근할 수 없다!
	}

}
