import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class CustomerGUI {

	private JFrame f;
	// North 영역
	private JTextField sName, sAge, sJumin;
	private JButton btnSelect;
	
	// Center 영역
	private JTable table;
	
	// West 영역
	private JTextField tfIdx, tfName, tfAge, tfEmail, tfJumin;
	
	// South 영역
	private JButton btnInsert, btnDelete;
	
	// 생성자
	public CustomerGUI() {
		showFrame();
	}
	
	public void showFrame() {
		f = new JFrame("고객 관리 프로그램");
		f.setBounds(500, 300, 900, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ------------ North 영역 (조회조건) ----------------
		JPanel pNorth = new JPanel();
		f.add(pNorth, BorderLayout.NORTH);
		pNorth.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pNorth.setLayout(new GridLayout(0, 4, 0, 0));
		
		// 조회조건 sName 입력 패널
		JPanel panelName = new JPanel();
		pNorth.add(panelName);	// 부모패널(북쪽 큰패널) 부착
		
		panelName.add(new JLabel("이름"));	// 레이블 부착
		sName = new JTextField();
		panelName.add(sName);	// TextField 부착
		sName.setColumns(10);
		
		// 조회조건 sAge 입력 패널
		JPanel panelAge = new JPanel();
		pNorth.add(panelAge);	// 부모패널(북쪽 큰패널) 부착
		
		panelAge.add(new JLabel("나이")); // 레이블 부착
		sAge = new JTextField();
		panelAge.add(sAge);	// TextField 부착
		sAge.setColumns(10);
		
		
		
		// 조회조건 sJumin 패널
		JPanel panelJumin = new JPanel();
		pNorth.add(panelJumin);
		
		panelJumin.add(new JLabel("주민"));
		
		sJumin = new JTextField();
		panelJumin.add(sJumin);
		sJumin.setColumns(10);
		
		
		btnSelect = new JButton("조회");
		pNorth.add(btnSelect);
		
		// ------------------------------------------------
		
		
		// ------------- WEST 영역 (회원 정보 입력 영역) ----------------
		JPanel pWest = new JPanel(new GridLayout(5, 0, 0, 0));
		f.add(pWest, BorderLayout.WEST);
		
		// --- 각 입력 항목에 대한 패널 생성 ---
		// 번호(IDX) 패널
		JPanel pIdx = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pWest.add(pIdx);
		
		pIdx.add(new JLabel("번 호"));
		
		tfIdx = new JTextField(10);
		tfIdx.setEditable(false); // 번호 입력 불가능하도록 잠금
		pIdx.add(tfIdx);
		
		// 이름(NAME) 패널
		JPanel pName = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pWest.add(pName);
		
		pName.add(new JLabel("이 름"));
		
		tfName = new JTextField(10);
		pName.add(tfName);
		
		// 나이(AGE) 패널
		JPanel pAge = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pWest.add(pAge);
		
		pAge.add(new JLabel("나 이"));
		
		tfAge = new JTextField(10);
		pAge.add(tfAge);
		
		// 이메일(EMAIL) 패널
		JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pWest.add(pEmail);
		
		pEmail.add(new JLabel("E-Mail"));
		
		tfEmail = new JTextField(10);
		pEmail.add(tfEmail);
		
		// 주민번호(JUMIN) 패널
		JPanel pJumin = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pWest.add(pJumin);
		
		pJumin.add(new JLabel("주민번호"));
		
		tfJumin = new JTextField(10);
		pJumin.add(tfJumin);
		// --------------------------------------------------------
		
		// ---------------- CENTER 영역(회원 정보 표시 영역) ------------------
		// 스크롤바 기능 추가를 위해 JScrollPane 객체 생성 후
		// 프레임에 추가한 뒤, JTable 객체는 JScrollPane에 추가
		JScrollPane scrollPane = new JScrollPane();
		f.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// 테이블 옵션 설정
		// 셀 위치 이동 불가 설정
		table.getTableHeader().setReorderingAllowed(false);
		
		// 컬럼 제목을 표시하기 위해 DefaultTableModel 객체 생성
		// 배열을 사용하여 제목을 생성한 뒤 Model 객체에 추가
		String[] columnNames = {"번 호", "이 름", "나 이", "E-Mail", "주민번호"};
		DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
		// DefaultTableModel 객체를 JTable 객체에 전달
		table.setModel(dtm);
		
		// --------------------------------------------------------------
		
		// ----------------- SOUTH 영역(버튼 영역) --------------------------
		JPanel pSouth = new JPanel();
		f.add(pSouth, BorderLayout.SOUTH);
		
		btnInsert = new JButton("회원추가");
		btnDelete = new JButton("회원삭제");
		
		pSouth.add(btnInsert);
		pSouth.add(btnDelete);
		
		// --------------------------------------------------------------
		
		// ---- Event -----
		
		// 조회 버튼 클릭 시 회원 조회
		btnSelect.addActionListener(e -> select());
		sName.addActionListener(e -> select());
		sAge.addActionListener(e -> select());
		sJumin.addActionListener(e -> select());
		
		// 회원 추가 버튼 클릭 시 insert() 메서드 호출
		btnInsert.addActionListener(e -> insert());
		
		// 회원 삭제 버튼 클릭 시 delete() 메서드 호출
		btnDelete.addActionListener(e -> delete());
		
		f.setVisible(true);
	}
	
	public void delete() {
		String idx = JOptionPane.showInputDialog(f, "삭제할 회원 번호를 입력하세요.");
		
		// 취소, X ==> null
		if(idx == null) return;
		
		// 입력 번호가 없을 경우 (널스트링 또는 길이 0) 오류 메세지 출력
		if(idx.equals("")) { // idx.length() == 0
			JOptionPane.showMessageDialog(
					f, "번호 입력 필수!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// IDX 값이 1부터 증가되므로 0 데이터도 오류 메세지 출력
		if(idx.equals("0")) {
			JOptionPane.showMessageDialog(
					f, "번호는 1이상 입력!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// 입력 데이터가 있을 경우 (삭제가능)
		// CustomerDAO 객체의 delete() 메서드에 번호 전달
		CustomerDAO dao = new CustomerDAO();
		boolean isSuccess = dao.delete(idx);
		
		if(isSuccess) {
			JOptionPane.showMessageDialog(
					f, "회원 삭제 성공", "성공", JOptionPane.INFORMATION_MESSAGE);
			select();
		} else {
			JOptionPane.showMessageDialog(
					f, "회원 삭제 실패", "실패", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	public boolean vaildCheck() {
		// true : 저장가능, false : 저장불가
		// null Check;
		// 나이(숫자 1 ~ 3 체크)
		// Email 형식 체크
		// 주민번호 형식 체크
		
		// tfName.getText().length() == 0
		if(tfName.getText().equals("")) {
			JOptionPane.showMessageDialog(
					f, "이름 입력 필수!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		
		if(tfAge.getText().equals("")) {
			JOptionPane.showMessageDialog(
					f, "나이 입력 필수!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if(tfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(
					f, "E-Mail 입력 필수!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if(tfJumin.getText().equals("")) {
			JOptionPane.showMessageDialog(
					f, "주민번호 입력 필수!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// 이름 4자 이하
		if(tfName.getText().length() > 4) {
			JOptionPane.showMessageDialog(
					f, "이름은 4자 이하로 입력", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// 입력 항목에 대한 양식 체크 시 => 정규표현식 활용
		// ex) 나이 입력에 대한 숫자 양식 체크
		String pattern = "^[0-9]{1,3}$"; // 숫자 1~3 자리 체크하는 패턴
		if(!Pattern.matches(pattern, tfAge.getText())) {
			JOptionPane.showMessageDialog(
					f, "나이는 숫자 3자리 이하 입력 필수!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public void insert() {
		// Vaildation Check (유효성 검사)
		if(!vaildCheck()) return;
		
		// TextField 에 입력된 데이터를 가져오기
		String name = tfName.getText();
		String age = tfAge.getText();
		String email = tfEmail.getText();
		String jumin = tfJumin.getText();
		
		// DTO에 저장
		CustomerDTO dto = new CustomerDTO("", name, age, email, jumin);
		
		// DAO에 insert() 메서드 호출할 때 파라미터로 DTO 전달
		CustomerDAO dao = new CustomerDAO();
		boolean isSuccess = dao.insert(dto);
		
		if(isSuccess) {
			JOptionPane.showMessageDialog(
					f, "회원 추가 성공", "성공", JOptionPane.INFORMATION_MESSAGE);
			select();
		} else {
			JOptionPane.showMessageDialog(
					f, "회원 추가 실패", "실패", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void select() {
		// 조회조건에 입력되어 있는 데이터를 HashMap에 저장 후
		// select() 메서드 파라미터로 전달
		Map<String, String> param = new HashMap();
		param.put("NAME", sName.getText());
		param.put("AGE", sAge.getText());
		param.put("JUMIN", sJumin.getText());
		
		CustomerDAO dao = new CustomerDAO();
		Vector<Vector> data = dao.select(param);
		
		// table 객체에 DefaultTableModel 객체를 가져오기
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		
		// Model 객체의 행번호를 0으로 초기화 (표시된 회원 목록 초기화)
		dtm.setRowCount(0);
		
		// 향상된 for문 사용하여 dtm에 추가
		for(Vector rowData : data) {
			dtm.addRow(rowData);
		}
		
	}
	
	public static void main(String[] args) {
		new CustomerGUI();
	}

}
