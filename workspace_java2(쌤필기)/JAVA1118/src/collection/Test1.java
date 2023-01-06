package collection;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * Set 계열 컬렉션 객체를 사용하여 로또 번호 생성 프로그램 작성
		 * 1) 1 ~ 45 사이의 중복되지 않는 숫자 6개를 Set 객체(myLotto)에 저장 후 출력
		 *    => 이때, 저장되는 숫자는 오름차순 정렬 수행
		 *    ex) 나의 로또 번호: [1, 10, 30, 35, 40, 44]
		 * 2) 1등 당첨 번호를 저장하는 Set 객체 (thisWeekLotto) 생성
		 * 	  => 저장할 번호 : 7, 3, 21, 12, 40, 33
		 *    => 이때, 저장되는 숫자는 오름차순 정렬 수행
		 *    ex) 1등 당첨 번호 : [3, 7, 12, 21, 33, 40]
		 * 3) 자신의 로또 번호와 1등 당첨 번호를 비교하여 일치하는 번호 갯수 출력하고
		 *    일치하는 번호 갯수에 따른 결과 출력
		 *    ex) 일치 갯수 0개(꽝)
		 *    	  일치 갯수 1개(꽝)
		 *    	  일치 갯수 2개(꽝)
		 *        일치 갯수 3개(4등)
		 *        일치 갯수 4개(3등)
		 *        일치 갯수 5개(2등)
		 *        일치 갯수 6개(1등)
		 * */
		Random r = new Random();
		
		int winCount = 0;
		while(true) {
			
			Set myLotto = new TreeSet();
			
			// 중복된 데이터는 저장되지 않으므로 반복횟수를 알 수 없음
//			for(int i = 0; i < 6; i++) {
//				myLotto.add(r.nextInt(45) + 1);
//			}
			
			while(myLotto.size() < 6) {
				myLotto.add(r.nextInt(45) + 1);
			}
			
			System.out.println("나의 로또 번호: "+ myLotto);
			
			// 1등 당첨번호를 저장하는 Set 객체 (thisWeekLotto) 생성
			// => 저장할 번호 : 7, 3, 21, 12, 40, 33
			Set thisWeekLotto = new TreeSet();
			thisWeekLotto.add(7);
			thisWeekLotto.add(3);
			thisWeekLotto.add(21);
			thisWeekLotto.add(12);
			thisWeekLotto.add(40);
			thisWeekLotto.add(33);
			
			System.out.println("1등 당첨 번호 : " + thisWeekLotto);
			
			// 일치 갯수 확인
			
			int count = 0;
			for(Object o : myLotto) {
				if(thisWeekLotto.contains(o)) { // 1등 당첨 로또에 내 번호가 있으면
					count++;
				}
			}
			
//			System.out.println(count);
			
			String result = "꽝";
			switch (count) {
			case 6: result = "1등"; break;
			case 5: result = "2등"; break;
			case 4: result = "3등"; break;
			case 3: result = "4등"; break;
//			default: result = "꽝";
			}
			
			System.out.println("일치 갯수 " + count + "개(" + result + ")");
			
			winCount++;
			
			if(count == 6) break;
			
			System.out.println("-------------------------------------");
		}
		
		System.out.println("1등 당첨까지 걸린 횟수 : " + winCount); // 8875584...
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
