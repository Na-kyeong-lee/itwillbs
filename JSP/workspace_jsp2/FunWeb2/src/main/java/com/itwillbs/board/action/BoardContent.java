package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class BoardContent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// num 값을 request에서 가져오기
		int num=Integer.parseInt(request.getParameter("num"));
		
		// BoardDAO 객체생성
		BoardDAO dao=new BoardDAO();
		
		// 조회수 증가 readcount 1증가
		dao.updateReadcount(num);
		
		// getBoard(num)메서드 호출
		BoardDTO dto=dao.getBoard(num); 
		
		// BoardDTO를 request에 저장
		request.setAttribute("dto", dto);
		
		// ./center/content.jsp로 이동 (false)
		ActionForward forward = new ActionForward();
		forward.setPath("./center/content.jsp");
		forward.setRedirect(false);
		return forward;
		
	}
	
}
