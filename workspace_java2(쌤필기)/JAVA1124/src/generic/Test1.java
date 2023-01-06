package generic;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("이순신", 44);
		
		System.out.println(p1);
		System.out.println(p2.toString());
		
		List list = new ArrayList();
		list.add(p1);
		list.add(p2);
		list.add(new Person("강감찬", 35));
		list.add("전지현"); // Person 객체가 아닌 데이터도 추가가 가능함
		// => Person 객체 형태로 꺼내서 사용하는 시점에서 문제가 발생할 수있다!
		for(Object o : list) {
			if(o instanceof Person) {
				Person p = (Person)o;
				System.out.println(p.getName() + ", " + p.getAge());
			} else {
				System.out.println("타입 불일치");
			}
		}
		
		System.out.println("-----------------------------");
		List<Person> list2 = new ArrayList<Person>();
		
		list2.add(p1);
		list2.add(p2);
		list2.add(new Person("강감찬", 35));
		
		// Person 타입이 아닌 객체(데이터)를 추가할 경우
		// 데이터타입 판별에 의해 오류가 발생하게 된다!
//		list2.add("전지현"); // 컴파일 에러!
		
		for(Person p : list2) {
			System.out.println(p);
			System.out.println(p.getName() + ", " + p.getAge());
		}
		
		
		
		
	}
	
}

/*
 * Person 클래스 정의
 * - 멤버변수(private) : 이름(name, 문자열), 나이(age, 정수)
 * - 생성자 : 이름과 나이를 전달받아 초기화하는 생성자
 * - toString() 메서드 오버라이딩 (이름과 나이를 결합하여 리턴)
 * - Getter / Setter 정의
 * */
class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}








