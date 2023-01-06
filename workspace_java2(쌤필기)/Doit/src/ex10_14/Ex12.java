package ex10_14;

import java.util.HashMap;
import java.util.Map;

public class Ex12 {

	public static void main(String[] args) {
		// 446p
		
		// Q1) 정답: 컬렉션 프레임워크
		// 자료 구조를 사용하기 편리하도록 자바에서 제공하는 라이브러리를 XXX 라고 합니다.
		
		// Q2) 정답: 제네릭 (프로그래밍)
		// 클래스에서 여러 자료형을 사용할 때 자료형을 명시하지 않고 자료형을 의미하는 문자로
		// 선언한 후 실제 클래스를 생성할 때 자료형을 명시하는 프로그래밍 방식을 XXX 이라고 합니다.
		
		// Q3) 정답: Iterator
		// Collection 인터페이스를 구현한 클래스를 순회하기 위해 사용하는 인터페이스는 XXX 입니다.
		
		// Q6)
		// 다음 코드에서 결과가 true, true, false 가 되도록 HashMap을 사용하여
		// CarFactory 클래스를 구현해 보세요.
		CarFactory factory = CarFactory.getInstance();
		Car sonata1 = factory.createCar("쏘나타");
		Car sonata2 = factory.createCar("쏘나타");
		System.out.println(sonata1 == sonata2);	// true
		
		Car avante1 = factory.createCar("아반떼");
		Car avante2 = factory.createCar("아반떼");
		System.out.println(avante1 == avante2);	// true
		
		System.out.println(sonata1 == avante1);	// false
	}
}
class Car {
	String type;

	public Car(String type) {
		this.type = type;
	}
}
class CarFactory {
	
//	static CarFactory instance = new CarFactory();
	static CarFactory instance;
	Map<String, Car> carMap = new HashMap<String, Car>();
	
	private CarFactory() {}
	public static CarFactory getInstance(){
		if(instance == null) {
			instance = new CarFactory();
		}
		return instance;
	}
	
	public Car createCar(String type){
		
		// 쏘나타라는 키값으로 자동차를 생산한적이 있는지 검사
		if(carMap.containsKey(type)) { 
			return carMap.get(type);
		}
		
		carMap.put(type, new Car(type));
		return carMap.get(type);
	}
}








