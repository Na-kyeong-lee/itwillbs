package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex3 {

	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 3");
		f.setBounds(600, 400, 300, 300);
		/*
		 * < 이벤트 처리 5단계 >
		 * 3단계. 내부클래스(Inner Class) 형태로 정의
		 * 리스너 인터페이스 또는 어댑터 클래스를 구현 시 내부클래스 형태로 구현하여 사용
		 * => 이벤트 리스너 구현체(핸들러 클래스)는 보통 GUI 클래스에서만 사용됨 (= 전용클래스)
		 *    따라서, 별도의 클래스로 외부에 정의하기 보다는 내부클래스 형태로 정의해서 사용
		 *    GUI 클래스 내부에 핸들러 클래스를 정의하면 내부클래스가 됨
		 * => 외부에 정의하는 방법과 클래스 모양은 동일하나 클래스 정의 위치만 달라짐   
		 * */
		
		// 로컬 내부 클래스 형태로 정의
		// => 로컬 변수와 동일한 범위에서만 접근 가능
		class MyLocalWindowAdapter extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
			}
		}
		
		MyLocalWindowAdapter listener = new MyLocalWindowAdapter();
		f.addWindowListener(listener);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void showFrame2() {
		MyMemberWindowAdapter litener;
		// 메서드가 달라지면 로컬 내부클래스는 접근이 불가능하므로
		// 여러 메서드에서 하나의 리스너를 공유하려면 멤버 내부클래스 형태로 정의해야한다!
//		MyLocalWindowAdapter litener2;
	}
	
	public static void main(String[] args) {
		new Ex3();
	}

	// 멤버 내부클래스 형태로 정의
	// => 인스턴스 멤버와 동일한 위치에 정의하므로 인스턴스 내부 클래스라고도 함
	class MyMemberWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing");
		}
	}
	
}





