package constructor;

class OverloadingPerson {
	String name;
	int age;
	boolean isHungry;
	
	// 기본 생성자 직접 정의
	public OverloadingPerson() {
		System.out.println("OverloadingPerson() 생성자 호출됨!!");
		name = "홍길동";
		age = 20;
		isHungry = true;
	}
	
	// 갯수
//	public OverloadingPerson(String name) {}
//	public OverloadingPerson(String name, int age) {}
	
	// 순서
	public OverloadingPerson(String name, int age) {}
	public OverloadingPerson(String name, boolean isHungry) {}
	public OverloadingPerson(boolean isHungry, String name) {}
	
	// 생성자 오버로딩
	// 이름, 나이, 배고픔을 전달받아 멤버변수를 초기화하는 생성자 정의
	public OverloadingPerson(String name, int age, boolean isHungry) {
		System.out.println("OverloadingPerson(String, int, boolean) 생성자 호출됨!");
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}
	
	public void print() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("배고픔: " + isHungry);
	}
}


public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 생성자 오버로딩
		 * - 파라미터가 다른(갯수, 순서) 생성자를 여러번 정의하는 것
		 * */
		OverloadingPerson op = new OverloadingPerson();
		op.print();
		System.out.println("-----------------------------");
		OverloadingPerson op2 = new OverloadingPerson("이순신", 44, false);
		op2.print();
		
		
		
		
		
		
	}

}
