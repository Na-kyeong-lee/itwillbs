package ex05_09;

public class Ex8 {

	public static void main(String[] args) {
		// 278p
		
		// Q1) 정답: extends
		// 자바에서 어떤 클래스의 기능을 확장하여 새로운 클래스를 만들기 위해 상속을 합니다.
		// 이때, 사용하는 예약어는 XXX 입니다.
		
		// Q2) 정답: super
		// 하위 클래스가 상위 클래스의 생성자를 호출하거나 상위 클래스의 멤버변수,
		// 메서드를 호출하기 위해 사용하는 예약어로 상위 클래스의 주소, 
		// 즉, 참조값을 나타내는 예약어는 XXX 입니다.
		
		// Q3) 정답: 메서드 오버라이딩 (method override) 
		// 클래스를 상속받은 상태에서 상위 클래스에 이미 정의되어 있는 메서드를 하위 클래스에서
		// 사용하기에 적절하지 않은 경우에 해당 메서드를 재정의할 수 있습니다.
		// 이것을 XXX 이라고 합니다.
		
		
		
		
		
	}
}
// Q4) 정답: 상위클래스(Employee)에 디폴트 생성자 없으므로
//			하위클래스(Engineer)에서 생성자를 정의하고 super()를 사용하여
//          상위클래스의 생성자를 명시적으로 호출해야함.

class Employee {
	public String name;
	public String grade;
	
//	public Employee() {}
	public Employee(String name){
		this.name = name;
	}
}
class Engineer extends Employee {
  	private String skillset;
  	
  	public Engineer() {
  		super("홍길동");
	}
  	
  	public String getSkillset(){
  		return skillset;
  	}
  
  	public void setSkillset(String skillset){
  		this.skillset = skillset;
  	}
}

/*
 * 
 * class Employee {
 * 		public String name;
 * 		public String grade;
 * 		public Employee(String name){
 * 			this.name = name;
 * 		}
 * }
 * 
 * class Engineer extends Employee {
 * 		private String skillset;
 * 		public String getSkillset(){
 * 			return skillset;
 * 		}
 * 
 * 		public void setSkillset(String skillset){
 * 			this.skillset = skillset;
 * 		}
 * }
 * 
 * 
 * */














