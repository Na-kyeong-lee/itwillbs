
/*
 * 은행계좌(Account) 클래스 정의
 * - 멤버변수
 * 		1) 계좌번호(accountNo, "xxx-xxxx-xxx" = 문자열)
 * 		2) 예금주명(ownerName, "xxx" = 문자열)
 * 		3) 현재잔고(balance, XXXX = 정수)
 * - 메서드
 * 		1) showAccountInfo(): 계좌정보를 출력 (매개변수 X, 리턴 X)
 * 			계좌번호 : 111-1111-111
 * 			예금주명 : 홍길동
 * 			현재잔고 : 100000원
 * 		2) deposit() : 입금기능 (매개변수: 입금금액(정수, amount), 리턴 X)
 * 			- 입금할 금액(amount)을 전달받아 현재잔고(balance)에 누적
 * 			- 다음과 같이 출력
 * 				입금금액 : XXXX원
 * 				현재잔고 : XXXX원
 * 		3) withdraw() : 출금 기능 (매개변수: 출금할 금액(정수, amount), 리턴값: 출금된 금액)
 * 			- 출금할 금액(amount)을 전달받아 다음 조건에 따라 출금 수행
 * 				a. 출금할 금액보다 현재잔고가 작을 경우 (출금이 불가능할 경우)
 * 					출력) 출금할 금액 : XXX원
 * 						 잔액이 부족하여 출금 불가! (현재잔고: XXX원)
 * 				b. 출금할 금액보다 현재잔고가 크거나 같을 경우 (출금이 가능할 경우)
 * 					출력) 출금할 금액 : XXX원
 * 						 현재잔고 : XXXX원 -> 출금하고 남은 금액만큼 출력
 * 					출금할 금액만큼 리턴
 * */
class Account {
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
//			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("잔액이 부족하여 출금 불가! (현재잔고: " + balance + "원)");
			amount = 0;
//			return 0;
		} else { // 출금 O
			balance -= amount;
//			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("현재잔고 : " + balance + "원");
//			return amount;
		}
		
		return amount;
	}
	
	// transfer 계좌이체 (매개변수: 계좌정보, 이체할금액)
	public void transfer(Account other, int amount) {
		balance -= amount;
		other.balance += amount;
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		Account acc = new Account();
		acc.accountNo = "111-1111-111";
		acc.ownerName = "홍길동";
		acc.balance = 100000;
		
		acc.showAccountInfo();
		System.out.println("-------------------------");
		acc.deposit(50000);
		
		System.out.println("-------------------------");
		int money = acc.withdraw(100000); // 출금 O
		System.out.println(money);
		
		System.out.println("--------------");
		
		int money2 = acc.withdraw(100000); // 출금 X
		System.out.println(money2);

		System.out.println("======================================");
		Account acc2 = new Account();
		acc2.accountNo = "222-2222-222";
		acc2.ownerName = "차동원";
		acc2.balance = 999900000;
		
		acc2.showAccountInfo();
		
		acc.transfer(acc2, 10000); // 홍길동이 나한테 10000원 이체
		System.out.println("-------");
		acc2.showAccountInfo();
		System.out.println("-------");
		acc.showAccountInfo();
		
//		Account acc1 = new Account();
//		Account acc2 = new Account();
//		Account acc3 = new Account();
//		Account acc4 = new Account();
//		Account acc5 = new Account();
		acc.showAccountInfo();
		acc2.showAccountInfo();

//		int[] 	  arr      = new int[2];
//      String[]  str      = new String[3];
//		Account[] accounts = new Account[2];
		
//		int[] arr = {10, 20};
//		String[]  str = {new String(), new String()}
//		Account[] accs = {new Account(), new Account()};
		
		int a = 10;
		int b = 20;
		int[] arr = {a, b};
		Account[] accs = {acc, acc2};
		System.out.println("=============================");
		for(Account account : accs) {
			account.showAccountInfo();
			System.out.println("-----------------");
		}
		
	}

}
