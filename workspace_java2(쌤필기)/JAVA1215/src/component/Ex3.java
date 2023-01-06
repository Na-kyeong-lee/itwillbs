package component;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex3 {

	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("CheckBox");
		f.setBounds(600, 400, 400, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 패널을 하나 생성한 후 프레임에 부착
		JPanel p = new JPanel();
		f.add(p);
		
		JCheckBox cb1 = new JCheckBox("Java");
		JCheckBox cb2 = new JCheckBox("JSP");
		JCheckBox cb3 = new JCheckBox("Android");
		JCheckBox cb4 = new JCheckBox("Spring");
		JCheckBox cb5 = new JCheckBox("Oracle");
		JCheckBox cb6 = new JCheckBox("MySQL");
		JTextField tf = new JTextField(10);
		JCheckBox cbAll = new JCheckBox("전체선택");
		
		// 패널에 체크박스 부착
		p.add(cb1); p.add(cb2); p.add(cb3); p.add(cb4); p.add(cb5); p.add(cbAll);
		p.add(cb6); p.add(tf);
		
		
//		JCheckBox[] cbs = {cb1, cb2, cb3, cb4};
//		List<JCheckBox> arrCbs = new ArrayList<JCheckBox>();
//		arrCbs.add(cb1); arrCbs.add(cb2); arrCbs.add(cb3); arrCbs.add(cb4);
		
		
		/*
		 * 전체선택 체크박스에 대한 이벤트 처리 => ActionListener 
		 * => 전체선택 체크 시 cb1, cb2, cb3... 모두 체크하고
		 *    전체선택 체크 해제 시 cb1, cb2, cb3... 모두 체크해제
		 * */
		
		cbAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(cbAll.isSelected()); 
//				if(cbAll.isSelected()) {
//					cb1.setSelected(true);
//					cb2.setSelected(true);
//					cb3.setSelected(true);
//					cb4.setSelected(true);
//				} else {
//					cb1.setSelected(false);
//					cb2.setSelected(false);
//					cb3.setSelected(false);
//					cb4.setSelected(false);
//				}
				
//				boolean result = cbAll.isSelected();
//				cb1.setSelected(result);
//				cb2.setSelected(result);
//				cb3.setSelected(result);
//				cb4.setSelected(result);
				
				// 일반 배열
//				boolean result = cbAll.isSelected();
//				for(JCheckBox cb : cbs) {
//					cb.setSelected(result);
//				}
				
				// ArrayList
//				boolean result = cbAll.isSelected();
//				for(JCheckBox cb : arrCbs) {
//					cb.setSelected(result);
//				}
				
				// 만약, 유지보수중 체크박스 항목이 추가된다면?
				boolean result = cbAll.isSelected();
				for(Component comp : p.getComponents()) {
					if(comp instanceof JCheckBox) 
						((JCheckBox) comp).setSelected(result);
				}
				
			}
		});
		
		
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex3();
	}

}
