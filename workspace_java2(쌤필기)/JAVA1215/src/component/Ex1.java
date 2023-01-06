package component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ex1 {

	// 다른 메서드에서 접근을 위해 멤버변수로 선언
	JTextField tf;
	
	public Ex1() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame();
		f.setBounds(600, 400, 300, 300);
		
		/*
		 * JTextField
		 * - 텍스트 한 줄을 입력 가능한 컴포넌트
		 * - BorderLayout에 바로 부착할 경우 기본 생성자로 생성 가능하지만,
		 *   주로 JPanel 등에 부착해서 사용할 때 생성자 파라미터로 컬럼 길이를 전달해야함
		 * - getText() 메서드로 입력된 텍스트를 가져오고,
		 *   setText() 메서드로 새 텍스트를 표시할 수 있다.  
		 * */
		
//		JTextField tf = new JTextField();
		tf = new JTextField();
		f.add(tf);
		
		JButton btn = new JButton("입력");
		f.add(btn, BorderLayout.SOUTH);
		
		ActionListener listener = e -> printMessage();
		btn.addActionListener(listener);
		tf.addActionListener(listener);
		
		// JButton 객체 이벤트 처리
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				System.out.println(tf.getText());
////				tf.setText("");
//				printMessage();
//			}
//		});
		
//		tf.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				printMessage();
//			}
//		});
		
//		tf.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
////				System.out.println(e.getKeyChar()); 
////				System.out.println(e.getKeyCode());
//				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
////					System.out.println(tf.getText());
////					tf.setText("");
//					printMessage();
//				}
//			}
//		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	} // showFrame() 메서드 끝
	
	// JTextField에 입력된 텍스트를 가져와서 출력하는 메서드 정의
	public void printMessage() {
		System.out.println(tf.getText());
		tf.setText("");
	}
	
	public static void main(String[] args) {
		new Ex1();
	}

}
