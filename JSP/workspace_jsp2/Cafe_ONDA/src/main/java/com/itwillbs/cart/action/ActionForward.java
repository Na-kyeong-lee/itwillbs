package com.itwillbs.cart.action;

import javax.servlet.http.HttpServlet;

public class ActionForward extends HttpServlet{

	private String path;
	private boolean isRedirect;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
