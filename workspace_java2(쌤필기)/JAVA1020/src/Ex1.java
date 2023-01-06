class Hero {
	// 멤버변수 (속성)
	int demage;
	int hp;
	int mp;
	String name;
	// 생성자
	// 메서드 (기능)
	// 영웅의 정보를 출력하는 showInfo()
	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("현재 hp: " + hp);
	}
	
	// 상대 영웅을 공격하는 attack() 메서드
	public void attack(Hero other) {
		// 전달받은 영웅의 hp를
		// 나의 (호출한) 데미지 만큼 차감
		other.hp -= demage;
	}
	
}

public class Ex1 {

	public static void main(String[] args) {
		// 객체 생성 및 초기화
		Hero h1 = new Hero();
		h1.name = "뽀삐";
		h1.hp = 500;
		h1.mp = 200;
		h1.demage = 250;
		
		Hero h2 = new Hero();
		h2.name = "티모";
		h2.hp = 300;
		h2.mp = 100;
		h2.demage = 10;
		
		// 객체 정보 출력
		h1.showInfo();
		h2.showInfo();
		System.out.println("------------");
		// 한대씩 주고 받아보자!
		h2.attack(h1); // 티모가 뽀삐를
		h1.showInfo();
		System.out.println("---------------");
		h1.attack(h2); // 뽀삐가 티모를
		h2.showInfo();
		
		
	}

}



