package method;

/*
 * 은행계좌 클래스 정의
 * - 멤버변수(단, 모든 멤버변수는 private 접근제한자로 선언)
 * 
 */
class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	// Getter, Setter 단축키 Alt + Shift + S -> R 
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 입금기능(deposit())메서드
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금할 금액: " + amount + "원");
		System.out.println("입금 후 현재잔고: " + balance + "원");
	}
	
//	
//	public void setAccountNo(String accountNo) {
//		this.accountNo = accountNo;
//	}
//
//	public String getAccountNo() {
//		return "111-1111-111";
//	}
//	
//	public void setOwnerName(String ownerName) {
//		this.ownerName = ownerName;
//	}
//	
//	public String getOwnerName() {
//		return "이나경";
//	}
//	
//	public void setBalnce(int balance) {
//		this.balance = balance;
//	}
//	
//	public int getBalance() {
//		return 500000;
//	}
//	

	
	
	
	
	
}
public class Test1 {

	public static void main(String[] args) {
		
		Account acc = new Account();
		acc.setAccountNo("111-1111-111");
		acc.setOwnerName("이나경");
		acc.setBalance(500000);
		
		acc.deposit(10000);		// 계좌가 누적됨
		acc.deposit(50000);
		
		
		System.out.println("계좌번호: " + acc.getAccountNo());
		System.out.println("예금주명: " + acc.getOwnerName());
		System.out.println("현재잔액: " + acc.getBalance());
		
		
		
		
		
	}

}
