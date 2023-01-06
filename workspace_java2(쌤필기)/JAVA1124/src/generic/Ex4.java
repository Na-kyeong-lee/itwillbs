package generic;

public class Ex4 {

	public static void main(String[] args) {
		GenericClass3<Integer> gc;
		GenericClass3<Double> gc2;
//		GenericClass3<String> gc3; // Number 계열이 아니므로 지정불가!
//		GenericClass3<Object> gc4; // Number 계열이 아니므로 지정불가!
	}

}

// 제네릭 타입의 상속과 구현
class Class1 <P> {}
interface Interface1 <Q> {}

class SubClass<P, Q, R> extends Class1<P> implements Interface1<Q> {
	// => Class1<P>, Interface<Q>을 상속받으려면 최소한 SubClass 뒤에
	//    P와 Q를 명시 필수!
	//    또한, 서브클래스 자신만의 제네릭 타입도 추가할 수 있다!
	P var1; // 슈퍼클래스 Class1의 타입 P
	Q var2;
	R var3;
}



/*
 * 제네릭 타입에 대한 사용 가능한 파라미터 타입 제한
 * - 제네릭 타입 파라미터 선언 시 Object 타입과 그 자식 타입들 모두 사용 가능
 * - 필요에 따라 파라미터 타입에 올 수 있는 데이터타입을 제한할 수 있음
 * < 기본 문법 >
 * 1. 파라미터에 대한 서브클래스 타입으로 제한하는 경우
 *    class 클래스명 <타입파라미터 extends 클래스타입> {}
 *    => 타입파라미터(ex. E 또는 T)는 extends 뒤의 클래스 타입이거나 하위 타입만 지정가능
 * */
class GenericClass3 <E extends Number> {}
// => Number 타입 또는 Number 클래스 하위 타입 (Integer, Double 등) 으로만 변환 가능








