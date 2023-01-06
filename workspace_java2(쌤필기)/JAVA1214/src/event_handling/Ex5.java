package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex5 {

	public Ex5() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 5");
		f.setBounds(600, 400, 300, 200);
		
		/*
		 * < 이벤트 처리 5단계 >
		 * 5단계. 익명 내부클래스(Anonymouns Inner Class)의 임시 객체 형태로 사용
		 * - 기본적인 개념은 익명 내부클래스와 동일하나 이벤트 처리 대상이 하나뿐일 경우
		 *   별도의 변수가 필요없으므로 변수 선언부를 제외하고
		 *   리스너 연결을 위한 addXXXListener() 메서드 파라미터로
		 *   익명 내부클래스를 구현하는 코드를 바로 기술하여 객체를 전달
		 * - 별도의 변수가 없으므로 두 개 이상의 컴포넌트에 리스너 연결이 불가능함
		 *   => 즉, 1회용 리스너 객체가 됨
		 * - 리스너 인스턴스 생성 및 추상클래스 구현과 함께 연결 작업까지 한꺼번에 수행
		 * - 동일한 이벤트를 다른 대상에 적용해야할 경우 중복되는 코드가 발생함
		 *   => 4단계 방법이 더 효율적  
		 * */
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
			}
		});
		
		abstract class A {
			public abstract void method();
		}
		
//		A a = new A() {
//			@Override
//			public void method() {
//				System.out.println("a");
//			}
//		};
//		A a = () -> System.out.println("a");
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex5();
	}

}
