package constructor;

class DefaultPerson {
	String name;
	
	// 생성자를 아무것도 정의하지 않으면 컴파일러에 의해 자동으로 기본생성자 생성됨
	// => 기본생성자: 파라미터 없음, 중괄호 블록 내부에 아무 코드도 없음
	//				=> 아무것도 전달받지 않으며, 아무 작업도 수행하지 않음
//	public DefaultPerson() {}
}

class DefaultPerson2 {
	String name;
	
	public DefaultPerson2() {
		System.out.println("DefaultPerson2() 생성자 호출됨!");
		name = "홍길동";
	}
}

class ParameterPerson {
	String name;
	
	public ParameterPerson(String n) {
		System.out.println("ParameterPerson(String) 생성자 호출됨!");
		name = n;
	}
}

class ParameterPerson2 {
	String name;		// 이름
	int age;			// 나이
	boolean isHungry;	// 배고픔 유무
	
//	public ParameterPerson2(String n, int a, boolean h) {
//		name = n;
//		age = a;
//		isHungry = h;
//	}
	
	// 생성자 자동 생성 단축키: Alt + Shift + S -> O
	public ParameterPerson2(String name, int age, boolean isHungry) {
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}
	
	
}

public class Ex1 {

	public static void main(String[] args) {
		DefaultPerson dp = new DefaultPerson();
		System.out.println("DefaultPerson의 name : " + dp.name);
		System.out.println("-----------------------------------");
		
		DefaultPerson2 dp2 = new DefaultPerson2();
		System.out.println("DefaultPerson2의 name : " + dp2.name);
		System.out.println("-----------------------------------");
		
		// 생성자를 하나라도 명시적으로 선언하는 경우
		// 컴파일러가 기본생성자를 추가해주지 않으므로 new ParameterPerson() 으로 생성할 수 없음!
//		ParameterPerson p = new ParameterPerson();
		ParameterPerson p = new ParameterPerson("홍길동");
		System.out.println("ParameterPerson의 name : " + p.name);
		System.out.println("-----------------------------------");
		
		ParameterPerson2 p2 = new ParameterPerson2("홍길동", 20, true);
		System.out.println("ParameterPerson2의 name: " + p2.name);
		System.out.println("ParameterPerson2의 age: " + p2.age);
		System.out.println("ParameterPerson2의 isHungry: " + p2.isHungry);
		
	}

}
