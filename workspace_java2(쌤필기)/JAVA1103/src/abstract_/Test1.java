package abstract_;

public class Test1 {

	public static void main(String[] args) {
		// 추상클래스인 Flyer 클래스는 인스턴스 생성 불가!
//		Flyer f = new Flyer();
		
		Flyer[] arr = {new Bird(), new Airplane(), new SuperMan()};
		
		for(Flyer flyer : arr) {
			flyer.fly();
		}
		
	}
}

// 날아다니는 것 (Flyer)
abstract class Flyer {
	public abstract void fly();
}

// Bird 클래스 정의 - Flyer 클래스 상속
// => fly() 오버라이딩하여 "Bird 비행!" 출력
class Bird extends Flyer {
	@Override
	public void fly() {
		System.out.println("Bird 비행!");
	}
}

// SuperMan 클래스 정의 - Flyer 클래스 상속
// => fly() 오버라이딩하여 "SuperMan 비행!" 출력
class SuperMan extends Flyer {
	@Override
	public void fly() {
		System.out.println("SuperMan 비행!");
	}
}

// Airplane 클래스 정의 - Flyer 클래스 상속
// => fly() 오버라이딩하여 "Airplane 비행!" 출력
class Airplane extends Flyer {
	@Override
	public void fly() {
		System.out.println("Airplane 비행!");
	}
}









