package enum_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * enum 객체의 메서드
		 * - enum 타입들은 모두 java.lang.Enum 클래스를 암묵적으로 상속받음
		 *   => 따라서, Enum 클래스에 정의된 메서드 활용 가능
		 * */
		Ex1 ex1 = new Ex1();
		ex1.compareEnum(Season.WINTER);
	}
	
	public void compareEnum(Season season) {
//		System.out.println(season.compareTo(Season.SPRING));
		//=> season 객체의 ordinal 값 - 파라미터로 전달된 상수의 ordinal 값
		
		// name() 메서드 : 상수명 리턴
		// ordinal() 메서드 : 상수의 ordinal 값 리턴
		System.out.println(season.name() + " : " + season.ordinal());
	}

}

// enum 타입 Season 정의
// => 상수: SPRING, SUMMER, FALL, WINTER
enum Season {
	// enum 타입 내의 상수는 자동으로 ordinal 값(순서번호)이 부여됨 (0부터 자동 부여)
	SPRING,	// 0 
	SUMMER, // 1
	FALL, 	// 2
	WINTER	// 3
}


