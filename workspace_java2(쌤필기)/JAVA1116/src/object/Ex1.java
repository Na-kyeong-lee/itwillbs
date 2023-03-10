package object;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * java.lang.Object
		 * - 모든 클래스의 최상위 클래스
		 *   => 별도로 상속을 받지 않는 클래스는 묵시적으로 Object 클래스를 상속 받음
		 * */
		int num = 10;
		System.out.println(num);
		
		Object o = new Object();
		System.out.println(o);
		// Object 인스턴스 생성 후 Object 의 메서드 호출 가능
		// 인스턴스 주소를 저장하는 참조변수의 내용을 그대로 출력하면 @~~~~ 출력됨
		System.out.println("-------------------");
		Person p1 = new Person();
		System.out.println(p1); // object.Person@5d22bbb7 (@ 뒤의 16진수 숫자는 다를 수 있음)
		
		Person p2 = new Person();
		System.out.println(p2); // object.Person@41a4555e
		System.out.println("-------------------------");
		// Person 클래스 인스턴스(p1 또는 p2)에는 Object 로 부터 상속받은 메서드도 존재함
		/*
		 * 1. getClass() 메서드
		 * - 현재 객체의 클래스 정보를 Class 타입 객체로 리턴
		 *   (ex. Person 클래스의 참조변수 p1의 getClass() 결과 출력 시 : class 패키지명.Person)
		 * - 해당 클래스의 클래스명을 얻으려면 getClass() 메서드 결과에 다시 .getName() 을 붙임
		 * - 클래스명만 필요한 경우 getClass() 메서드 결과에 다시 .getSimpleName()을 붙임  
		 * */
		System.out.println("p1.getClass(): " + p1.getClass());
		System.out.println("p2.getClass(): " + p2.getClass());
		System.out.println("o.getClass(): " + o.getClass());
		
		System.out.println("p1.getClass().getName(): " + p1.getClass().getName());
		System.out.println("p2.getClass().getName(): " + p2.getClass().getName());
		System.out.println("o.getClass().getName(): " + o.getClass().getName());
		
		System.out.println("p1.getClass().getSimpleName(): " + p1.getClass().getSimpleName());
		System.out.println("p2.getClass().getSimpleName(): " + p2.getClass().getSimpleName());
		System.out.println("o.getClass().getSimpleName(): " + o.getClass().getSimpleName());
		
		System.out.println("---------------------------");
		/*
		 * 2. hashCode() 메서드
		 * - 주소를 리턴
		 * */
		System.out.println("p1.hashCode(): " + p1.hashCode());
		System.out.println("p2.hashCode(): " + p2.hashCode());
		
	}

}

class Person {
	String name;
	int age;
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}










