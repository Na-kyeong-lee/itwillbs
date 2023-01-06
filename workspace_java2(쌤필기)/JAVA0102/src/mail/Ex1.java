package mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Ex1 {

	public static void main(String[] args) {
		
		String sender = "omama69@gmail.com"; //보내는 메일 주소
		String receiver = "omama69@naver.com"; //받는 메일 주소
		String title = "안뇽"; //제목 텍스트
		String content = "이제 쉬는시간~~"; //내용 텍스트
		
		try {
			
		
		
			// ---- 메일 전송에 필요한 설정 작업 ----
			// 메일 전송 프로토콜 : SMTP(Simple Mail ransfer Protocol)
			// (참고. 메일 수신 프로토콜 : POP3)
			
			// 시스템(서버)의 속성 정보(=서버 정보)를 관리하는 java.util.Properties 객체 리턴받기
			// => System 클래스의 getProperties() 메서드 사용
			Properties properties = System.getProperties(); //Properties 도 HashMap의 한 종류임
			
			// 메일 발송 프로토콜 정보 설정
			// => 첫번째 파라미터는 고정, 두번째 파라미터는 메일 서버와 전송상황에 따라 값이 달라짐
			// TLS(Transprot Layer Security) 인증 관련 설정
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
			// 메일 전송에 사용할 메일 서버 지정(Gmail, naver, nate, outlook 등) => 각 메일 서비스에 설정 방법 설명되어있음
			properties.put("mail.smtp.host", "smtp.gmail.com"); // 구글(Gmail) 메일 전송
			properties.put("mail.smtp.auth", "true"); // 인증 여부 설정(로그인 필요 시)
			properties.put("mail.smtp.port", "587"); // 메일 전송에 사용될 서비스 포트 설정(SMPT 포트)
			// => 기본 25번. 각 서버별로 달라질 수 있음
			
			// -------------------------------------------------------------
			// 메일 서버에 대한 인증 정보를 관리하는 사용자 정의 클래스의 인스턴스 생성
			Authenticator authenticator = new GoogleSMTPAuth(); // 상속받았으므로 슈퍼클래스 타입으로 업캐스팅 가능함
			
			// 자바 메일의 기본 전송 단위를 javax.mail.Session 객체 단위로 관리
			// => Session 클래스의 getDefaultInstance() 메서드를 호출하여 파라미터로 서버 정보와 인증정보 객체
			// => 주의! JSP 내장객체인 HttpSession 객체(변수명 session)이랑 겹치면 안되니까(와 별개의 객체이므로)
			//	  변수명을 session이 아닌 다른 이름 사용 필수!!
			Session mailSession = Session.getDefaultInstance(properties, authenticator);
			
			// 메일 발송 정보를 관리할 javax.mail.internet.MimeMessage 객체 생성
			// => 파라미터로 서버 정보와 인증 정보를 관리하는 java.mail.Session 객체 전달
			// => MimeMessage 객체를 사용하여 전송할 메일에 대한 발송 정보 설정 가능
			Message mailMessage = new MimeMessage(mailSession);
			
			// -------------------------------------------------------------
			// 전송할 메일에 대한 발송 정보 설정
			// 1. 발신자 정보 설정(발신자 정보를 주소형태로 관리하는 InternetAddress 객체 생성)
			// => 파라미터 : 발신자 메일주소, 발신자 이름
			// => 단, 스팸 메일 방지 정책으로 인해 사용 메일 사이트(구글, 네이버)에서는 발신자 주소 설정 불가능
			Address sender_addAddress = new InternetAddress(sender, "cafe_ONDA"); // 두번째 파라미터는 변경가능ㄴ
			
			// 2. 수신자 정보 설정
			Address receiver_address = new InternetAddress(receiver);
			
			// 3. 전송할 메일 정보 설정
			// 3-1) 메일 헤더 정보 설정
			mailMessage.setHeader("content-type", "text/html; charset=UTF-8");
			// 3-2) 발신자 정보 설정
			mailMessage.setFrom(sender_addAddress);
			// 3-3) 수신자 정보 설정 (파라미터로 RecipientType 클래스의 TO 상수와 수신자 주소 전달)
			// => 참조의 경우 RecipientType.CC 사용
			//	  숨은 참조의 경우 RecipientType.BCC 사용
			mailMessage.addRecipient(RecipientType.TO, receiver_address);
			// 3-4) 메일 제목 설정
			mailMessage.setSubject(title);
			// 3-5) 메일 본문 설정
			mailMessage.setContent(content, "text/html; charset=UTF-8");
			// 3-6) 메일 전송 날짜 및 시간 정보 설정
			mailMessage.setSentDate(new Date());
			// 4. 메일 전송
			// javax.mail.Transport 클래스의 static 메서드 send() 메서드 호출
			// => 파라미터로 메일 정보가 저장된 Message 객체 전달
			Transport.send(mailMessage);
			
			System.out.println("메일이 정상적으로 전송되었습니다.");
			
		} catch (Exception e) {
			System.out.println("SMTP 서버 설정 또는 서비스 문제 발생!");
		}
		
		
		
		
		
	}

}

// 자바 메일 기능 사용 시 메일 서버(ex. Gmail 등) 인증을 위한 인증 정보를 관리하는
// javax.mail.Authenticator 클래스를 상속받는 서브클래스 정의
class GoogleSMTPAuth extends Authenticator {
	// 인증 정보 (아이디, 패스워드)를 관리할 javax.mail.Password ~~~ 클래스타입 변수 선언
	PasswordAuthentication passwordAuthentication;
	
	// 기본 생성자 정의
	public GoogleSMTPAuth() {
		// 인증에 사용할 아이디와 패스워드 정보를 갖는 passwordAuthentication 객체 생성
		// => 파라미터로 계정명과 패스워드 전달
		// => Gmail 기준 2단계 인증 미사용 했을 시 Gmail 계정명, 패스워드 전달
		// => Gmail 기준 2단계 인증 사용 시 Gmail 계정명과 함께 패스워드 대신 2단계 인증을 우회하는 앱비밀번호 전달
		//	  (구글 계정 설정 - 보안 - Google에 로그인 항목의 앱 비밀번호 설정 필요)
		//	  (생성 항목 : 앱선택 = 메일, 기기 선택 = Windows 컴퓨터)
		// 	  => 생성 완료 시 나타나는 앱 비밀번호를 사용해야함
		passwordAuthentication = new PasswordAuthentication("omama69@gmail.com", "xzybbnnbconwxdjf"); //메일서버계정명: 내가 보내는 주소, 구글에서 받은 인증번호
	}

	
	// 인증번호를 관리하는 passwordAuthentication 객체를 외부로 리턴하는 get 메서드 오버라이딩
	// => 주의! Getter 메서드 정의 시 변수명에 따라 메서드명이 달라질 수 있으므로 직접 정의하지 말 것!
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {

		return passwordAuthentication;
	}
	
	
	
	
	
	
	
	
	
}