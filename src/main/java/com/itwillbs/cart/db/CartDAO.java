package com.itwillbs.cart.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.member.db.MemberDTO;


public class CartDAO {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	//디비연결하는 메서드 1,2 단계
	public Connection getConnection() throws Exception {
		//예외처리를 함수 호출하는 곳으로 전달
		
		Context init=new InitialContext();
		// 자원이름호출("자원위치/자원이름") => DataSource 에 저장
		// import javax.sql.DataSource;          자원위치   /   자원이름
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/Mysql"); //lookup 자원을 찾는 메서드
		// DataSource => con 에 저장
		con=ds.getConnection();
		return con;
	}
	
	
	//장바구니에 담기
	public void insertCart(CartDTO dto) {
		
		try {
			//예외(에러)가 발생할 가능성이 높은 코드(명령)
			//1, 2단계 메서드 호출
			con=getConnection(); //디비연결해줌
			
			//3단계 sql구문을 만들고 select로 회원아이디를 기준으로 담은 제품 가져오기
			String sql="select max(crt_num) as cus_num from cart";
			// sql 구문 실행할 준비 pstmt 변수에 담아줌
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			int num=0;
			if(rs.next()) {
				num=rs.getInt("crt_num")+1;
			}
			
			Connection con=getConnection();
			String sql2="insert into cart(crt_num,menu_num,crt_price,crt_count) value(?,?,?,?)";
			PreparedStatement pstmt2=con.prepareStatement(sql2);
			//?에 값을 넣어서 sql구문 완성
			pstmt.setInt(1, dto.getCrt_num());
			pstmt.setInt(2, dto.getMenu_num());
			pstmt.setInt(3, dto.getCrt_price());
			pstmt.setInt(4, dto.getCrt_count());
			//select절은 디비에서 불러와서 값을 rs에 담아서 출력해야함
			rs=pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		

}//insertCart() 메서드
	
	
	//updateCart() 수정
	public void updateCart(CartDTO dto) {
		
		try {
			con=getConnection();
			String sql="update cart set crt_price=?,crt_count=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCrt_price());
			pstmt.setInt(2, dto.getCrt_count());
			//update는 값을 변경만 해서 디비에 올리는거라서 rs에 담을 필요없음
			//executeUpdate
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	//deleteCart() 삭제
	public void deleteCart(CartDTO dto) {
		
		try {
			con=getConnection();
			String sql="delete from cart where menu_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getMenu_num());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	// 장바구니 목록 조회
	public List<CartDTO> getCartList(String id) {
		List<CartDTO> cartList = new ArrayList<CartDTO>();
		try {
			con = getConnection();
			String sql="select * from cart where cus_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartDTO dto=new CartDTO();
				dto.setCrt_num(rs.getInt("crt_num"));
				dto.setCus_id(rs.getString("cus_id"));
				dto.setMenu_num(rs.getInt("menu_num"));
				dto.setCrt_price(rs.getInt("crt_price"));
				dto.setCrt_count(rs.getInt("crt_count"));
				
				cartList.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return cartList;
	}


	}
	
	
	
	
}
