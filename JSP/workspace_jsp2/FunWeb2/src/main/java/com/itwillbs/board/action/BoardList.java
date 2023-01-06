package com.itwillbs.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;

public class BoardList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		http://localhost:8080/FunWeb2/BoardList.bo
//		http://localhost:8080/FunWeb2/BoardList.bo?pageNum=2
		
		// 한페이지에 15개씩 글목록 가져오기
		int pageSize=15;
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			//페이지넘버가 null이면 1에서 시작
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);
		int startRow= (currentPage-1)*pageSize+1;
		int endRow= startRow+pageSize-1;
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> boardList=dao.getBoardList(startRow, pageSize);
		
		// 한페이지 안에 10개의 페이지 번호가 보이게 설정
		int count=dao.getBoardCount();
		int pageBlock=10; //한화면에 보여질 페이지 갯수 10개
		int startPage=(currentPage-1)/pageBlock*pageBlock+1; //시작하는 페이지
		int endPage=startPage+pageBlock-1;
		int pageCount = count/pageSize
				+(count%pageSize==0 ? 0 : 1);
		if(endPage > pageCount) {  //페이지갯수가 딱 안떨어지고 5일 경우 엔드페이지도 5로 바꿀 수 잇게
			endPage=pageCount;
		}
		
		// 글 목록, 페이지 정보 => request에 저장
		// 데이터를 담아서 list.jsp로 이동
		request.setAttribute("boardList", boardList);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		// 이동정보 저장 => ./center/notice.jsp 파일로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./center/notice.jsp"); //jsp는 주소가 안보여야됨
		forward.setRedirect(false); //주소는 안바뀌면서 이동해야하므로 false
		return forward;
		
	}

	
	
}
