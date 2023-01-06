package interface_;

public class Test1 {

	public static void main(String[] args) {
		
		Flyer[] fArr = {new SuperMan(), new Bird(), new Airplane(), new SuperMan()};
		for(Flyer f : fArr) {
			f.takeOff();
			f.fly();
			f.land();
		}
		
		
		
	}

}

// 날 수 있는 모든 것들에 대한 인터페이스 Flyer 정의
// => SuperMan, Bird, Airplane 모두 '날다' 라는 기능 fly() 존재하므로
// 인터페이스에서 공통 기능을 하나의 추상메서드로 제공
interface Flyer {
	void takeOff();	// 이륙!
	void fly();		// 비행!
	void land();	// 착륙!
}

// SuperMan 클래스 정의 - Flyer 인터페이스를 상속받아 구현
// => 추상메서드 3개 구현 필수!
// 예) SuperMan 이륙!, SuperMan 비행!, SuperMan 착륙!
class SuperMan implements Flyer {
	@Override
	public void takeOff() {
		System.out.println("SuperMan 이륙!");
	}
	@Override
	public void fly() {
		System.out.println("SuperMan 비행!");
	}
	@Override
	public void land() {
		System.out.println("SuperMan 착륙!");
	}
}

// Bird 클래스 정의 - Flyer 인터페이스를 상속받아 구현
class Bird implements Flyer {
	@Override
	public void takeOff() {
		System.out.println("Bird 이륙!");
	}
	@Override
	public void fly() {
		System.out.println("Bird 비행!");
	}
	@Override
	public void land() {
		System.out.println("Bird 착륙!");
	}
}

// Airplane 클래스 정의 - Flyer 인터페이스를 상속받아 구현
class Airplane implements Flyer {
	@Override
	public void takeOff() {
		System.out.println("Airplane 이륙!");
	}
	@Override
	public void fly() {
		System.out.println("Airplane 비행!");
	}
	@Override
	public void land() {
		System.out.println("Airplane 착륙!");
	}
}







