
public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 돈이 10000원 있고 사과 한 개에 1000원이라고 할 때
		 * 1. 최대 구매 가능 갯수
		 * 2. 사과 3개의 가격
		 * 3. 사과 5개를 사고 남는 금액
		 * 4. 사고 5개를 사고 쌓이는 적립금 (구매금액의 1% 라고 가정)
		 * 
		 *///하드코딩
		System.out.println(10000 / 1000);
		System.out.println(1000 * 3);
		System.out.println(10000 - (1000*5));
		System.out.println(1000 * 5 * 0.01);
		
		
		//변수의 필요성(데이터 값만 바꿔주면됨)
		int money = 10000;
		int apple = 1000;
		
		System.out.println(money / apple);
		System.out.println(apple * 3);
		System.out.println(money - (apple * 5));
		System.out.println(apple * 5 * 0.01);
		/*
		 * 
		 */
	}

}
