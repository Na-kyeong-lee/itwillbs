package component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex2 {

	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("Dialog 기초");
		f.setBounds(800, 400, 300, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * JOptionPane
		 * - 다이얼로그(팝업창)을 생성하는 객체
		 * - 사용자에게 알림 메세지를 팝업창으로 표시하거나 (alert)
		 *   사용자의 선택을 받거나 (confirm), 사용자로부터 데이터를 입력받는(prompt) 용도로 사용 
		 * 
		 * 1) MessageDialog	: 사용자에게 메세지를 표시하기 위한 다이얼로그 
		 * 2) ConfirmDialog	: 사용자로부터 선택을 받도록 버튼을 표시하는 다이얼로그
		 * 3) InputDialog	: 사용자로부터 데이터를 입력받기 위한 다이얼로그
		 * */
		
		// JPanel 객체 생성하여 CENTER 영역에 부착
		JPanel p = new JPanel();
		f.add(p);
		
	 	JButton btnMessage = new JButton("Message");
	 	JButton btnConfirm = new JButton("Confirm");
	 	JButton btnInput = new JButton("Input");
		
	 	p.add(btnMessage); p.add(btnConfirm); p.add(btnInput);
		
	 	// 각 버튼 이벤트 처리 - 4단계
	 	ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMessage) {
					/*
					 * 1. parentComponent : 다이얼로그 표시할 부모 객체
					 *    => 만약, null 지정 시 전체 화면의 중앙에 표시됨
					 * 2. message : 다이얼로그에서 표시할 본문
					 * 3. title : 다이얼로그 제목 표시줄에 표시할 제목
					 * 4. messageType : 메세지 종류
					 * */
					JOptionPane.showMessageDialog(
							f, 
							"다이얼로그 메세지", 
							"다이얼로그 제목", 
							JOptionPane.WARNING_MESSAGE);
					
				} else if(e.getSource() == btnConfirm) {
					// DEFAULT_OPTION 
					// YES_NO_OPTION 
					// YES_NO_CANCEL_OPTION
					// OK_CANCEL_OPTION
					int select = JOptionPane.showConfirmDialog(
							f, 
							"종료 하시겠습니까?", 
							"종료", 
							JOptionPane.YES_NO_CANCEL_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
					
					if(select == JOptionPane.YES_OPTION) {
						System.out.println("종료!");
					} else if(select == JOptionPane.NO_OPTION) {
						System.out.println("종료 안함!");
					} else if(select == JOptionPane.CANCEL_OPTION) {
						System.out.println("종료 취소");
					} else if(select == JOptionPane.CLOSED_OPTION) {
						System.out.println("Confirm창 닫음");
					}
					
				} else if(e.getSource() == btnInput) {
					String input = JOptionPane.showInputDialog(f, "검색할 이름 입력");
					System.out.println("입력 데이터 : " + input);
				}
			}
		};
		
	 	btnMessage.addActionListener(listener);
	 	btnConfirm.addActionListener(listener);
	 	btnInput.addActionListener(listener);
	 	
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
