package lambda;

@FunctionalInterface
interface MyFuncInterface {
	int interfaceMember = 20;
	String method(String msg);
}

class VariableUseTest {
	private int memberVar;
	
	public void useFiMethod(MyFuncInterface mi) {
		
		System.out.println(mi.method("홍길동"));
	}
	
	public void lambdaTest() {
		int localVar = 20;
		
		/*
		 * 출력결과 비교
		 * - 람다식 내부에서 this와 외부클래스.this는 같음을 알 수 있다.
		 * - 람다식에서의 this는 마치 해당되는 클래스 처럼 접근됨
		 * - 익명의 내부클래스에서 this는 해당되는 인터페이스 처럼 접근됨
		 * */
		
		
		// 람다식
		useFiMethod(msg -> {
			
//			this.memberVar	// 접근가능 (O)
//			memberVar		// 접근가능 (O)
			
//			interfaceMember	// 접근불가 (X)
//			this.interfaceMember // 접근불가(X)
			System.out.println("----- 람다식 -----");
			System.out.println("this: " + this);
			System.out.println("외부클래스.this: " + VariableUseTest.this);
			
			return msg;
		});
		
		// 익명내부클래스
		useFiMethod(new MyFuncInterface() {
			
			@Override
			public String method(String msg) {
//				this.memberVar	// 접근불가(X)
//				memberVar		// 접근가능(O)
				
//				interfaceMember // 접근가능(O)
//				this.interfaceMember // 접근가능(O)
				System.out.println("----- 익명 내부클래스 -----");
				System.out.println("this: " + this);
				System.out.println("외부클래스.this: " + VariableUseTest.this);
				
				return msg;
			}
		});
		
		
	}
	
}


public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 람다식 실행블록에서 변수 참조 (this)
		 * 
		 * 람다식은 컴파일러에 의해 익명의 내부클래스로 처리되기 때문에
		 * 변수에 대한 참조 규칙이 동일하다.
		 * - 외부클래스의 멤버를 자유롭게 사용할 수 있다.
		 * - 자바8 부터는 일반 로컬 변수도 사용할 수 있는데
		 *   final 키워드가 적용된 것처럼 새로운 값을 할당할 수는 없다!
		 *   
		 * * 하지만 this를 사용하는 방법이 약간 다르다.
		 * - 람다식에서 this는 타겟 인터페이스가 아닌 외부클래스를 나타낸다.
		 * - 따라서, 람다식 내에서 this와 외부클래스.this는 동일한 객체를 나타낸다.  
		 * 
		 * */
		VariableUseTest vut = new VariableUseTest();
		vut.lambdaTest();
		
		
		
		
		
		
	}

}
