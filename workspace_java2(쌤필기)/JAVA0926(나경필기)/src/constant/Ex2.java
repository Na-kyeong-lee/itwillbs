
public class Ex2 {

	public static void main(String[] args) {
		 // 변수 (Variable)\
		// - 자바에서 사용되는 데이터를 저장하는 메모리공간
		// - 한번에 하나의 데이터만 저장 가능
		// => 언제든 다른 데이터로 대체 될 수 있다(변할 수 있다)
		// - 변수를 사용하기 위해선 변수 선언이 먼저 진행되어야홤
		// - 변수에 데이터를 저장하는 것을 변수'초기화' 라고함
		//
		// < 변수 선언 기본 문법>
		// 데이터 타입 변수형;
		// => 데이터 타입 : 기본형 또는 참조형 타입명 명시
		// => 변수명 : 식별자 작성규칙에 따른 변수명 지정
		//
		//
		//< 변수 초기화 기본 문법>
		// 변수명 = 데이터(또는 변수명);
		//
		// => 우변의 데이터를 좌변의 변수에 저장(대입,초기화)
		//
		// 
		
		
//		int a;
//		int b;
//		a = 1;
//		System.out.println(a);
//		System.out.println(b); // 초기화 후에 사용해야함
//		a = 2;
//		System.out.println(a);
//		
//		// 선언과 초기화를 동시에
//		int a =10;
//		int b = 20; 
//		
//		//동시에 여러개의 변수를 선언
//		int a, b;
//		a = 10;
//		b = 20;
		//
		//동시에 여러개 변수를 선언과 동시에 초기화
//		int a = 10, b = 20;
		//
		//
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a+b);
		//
		
		//
		//a에는 b의 데이터을 넣고 b에는 a데이터을 넣기
		//temp라는 다른 방을 만들어서, 데이터를 넣고 a에 삽입하면 기존에 있던
		//a의 데이터는 지워지고 temp의 데이터가 삽입, b는 a의 데이터 삽입
		int a = 10, b = 20;
		int temp = 10; // 리터럴을 직접적으로 고정 시키는 것을 "하드코딩"이라고함 
//		int temp = a;
		a = b;
		b = temp;
		System.out.println("a:" + a);
		System.out.println("b: " + b);
		
		String name;
		name = "이나경";
		System.out.println(name);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
	}

}
