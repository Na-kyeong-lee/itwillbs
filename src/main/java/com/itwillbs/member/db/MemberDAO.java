package com.itwillbs.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	//멤버변수
	
	//기본생성자 => 생략가능
	
	// 디비연결하는 메서드 1,2단계
	public Connection getConnection() throws Exception {
		// 예외처리를 함수 호출하는 곳으로 전달
		
		//1단계 JDBC 프로그램 가져오기
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
		String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
		String dbUser="root";
		String dbPass="1234";
		Connection con=
		    DriverManager.getConnection(dbUrl, dbUser, dbPass);
		return con;
	}
	
//	//멤버함수(메서드)
//	// 디비작업 => 1~4단계 자바파일에 메서드 정의
//	public void insertMember(String id,String pass,String name,Timestamp date) {
//		// 1~4단계
//		System.out.println("MemberDAO insertMember()");
//		System.out.println("전달받은 id 값 : " + id);
//		System.out.println("전달받은 pass 값 : " + pass);
//		System.out.println("전달받은 name 값 : " + name);
//		System.out.println("전달받은 date 값 : " + date);
//		
//		try {
//			// 예외(에러)가 발생할 가능성 높은 코드(명령)
//			// 1, 2 단계 메서드 호출
//			Connection con = getConnection();
//
//			// 3단계 sql구문을 만들고 실행할 준비 insert
//			String sql="insert into members(id,pass,name,date) values(?,?,?,?)";
//			PreparedStatement pstmt =con.prepareStatement(sql);
//			// ? 표 값을 넣어서 sql구문 완성
//			pstmt.setString(1, id);
//			pstmt.setString(2, pass);
//			pstmt.setString(3, name);
//			pstmt.setTimestamp(4, date);
//
//			// 4단계 : sql구문 실행 (insert)
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			// 예외가 발생하면 처리하는 곳=> 에러메시지 출력
//			e.printStackTrace();
//		}finally {
//			// 예외 상관없이 마무리 작업 
//			// => Connection, PreparedStatement
//			// => 기억장소 해제
//		}
//		return;
//	}//insertMember() 메서드
	
	
	//멤버함수(메서드)
	// 디비작업 => 1~4단계 자바파일에 메서드 정의
