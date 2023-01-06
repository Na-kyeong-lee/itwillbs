package array;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 배열(Array)
		 * - 같은 타입 데이터 여러개를 하나의 변수명을 사용하여 연속된 공간으로 다루는 것
		 * 1. 같은 데이터타입만 하나의 배열로 저장 가능
		 * 2. 기본 데이터타입과 참조 데이터타입 모두 배열로 저장 가능
		 * 3. 배열명(변수명)을 사용하여 여러 데이터 관리 가능
		 * 4. 배열 내에 자동으로 부여되는 번호(인덱스 index)를 사용하여 배열의 각 요소 접근 가능
		 *    (인덱스 번호는 0부터 시작하여 배열크기-1 번까지 자동으로 부여됨)
		 * 5. 배열 크기는 배열명.length 속성을 통해 얻을 수 있음
		 * 6. *한번 생성된 배열의 크기 변경이 불가능
		 * 
		 * String[] class1 = new String[3];
		 * < 배열 선언 기본 문법 >
		 * 데이터타입[] 변수명; // 데이터타입에 해당하는 배열 타입으로 변수를 선언
		 * => 스택(Stack) 영역에 배열 공간의 주소를 저장할 참조변수만 생성됨
		 * => 단, 아직 데이터를 저장할 수 있는 공간은 생성되기 전이므로 데이터 저장 불가!
		 * 
		 * < 배열 생성 기본 문법 >
		 * 변수명 = new 데이터타입[배열크기];
		 * => new 연산자에 의해 Heap 영역에 배열크기만큼의 배열공간이 생성되고
		 *    해당 배열에 저장되는 데이터타입은 지정된 데이터타입이 사용되며
		 *    생성된 배열공간의 주소값을 좌변의 변수에 저장
		 * 
		 * => 배열을 생성하고 나면 자동으로 해당 배열의 공간은
		 *    지정된 데이터타입의 기본값으로 자동으로 초기화를 수행!
		 *    (ex. int형 = 0, double형 = 0.0, String형 = null 등)
		 *    
		 * => 또한 생성된 공간은 각각 0부터 배열크기-1 까지 인덱스 자동으로 부여됨
		 * 
		 * < 배열 접근 기본 문법 >
		 * 변수명[인덱스]
		 * => 해당 변수가 가리키는 배열공간의 지정된 인덱스 번호에 해당하는 요소에 접근
		 * => 변수명은 배열이름(= 아파트이름)이고, 인덱스는 배열요소 위치(아파트 호수)
		 * */
		
		// 배열 선언: 데이터타입[] 변수명 (or 데이터타입 변수명[])
		int[] score;
//		int score2[]; // 옛날문법!!
		// 스택(Stack) 공간에 배열 주소를 저장할 참조데이터타입 변수 score가 생성됨
		// => 이때, int형의 의미는 해당 배열에 저장될 데이터타입이 정수(int)라는 의미
//		score = 10;
		
		// 배열 생성: 변수명 = new 데이터타입[배열크기]
		score = new int[5]; // 정수 데이터 5개 저장 공간이 생성되고 주소값을 score에 저장
		
		System.out.println(score); // Heap에 생성된 배열의 주소가 출력됨!
		System.out.println(score.length);
		System.out.println("0번 인덱스 요소: " + score[0]);
		System.out.println("1번 인덱스 요소: " + score[1]);
		System.out.println("2번 인덱스 요소: " + score[2]);
		System.out.println("3번 인덱스 요소: " + score[3]);
		System.out.println("4번 인덱스 요소: " + score[4]);
		
		// 5개 크기를 갖는 배열의 인덱스 0 ~ 4까지 존재함
		// 이때, 4보다 큰 인덱스를 사용할 경우 아래와 같이 오류 발생!
//		System.out.println("5번 인덱스 요소: " + score[5]);
		
		// 배열 초기화: 변수명[인덱스] = 데이터;
//		int score1 = 80, score2 = 100, score3 = 50;
		
		score[0] = 80;
		score[1] = 100;
		score[2] = 50;
		score[3] = 90;
		score[4] = 77;
//		score[5] = 60;
		System.out.println("0번 인덱스 요소: " + score[0]);
		System.out.println("1번 인덱스 요소: " + score[1]);
		System.out.println("2번 인덱스 요소: " + score[2]);
		System.out.println("3번 인덱스 요소: " + score[3]);
		System.out.println("4번 인덱스 요소: " + score[4]);
		System.out.println("--------------------------------");
		
		// 반복문을 사용한 배열의 모든 인덱스에 접근
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "번 인덱스 요소: " + score[i]);
		}
		
		// 위의 반복문 처럼 사용해도 되지만 배열 크기가 변하면 코드도 변경되어야함!
		// 따라서, 배열의 크기를 동적으로 대응할 수 있도록 작성할 필요가있음
		// 즉, 조건식 부분에 배열크기를 직접 입력하지 않고 배열명.length를 지정!
		for(int i = 0; i < score.length; i++) {
			System.out.println(i + "번 인덱스 요소: " + score[i]);
		}
		System.out.println("-----------------------------------");
		
		// 배열 선언 및 생성을 동시에 수행
//		int[] arr;
//		arr = new int[10];
		// 위 두문장을 한문장으로 결합
		int[] arr = new int[10];
		arr[0] = 10;
		System.out.println(arr[0]);
		
		// 배열 선언, 생성, 초기화를 동시에 수행
		// 데이터타입[] 변수명 = {데이터1, 데이터2, ... 데이터n}
		int[] arr2 = {10, 20, 30};
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		
		int[] arr3;
//		arr3 = {10, 20, 30}; // {}는 한줄로 표현할때 사용!!!
//		arr3 = new int[3] {10, 20, 30};
		// 배열 생성 문법과 한꺼번에 초기화하는 문법을 결합하여 사용할때
		// 배열 크기는 데이터의 갯수로 자동 지정되므로 배열 크기 지정을 생략해야함!!
		arr3 = new int[] {10, 20 , 30};
		
		
		
		
		
	}

}
