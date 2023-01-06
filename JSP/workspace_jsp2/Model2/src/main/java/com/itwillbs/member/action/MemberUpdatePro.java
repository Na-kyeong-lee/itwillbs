package com.itwillbs.member.action;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberUpdatePro implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request한글처리
		request.setCharacterEncoding("utf-8");
		// 폼에서 입력한 파라미터값(id,pass,name)을 서버에 request에 저장
		// 변수 = request에 저장된 값 가져오기
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		//MemberDAO 객체생성
		MemberDAO dao=new MemberDAO();
		// MemberDTO dto =디비작업주소.userCheck(id,pass) 메서드 호출
		MemberDTO dto=dao.userCheck(id, pass);
		//dto null이 아니면  =>"아이디 비밀번호 일치" =>수정,메인이동
//		    null이면      => "아이디 비밀번호 틀림" => 뒤로이동
		if(dto!=null){
		//다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"
		// 수정할 정보를 MemberDTO에 객체생성 set 호출 저장
		MemberDTO dtoUpdate=new MemberDTO();
		dtoUpdate.setId(id);
		dtoUpdate.setPass(pass);
		dtoUpdate.setName(name);
		// 리턴할형없음 void updateMember(수정할 정보MemberDTO 주소) 메서드 정의
		// updateMember(MemberDTO 주소) 메서드 호출
		dao.updateMember(dtoUpdate);
		
		// ./MemberMain.me 이동
		ActionForward forward=new ActionForward();
		forward.setPath("./MemberMain.me");
		forward.setRedirect(true);
		return forward;
		
		}else{
		//데이터 없으면 => false => "아이디 비밀번호 틀림"	
//		 	"입력하신 정보 틀림", 뒤로이동
//			%>
//			<script type="text/javascript">
//				alert("입력하신 정보 틀림");
//				history.back();
//			</script>
//			<%
		}
		return null;
	}
}
