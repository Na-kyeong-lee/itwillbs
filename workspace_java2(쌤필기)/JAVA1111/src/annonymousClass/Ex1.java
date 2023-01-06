package annonymousClass;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 익명클래스 (Annonymous Class)
		 * - 이름이 없는 클래스
		 * - 재사용하지 않고 단 한번만 사용하기 위한 방식 (1회성)
		 *   => 이름이 있다는 것은? 계속해서 여러번 재사용하겠다는 뜻인데
		 *      애플리케이션에서 단한번만 사용한다거나 상황에 따라 다르게 동작해야할 경우
		 *      오히려 class로 만들어 둔것이 번거로울수 있음 (파일만 많아짐)
		 * - 중괄호 내부에서 생성자는 불필요
		 * 	 => 생성자는 new 키워드로 객체를 생성하는 방법을 기술하는 것인데,
		 *      이름이 없는 클래스이기 때문에 다시 생성할 이유가 없음
		 *   => 생성자 규칙은 리턴타입이 없고 클래스명과 동일해야하는데
		 *      익명클래스는 이름이 없으므로 생성자 선언 불가능   
		 * 
		 * */
		// 일반적인 클래스 사용
		Parent p = new Child();
		System.out.println(p.name);
		p.method();
		
		System.out.println("---------------------");
		
		// 익명 클래스 사용
		Parent p2 = new Parent() {
			String name = "Child";

			@Override
			public void method() {
				System.out.println("Child");
			}
		};
		
		System.out.println(p2.name);
		p2.method();
		
		// => 마치 Parent 클래스를 상속받는 서브클래스를 선언하고 생성하여 업캐스팅 한것처럼
		//    Parent 클래스를 상속받는 클래스를 이름없이 바로 선언함과 동시에 생성하여 업캐스팅
		
		System.out.println("---------------------------------");
		
		Parent p3 = new Parent() {
			// 멤버변수 (O)
			// 생성자 (X)
			// 메서드 (O)
		};
		
		System.out.println("---------------------------------");
		// 익명클래스 내부에서 변수 접근
		int localVar = 10;
		
		Parent p4 = new Parent() {
			int memberVar = 20;
			// static int staticMemberVar = 30;

			@Override
			public void method() {
				System.out.println(localVar); // 사용 가능
//				localVar++; // 마치 final 인것처럼 변경 불가!
				
				// 수정 및 사용 가능
				System.out.println(memberVar);
				memberVar++;
			}
		};
		
		// 정리) 1. 익명클래스 내부에서 선언한 변수는(멤버변수) 값변경 및 사용 둘다 가능
		//      2. 클래스 외부에 선언한 변수는 변경은 불가하고 사용만 가능
		
		new I() {
			
		};
	}

}

interface I {}

class Parent {
	String name = "Parent";
	public void method() {
		System.out.println("Parent");
	}
}

class Child extends Parent {
	String name = "Child";

	@Override
	public void method() {
		System.out.println("Child");
	}
	
}












