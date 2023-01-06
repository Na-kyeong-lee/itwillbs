package method;

public class Test1 {

	public static void hello() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Hellow, World!");
		}
	}
	
	public static void hello2(String msg, int count) {
		for(int i = 0; i < count; i++) {
			System.out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		// 1. 매개변수 X, 리턴값 X
		// "Hellow, World!" 라는 문자열을 10번 반복 출력하는 hello() 메서드 호출
		hello();
		System.out.println("--------------");
		// 2. 매개변수 O, 리턴값 X
		// "안녕하세요"와 반복횟수를 전달하여 전달한 만큼 반복 출력하는 hello2() 메서드 작성
		hello2("안녕안한데", 3);
		System.out.println("----------------");
		
		// 3. 매개변수 X, 리턴값 O
		// 1 ~ 10 까지 정수의 합(55)을 계산하여 리턴하는 메서드 sum() 호출 후 결과 출력
//		int result = sum();
//		int result = 100;
//		System.out.println(result);
//		System.out.println(sum());
//		System.out.println(100);
		
		// 4. 위 sum()을 수정하여 1부터 전달받은 매개변수 까지의 합을 리턴하는 메서드로 수정
		System.out.println("1 ~ 500까지의 합: " + sum(500));
		System.out.println("------------------------------");
		// 5. 정수 3개를 전달하여 전달받은 정수 3개가 저장된 배열을 리턴하는 메서드
		//    getArray()를 호출하여 리턴되는 배열을 전달받아 배열 내의 모든 요소 출력
		int[] arr = getArray(10, 20, 30);
//		for(int i=0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		printArray(arr);
		System.out.println();
		
		// 6. 정수 start, end 값을 매개변수로 전달받아 start 부터 end까지의
		//    배열을 리턴하는 메서드 getArray2() 호출 후 출력 (데이터 start ~ end)
		int[] arr2 = getArray2(5, 19);
//		for(int i=0; i < arr2.length; i++) {
//			System.out.print(arr2[i] + " ");
//		}
		printArray(arr2);
	}
	
	public static void printArray(int[] arr) {
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int[] getArray2(int start, int end) {
		int size = end - start + 1;
		int[] arr = new int[size];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = start;
			start++;
		}
		return arr;
	}
	
	
	public static int[] getArray(int a, int b, int c) {
		int[] arr = {a, b, c};
		return arr;
	}
	
	
	public static int sum(int limit) {
		int sum = 0;
		for(int i = 1; i <= limit; i++) {
			sum += i;
		}
		return sum;
	}
	
	
	
	
}
