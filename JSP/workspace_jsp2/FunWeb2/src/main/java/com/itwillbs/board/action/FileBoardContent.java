package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class FileBoardContent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// num 가져오기
		int num=Integer.parseInt(request.getParameter("num"));
		
		// 객체생성 기억장소 할당=> dao 기억장소 주소 저장
		BoardDAO dao=new BoardDAO();
		
		// 조회수 증가 readcount 1증가
		// update board set readcount=readcount+1 where num=?
		// 리턴할형없음 updateReadcount(int num)	메서드 정의
		// dao주소를 통해서  updateReadcount(num) 메서드 호출
		dao.updateReadcount(num);
		
		// BoardDTO 리턴할형  getBoard(int num)메서드 정의
		// dao주소를 통해서 메서드 호출 => 리턴할형 BoardDTO
		BoardDTO dto=dao.getBoard(num); 
		
		//dto주소값을 dto 변수에 담아와서(content.jsp에 있는 값)
		request.setAttribute("dto", dto);
		
		//이동하는거 (./center/fcontent.jsp) false
		ActionForward forward = new ActionForward();
		forward.setPath("./center/fcontent.jsp");
		forward.setRedirect(false);
		return forward;
	}
	
}
