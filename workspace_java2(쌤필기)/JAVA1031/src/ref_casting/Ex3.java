package ref_casting;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 동적 바인딩
		 * 
		 * */
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
 * Managere 클래스 정의 - Employee 클래스 상속
 * 멤버변수: 부서명(depart, 문자열)
 * 생성자: 파라미터 생성자 - 사원명, 연봉, 부서명을 전달받아 초기화
 * 메서드: getEmployee() 메서드 오버라이딩
 * 		 사원명, 연봉, 부서명을 문자열로 결합하여 리턴
 * */

/*
 * Engineer 클래스 정의 - Employee 클래스 상속
 * 멤버변수: 기술명(skill, 문자열)
 * 생성자: 파라미터 생성자 - 사원명, 연봉, 기술명을 전달받아 초기화
 * 메서드: getEmployee() 메서드 오버라이딩
 * 		 사원명, 연봉, 기술명을 문자열로 결합하여 리턴
 * 
 * */












