package operator;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 단항 연산자 (증감 연산자) (++, --)
		 * 
		 * 1. 선행연산자 (전위연산자)
		 * 	- 피연산자의 앞쪽(좌측)에 붙여서 값을 1 증가 또는 감소시키는데
		 *    먼저 피연산자의 값을 증가 또는 감소시킨 후에 다른연산에 참여
		 *    ex) ++i, --i
		 * 
		 * 2. 후행연산자 (후위연산자)
		 * 	- 피연산자의 뒷쪽(우측)에 붙여서 값을 1 증가 또는 감소시키는데
		 *    피연산자를 먼저 다른연산에 참여시킨 후 피연산자 값을 1증가 또는 감소
		 *    ex) i++, i--
		 * */
		
		int x1 = 5;
		int y1 = ++x1;
		
		int x2 = 5;
		int y2 = x2++;
		
		System.out.println("x1: " + x1 + ", y1: " + y1);
		System.out.println("x2: " + x2 + ", y2: " + y2);
		
		System.out.println("========================");
		
		int x = 10, y = 5;
//		int z = ++x + y--;
		
		x++;
		int z = x + y;
		y--;
		
		System.out.println("x: " + x + ", y: " + y + ", z: " + z);
		System.out.println("---------------------------");
		
		int i = 3;
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(i);
		
		System.out.println("---------------------------");
		
		int dan = 2;
		int index = 0;
		
		System.out.println("< " + dan + "단 >");
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		
		
		
		
		
	}

}
