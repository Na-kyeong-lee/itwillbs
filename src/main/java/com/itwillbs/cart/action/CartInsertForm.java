package com.itwillbs.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.cart.action.ActionForward;
import com.itwillbs.cart.db.CartDAO;
import com.itwillbs.cart.db.CartDTO;

public class CartInsertForm implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request 한글처리
		request.setCharacterEncoding("utf-8");
		
		String cus_id=request.getParameter("cus_id");
		
		//CartDAO 객체생성 기억장소 할당=>dao기억장소 주소저장
		CartDAO dao=new CartDAO();
		
		CartDTO dto=new CartDTO();
		request.setAttribute("dto", dto);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./cart/cartInsertForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

	
}
