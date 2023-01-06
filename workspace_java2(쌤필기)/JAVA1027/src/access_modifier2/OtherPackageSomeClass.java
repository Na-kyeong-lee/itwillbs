package access_modifier2;

import access_modifier.ParentClass;

public class OtherPackageSomeClass {

	public void useMember() {
		ParentClass p = new ParentClass();
		p.publicVar = 10;
//		p.protectedVar = 20; (X) - 다른 패키지이고 상속관계가 아니므로 접근불가!
//		p.defaultVar = 30;   (X) - 다른 패키지이므로 접근 불가
//		p.privateVar = 40;	 (X) - 다른 클래스에서 접근 불가
	}
	
}
