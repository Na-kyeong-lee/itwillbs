package object;

import java.util.Objects;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * Account 클래스 정의
		 * 멤버변수 : 계좌번호(accountNo, 문자열), 예금주명(ownerName, 문자열)
		 * 			현재잔고(balance, 정수형)
		 * 생성자: 모든 멤버변수를 초기화하는 생성자
		 * equals() 메서드 오버라이딩 : 모든 멤버변수 값이 같을 경우 true 리턴
		 * toString() 메서드 오버라이딩 : 모든 멤버변수 정보를 String 으로 리턴
		 * */
		Account acc1 = new Account("111-1111-111", "홍길동", 100);
		Account acc2 = new Account("111-1111-111", "홍길동", 100);
		
		if(acc1.equals(acc2)) {
			System.out.println("두 계좌는 동일!");
		} else {
			System.out.println("두 계좌는 다름!");
		}
		System.out.println(acc1);
		System.out.println(acc2);
	}

}

class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNo, other.accountNo) && balance == other.balance
				&& Objects.equals(ownerName, other.ownerName);
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
}













