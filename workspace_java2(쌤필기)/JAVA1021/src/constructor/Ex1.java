package constructor;

class Person {
	String name;
	int age;
	
	// 문자열을 전달받아 name을 초기화하는 메서드
	public void setName(String newName) {
		name = newName;
	}
	
	public void printThis() {
		System.out.println(this);
	}
	
}


public class Ex1 {

	public static void main(String[] args) {
		/*
		 * this 키워드
		 * 1. 레퍼런스(Refernce) this
		 * 		- 자신의 인스턴스 주소가 저장되는 레퍼런스(= 참조변수)
		 * 		- 개발자가 임의로 생성할 수 없으며, 인스턴스 생성 시 (new) 자동으로 주소가 저장됨
		 * 		=> 각 인스턴스마다 this에 저장되는 주소가 달라짐
		 * 		- 일반적인 참조변수와 동일한 방법으로 사용가능
		 * 		- 주로 생성자나 메서드 내에서 멤버변수와 로컬변수의 이름이 동일할 경우
		 * 		  멤버변수를 구별할 목적으로 사용
		 * 		- 또한, 자신의 인스턴스 내의 다른 메서드를 호출하는데에도 사용 가능
		 * 		   (일반적으로 메서드 이름은 로컬변수처럼 중복되지 않으므로 this 생략)
		 * 
		 * < 기본 문법 >
		 * this.멤버변수명
		 * this.메서드명()
		 * 
		 * 
		 */
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = p1;				// 사람은 두명이고 p3에는 p1의 주소가 들어간다. 변수가 2개인거지 person이 3명인게 아님
		
		// 참조변수 주소 출력
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("-------------------------");
		// 위 아래 같은 this임
		
		// this 출력
		p1.printThis();
		p2.printThis();
		p3.printThis();
		
		System.out.println("-------------------------");
		
		p1.name = "홍길동";
		System.out.println(p3.name);
		
		p3.age = 20;
		System.out.println(p1.age);
		
		
		
		
		
		
		
	}

}
