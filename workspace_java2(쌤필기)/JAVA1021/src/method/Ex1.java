package method;

class Student {
	// 멤버변수: 이름(name, 문자열), 나이(age, 정수), 점수(score, 정수)
	// => 모든 멤버변수는 private 접근제한자를 사용하여 선언
	private String name;
	private int age;
	private int score;
	
	// 멤버변수 name의 값을 외부로 리턴하는 Getter 메서드 정의
	// => 파라미터 X, 리턴타입: String(이름(name) 리턴)
	public String getName() {
		return name;
	}
	
	// 이름(name)을 외부로부터 전달받아 내부 멤버변수 name에 저장하는 Setter 메서드 정의
	// => 파라미터: 이름(String타입, name), 리턴타입 X
	public void setName(String name) {
		this.name = name;
	}
	
	// age 에 대한 Getter 메서드
	public int getAge() {
		return age;
	}
	
	// age 에 대한 Setter 메서드
	public void setAge(int age) {
		this.age = age;
	}
	
	// Getter / Setter 자동 생성 단축키 : Alt + Shift + S -> R
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}

public class Ex1 {

	public static void main(String[] args) {
		Student s = new Student();
		s.setName("홍길동");
		s.setAge(20);
		s.setScore(90);
		
		System.out.println("이름: " + s.getName());
		System.out.println("나이: " + s.getAge());
		System.out.println("점수: " + s.getScore());
		
	}

}
