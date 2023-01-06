package polymorphism;

public class Ex4 {

	public static void main(String[] args) {
		Marine m1 = new Marine(5, 6);
		Marine m2 = new Marine(5, 6);
		Marine m3 = new Marine(5, 6);
		
		Marine[] marines = {m1, m2, m3};
		
		for(Marine m : marines) {
			m.attack();
		}
		
		Tank t1 = new Tank(20, 10);
		Tank t2 = new Tank(20, 10);
		
		Tank[] tanks = {t1, t2};
		for(Tank t : tanks) {
			t.attack();
		}
		
		System.out.println("======================");
		// 다형성 활용
		Unit[] units = {m1, m2, m3, t1, t2};
		for(Unit u : units) {
			u.attack();
		}
		
	}

}

// 추상화를 통해 Unit 클래스 정의
class Unit {
	int demage;
	int range;
	
	public Unit(int demage, int range) {
		this.demage = demage;
		this.range = range;
	}
	
	public void attack() {
		
	}
}

class Marine extends Unit {
	
	public Marine(int demage, int range) {
		super(demage, range);
	}

	@Override
	public void attack() {
		System.out.println(range + " 사정거리로 " + demage + " 만큼 공격!");
	}
}

class Tank extends Unit {
	
	public Tank(int demage, int range) {
		super(demage, range);
	}

	@Override
	public void attack() {
		System.out.println(range + " 사정거리로 " + demage + " 만큼 공격!");
	}
}














