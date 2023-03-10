package static_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 싱글톤(singleton)
		 * - 애플리케이션이 시작될때 어떤 클래스가 최초 한번만 메모리를 할당하고 (static)
		 *   그 메모리에 인스턴스를 만들어 사용하는 디자인 패턴.
		 * - 일반적으로 java에서는 생성자를 private로 선언해서 생성 불가능하게 하고
		 *   getInstance() 메서드 작성해서 객체를 받도록 구현
		 *   => 싱글톤 패턴은 단 하나의 인스턴스를 생성해 사용하는 디자인 패턴
		 *     
		 * [ 싱글톤 패턴을 쓰는 이유 (장점) ]
		 * 1. 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지
		 * 2. 싱글톤으로 만들어진 클래스의 인스턴스는 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이
		 *    데이터를 공유하기 쉽다. DBCP(DataBase Connection Pool) 처럼 공통된 객체를 여러 인스턴스
		 *    변수로 사용해야하는 상황에서 많이 사용
		 *    (쓰레드풀, 캐시, 대화상자, 사용자 설정, 레지스트리 설정, 로그 기록 객체 등)
		 * 3. 안드로이드 앱 같은 경우 각 액티비니나 클래스별로 주요 클래스들을 일일이 전달하기가 번거롭기 때문에
		 *    싱글톤 클래스를 만들어서 어디서나 접근가능하도록 설계
		 *    
		 * => 결론. 인스턴스가 절대적으로 한개만 존재하는 것을 보장하고 싶을 때
		 * 
		 * [ 문제점 ]
		 * 1. 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우
		 *    다른 클래스의 인스턴스들 간에 결합도가 높아져 수정(유지보수)이 어려워지고 테스트하기 어려워진다.
		 * 2. 멀티쓰레드환경에서 동기화처리를 안하면 인스턴스가 두개 생성된다든지 하는 경우가 발생할 수 있음.            
		 * */
		NormalClass a = new NormalClass();
		NormalClass b = new NormalClass();
		System.out.println(a == b);
		
		Car car1 = Car.getInstance();
		Car car2 = Car.getInstance();
		Car car3 = Car.getInstance();
		
		System.out.println(car1 == car2);
		System.out.println(car2 == car3);
		
		
	}

}

class Car {
	// 2. 객체를 저장해둘 변수를 선언한다.
	//    (단, 외부에서 접근할수 없도록 private)
	private static Car car;
	// 1. 외부에서 생성할 수 없도록 생성자 private
	private Car() {}
	
	// 3. car 객체를 리턴 해줄 getInstance() 메서드 선언
	// (단, 외부메서 getInstance() 메서드를 호출할 방법이 없기 때문에 static 선언하고
	//      인스턴스 변수는 static 메서드에서 접근 불가능 하므로 car 변수 static 선언)
	static Car getInstance() {
		if(car == null) {
			car = new Car();
		}
		return car;
	}
}











class NormalClass {
	
}
