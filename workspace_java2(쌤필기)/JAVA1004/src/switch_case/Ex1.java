package switch_case;

public class Ex1 {

	public static void main(String[] args) {
		
		/*
		 * switch - case 문
		 * - if문과 유사하게 조건에 따른 실행 문장을 달리하는 조건문
		 * - if문과 달리 조건식이 아니고, 소괄호() 안에 정수값(문자), 문자열, Enum 상수 중 하나의 결과가 와야함
		 * - case 문에는 조건식 판별 결과와 비교할 값을 사용하며
		 *   범위 지정이 불가능하고, 값만 사용 가능
		 *   => 조건식 결과와 일치하는 case문의 : 뒤에 있는 문장들을 차례대로 실행
		 * - case 문의 값은 중복될 수 없으며, 순서는 상관없음
		 * 
		 * - break 문은 각 case문의 영역을 구분하는 역할.
		 *   => 그러므로, 각 case문의 마지막에 break문을 빼먹는 실수를 하면 안됨!!!
		 * - case 문 실행 후 break문을 사용하여 switch ~ case 문을 빠져나갈 수 있으며
		 *   break 문이 없을 경우에는 조건과 상관없이 다른 case문 또는 default문을 모두 실행함!
		 *   (break문을 만나거나 switch ~ case 문이 끝날때 까지 실행!)
		 * 
		 * */
		
		int num = 10;
		
		switch (num) {
		case 1:
			System.out.println("num == 1");
			break;
		case 2:
			System.out.println("num == 2");
			break;
		case 3:
			System.out.println("num == 3");
			break;
		default:
			System.out.println("나머지");
			break;
		}
		
//		if(num == 1) {
//			
//		} else if (num == 2) {
//			
//		}
		
		System.out.println("---------------------------------------");
		
		String init = "C";
		
		switch (init) {
		case "U":
			System.out.println("USA");
			break;
		case "K":
			System.out.println("KOREA");
			break;
		case "C":
			System.out.println("CANADA");
			break;
		}
		
		
		
		
		
		
	}

}
