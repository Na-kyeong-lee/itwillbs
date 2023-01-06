/*
 * 클래스 정의
 * - 객체를 나타내는 설계도!
 * - 표현하려는 대상 객체의 이름을 지정하여 클래스를 정의
 * - 클래스 내의 멤버변수는 인스턴스 생성 시 각 인스턴스마다 별도의 공간을 할당 받음
 *   => 이때, 각 멤버변수는 자동으로 기본값으로 초기화가 수행됨
 * - 클래스 내의 메서드는 인스턴스 생성 후 호출을 통해 작업을 수행하게 됨  
 * - 클래스 정의 후에는 반드시 인스턴스화를 (new) 통해 메모리상에 실제 객체를 생성해야함!
 * 
 * < 기본 문법 >
 * [접근제한자] class 클래스명 {
 * 		// 멤버변수 (= 객체의 정보를 저장할 변수 = 속성 = 필드)
 * 		// 생성자 (= 객체의 정보를 초기화하는 역할)
 * 		// 메서드 (= 객체의 수행할 동작 = 기능)
 * }
 * 
 * 예) 사람(Person) 클래스 정의
 * 1. 분석 단계 (객체 모델링)
 *  - 속성: 이름, 나이, 성별, 주민번호 등
 *  - 기능: 걷다, 앉다, 웃다, 말하다, 먹다 등
 * 
 * 2. 설계 단계 (클래스 정의)
 *  - 클래스명: 사람 = Person
 *  - 멤버변수(속성): 이름(name, 문자열 = String), 나이(age, 정수 = int) 등
 *  - 메서드(기능)
 *  	1) 먹다() = eat() : 파라미터없음, 리턴값없음
 * 		2) 말하다() = talk() : 파라미터없음, 리턴값없음
 * 
 * */

public class Person {
	String name;	// 이름
	int age;		// 나이
	
	public void eat() {
		System.out.println("먹다");
	}
	
	public void talk() {
		System.out.println("말하다!");
	}
}




