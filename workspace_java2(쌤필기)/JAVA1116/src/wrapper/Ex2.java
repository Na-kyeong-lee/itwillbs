package wrapper;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 기본 데이터타입 Stack 공간에 실제 데이터(리터럴) 형태를 직접 저장 및 관리하지만
		 * 참조 데이터타입(객체)은 Heap 공간에 실제 데이터가 저장되며, 참조변수가
		 * 해당 공간의 주소값을 저장 및 관리함
		 * => 따라서, 기본 데이터타입 변수와 참조데이터타입 변수는 서로 호환 불가능했음
		 *    그러나, Java(JDK) 1.5 부터 오토 박싱, 오토 언박싱 기능이 제공되면서
		 *    두 데이터타입 간에 자동으로 변환이 되도록 지원됨
		 * 
		 * 1. 오토 박싱 (Auto Boxing)
		 * - 기본데이터타입(물건) -> Wrapper 클래스 타입 객체 (박스)로 자동(Auto) 변환(포장)
		 *   => Heap 공간의 객체 박스 (Wrapper클래스 타입)에 기본 데이터타입 변수(물건)를
		 *      전달하여 객체 형태로 포장하는 기능
		 *   => 컴파일러에 의해 자동으로 변환(포장)되어진다!   
		 * 
		 * 2. 오토 언박싱 (Auto Unboxing)
		 * - Wrapper 클래스타입 객체(박스)의 포장을 뜯어서 기본데이터타입(물건) 꺼내기
		 *   => Heap 공간의 객체 박스(Wrapper클래스타입)에 들어있는 물건(기본데이터타입 값)을
		 *      꺼내서 기본 데이터타입으로 변환
		 *   => 컴파일러에 의해 자동으로 변환(포장 뜯기) 되어진다!   
		 * */

		
		Integer n2 = new Integer(20);
//		Integer n2 = new Integer("20");
		
		// 주의! 정수데이터가 아닐 경우 타입 변환에 대한 오류가 발생할 수 있음!
//		Integer n2 = new Integer("20.5");
//		System.out.println(n2);
		
		System.out.println(n2);
		System.out.println(n2.toString());
		// Integer 타입 변수 n2의 값을 출력하면 주소값이 아닌 실제 데이터가 출력됨
		// => toString() 메서드가 오버라이딩 되어 있으므로 저장된 실제 값을 리턴 하도록 함
		
		System.out.println("=====================================");
		Integer n1;
		int num1 = 10;
		// 오토 박싱 (Auto Boxing)
		// Integer 타입 변수 n1에 int 타입 변수 num1 의 값(리터럴)을 저장하려고 할 경우
		// 1. 자바 초기에 사용하던 방법 (Java 1.5 이전)
//		n1 = Integer.valueOf(num1);
//		System.out.println("기본데이터타입 num1 = " + num1);
//		System.out.println("참조데이터타입 n1 = " + n1);
		
		// 2. Java (JDK) 1.5 부터 사용 가능한 방법
		n1 = num1;
		System.out.println("기본데이터타입 num1 = " + num1);
		System.out.println("참조데이터타입 n1 = " + n1);
		
		int num2 = 20;
		// 오토 언박싱(Auto Unboxing)
		// 1. 자바 초기에 사용하던 방법 (Java 1.5 이전)
//		num2 = n2.intValue();
//		System.out.println("기본데이터타입 num2 = " + num2);
//		System.out.println("참조데이터타입 n2 = " + n2);
		
		// 2. Java (JDK) 1.5 부터 사용 가능한 방법
		num2 = n2;
		System.out.println("기본데이터타입 num2 = " + num2);
		System.out.println("참조데이터타입 n2 = " + n2);
		
		System.out.println("=========================================");
		
		Integer n3 = 30; // 오토 박싱
		
		Object o = n3; // 업캐스팅
		Object o2 = 30;// 오토박싱 -> 업캐스팅
		System.out.println(o2);
		
		System.out.println("=========================================");
		
		Integer n4 = new Integer(40);
		int num4 = 40;
		System.out.println(n4 + num4); // Integer -> int 오토언박싱
		// => 즉, Integer + int = int + int 형태로 연산됨
		
		
	}

}
