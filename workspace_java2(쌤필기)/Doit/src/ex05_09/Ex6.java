package ex05_09;

public class Ex6 {

	public static void main(String[] args) {
		// 197p
		
		// Q1) 정답: this
		// 클래스 내부에서 자신의 주소를 가리키는 예약어를 XXX 라고 합니다.
		
		// Q2) 정답: this()
		// 클래스에 여러 생성자가 오버로딩되어 있을 경우에
		// 하나의 생성자에서 다른 생성자를 호출할 때 XXX를 사용합니다.
		
		// Q3) 정답: 클래스변수
		// 클래스 내부에 선언하는 static 변수는 생성되는 인스턴스마다 만들어지는 것이 아닌
		// 여러 인스턴스가 공유하는 변수입니다. 따라서 클래스에 기반한 유일한 변수라는 의미로
		// XXX 라고도 합니다.
		
		// Q4) 스택, 데이터 영역
		// 지역 변수는 함수나 메서드 내부에서만 사용할 수 있고 XXX 메모리에 생성됩니다.
		// 멤버변수중 static 예약어는 사용하는 변수는 static XXX 메모리에 생성됩니다.
		
		// Q5)
		// 아침 출근길에 김 씨는 4000원을 내고 별다방에서 아메리카노를 사 마셨습니다.
		// 이씨는 콩다방에서 4500원을 내고 라떼를 사 마셨습니다.
		// 이 과정을 객체지향으로 프로그래밍 해보세요.
		
		// 가게 오픈
		CoffeeShop 별다방 = new CoffeeShop("별다방");
		CoffeeShop 콩다방 = new CoffeeShop("콩다방");
		
		// 고객
		Customer 김씨 = new Customer("김씨", 10000);
		Customer 이씨 = new Customer("이씨", 50000);
		
		// ------- 커피 구매 ------------
		김씨.buy(별다방, "아메리카노", 4000);
		이씨.buy(콩다방, "라떼", 4500);
		
		// ------- 커피 구매 후 -------
		별다방.showInfo();
		콩다방.showInfo();
		
		김씨.showInfo();
		이씨.showInfo();
		
		System.out.println("=================================");
		// ------- 커피 구매 ------------
		김씨.buy(콩다방, "아메리카노", 2000);
		이씨.buy(별다방, "아인슈패너", 40000);
		
		// ------- 커피 구매 후 -------
		별다방.showInfo();
		콩다방.showInfo();
		
		김씨.showInfo();
		이씨.showInfo();
		
		
		
	}
}

class Customer {
	String name;
	int money;
	Coffee coffee;
	
	public Customer(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	// 커피 구매 기능
	public void buy(CoffeeShop coffeeShop, String kind, int price) {
		this.money -= price;
		coffee = coffeeShop.sell(kind, price);
	}
	
	// 고객정보 showInfo()
	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("돈: " + money);
		System.out.println("커피: " + coffee.kind);
	}
	
}

class CoffeeShop {
	String name; // 별다방, 콩다방
	int money;   // 매출
	
	public CoffeeShop(String name) {
		this.name = name;
	}
	
	// 커피 판매 기능
	public Coffee sell(String kind, int money) {
		this.money += money;
		return new Coffee(kind, money);
	}
	
	// 가게 정보 showInfo()
	public void showInfo() {
		System.out.println("가게: " + name);
		System.out.println("매출: " + money);
	}
	
}

class Coffee {
	String kind; // 라떼, 아메리카노, 아인슈패너
	int price;
	
	// Alt + Shift + S -> O
	public Coffee(String kind, int price) {
		this.kind = kind;
		this.price = price;
	}
}

//교제 정답
//class Person {
//	String name;
//	int money;
//	
//	public Person(String name, int money) {
//		this.name = name;
//		this.money = money;
//	}
//	
//	// 별다방 커피 사기
//	public void buyStarCoffee(StarCoffee sCoffee, int money) {
//		String message = sCoffee.brewing(4000);
//		if(message != null) {
//			this.money -= money;
//			System.out.println(name + " 씨는 " + money +"원을 내고 "  + message);
//		}
//	}
//	
//	public void buyBeanCoffee(BeanCoffee bCoffee, int money) {
//		String message = bCoffee.brewing(4500);
//		if(message != null) {
//			this.money -= money;
//			System.out.println(name + " 씨는 " + money +"원을 내고 "  + message);
//		}
//	}
//}
//
////별다방 클래스
//class StarCoffee {
//	int money;
//	
//	public String brewing(int money) {
//	
//		this.money += money;
//		if(money == Menu.STAR_AMERICANO) {
//			return "별 다방 아메리카노를 구입했습니다";
//		}
//		else if(money == Menu.STAR_LATTE) {
//			return "별 다방 라떼를 구입했습니다";
//		}
//		else {
//			return null;
//		}
//	}
//}
//
////콩다방 클래스
//class BeanCoffee {
//
//	int money;
//	
//	public String brewing(int money) {
//	
//		this.money += money;
//		if(money == Menu.BEAN_AMERICANO) {
//			return "콩 다방 아메리카노를 구입했습니다";
//		}
//		else if(money == Menu.BEAN_LATTE) {
//			return "콩 다방 라떼를 구입했습니다";
//		}
//		else {
//			return null;
//		}
//	}
//}
//
//
//class Menu {
//	public static final int STAR_AMERICANO = 4000;
//	public static final int STAR_LATTE = 4300;
//	
//	public static final int BEAN_AMERICANO = 4100;
//	public static final int BEAN_LATTE = 4500;
//}


//=================================================================















