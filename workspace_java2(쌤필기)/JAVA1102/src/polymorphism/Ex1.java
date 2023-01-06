package polymorphism;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 동적 바인딩
		 * - 컴파일(번역) 시점에서 실행될 것으로 예상되는 코드와
		 *   실제 실행 시점에서 해당 객체의 타입 기준으로 메서드가 달라지는 것
		 * */
		
		// 슈퍼클래스(Employee) 인스턴스 생성
		Employee emp = new Employee("홍길동", 3000);
//		System.out.println("asdhahsd");
		System.out.println(emp.getEmployee());
		System.out.println("-----------------------------");
		
		// 서브클래스(Manager) 인스턴스 생성
		Manager man = new Manager("이순신", 4000, "개발팀");
		System.out.println(man.getEmployee());
		System.out.println("==============================");
		
		// Manager -> Employee 업캐스팅
//		emp = (Employee)man;
		emp = man;
		System.out.println(emp.getEmployee()); 
		// => 코드상(컴파일시점)으로는 Employee 클래스의 getEmployee() 메서드가 호출되지만
		//    실제 emp변수에 저장된 인스턴스(객체) Manager 클래스의 인스턴스 이므로
		//    실행 시점에는 Manager 클래스에 오버라이딩 된 getEmployee() 메서드가 실행됨!
		System.out.println("-----------------------------");
		
		// 서브클래스(Engineer) 인스턴스 생성
		Engineer eng = new Engineer("차동원", 8000, "자바개발");
		System.out.println(eng.getEmployee()); 

		// Engineer(eng) -> Employee(emp2) 업캐스팅
		Employee emp2 = eng;
		System.out.println(emp2.getEmployee()); 
		
		// Manager 인스턴스를 생성하여 Employee(emp2) 로 업캐스팅
		emp2 = new Manager("이순신", 5000, "개발2팀");
		
		System.out.println(emp2.getEmployee());
		
		System.out.println("======================================");
		
		// emp = new Manager(), emp2 = new Manager()
		Employee[] emps = {emp, emp2, new Engineer("차동원", 9000, "자바개발")}; 
		
		// 일반 for문
		for(int i = 0; i < emps.length; i++) {
			System.out.println(emps[i].getEmployee());
		}
		
		// 향상된 for문
		for(Employee em : emps) {
			System.out.println(em.getEmployee()); 
		}
	}
}

class Employee {
	String name;
	int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getEmployee() {
		return name + ", " + salary;
	}
}

/*
 * Manager 클래스 정의 - Employee 클래스 상속
 * 멤버변수: 부서명(depart, 문자열)
 * 생성자: 파라미터 생성자 - 사원명, 연봉, 부서명을 전달받아 초기화
 * 메서드: getEmployee() 메서드 오버라이딩
 * 		 사원명, 연봉, 부서명을 문자열로 결합하여 리턴
 * */
class Manager extends Employee {
	
	String depart;

	public Manager(String name, int salary, String depart) {
		super(name, salary);
		this.depart = depart;
	}

	@Override
	public String getEmployee() {
		return super.getEmployee() + ", " + depart;
	}
}

/*
 * Engineer 클래스 정의 - Employee 클래스 상속
 * 멤버변수: 기술명(skill, 문자열)
 * 생성자: 파라미터 생성자 - 사원명, 연봉, 기술명을 전달받아 초기화
 * 메서드: getEmployee() 메서드 오버라이딩
 * 		 사원명, 연봉, 기술명을 문자열로 결합하여 리턴
 * */
class Engineer extends Employee {
	
	String skill;

	public Engineer(String name, int salary, String skill) {
		super(name, salary);
		this.skill = skill;
	}

	@Override
	public String getEmployee() {
		return super.getEmployee() + ", " + skill;
	}
}











