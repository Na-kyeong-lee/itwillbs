package interface_;

public class Ex1 {

	public static void main(String[] args) {
		// 인터페이스도 추상클래스와 마찬가지로 인스턴스 생성 불가!
//		MyInterface mi = new MyInterface();
		
		// 인터페이스 내의 모든 변수는 상수이므로 값 변경 불가!
//		MyInterface.NUM1 = 100;
//		MyInterface.NUM2 = 200;
		
		// 인터페이스를 구현한 구현체 클래스를 통해 사용해야함
		MySubClass msc = new MySubClass();
		msc.method1();
		msc.method2();
		
		// 인터페이스를 구현한 구현체 클래스에도 동일한 상수가 상속됨
//		MySubClass.NUM1 = 10; // 변경불가!
//		msc.NUM2 = 20;		  // 변경불가!
		
		// 인터페이스는 인스턴스 생성은 불가능하지만, 참조변수 타입으로 사용 가능
		// => 클래스의 인스턴스를 인터페이스 타입으로오도 업캐스팅 가능함
		MyInterface mi = new MySubClass(); // 업캐스팅
		// 업캐스팅 후에는 참조영역이 축소되므로 상속된 메서드만 호출 가능함
		// => 하지만, 인터페이스가 정의한 추상메서드를 모두 오버라이딩 했기 때문에
		//    인터페이스의 모든 메서드는 참조영역이 축소 되더라도 호출 가능함
		mi.method1();
		mi.method2();
		
		// 또한, 상수도 인터페이스에서 선언 했으므로 접근 가능
		System.out.println(mi.NUM1);
		System.out.println(mi.NUM2);
		System.out.println(MyInterface.NUM1);
		System.out.println(MySubClass.NUM2);
		
		
	}

}

// 인터페이스 정의
// class 키워드 대신 interface 키워드를 사용하여 정의
interface MyInterface {
	// 인터페이스 내의 모든 멤버변수는 상수 (public static final) 이다.
	public static final int NUM1 = 10; // 상수
	int NUM2 = 20; // public static final 생략되어 있음
	
	// 인터페이스 내의 모든 메서드는 추상메서드(public abstract) 이다.
	public abstract void method1(); // 추상메서드
	void method2();	// public abstract 생략되어있음
}

// 인터페이스를 상속받아 구현하는 구현체 클래스 정의
// => 서브클래스 정의 시 클래스명 뒤에 implements 키워드를 붙이고 인터페이스명을 지정
class MySubClass implements MyInterface {

	@Override
	public void method1() {
		System.out.println("서브클래스에서 구현한 추상메서드 method1()");
	}
	
	// 상속 관계에서 오버라이딩 시 부모의 접근제한자보다 좁아질 수 없다!
	// => 인터페이스에서 method2() 의 접근제한자를 생략 했지만, 자동으로 public 이 붙으므로
	//    오버라이딩 메서드는 public 만 사용 가능함!
//	@Override
//	void method2() {
//		
//	}

	@Override
	public void method2() {
		System.out.println("서브클래스에서 구현한 추상메서드 method2()");
	}
}







