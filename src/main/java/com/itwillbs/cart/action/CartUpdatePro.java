package com.itwillbs.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.cart.db.CartDAO;
import com.itwillbs.cart.db.CartDTO;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class CartUpdatePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request한글처리
		request.setCharacterEncoding("utf-8");

		int menu_id=Integer.parseInt(request.getParameter("menu_id"));
		int crt_count=Integer.parseInt(request.getParameter("crt_count"));
		
		CartDTO dto=new CartDTO();
		dto.setMenu_id(menu_id);
		dto.setCrt_count(0);
		
		CartDAO dao=new CartDAO();
		dao.updateCart(dto);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./CartList.ca");
		forward.setRedirect(true);
		
		return forward;
	}

	
}
