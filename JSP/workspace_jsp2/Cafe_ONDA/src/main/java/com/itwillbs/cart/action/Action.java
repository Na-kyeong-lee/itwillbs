package com.itwillbs.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.cart.action.ActionForward;

public interface Action {
	// 추상메서드 (내용은 없는데 틀은 있음)
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
