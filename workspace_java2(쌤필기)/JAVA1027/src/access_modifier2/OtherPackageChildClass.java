package access_modifier2;

import access_modifier.ParentClass;

public class OtherPackageChildClass extends ParentClass {

	public void useMember() {
		
		// 주의! 상속 관계에서 슈퍼클래스의 멤버에 접근할 때
		// 슈퍼클래스의 인스턴스를 생성하여 접근할 경우
		// 객체로 접근한 것이고 상속 관계로써의 접근이 아니게 된다!
		ParentClass p = new ParentClass();
		p.publicVar = 10;
//		p.protectedVar = 20;
//		p.defaultVar = 30;
//		p.privateVar = 40;
		
		this.publicVar = 10;
		this.protectedVar = 20; // (O) - 다른 패키지이지만 상속 관계이므로 접근가능
//		this.defaultVar = 30;
//		this.privateVar = 40;
	}
	
}