//	                        (바구니 주소를 저장하는 변수)
	public void insertMember(MemberDTO dto) {
		// 1~4단계
		System.out.println("MemberDAO insertMember()");
		System.out.println("전달받은 바구니(dto)의 주소 : "+dto);
		System.out.println("전달받은 바구니안에 있는 id 값 : " + dto.getId());
		System.out.println("전달받은 바구니안에 있는 pass 값 : " + dto.getPass());
		System.out.println("전달받은 바구니안에 있는 name 값 : " + dto.getName());
		System.out.println("전달받은 바구니안에 있는 date 값 : " + dto.getDate());
		
		try {
			// 예외(에러)가 발생할 가능성 높은 코드(명령)
			// 1, 2 단계 메서드 호출
			Connection con = getConnection();

			// 3단계 sql구문을 만들고 실행할 준비 insert
			String sql="insert into members(id,pass,name,date) values(?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(sql);
			// ? 표 값을 넣어서 sql구문 완성
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setTimestamp(4, dto.getDate());

			// 4단계 : sql구문 실행 (insert)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// 예외가 발생하면 처리하는 곳=> 에러메시지 출력
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리 작업 
			// => Connection, PreparedStatement
			// => 기억장소 해제
		}
		return;
	}//insertMember() 메서드
	
	// 리턴할형MemberDTO userCheck(String id,String pass)
	// 메서드 정의
	public MemberDTO userCheck(String id,String pass) {
		// MemberDTO 변수 선언 초기값 null
		MemberDTO dto=null;
		try {
			//1,2 디비연결
			Connection con = getConnection();
			// 3단계 sql구문을 만들고 실행할 준비 select
			//String sql="select * from 테이블이름 where id=? and pass=?";
			String sql="select * from members where id=? and pass=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			//4단계 : sql구문 실행 , 실행결과 저장(select)
			//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
			ResultSet rs=pstmt.executeQuery();
			//5단계 : 결과를 출력, 배열저장 (select)
			//if 다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"
			//else        데이터 없으면 => false => "아이디 비밀번호 틀림"
			if(rs.next()){
				//데이터 있으면 => true =>"아이디 비밀번호 일치"
				//out.println("아이디 비밀번호 일치");
				// id pass name date => 바구니 MemberDTO 저장
				// MemberDTO 객체생성
				dto=new MemberDTO();
				// set메서드 호출 값(디비 가져온값)을 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setDate(rs.getTimestamp("date"));
				
			}else{
				//데이터 없으면 => false => "아이디 비밀번호 틀림"
//				out.println("아이디 비밀번호 틀림");
				// "입력하신 정보 틀림", 뒤로이동
//					초기값 null
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//마무리
		}
		System.out.println("회원정보가 저장된 리턴할 주소 : " + dto);
		return dto;
		
	}// userCheck()
	
	// 리턴할형MemberDTO getMember(String id)
	// 메서드 정의
	public MemberDTO getMember(String id) {
		// MemberDTO 변수 선언 초기값 null
		MemberDTO dto=null;
		try {
			//1,2 디비연결
			Connection con = getConnection();
			// 3단계 sql구문을 만들고 실행할 준비 select
			//String sql="select * from 테이블이름 where id=? and pass=?";
			String sql="select * from members where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			//4단계 : sql구문 실행 , 실행결과 저장(select)
			//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
			ResultSet rs=pstmt.executeQuery();
			//5단계 : 결과를 출력, 배열저장 (select)
			//if 다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"
			//else        데이터 없으면 => false => "아이디 비밀번호 틀림"
			if(rs.next()){
				//데이터 있으면 => true =>"아이디  일치"
//				out.println("아이디 비밀번호 일치");
				// id pass name date => 바구니 MemberDTO 저장
				// MemberDTO 객체생성
				dto=new MemberDTO();
				// set메서드 호출 값(디비 가져온값)을 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setDate(rs.getTimestamp("date"));
				
			}else{
				//데이터 없으면 => false => "아이디  틀림"
//				out.println("아이디 비밀번호 틀림");
				// "입력하신 정보 틀림", 뒤로이동
//					초기값 null
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//마무리
		}
		System.out.println("회원정보가 저장된 리턴할 주소 : " + dto);
		return dto;
	}// getMember()
	
// 리턴할형없음 void updateMember(수정할 정보MemberDTO 주소) 메서드 정의
	public void updateMember(MemberDTO dto) {
		// 1~4단계
		System.out.println("MemberDAO updateMember()");
		System.out.println("전달받은 바구니(dto)의 주소 : "+dto);
		System.out.println("전달받은 바구니안에 있는 id 값 : " + dto.getId());
		System.out.println("전달받은 바구니안에 있는 pass 값 : " + dto.getPass());
		System.out.println("전달받은 바구니안에 있는 name 값 : " + dto.getName());
		System.out.println("전달받은 바구니안에 있는 date 값 : " + dto.getDate());
		
		try {
			// 예외(에러)가 발생할 가능성 높은 코드(명령)
			// 1, 2 단계 메서드 호출
			Connection con = getConnection();
			
//		 	3단계 sql update, 4단계 실행, main.jsp 이동
			String sql="update members set name=? where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			// 4단계 실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			// 예외가 발생하면 처리하는 곳=> 에러메시지 출력
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리 작업 
			// => Connection, PreparedStatement
			// => 기억장소 해제
		}
		
	}//updateMember() 메서드	
	
	// 리턴할형없음 void deleteMember(삭제할 정보) 메서드 정의
		public void deleteMember(String id) {
			
			try {
				// 예외(에러)가 발생할 가능성 높은 코드(명령)
				// 1, 2 단계 메서드 호출
				Connection con = getConnection();
				
//			 	3단계 sql delete, 4단계 실행, 세션초기화, main.jsp 이동
				String sql="delete from members where id=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				// 4단계 실행
				pstmt.executeUpdate();

			} catch (Exception e) {
				// 예외가 발생하면 처리하는 곳=> 에러메시지 출력
				e.printStackTrace();
			}finally {
				// 예외 상관없이 마무리 작업 
				// => Connection, PreparedStatement
				// => 기억장소 해제
			}

		}//updateMember() 메서드	
		
//		List memberList =dao.getMemberList();
		public List<MemberDTO> getMemberList() {
			// 배열 객체생성할때 같은형이 저장되게 정의=> 제네릭타입
//			List memberList=new ArrayList();
			List<MemberDTO> memberList=new ArrayList<MemberDTO>();
			System.out.println("배열의 주소:"+memberList);
			try {
				//1, 2 단계 메서드 호출
				Connection con = getConnection();
				// 3단계 sql구문을 만들고 실행할 준비 select
				//String sql="select * from 테이블이름";
				String sql="select * from members";
				PreparedStatement pstmt=con.prepareStatement(sql);
				//4단계 : sql구문 실행 , 실행결과 저장(select)
				//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
				ResultSet rs=pstmt.executeQuery();
				//5단계 : while 결과를 출력, 배열저장 (select)
				while(rs.next()){
					//한사람에 데이터 id pass name date => MemberDTO
					MemberDTO dto=new MemberDTO();
					dto.setId(rs.getString("id"));
					dto.setPass(rs.getString("pass"));
					dto.setName(rs.getString("name")); 
					dto.setDate(rs.getTimestamp("date"));  
					// 한사람의 데이터를 배열 한칸에 저장 => memberList
					memberList.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				// 예외 상관없이 마무리 작업 
				// => Connection, PreparedStatement
				// => 기억장소 해제
			}
			return memberList;
		}
		
	
}//클래스




