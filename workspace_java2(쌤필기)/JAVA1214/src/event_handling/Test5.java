package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test5 {

	public Test5() {
		showFrame();
	}
	
	public void showFrame() {
		// 이벤트 처리5. 익명 내부클래스의 임시객체 형태로 이벤트 처리
		// JButton 컴포넌트에 대한 이벤트 처리 담당 리스너 : ActionListener 인터페이스
		// 1. JFrame 생성 (위치, 크기, 창닫기, visible)
		// 2. JButton 생성
		// 3. JButton을 JFrame 부착
		// 4. JButton 객체에 이벤트를 5단계 방식으로 연결
		JFrame f = new JFrame("이벤트 처리 연습 - 5");
		f.setBounds(800, 400, 300, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("버튼");
		f.add(btn);
		
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭!");
//			}
//		});
		btn.addActionListener(e -> System.out.println("버튼 클릭!"));
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test5();
	}

}
