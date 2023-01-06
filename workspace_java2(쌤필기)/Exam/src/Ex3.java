
/*
 * 클래스 작성 문제
 * 
 * 클래스 이름: Student
 * 멤버변수: 이름(문자열, name), 성적(정수, score)
 * 메서드: 이름(name)과 성적(score)를 출력하는 
 * 	     print() 메서드 정의 (파라미터 X, 리턴 X)
 * */
class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public void print() {
		System.out.println("이름: " + this.name);
		System.out.println("성적: " + score);
	} 
}



public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 객체 생성 후 사용
		 * 
		 * Student 클래스의 객체를 생성해서
		 * 홍길동, 90으로 초기화 후 출력
		 * */
//		Student student = new Student();
//		student.name = "홍길동";
//		student.score = 90;
		
		Student student = new Student("홍길동", 90);
		student.print();
		
		/*
		 * 객체지향언어 특징 (APIE)
		 * 1. 슈퍼클래스 멤버를 서브클래스에서 사용할 수 있도록 물려받는것 
		 * 	  (상속성, Inheritance)
		 * 2. 객체의 구조를 외부에 숨기고, 메세지만으로 객체와 상호작용 하게 하는것
		 * 	  (캡슐화, Encapsulation)
		 * 3. 상속 관계에서 슈퍼클래스 타입으로 서브클래스의 인스턴스를 참조할 수 있는 것
		 * 	  (다형성, Polymorphism) 업캐스팅 X
		 * 4. 공통점을 추출하여 상위 개념을 만들고 상세내역을 없애 나가는 과정
		 *    (추상화, Abstraction)
		 * */
		
		/*
		 * 접근제한자 접근 범위가 넓은 것 부터 좁은것 순으로 나열하시오.
		 * public protected default private 
		 * 
		 * */
		
		/*
		 * 클래스 간에 레퍼런스 형변환을 할때, 인스턴스가 어떤 클래스의 하위 타입인지
		 * 판별하기 위해 사용하는 연산자는 무엇인가
		 * 
		 * instanceof
		 * 
		 * */
		
		/*
		 * Random 클래스를 활용하여 1 ~ 10 사이의 난수를 발생시키는 코드를 작성
		 * Random r = new Random();
		 * r.nextInt(10) + 1;
		 * 
		 * new Random().nextInt(10) + 1
		 * */
		
		/*
		 * final
		 * 
		 * 1. 변수	: 값을 변경할 수 없다. (상수) 
		 * 2. 클래스	: 상속 불가능
		 * 3. 메서드	: 재정의 즉, 오버라이딩을 할 수 없다.
		 * 
		 * */
		
	}

}
