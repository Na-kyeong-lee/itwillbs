package swing;

import javax.swing.JFrame;

/*
 * 400 * 400 크기의 창 생성
 * 제목: JFrame 생성 연습
 * 닫기 버튼 클릭 시 프로그램 종료
 * 화면 표시 설정: true
 * */

public class Test1 extends JFrame {

	public Test1() {
		showFrame();
	}
	
	public void showFrame() {
//		setTitle("JFrame 생성 연습");
//		setSize(400, 400);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
		
		// ---------------------------------------------------
		JFrame f = new JFrame("JFrame 생성 연습");
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}

}
