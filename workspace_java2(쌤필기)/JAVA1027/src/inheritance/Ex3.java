package inheritance;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 메서드 오버라이딩 (Method Overriding)
		 * - 슈퍼클래스로 부터 상속받은 메서드를 서브클래스에서 새롭게 재정의 하는 것
		 * - 반드시 상속 관계에서 상속받은 메서드에 대해서만 적용 가능
		 * - 서브클래스에서 오버라이딩 수행 후에는 슈퍼클래스의 메서드는 은닉됨
		 * 
		 *  < 메서드 오버라이딩 규칙 >
		 *  1. 슈퍼클래스의 메서드와 시그니처(리턴타입, 메서드명, 매개변수)가 동일 해야함
		 *  2. 접근제한자는 범위가 좁아질 수 없다
		 *     (=> 부모가 public이면 자식도 public만 선택 가능함)
		 * */
		Child2 c = new Child2();
		c.parentPrn(); // 서브클래스에서 오버라이딩된 parentPrn() 메서드가 호출됨
		// => 이때, 오버라이딩 된 메서드로 인해 슈퍼클래스의 메서드는 은닉되기 때문에
		//    Child 인스턴스를 통해서는 Parent 클래스의 parentPrn() 접근이 불가능
		Parent2 p = new Parent2();
		p.parentPrn();
		c.childPrn();
		System.out.println("============================");
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.cry();
		cat.cry();
		
	}

}

class Animal {
	String name;
	int age;
	
	public void cry() {
		System.out.println("동물울음 소리!");
	}
}

class Dog extends Animal {
	public void cry() {
		System.out.println("멍멍!");
	}
}

class Cat extends Animal {
	// 자동 오버라이딩 단축키 : Alt + Shift + S -> V
	@Override
	public void cry() {
		// @Override 표시는 어노테이션(Annotation) 기능으로 자바 컴파일러를 위한 주석이며
		// 이 메서드가 오버라이딩 되어 있다는 표시이므로, 반드시 오버라이딩만 가능하며
		// 오버라이딩 규칙을 위반할 경우 오류가 발생
		System.out.println("야옹!");
	}
}



// ------------------------------------------------------

class Parent2 {
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn()");
	}
}

class Child2 extends Parent2 {
	
	// Parent 클래스의 parentPrn() 메서드를 상속받아 오버라이딩을 수행
	// => 슈퍼클래스인 Parent 클래스의 parentPrn() 메서드와 시그니처를 동일하게 정의하고
	//    접근제한자는 public 이므로 다른 접근제한자로 변경 불가 (좁아질 수 없음)
	public void parentPrn() {
		System.out.println("서브클래스에서 오버라이딩 된 parentPrn()");
	}
	
	
	
	public void childPrn() {
		System.out.println("서브 클래스의 childPrn()");
	}
}











