package com.itwillbs.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.cart.action.ActionForward;

public interface Action {
	//추상메서드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
