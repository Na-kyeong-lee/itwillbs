package com.itwillbs.cart.action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.cart.db.CartDAO;
import com.itwillbs.cart.db.CartDTO;
import com.itwillbs.member.db.MemberDAO;

public class CartInsertPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request 한글처리
		request.setCharacterEncoding("utf-8");
		
		int crt_num=Integer.parseInt(request.getParameter("crt_num"));
		int menu_id=Integer.parseInt(request.getParameter("menu_id"));
		int crt_price=Integer.parseInt(request.getParameter("crt_price"));
		int crt_count=Integer.parseInt(request.getParameter("crt_count"));
		
		
		CartDAO dao=new CartDAO();
		
		CartDTO dto=new CartDTO();
		dto.setCrt_num(crt_num);
		dto.setMenu_id(menu_id);
		dto.setCrt_price(crt_price);
		dto.setCrt_count(crt_count);
		
		dao.insertCart(dto);
		
		
//		if(dto!=null) {
//			HttpSession session=request.getSession();
//			session.getAttribute("crt_num");
//			session.getAttribute("menu_num");
//			session.getAttribute("crt_price");
//			session.getAttribute("crt_count");
			
			// 리턴 이동할 장바구니 담기페이지로 이동
			// ActionForward 객체 생성
			// 이동경로, 이동방식 담아서 forward 방식 리턴
			ActionForward forward=new ActionForward();
			forward.setPath("./CartInsertForm.ca");
			forward.setRedirect(true);
			return forward;
			
//		} else {
//			//데이터 없으면 => false => 메뉴페이지로 다시 이동?
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out=response.getWriter();
//			out.print("<script>");
//			out.print("alert('장바구니가 비어있습니다!');");
//			out.print("history.back();");
//			out.print("</script>");
//			out.close();
//			return null;
//		}
		
		
		
		
		
	}

	
}
