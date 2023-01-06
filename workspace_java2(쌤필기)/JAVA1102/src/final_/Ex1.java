package final_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * final 키워드
		 * - 클래스, 메서드, 멤버변수에 지정 가능
		 * - 정말 마지막 이라는 뜻
		 * 
		 * 1) 멤버변수에 final이 붙은 경우
		 *  - 변수값 변경 불가 = 상수로 취급됨
		 *    => 즉, 기존에 저장된 값을 사용하는 것만 가능하고, 값을 변경할 수는 없다!
		 *    
		 * 2) 메서드에 final이 붙은 경우
		 *  - 메서브 변경 불가 = 오버라이딩 금지
		 *    => 즉, 슈퍼클래스의 메서드를 상속받아 사용하는 것은 가능하나
		 *       오버라이딩을 통해 슈퍼클래스의 메서드를 변경(수정) 할 수는 없다!
		 * 
		 * 3) 클래스에 final이 붙은 경우
		 * 	- 클래스 변경 불가 = 상속 금지
		 *    => 즉, 특정 클래스 자체를 그대로 사용하는 것은 가능 하나
		 *       다른 클래스에서 해당 클래스를 상속 받을 수는 없다!
		 *    => 어떤 클래스 자체로 이미 완전한 클래스 기능을 수행하는 경우 상속을 금지시킴
		 *    ex) String 클래스, Math 클래스 등
		 *  - final 메서드보다 더 광범위한 제한을 두도록 할때 사용      
		 * */
		FinalMemberVariable fmv = new FinalMemberVariable();
		fmv.normalVar = 99;
//		fmv.finalVar = 999; // 오류 발생! final로 선언된 멤버변수는 값 변경 불가!
		System.out.println(fmv.normalVar);
		System.out.println(fmv.finalVar); // 사용은 가능
		final int a;
		a = 10;
//		a = 20;
		
	}

}

// ----- final 멤버변수 -----
class FinalMemberVariable {
	int normalVar = 10;
	final int finalVar = 20;
}

// ----- final 메서드 -----
class FinalMethod {
	
	public void normalMethod() {
		System.out.println("normalMethod()");
	}
	
	public final void finalMethod() {
		System.out.println("finalMethod()");
	}
}

class SubClass extends FinalMethod {
	
	@Override
	public void normalMethod() {
		
	}
	
//	@Override
//	public final void finalMethod() {
//		// 오류 발생! final 메서드는 서브클래스에서 오버라이딩 불가!
//	}
	
}

// ----- final 클래스 -----





