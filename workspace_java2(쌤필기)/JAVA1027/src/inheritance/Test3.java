package inheritance;

public class Test3 {

	public static void main(String[] args) {
		ItwillBank2 ib = new ItwillBank2();
		ib.deposit(50000);
		System.out.println("출금된 금액: " + ib.withdraw(50000));
		System.out.println("------------------------");
		// ItwillBank2 클래스에서 오버라이딩 된 withdraw() 메서드가 호출되므로
		// 잔고가 부족하더라도 무조건 출금이 수행됨
		System.out.println("출금된 금액: " + ib.withdraw(50000));
		System.out.println("========================");
		
		Account2 acc = new Account2();
		acc.deposit(50000);
		System.out.println("출금된 금액: " + acc.withdraw(100000));
		
	}

}
/*
 * ItwillBank2 클래스 정의 - Account2 클래스 상속
 * - 출금 기능(withdraw()) 메서드 오버라이딩 수행
 *   => 잔고가 부족하더라도 무조건 출금하도록 구현
 *      은행 잔고에 관계없이 무조건 출금 수행 (마이너스 통장)
 * */
class ItwillBank2 extends Account2 {

	@Override
	public int withdraw(int amount) {
		balance -= amount;
		System.out.println("출금할 금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
		return amount;
	}
	
}



class Account2 {
	String accountNo;
	String ownerName;
	int balance;
	
	public void showAccountInfo() {
		System.out.println("계좌번호: " + accountNo);
		System.out.println("예금주명: " + ownerName);
		System.out.println("현재잔고: " + balance);
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금금액 : " + amount);
		System.out.println("현재잔고 : " + balance);
	}
	
	public int withdraw(int amount) {
		System.out.println("출금할 금액 : " + amount + "원");
		if(amount > balance) { // 출금 X
			System.out.println("잔액이 부족하여 출금 불가! (현재잔고: " + balance + "원)");
			amount = 0;
		} else { // 출금 O
			balance -= amount;
			System.out.println("현재잔고 : " + balance + "원");
		}
		return amount;
	}
}