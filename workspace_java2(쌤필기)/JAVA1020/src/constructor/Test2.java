package constructor;

import java.util.ArrayList;
import java.util.Scanner;

class Account2 {
	
	String accountNo;
	String ownerName;
	int balance;
	
	// 1. 파라미터가 없는 기본 생성자 정의, 다음과 같이 멤버변수 초기화
	// => 계좌번호: 111-1111-111
	//    예금주명: 홍길동
	//    현재잔고: 0
	public Account2() {
		accountNo = "111-1111-111";
		ownerName = "홍길동";
		balance = 0;
	}
	
	// 2. 계좌번호를 전달받아 초기화하는 생성자 정의, 나머지는 다음과같이 초기화
	// => 예금주명: 홍길동
	//    현재잔고: 0
	public Account2(String accountNo) {
		this.accountNo = accountNo;
		ownerName = "홍길동";
		balance = 0;
	}
	
	// 3. 계좌번호, 예금주명을 전달받아 초기화하는 생성자 정의, 나머지는 다음과 같이 초기화
	// => 현재잔고: 0
	public Account2(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		balance = 0;
	}
	
	// 데이터타입이 같은 경우 매개변수 순서를 바꾸는 것은 의미가 없음!! (식별이 불가능)
//	public Account2(String ownerName, String accountNo) {}
	
	
	// 4. 계좌번호, 예금주명, 현재잔고를 전달받아 초기화하는 생성자 정의
	public Account2(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	// 계좌정보를 출력하는 showAccountInfo() 메서드 정의
	public void showAccountInfo() {
		System.out.println("계좌번호: " + accountNo);
		System.out.println("예금주명: " + ownerName);
		System.out.println("현재잔고: " + balance);
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Account2 acc = new Account2();
		acc.showAccountInfo();
		System.out.println("----------------");
		
		Account2 acc2 = new Account2("222-2222-222");
		acc2.showAccountInfo();
		System.out.println("----------------");
		
		Account2 acc3 = new Account2("333-3333-333", "이순신");
		acc3.showAccountInfo();
		System.out.println("----------------");
		
		Account2 acc4 = new Account2("777-7777-777", "김태희", 999999);
		acc4.showAccountInfo();
		System.out.println("----------------");
		
		
		System.out.println("===============================================");
		
//		Scanner sc2 = new Scanner();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		// 배열의 크기가 변경될 수 있는 ArrayList
		// => 일반 배열은 크기가 고정되어 변경할 수 없지만
		//    자바에서 제공하는 ArrayList 클래스는 계속해서 배열에 요소를 추가가능
		// => <> 제네릭 (자세한 설명은 추후에...)
		//    배열에 저장할 데이터타입을 제한할 수 있다! (단, 기본데이터타입은 안됨!!)
		ArrayList<Account2> arr = new ArrayList<>();
		arr.add(acc);
		arr.add(acc2);
		arr.add(acc3);
		arr.add(acc4);
		
		
		
		
	}

}
