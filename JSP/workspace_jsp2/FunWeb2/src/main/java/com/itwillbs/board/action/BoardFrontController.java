package com.itwillbs.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주소 매핑
//		http://localhost:8080/FunWeb2/BoardList.bo
		
//		/BoardList.bo가상 주소 뽑아오기
		String strpath=request.getServletPath(); //뽑은 주소 가져오는 것
		System.out.println("뽑은 주소 strpath : " + strpath); //path에 최종적으로 값이 담김
		//주소 비교
		Action action=null;
		ActionForward forward=null;
		if(strpath.equals("/BoardList.bo")) {
//			주소를 비교해서 자바에 BoardList 객체 만들고 action에 들어감
			action=new BoardList();
			try {
//				처리결과값을 forward 변수에 담기
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(strpath.equals("/BoardWriteForm.bo")) {
			forward=new ActionForward();
			forward.setPath("./center/writeForm.jsp");
			forward.setRedirect(false);
		
		} else if(strpath.equals("/BoardWritePro.bo")) {
			action=new BoardWritePro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(strpath.equals("/BoardContent.bo")) { //false이므로 아래의 else를 통해 이동함
			action=new BoardContent();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(strpath.equals("/BoardUpdate.bo")) {
			action=new BoardUpdateForm();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(strpath.equals("/FileBoardList.bo")) {
			//목록으로 갈 것이므로 처리 작업함
			action=new FileBoardList();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(strpath.equals("/FileBoardWriteForm.bo")) {
			forward=new ActionForward();
			forward.setPath("./center/fwriteForm.jsp");
			forward.setRedirect(false);
		
		} else if(strpath.equals("/FileBoardWritePro.bo")) {
			action=new FileBoardWritePro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(strpath.equals("/FileBoardContent.bo")) {
			action=new FileBoardContent();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(strpath.equals("/FileBoardDelete.bo")) {
			action=new FileBoardDelete();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		//이동 (forward가 null인지 아닌지에 따라 처리함 - null이 아닐경우 이동함(JSP))
		if(forward!=null) {
			if(forward.isRedirect()) {
				//true이면 sendRedirect(forward에 주소를 담아서 이동)
				//true - 주소변경하면서 이동
				response.sendRedirect(forward.getPath());
			}else {
				//false이면 주소변경 없이 이동하면서 request, response를 가지고 이동함
				RequestDispatcher dis
				= request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		//doProcess 메서드를 doGet방식일 때도 사용하고
	}

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		//doProcess 메서드를 doPost 방식일 때도 사용하려고 doProcess 넣어줌
	}

	
}
