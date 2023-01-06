package polymorphism;

// 캐릭터
// 다형성을 활용하지 않은 예
class Hero {
	// has - a 관계
	Sword sword;
	Bow bow;
	// 신규무기 추가 후 Hero 클래스 다시 설계 (수정!)
	Gun gun;

	// 장착한 무기로 공격하는 attack() 정의
	public void attack() {
		// 장착된 무기가 뭔지 null 체크!
		if(sword != null) {
			sword.attack();
		} else if(bow != null) {
			bow.attack();
		} else if(gun != null) {
			gun.attack();
		}
	}
	
	// Set 메서드
	public void setSword(Sword sword) {
		this.sword = sword;
	}
	
	public void setBow(Bow bow) {
		this.bow = bow;
	}
	
	public void setGun(Gun gun) {
		this.gun = gun;
	}
}

// 다형성 활용 예
class Hero2 {
	Weapon w;

	public Weapon getW() {
		return w;
	}

	public void setW(Weapon w) {
		this.w = w;
	}
	
	public void attack() {
		w.attack();
	}
}

public class Ex3 {

	public static void main(String[] args) {
		
		// 다형성이 적용되지 않은 예
		Hero hero = new Hero(); // 캐릭터 생성
		
		hero.setSword(new Sword(50, 2)); // 검 장착
		hero.attack();
		
//		hero.setBow(new Sword(50, 2)); // 데이터타입이 다르므로 오류발생!
//		hero.attack();

		hero.setBow(new Bow(500, 10));
		// sword 변수 null 처리
		hero.setSword(null);
		hero.attack();
		
		hero.setGun(new Gun(5000, 20));
		hero.setBow(null);
		hero.attack();
		
		System.out.println("---------------------------------------------------");
		
		// 다형성 활용 예
		Hero2 hero2 = new Hero2();
		hero2.setW(new Sword(35, 2));
		// => 매개변수 데이터타입이 Weapon 타입이지만 업캐스팅 때문에 Sword 타입 전달 가능
		hero2.attack();
		
		hero2.setW(new Gun(200, 10)); 
		hero2.attack();
		
		hero2.setW(new Bow(200000, 20));
		hero2.attack();
	}
}

// 검, 활, 총 클래스들을 추상화 하여 공통된 멤버를 정의
class Weapon {
	public void attack() {
		
	}
}

// 검 클래스
class Sword extends Weapon {
	int demage; // 데미지
	int range;	// 사정거리
	
	public Sword(int demage, int range) {
		this.demage = demage;
		this.range = range;
	}
	
	@Override
	public void attack() {
		System.out.println(range + "의 사정거리로 " + demage + "만큼 공격!");
	}
}

// 활 클래스
class Bow extends Weapon {
	int demage;
	int range;
	
	public Bow(int demage, int range) {
		this.demage = demage;
		this.range = range;
	}
	
	@Override
	public void attack() {
		System.out.println(range + "의 사정거리로 " + demage + "만큼 공격!");
	}
}

// 신규 무기 총 추가
class Gun extends Weapon {
	int demage;
	int range;
	
	public Gun(int demage, int range) {
		this.demage = demage;
		this.range = range;
	}
	
	@Override
	public void attack() {
		System.out.println(range + "의 사정거리로 " + demage + "만큼 공격!");
	}
}










