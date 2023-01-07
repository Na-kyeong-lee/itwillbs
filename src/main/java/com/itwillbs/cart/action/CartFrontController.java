package com.itwillbs.cart.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.cart.action.Action;
import com.itwillbs.cart.action.ActionForward;

public class CartFrontController extends HttpServlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController doProcess()");
		//가상주소 뽑아오기
		String requestURI=request.getRequestURI();
		System.out.println("requestURI : " + requestURI);
		
		String contextPath=request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		System.out.println("contextPath길이 : " + contextPath.length());
		
		String strpath=requestURI.substring(contextPath.length());
		System.out.println("뽑은 주소 strpath : " + strpath); //path에 최종적으로 값이 담김
		//가상주소 비교 => 실제주소(파일) 맵핑(연결)
		ActionForward forward=null;
		Action action=null;
		if(strpath.equals("/CartInsertForm.ca" )) { //화면으로 가고싶다고 가상주소를 만든것
//			./board/writeForm.jsp 이동주소, false 이동방식
			forward=new ActionForward();
			forward.setPath("./cart/CartInsertForm.jsp");
			forward.setRedirect(false); //이동방식(true:response.sendRedirect / false:주소가 안바뀌면서 이동)
		
			
		} else if(strpath.equals("/CartInsertPro.ca")) {
			//BoardWritePro 객체생성
			action=new CartInsertPro();
			//메서드 호출
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
		} else if(strpath.equals("/CartList.ca")) {
			// DB 내용 가져와서 list.jsp 출력
			// BoardList 객체생성
			action=new CartList();
			//메서드 호출
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(strpath.equals("/CartUpdateForm.ca")) {
			//DB에 가서 num에 대한 글을 가져와서 updateForm.jsp로 이동해줌
			//BoardUpdateForm 객체생성
			action=new CartUpdateForm();
			//메서드 호출
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(strpath.equals("/CartUpdatePro.ca")) {
			//DB에 가서 num에 대한 글을 가져와서 updatePro.jsp로 이동해줌
			//BoardUpdatePro객체생성
			action=new CartUpdatePro();
			//메서드 호출
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
//		} else if(strpath.equals("/CartDelete.ca")) {
//			//DB에 가서 num에 대한 글을 가져와서 updatePro.jsp로 이동해줌
//			//BoardUpdatePro객체생성
//			action=new CartDelete();
//			//메서드 호출
//			try {
//				forward=action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		 
		
		
		
		
		//이동
		if(forward != null) {
			if(forward.isRedirect()) {
				//true : 주소변경 되면서 이동
				System.out.println("true:" + forward.getPath() + "sendRedirect 이동"); //sendRedirect는 주소를 바꾸면서 이동하는 방식
				response.sendRedirect(forward.getPath());
			}else {
				//false : 주소변경 안되면서 이동
				System.out.println("false:" + forward.getPath() + "forward() 이동"); //forward: 주소를 안바꾸면서 이동하는 방식
				RequestDispatcher dis
				= request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			
			} 
			
			}
		}
		
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
}

	
	