package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test4 {

	public Test4() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 연습 - 4");
		f.setBounds(800, 400, 300, 200);
		
		JButton btn = new JButton("버튼");
		f.add(btn);
		
		// 이벤트 처리4. 익명 내부 클래스 형태로 정의
		// JButton 컴포넌트에 대한 이벤트 처리 담당 리스너 : ActionListener 인터페이스
//		ActionListener listener = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("로컬 버튼 클릭!");
//			}
//		};
		
		ActionListener listener = e -> System.out.println("로컬 버튼 클릭!");
		
		btn.addActionListener(this.listener);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
//	ActionListener listener = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("멤버 버튼 클릭!");
//		}
//	};
	
	ActionListener listener = e -> System.out.println("멤버 버튼 클릭!");
	
	public static void main(String[] args) {
		new Test4();
	}

}
