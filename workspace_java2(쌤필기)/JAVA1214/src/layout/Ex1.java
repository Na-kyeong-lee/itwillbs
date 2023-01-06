package layout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex1 {

	public Ex1() {
		showFrame();
	}
	
	public void showFrame() {
		/*
		 * 레이아웃(Layout)
		 * - 화면을 구성하는 형태(요소들의 배치 형태)
		 * - 다양한 레이아웃을 사용하여 요소들의 배치 형태를 결정 가능
		 * - 각 레이아웃을 지원하는 객체 사용하여 레이아웃 적용 가능
		 * - BorderLayout, FlowLayout, GridLayout, CardLayout
		 * 
		 * BorderLayout
		 * - 대상 컨테이너의 동,서,남,북,중앙 5개의 영역으로 분할하여 컴포넌트를 배치
		 * - JFrame 객체의 기본 레이아웃
		 *   => 별도의 설정이 없을 경우 기본적으로 BorderLayout 이 적용되어 있음
		 * - 배치할 영역을 지정하는 경우 add() 메서드의 두번째 파라미터로
		 *   BorderLayout.XXX 상수를 사용하여 위치 지정 가능  
		 * */
		JFrame f = new JFrame("레이아웃 기초");
		f.setBounds(200, 200, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCenter = new JButton("중앙");
		
//		f.add(btnCenter);
		f.add(btnCenter, BorderLayout.CENTER);
//		f.add(btnCenter, "CENTER"); // 주의!! 예외 발생 => CENTER 문자열 틀림
//		f.add(btnCenter, "Center"); // 문자열을 사용하여 영역 지정할 경우 
		
		JButton btnNorth = new JButton("NORTH");
		f.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnEast = new JButton("EAST");
		f.add(btnEast, BorderLayout.EAST);
		
		JButton btnWest = new JButton("WEST");
		f.add(btnWest, BorderLayout.WEST);
		
		JButton btnSouth = new JButton("SOUTH");
		f.add(btnSouth, BorderLayout.SOUTH);
		
		// 각 버튼에 대한 이벤트 처리 - 5단계
//		btnCenter.addActionListener(e -> System.out.println("CENTER 버튼 클릭됨!"));
//		btnEast.addActionListener(e -> System.out.println("EAST 버튼 클릭됨!"));
//		btnWest.addActionListener(e -> System.out.println("WEST 버튼 클릭됨!"));
//		btnNorth.addActionListener(e -> System.out.println("NORTH 버튼 클릭됨!"));
//		btnSouth.addActionListener(e -> System.out.println("SOUTH 버튼 클릭됨!"));
		
		// 각 버튼에 대한 이벤트 처리 - 4단계
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 위 5단계 방식 처럼 이벤트 처리
//				System.out.println(e.getID()); 
//				System.out.println(e.getSource()); 
				
//				if(e.getSource() == btnCenter) {
//					System.out.println("CENTER 버튼 클릭됨!");
//				} else if(e.getSource() == btnEast) {
//					System.out.println("EAST 버튼 클릭됨!");
//				}
				
//				System.out.println(e.getActionCommand() + " 버튼 클릭됨!"); 
				
				Date d = new Date(e.getWhen());
				System.out.println(d.getHours()); 
				if(d.getHours() > 12) {
					System.out.println("오후에는 가능");
				}
			}
		};
		
		btnCenter.addActionListener(listener);
		btnEast.addActionListener(listener);
		btnWest.addActionListener(listener);
		btnNorth.addActionListener(listener);
		btnSouth.addActionListener(listener);
		
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex1();
	}

}
