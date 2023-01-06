
/*
 * 하나의 소스파일(.java) 내에 복수개의 클래스 정의 가능
 * 단, 파일명과 동일한 클래스에만 public 접근제한자를 붙이고
 * 나머지 클래스에는 public을 붙이지 않도록 한다!
 * */

/*
 * Student 클래스 정의
 * - 멤버변수: 이름(name, 문자열), 학번(id, 문자열), 나이(age, 정수)
 * 			 국어점수(kor, 정수), 영어점수(eng, 정수), 수학점수(mat, 정수)
 * */
class Student {
	String name;
	String id;
	int age;
	int kor;
	int eng;
	int mat;
	
	// showInfo() 메서드 정의
	// 파라미터, 리턴값 없음. 다음과 같이 출력
	// 이름: XXX
	// 학번: XXX
	// 나이: XXX...
	public void showInfo() {
		// 자신의 클래스에서 선언된 멤버변수는 클래스 내의 모든 메서드에서 접근이 가능
		// => 이때, 별도의 주소 지정없이 변수명만으로 접근 가능
		System.out.println("이름: " + name);
		System.out.println("학번: " + id);
		System.out.println("나이: " + age);
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + mat);
		System.out.println("총점: " + getTotal());
		System.out.println("평균: " + getAverage());
	}
	
	// 총점 getTotal()
	public int getTotal() {
		return kor + eng + mat;
	}
	
	// 평균을 리턴하는 getAverage()
	public double getAverage() {
//		return (kor + eng + mat) / 3.0;
		
		// 합계 계산 코드를 직접 작성하지 않고, 기존의 getTotal() 메서드를 재사용
		return getTotal() / 3.0;
	}
	
}

public class Ex3 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.id = "a1234657";
		s1.age = 20;
		s1.kor = 100;
		s1.eng = 80;
		s1.mat = 50;
		
		Student s2 = new Student();
		s2.name = "변기태";
		s2.id = "b7654321";
		s2.age = 30;
		s2.kor = 50;
		s2.eng = 90;
		s2.mat = 100;
		
//		System.out.println("이름: " + s1.name);
//		System.out.println("학번: " + s1.id);

//		s1.showInfo();
//		System.out.println("s1의 총점: " + s1.getTotal());
//		System.out.println("s1의 평균: " + s1.getAverage());
//		
////		System.out.println("총점: " + 230);
//		System.out.println("------------------");
//		s2.showInfo();
//		System.out.println("s2의 총점: " + s2.getTotal());
//		System.out.println("s2의 평균: " + s2.getAverage());
		
		// 학생의 정보를 (showInfo()) 출력할때
		// 총점과 평균을 함께 출력하고 싶다면?
		s1.showInfo();
		System.out.println("---------------");
		s2.showInfo();
		
	}

}






