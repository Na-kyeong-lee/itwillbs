package static_;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * static 메서드 (= 정적 메서드)
		 * - 메서드 선언 시 리턴타입 앞에 static 키워드를 붙여서 정의한 메서드
		 * - static 멤버변수와 마찬가지로 클래스 로딩 시 함께 모리에 로딩되므로
		 *   인스턴스 생성과 관계없이 클래스명만으로 호출 가능한 메서드
		 *   (클래스명.메서드명() 호출이 가능)
		 *   
		 * < 주의 사항 >
		 * 1. static 메서드 내에서는 인스턴스 멤버변수에 접근 불가
		 *    => static 메서드가 로딩되는 시점에는 인스턴스가 생성되지 전이므로
		 *       인스턴스 멤버변수도 로딩되지 않은 상태이다!
		 *       따라서, static 메서드 호출 시점에 인스턴스 멤버변수가 존재하지 않을 수 있다!
		 * 2. static 메서드 내에서 this, super 사용 불가
		 *    => static 메서드가 로딩되는 시점은 인스턴스 생성 전이므로
		 *       인스턴스 주소가 저장되는 레퍼런스 this와 super는 존재하지 않음 (생성전)
		 * 3. static 메서드 내에서 일반 메서드 호출 불가
		 *    => 사유 동일
		 *    => static 메서드만 호출 가능
		 * 
		 * << 결론! static 메서드 내에서는 static 멤버만 접근 가능하다! >>
		 * */
		
		StaticMethod.setStaticVar(99);
	}

}

class StaticMethod {
	
	private int normalVar = 10;			// 인스턴스 멤버변수(인스턴스 생성 시 로딩)
	private static int staticVar = 20;	// 클래스(static) 멤버변수(클래스 로딩 시 로딩)
	
	// 일반 메서드 정의
	public void normalMethod() {
		System.out.println("일반 메서드에서 인스턴스 변수 접근: " + normalVar);
		System.out.println("일반 메서드에서 static 변수 접근: " + staticVar);
	}
	
	// static 메서드 정의
	// => 클래스에 로딩될 때 메모리에 함께 로딩되는 메서드
	public static void staticMethod() {
//		System.out.println("static 메서드에서 인스턴스 변수 접근: " + normalVar);
		// => static 멤버가 메모리에 로딩되는 시점에는 인스턴스 멤버는 로딩되지 않은 상태!
		//    따라서, static 메서드 내에서는 인스턴스 멤버변수 접근이 불가능 하다!
		System.out.println("static 메서드에서 static 변수 접근: " + staticVar);
	}
	
	// normalVar 변수에 대한 Setter 정의
	public void setNormalVar(int normalVar) {
		this.normalVar = normalVar; 
	}
	
	// staticVar 변수에 대한 Setter 정의
	// => static 멤버변수에 클래스명만으로 접근하기 위해 static 메서드로 정의
	public static void setStaticVar(int staticVar) {
		// 레퍼런스 this? 자신의 인스턴스 주소를 저장하는 참조변수
//		this.staticVar = staticVar; 오류! static 메서드 내에서 this 사용 불가!
		// => static 멤버가 메모리에 로딩되는 시점에는 인스턴스가 생성되기 전이므로
		//    인스턴스 주소를 저장하는 레퍼런스 this 도 생성되기 전이다!
		//    따라서, static 메서드 내에서는 this 사용이 불가능하다!
		
		// 레퍼런스 this 대신 클래스명을 사용하여 멤버변수 지정 가능
		StaticMethod.staticVar = staticVar;
		
		// static 메서드 내에서 static 메서드 호출 가능
		staticMethod(); // static 메서드 호출 가능! (함께 같은 타이밍에 로딩되어 있기 때문)
//		normalMethod(); // 일반 메서드 호출 불가! (인스턴스 생성 전이므로 로딩 X)
	}
	
}














