package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex2 {

	/*
	 * < 이벤트 처리 5단계 >
	 * 2. 리스너 인터페이스 대신 어댑터 클래스 사용
	 * 	- 추상메서드가 2개 이상인 인터페이스를 구현할 경우
	 *    불필요한 메서드까지 구현해야하므로 코드가 길어짐
	 *  - 리스너 인터페이스를 미리 구현해놓은 어댑터 클래스를 상속받는 핸들러에서
	 *    원하는 메서드만 선택해야 오버라이딩이 가능하므로 코드가 간결해짐
	 *  - XXXListener 인터페이스에 대응하는 XXXAdapter 클래스가 제공됨
	 *    단, 추상메서드가 하나뿐인 인터페이스는 어댑터클래스가 제공되지 않음
	 *    ex) ActionListener 인터페이스의 추상메서드가 1개이므로 ActionAdapter 제공 X    
	 * */
	
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 2");
		f.setBounds(600, 400, 300, 300);
		
		MyWindowAdapter listener = new MyWindowAdapter();
		f.addWindowListener(listener);
		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}

// 이벤트 처리 2단계
// 윈도우에 대한 이벤트 처리 담당 리스너 : WindowListener 인터페이스
// => 이레 대한 어댑터클래스 : WindowAdapter 클래스
class MyWindowAdapter extends WindowAdapter {

	// 상속받은 슈퍼클래스의 메서드 중 필요한 메서드만 선택적 오버라이딩
	// => windowClosing() 메서드 오버라이딩
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0);
	}
}










