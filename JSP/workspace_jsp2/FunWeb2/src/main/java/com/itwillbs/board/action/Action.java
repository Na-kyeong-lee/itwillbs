package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//meber의 Action, ActionForward 파일 복사해서 board패키지에 붙여넣기

// 인터페이스 => 클래스 틀 : 처리작업하는 자바파일의 틀
// 인터페이스 상속받은 모든 자식클래스는 틀을 강제적으로 적용
// 강제적으로 메서드오버라이딩 
// 리턴할때 ActionForward에 이동경로, 이동방식을 담아서 리턴
public interface Action {
	
//추상메서드
	public ActionForward execute
	(HttpServletRequest request,
			HttpServletResponse response) 
			throws Exception;
	
}
