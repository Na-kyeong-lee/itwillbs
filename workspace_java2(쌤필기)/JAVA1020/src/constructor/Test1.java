package constructor;


class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	// 기본 생성자와 동일한 Account() 생성자 정의
	// => 생성자 내에서 멤버변수를 다음과같이 초기화
	//    계좌번호(accountNo) : "111-1111-111"
	//    예금주명(ownerName) : "홍길동"
	//    현재잔고(balance)   : 100000
	public Account() {
		accountNo = "111-1111-111";
		ownerName = "홍길동";
		balance = 100000;
	}

	// 파라미터 3개 (계좌번호, 예금주명, 현재잔고)를 전달받아 초기화하는 생성자 정의
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		Account acc = new Account();
		Account acc2 = new Account("222-2222-222", "차동원", 972636214);
		
		System.out.println("계좌번호: " + acc.accountNo);
		System.out.println("예금주명: " + acc.ownerName);
		System.out.println("현재잔고: " + acc.balance);
		System.out.println("------------------------------------");
		System.out.println("계좌번호: " + acc2.accountNo);
		System.out.println("예금주명: " + acc2.ownerName);
		System.out.println("현재잔고: " + acc2.balance);
		
		System.out.println("------------------------------------");
		Account acc3 = new Account();
		System.out.println("계좌번호: " + acc3.accountNo);
		System.out.println("예금주명: " + acc3.ownerName);
		System.out.println("현재잔고: " + acc3.balance);
		
		System.out.println(acc == acc3);
		
	}

}
