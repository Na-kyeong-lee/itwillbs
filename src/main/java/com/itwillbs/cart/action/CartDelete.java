package com.itwillbs.cart.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.cart.db.CartDAO;
import com.itwillbs.cart.db.CartDTO;

public class CartDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cus_id = request.getParameter("id");
		int menu_num=Integer.parseInt(request.getParameter("menu_num"));
		
		CartDAO dao=new CartDAO();
		List<CartDTO> dto=dao.getCartList();
		
		//dto null이 아니면 => 메뉴삭제, 장바구니 이동
		//dto null이면 => "제품을 담아주세요" => 뒤로이동
		if(dto!=null) {
			dao.deleteCart();
			//세션초기화(java는 HttpSession)
			HttpSession session=request.getSession();
			session.invalidate();
			
			// ./CartList.ca로 이동
			ActionForward forward=new ActionForward();
			forward.setPath("./CartList.ca");
			forward.setRedirect(true);
			return forward;
		
		} else {
			
		}
		
		
		ActionForward forward=new ActionForward();
		forward.setPath("./CartList.ca");
		forward.setRedirect(true);
		
		return forward;
	}

	
}
