package super_;

public class Test1 {

	public static void main(String[] args) {
		S s = new S();
		s.scope();
	}
}

class P { 
	String name = "P"; 
}
class C2 extends P { 
//	String name = "C"; 
}
class S extends C2 {
//	String name = "S";
	public void scope() {
		String name = "로컬";
		System.out.println(name);
		System.out.println(this.name);
		System.out.println(super.name);
	}
}


