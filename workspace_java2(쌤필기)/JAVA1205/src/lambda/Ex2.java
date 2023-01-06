package lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 5. Predicate 계열
		 * - Function, Operator 와 같이 파라미터와 리턴을 갖는다.
		 * - 리턴타입 boolean 으로 고정되어있다.
		 * - 매개변수로 전달받은 데이터를 "어떠한 판단" 후 true/false 리턴
		 * */
		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.contains("Java");
			}
		};
		System.out.println(predicate.test("Javascript")); 
//		Predicate<String> predicate2 = (String t) -> { return t.contains("Java"); };
		Predicate<String> predicate2 = t -> t.contains("Java");
		System.out.println(predicate2.test("javascript"));
		System.out.println("----------------------------------------------");
		
		PredicateTest pt = new PredicateTest();
		pt.printSome(n -> n % 3 == 0);
		pt.printSome(n -> n > 5);
	}

}

class PredicateTest {
	int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	public void printSome(IntPredicate pred) {
		
		for(int num : nums) {
			if(pred.test(num)) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
		
	}
	
}









