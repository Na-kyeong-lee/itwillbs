package com.itwillbs.cart.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.cart.db.CartDAO;
import com.itwillbs.cart.db.CartDTO;

public class CartList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = "naramji";	// TODO : 하드코딩 고치기
		// 기억장소 할당 CartDAO(객체생성)
		CartDAO dao=new CartDAO();
		
		// dao주소를 통해 메서드호출
		// 여러개 저장하는 List배열변수=dao.getCartList();
		// List cartList=dao.getCartList();
		List<CartDTO> cartList = dao.getCartList(id);
		request.setAttribute("cartList", cartList);

		
		ActionForward forward = new ActionForward();
		forward.setPath("./cart/cartlist.jsp");
		forward.setRedirect(false);
		return forward;
	}

	
}
