package com.itwillbs.cart.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.cart.db.CartDAO;
import com.itwillbs.cart.db.CartDTO;

public class CartUpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int crtNum=Integer.parseInt(request.getParameter("crt_num"));
		String cusId=request.getParameter("id");
		int menuNum=Integer.parseInt(request.getParameter("menu_num"));
		int crtPrice=Integer.parseInt(request.getParameter("crt_price"));
		int crtCount=Integer.parseInt(request.getParameter("crt_count"));
		
		
		//CartDAO 객체생성 기억장소 할당=>dao기억장소 주소저장
		CartDAO dao=new CartDAO();
		
		List<CartDTO> dto=dao.getCartList(cusId);
		request.setAttribute("dto", dto);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./cart/cartUpdateForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

	
}
