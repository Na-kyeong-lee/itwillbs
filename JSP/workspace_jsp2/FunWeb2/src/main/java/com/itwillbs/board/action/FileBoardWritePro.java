package com.itwillbs.board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileBoardWritePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// 글쓰기 폼에서 입력한 내용을 서버에 전달하면 
			// 내장개체 request에 저장되어진다.
		
			// 파일 업로드 => 프로그램 설치
			// http://www.servlets.com/cos
			// cos-22.05.zip 다운로드 => 압축풀기 => lib => cos.jar
			// 설치 WEB-INF -> lib -> cos.jar 붙여넣기
			
			// cos.jar 파일 안에 MultipartRequest 객체 생성 
			// => 파일 업로드가 됨, 파라미터 정보가 multi에 저장됨 
			// 1. request 정보
		
			// 2. 파일 업로드 할 웹서버의 물리적인 경로를 만들어주기
			// 	  webapp - upload 폴더 만들기 => 물리적 경로
			String uploadPath=request.getRealPath("/upload");
			System.out.println(uploadPath);  //파일업로드가 된 경로 보기위해 콘솔창에 출력시켜줌
			
			// 3. 업로드 할 최대 파일크기(10M) 지정해주기
			int maxSize=10*1024*1024;
			
		 	// 4. 한글처리
			// 5. 업로드 파일이름이 동일할 경우 => 파일이름 변경하는 프로그램
			// 	  new DefaultFileRenamePolicy() : 기본파일이름으로 동일하게 변경하겠다
			MultipartRequest multi=new MultipartRequest(request, uploadPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		    
			
			
			// request name, subject, content 파라미터 가져와서 변수에 저장
			String name=multi.getParameter("name"); //객체안에 정의가 되어있음, 그 정보를 끄집어냄
			String subject=multi.getParameter("subject");
			String content=multi.getParameter("content");

			// 파일이름 가져오기
			String file=multi.getFilesystemName("file");


			// <boardDTO 파일에서 하기>
			// 패키지board 파일이름BoardDTO 자바 클래스 만들기
			// 멤버변수 num, name, subject, content, readcount, date 정의
			// set() get() 메서드 정의
			// => 파일 file 추가


			// BoardDTO 객체생성(=기억장소 할당, 객체생성)
			BoardDTO dto = new BoardDTO();
			//set() 메서드 호출 파라미터값 저장
			dto.setName(name);
			dto.setSubject(subject);
			dto.setContent(content);
			// 현시스템 날짜시간
			dto.setDate(new Timestamp(System.currentTimeMillis()));
			// 조회수는 0으로 설정
			dto.setReadcount(0);
			// 글번호 num값 => BoardDAO에서 작업
			// 추가 첨부파일 저장
			dto.setFile(file);



			// 패키지board 파일이름BoardDAO 자바 클래스 만들기
			// BoardDAO 객체생성(=기억장소 할당,객체생성)
			BoardDAO dao=new BoardDAO();
			// 리턴할형 없음 insertBoard(BoardDTO 주소값 저장하는 변수) 메서드 정의
			// BoardDAO주소.insertBoard(BoardDTO 주소)메서드 호출
			dao.insertBoard(dto);
			//글목록 이동
			ActionForward forward=new ActionForward();
			forward.setPath("./FileBoardList.bo"); //주소가 바뀌면서 이동할것이므로
			forward.setRedirect(true);  //true
			return forward;	

	}

	
}
