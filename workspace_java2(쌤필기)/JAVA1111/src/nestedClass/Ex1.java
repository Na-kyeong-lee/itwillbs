package nestedClass;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 중첩 클래스 (Nested Class)
		 * - 클래스 내에서 정의 한 클래스
		 * - 독립적인 일반 클래스 형태로 작성할 필요가 없지만
		 *   나름대로 클래스 형태(멤버변수, 메서드, 생성자)를 갖춰야할 필요성이 있을 경우 사용
		 * - 자신의 클래스만 접근 가능하도록 전용 클래스로 정의할 때 사용 
		 *   => 주로 GUI 구현 시 이벤트 처리를 수행하는 핸들러 클래스 정의시 사용
		 * - 외부클래스와 내부클래스로 구분됨   
		 * - 클래스를 정의하는 위치에 따라 다음과 같이 구분됨
		 * 	1) 멤버 내부클래스
		 * 		- 멤버변수 및 메서드와 동일한 레벨에 정의한 클래스
		 * 		- *.class 파일 생성시 외부클래스명$내부클래스명.class 형태로 생성됨
		 * 	2) 정적 내부클래스
		 * 		- 정적 멤버변수 및 메서드와 동일한 방식으로 정의한 클래스
		 * 		- 클래스 파일은 멤버 내부클래스와 동일함
		 * 	3) 로컬 내부클래스
		 * 		- 클래스 내의 메서드 내에서 정의한 클래스
		 * 		- 특정 메서드 내에서만 사용할 클래스를 정의할 때
		 * 		- 메서드 호출 시점에서 메모리에 로딩되므로 메서드 외부에서 접근 불가능하며
		 *  	  메서드 내에서도 클래스 정의 코드 아래쪽에서 접근 가능함
		 *  	- *.class 파일 생성 시 외부클래스명$1내부클래스명.class 형태로 생성됨
		 *  
		 *  ex)
		 *  class A {
		 *  	int num;	// 인스턴스 멤버 변수
		 *  	class B {}	// 인스턴스 멤버 클래스
		 *  	// 인스턴스 생성 후 참조변수를 통해 접근 가능한 클래스
		 *  ------------------------------------------------
		 *  	static int num2;	// 정적 멤버변수(클래스명으로 접근)
		 *  	static class C {}	// 정적 멤버클래스
		 *  	// 클래스명만으로 접근 가능한 클래스
		 *  
		 *  	public void method(){
		 *  		int num3;	// 로컬 변수 (메서드 내에서만 접근 가능 변수)
		 *  		class D {}	// 로컬 내부클래스
		 *  		// 메서드 내에서만 접근 가능한 클래스
		 *  	}
		 *  }
		 *  
		 * */
		
		// 클래스 내의 인스턴스 멤버(변수 및 메서드)에 접근하려면
		// 반드시 클래스의 인스턴스를 생성한 후 참조변수를 통해 멤버에 접근해야한다!
		Outer outer = new Outer();
		outer.method();
		
		// 인스턴스 멤버 내부클래스도 인스턴스 멤버와 마찬가지로
		// 인스턴스를 통해 접근해야하는데 인스턴스 멤버 내부클래스의 인스턴스를 생성해야만
		// 해당 클래스 내의 멤버에 접근 가능하다!
		Outer.Inner inner = outer.new Inner();
		inner.innerMethod();
		
		// 정적 내부클래스의 인스턴스 생성
		// => 정적 내부클래스 static 키워드가 사용되므로
		//    클래스가 메모리에 로딩될때 정적 내부클래스도 함께 로딩됨
		//    따라서, 내부클래스 접근 문법은 외부클래스의 인스턴스 생성없이
		//    외부클래스명만으로 접근 가능
		// => 외부클래스명.내부클래스명 참조변수명 = new 외부클래스명.내부클래스명();
		Outer.StaticInner staticInner = new Outer.StaticInner();
		
	} // main() 메서드 끝
	
}

class Outer { // 외부클래스
	int num = 10;	// 인스턴스 멤버변수
	public void method() { // 멤버 메서드
		System.out.println(num);
		
		// 외부클래스의 멤버메서드 내에서 내부클래스 접근 가능 (메서드와 동일)
		Inner inner = new Inner(); 
		// => 바로 접근 가능하므로 일반적인 인스턴스 생성 코드와 동일
		
		// 로컬 내부클래스에 접근하기 위해서 선언부보다 아래쪽에서 접근 해야함!
//		LocalInner localInner; // 오류발생! => 아직 존재하지 않는 클래스
		
		// 로컬 내부클래스 정의 -> 특정 메서드에서만 사용가능한 클래스
		class LocalInner {
			String name = "LocalInner";
		}
		
		// 클래스 선언부(정의)보다 아래쪽에서는 클래스 접근 가능
		// => 일반 클래스처럼 사용 가능
		LocalInner localInner = new LocalInner();
		System.out.println(localInner.name);
		
		
	}
	
	// 내부클래스 (=> 인스턴스 멤버 내부클래스 = 멤버 내부클래스)
	class Inner {
		
		public void innerMethod() {
			System.out.println(num);	// 외부클래스 멤버변수 접근가능
			method();	// 내부클래스에서 외부클래스 메서드 호출 가능
		}
		
	}
	
	// 정적내부클래스
	static class StaticInner {
		
		public void staticInnerMethod() {
			// 정적 내부클래스에서 외부클래스의 인스턴스 멤버에 접근이 불가능하다!
			// => 메모리 로딩 시점이 다르기 때문에 (= 정적 메서드와 규칙이 동일)
//			System.out.println(num);
//			method();
		}
	}
	
}














