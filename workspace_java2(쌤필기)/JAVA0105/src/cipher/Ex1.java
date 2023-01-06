package cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Ex1 {

	public static void main(String[] args) {
		// MyMessageDigest 객체 생성
		// => 단방향 해싱 함수 : "MD5", "SHA-1", "SHA-256", "SHA-512" 등 실제 함수명을 정확히 전달
		String hashAlgorithm = "SHA-256";
		MyMessageDigest md = new MyMessageDigest(hashAlgorithm, "1234");
		
		// 암호화 된 암호문을 리턴받아 출력
		String myData = md.getHashedData();
		System.out.println("암호화 결과 : " + myData);
		
		// ===================================================================
		// 만약, 위의 암호화 결과가 DB에 저장된 패스워드라고 가정했을 때
		// 새로 입력받은 패스워드를 passwd 변수에 저장 후 암호문과 비교하려면
		// 새 패스워드도 단방향 암호화를 수행한 후 암호화 된 DB 패스워드와 비교해야함
		String passwd = "1233";
		MyMessageDigest md2 = new MyMessageDigest(hashAlgorithm, passwd);
		String hashedPasswd = md2.getHashedData();
		
		// 두 암호문을 비교하여 같으면 "패스워드 일치", 아니면 "패스워드 불일치" 출력
		if(myData.equals(hashedPasswd)) {
			System.out.println("패스워드 일치!");
		} else {
			System.out.println("패스워드 불일치!");
		}
		
		
		
	}

}


// 단방향 암호화(= 해싱)를 수행할 클래스 정의
class MyMessageDigest {
	private String strSourceData = "";	// 평문 저장 변수
	private String strHashedData = "";	// 암호문 저장 변수
	
	// 파라미터 생성자 정의
	// => 파라미터 : 암호화 알고리즘명, 평문 데이터
	public MyMessageDigest(String hashAlgorithm, String strSourceData) {
		// 해싱 작업을 수행하는 hashing() 메서드 호출
		hashing(hashAlgorithm, strSourceData);
	}
	
	// 해싱(= 단방향 암호화) 작업을 수행하는 hashing() 메서드 정의
	// => 파라미터 : 암호화 알고리즘명, 평문 데이터
	public void hashing(String hashAlgorithm, String strSourceData) {
//		System.out.println("알고리즘 : " + hashAlgorithm);
//		System.out.println("평문 : " + strSourceData);
		try {
			// java.security.MessageDigest 클래스의 static 메서드 getInstance() 메서드 호출하여
			// MessageDigest 객체 리턴 받기 => 파라미터로 암호화 알고리즘(해싱 함수) 이름 전달
			// => 주의! 알고리즘 이름이 틀렷을 경우 NoSuchAlgorithmException 발생
			MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
			System.out.println(md.getAlgorithm() + " : 해당 알고리즘은 존재합니다!");
			
			// 평문 문자열이 저장된 String 객체의 getBytes() 메서드를 호출하여
			// 평문 문자열을 byte[] 타입으로 변환
			byte[] byteData = strSourceData.getBytes();
			System.out.println("평문 데이터(배열) : " + Arrays.toString(byteData));
			
			// MessageDigest 객체의 update() 메서드를 호출하여 byte[] 배열 타입 평문 전달
			md.update(byteData);
			
			// MessageDigest 객체의 digest() 메서드를 호출하여 평문을 암호문으로 변환(= 해싱)
			// => 해싱 결과값(= 암호문)이 byte[] 타입으로 리턴(기본 32byte 짜리 암호문 생성됨)
			byte[] digestResult = md.digest();
			System.out.println("암호문 데이터(배열) : " + Arrays.toString(digestResult));
			System.out.println("암호문 배열 길이 : " + digestResult.length);
			
			// for문을 사용하여 암호문 배열 크기만큼 반복
			for(int i = 0; i < digestResult.length; i++) {
				// int 타입 기준으로 음수데이터 -> 양수로 변환한 후
				// 16진수 문자열 대문자로 변환하여 strHashedData에 문자열 결합
//				System.out.print((digestResult[i] & 0xFF) + ", ");
				strHashedData += Integer.toHexString((digestResult[i] & 0xFF)).toUpperCase(); 
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("해당 암호화 알고리즘이 존재하지 않습니다.");
			e.printStackTrace();
		}
		
	}
	
	// 암호화 된 암호문을 리턴하는 getHashedData() 메서드 정의
	public String getHashedData() {
		return strHashedData;
	}
	
	
}









