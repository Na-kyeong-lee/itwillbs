package constructor;


class Account {
	String accountNo;	
	String ownerName;
	int balance;
	
	// < this 자동완성 단축키 >
	// 단축키 Alt + Shift + S 누르고 뗀 담에 O!!!!!
	
		// 1. 기본생성자
		public Account() {
			this("111-1111-111");	// 밑에서 홍길동, 100000을 불러오니까 생략
		}
		
		//2. 계좌번호 전달받는 생성자
		public Account(String accountNo) {	
			this(accountNo, "홍길동");		// 밑에서 불러올 것이 있으니까 100000을 생략할 수 있음
		}
		
		// 3. 계좌번호, 예금주명 전달받는 생성자
		public Account(String accountNo, String ownerName) {
			this(accountNo, ownerName, 100000);
		}
		
		// 4. 계좌번호, 예금주명, 현재잔고 전달받는 생성자		// 얘는 있어야지 3번이 this()를 사용할 수 있으니까 생략불가!!
		public Account(String accountNo, String ownerName, int balance) {
			this.accountNo = accountNo;
			this.ownerName = ownerName;
			this.balance = balance;
		}
		
		// 계좌정보 출력하는 메서드
		public void showAccountInfo() {
			System.out.println("계좌번호 : " + accountNo);
			System.out.println("예금주명 : " + ownerName);
			System.out.println("현재잔고 : " + balance);
		}
		
		
}
public class Test2 {

	public static void main(String[] args) {
		
		Account acc = new Account();
		acc.showAccountInfo();
		System.out.println("--------------------");
		
		// 계좌번호 하나만 전달받는 것
		Account acc2 = new Account("333-3333-333");
		acc.showAccountInfo();
		System.out.println("--------------------");
		
		
		Account acc3 = new Account("555-5555-555", "이순신");
		acc2.showAccountInfo();
		System.out.println("--------------------");
		
		Account acc4 = new Account("777-7777-777", "차동원", 1234567);
		acc3.showAccountInfo();
		
		
	}

}
