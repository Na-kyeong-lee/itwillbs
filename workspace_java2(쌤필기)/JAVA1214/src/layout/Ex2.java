package layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex2 {

	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("GridLayout");
		f.setBounds(600, 300, 300, 300);
		/*
		 * GridLayout
		 * - 컴포넌트를 테이블(표) 형태로 배치하는 레이아웃
		 * - 행, 열 형태의 구조를 가지며, 배치되는 컴포넌트의 크기가 균등함
		 * - 첫 행의 좌측열부터 우측열 방향, 다음행의 좌측열부터 우측열 순으로 배치  
		 * */
		GridLayout gridLayout = new GridLayout(3, 2); // 행, 열 선택
		f.setLayout(gridLayout);
		
		// 버튼 5개 생성
		JButton btn1 = new JButton("BUTTON 1");
		JButton btn2 = new JButton("BUTTON 2");
		JButton btn3 = new JButton("BUTTON 3");
		JButton btn4 = new JButton("BUTTON 4");
		JButton btn5 = new JButton("BUTTON 5");
		JButton btn6 = new JButton("BUTTON 6");
		JButton btn7 = new JButton("BUTTON 7");
		
		// 생성된 버튼들을 frame 부착
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);
		f.add(btn6);
		f.add(btn7);
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
