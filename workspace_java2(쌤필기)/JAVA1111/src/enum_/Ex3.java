package enum_;

import java.util.Scanner;

enum PayType {
	ACCOUNT_TRANSFER("계좌이체"),
	REMITTANCE("무통장입금"),
	ON_SITE_PAYMENT("현장결재"),
	TOSS("토스"),
	PAYCO("페이코"),
	CARD("신용카드"),
	KAKAO_PAY("카카오페이"),
	BEMIN_PAY("배민페이"),
	POINT("포인트"),
	COUPON("쿠폰");
	
	String title;
	private PayType(String title) {
		this.title = title;
	}
}

enum PayGroup {
	CASH("현금", new PayType[] { PayType.ACCOUNT_TRANSFER
							  , PayType.REMITTANCE
							  , PayType.ON_SITE_PAYMENT
							  , PayType.TOSS }), 
	CARD("카드", new PayType[] { PayType.PAYCO
							  , PayType.CARD
							  , PayType.KAKAO_PAY
							  , PayType.BEMIN_PAY }), 
	ETC("기타", new PayType[] { PayType.POINT, PayType.COUPON }), 
	EMPTY("없음", new PayType[] {});
	
	private String title;
	private PayType[] payTypes;
	
	private PayGroup(String title, PayType[] payTypes) {
		this.title = title;
		this.payTypes = payTypes;
	}
	
	public String getTitle() {
		return title;
	}
	
	// 문자열을 전달받아 해당 문자열이 어떤 PayGroup에 속하는 판별후
	// 해당 Enum을 리턴하는 findByPayType 메서드
	public static PayGroup findByPayType(String data) {
//		PayGroup[] payGroups = PayGroup.values(); // CASH, CARD, ETC, EMPTY
		for(PayGroup pg : PayGroup.values()) { // CASH, CARD, ETC, EMPTY
			
			for(PayType p : pg.payTypes) { // ACCOUNT_TRANSFER, ...
				if(p.title.equals(data)) {
					return pg;
				}
			}
		}
		return EMPTY;
	}
	
}

public class Ex3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		
		// 입력받은 data가 어떤 결재 로직으로 이동하면 될지 판단 
		// => 어떤 PayGroup에 속하는지 판별
		PayGroup pg = PayGroup.findByPayType(data);
		
		switch (pg) {
		case CASH: System.out.println("현금 결재 로직으로 이동"); break;
		case CARD: System.out.println("카드 결재 로직으로 이동"); break;
		case ETC: System.out.println("기타 결재 로직으로 이동"); break;
		case EMPTY: 
			System.out.println("존재하지 않는 결재 코드 입니다.");
			System.out.println("예외 처리 로직으로 이동");
			break;
		}
		
	}

}
