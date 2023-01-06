package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주소뽑아오기
//		String requestURI=request.getRequestURI();
//		System.out.println("requestURI : "+requestURI);
		
//		String contextPath=request.getContextPath();
//		System.out.println("contextPath : " + contextPath);
//		System.out.println("contextPath길이 : " + contextPath.length());
	
		// 뽑은 가상주소          =>            /insertForm.me
	// 시작위치(contextPath길이) 부터 끝까지 문자열을 잘라서 가져오기
//		String strpath=requestURI.substring(contextPath.length());
		
		String strpath=request.getServletPath();
		System.out.println("뽑은 주소 strpath : "+strpath);
		
		
		
		//주소비교
		ActionForward forward=null;
		Action action=null;
		if(strpath.equals("/MemberInsertForm.me")) {
			// ./member/join.jsp 이동 false
			forward=new ActionForward();
			forward.setPath("./member/join.jsp");
			forward.setRedirect(false);
		}else if(strpath.equals("/MemberInsertPro.me")) {
			action=new MemberInsertPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(strpath.equals("/MemberLoginForm.me")) {
			forward=new ActionForward();
			forward.setPath("./member/login.jsp");
			forward.setRedirect(false);
		}else if(strpath.equals("/MemberLoginPro.me")) {
			action=new MemberLoginPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(strpath.equals("/MemberMain.me")) {
			forward=new ActionForward();
			forward.setPath("./main/main.jsp");
			forward.setRedirect(false);
		}else if(strpath.equals("/MemberLogout.me")) {
			action=new MemberLogout();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//이동
		if(forward!=null) {
			if(forward.isRedirect()) {
				//true : 주소 변경 되면서 이동
				response.sendRedirect(forward.getPath());
			}else {
				//false : 주소 변경 없이 이동
				RequestDispatcher dis
				=request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);	
			}
		}
		
	}//doProcess()
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
