package randomize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex1 {

	public static void main(String[] args) {
		//인증번호 보내기
		//난수를 활용하여 특정 범위의 값을 발생시키기 - SMS 인증번호 생성
		//=> Random 객체의 nextInt() 메서드를 사용하여
		//	 특정범위에 해당하는 정수형 난수를 발생시키기
		Random r = new Random();
		// ex) 4자리 인증번호(0000 ~ 9999) 생성
//		for(int i = 0; i < 10; i++) {
//			int rNum = r.nextInt(10000); // 0 ~ 9999 사이의 난수 발생
//			System.out.println(rNum);
			
			// 4자리보다 적은 자릿수를 갖는 정수를 4자리로 만드는 방법
			// (부족한 앞자리 숫자를 0으로 채우기 = 0으로 패딩 / *패딩= LPAD에서 PAD / LPAD: 왼쪽부터 채우는거(RPAD)
			// => String 클래스의 format() 메서드를 활용
			// => format() 메서드 첫번째 파라미터로 형식지정 패턴 문자열 지정
			//	  %d가 10진수이며, %4d는 10진수 4자리로 표기
			//	  %04d는 10진수 4자리로 표기할 때 부족한 앞자리는 0으로 채움(ex. 545 -> 0545)
//			String strNum = String.format("%04d", rNum); //%04d: 0이 4개라는 의미 / rNum이 int형이여야함
//			System.out.println(strNum);
//		}
		
		// ex) 6자리 인증번호 (000000 ~ 999999) 생성
		for(int i = 0; i < 10; i++) {
			int rNum = r.nextInt(1000000); // 0 ~ 999999 사이의 난수 생성
			
			String strNum2 = String.format("%06d", rNum);
			System.out.println(strNum2);
		}
		
		//-------------------------------------------------------------------------------
		// 난수를 활용하여 특정 범위의 값을 발생시키기 - E_mail 인증코드 생성
		// 1. 인증코드에 사용될 문자를 배열로 모두 저장하기
		//	  'A' ~ 'Z', 'a' ~ 'z', '0' ~ '9', '!@#$'
//		char[] codeTable = {
//			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'
			// ..
//		};
		
		List<Character> codeTable = new ArrayList<Character>();
		
//		Character.MIN_VALUE;
//		Character.MAX_VALUE;
//		Character.isUpperCase(0);
//		Character.isLowerCase(0);
//		Character.isDigit(0);
		
		//대문자
		char ch = 'A' - 1;
		for(int i = 0; i < 26; i++) { //i는 반복횟수로만 쓰일 것임
			codeTable.add(ch += 1); 
		}
		
		//소문자
		ch = 'a' - 1;
		for(int i = 0; i < 26; i++) { //i는 반복횟수로만 쓰일 것임
			codeTable.add(ch += 1); 
		}
		
		//숫자
		ch = '0' - 1;
		for(int i = 0; i < 10; i++) { //i는 반복횟수로만 쓰일 것임
			codeTable.add(ch += 1); 
		}
		
		//특수문자
		codeTable.add('!');
		codeTable.add('@');
		codeTable.add('#');
		codeTable.add('$');
		
		System.out.println(codeTable);
		//변수 잘 담고 있는지 확인하려면 toString 오버라이딩 하기(DTO)
		
		
		
		// 숫자와 특수문자 섞어서 인증문자 생성하기
		String code = ""; //최종적으로 E-Mail 인증코드를 보낼 변수
		int codeLength = 20;
		
		//원하는 코드 길이만큼 for문을 사용하여 반복문 처리
		for(int i = 0; i < codeLength; i++) {
			//배열크기를 난수의 범위로 지정하여 난수 생성
			int index = r.nextInt(codeTable.size());
			code += codeTable.get(index);
		}
		
		System.out.println("인증코드 : " + code);
		
		
		
		
		
	}

}
