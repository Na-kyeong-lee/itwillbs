package io;

import java.io.IOException;
import java.io.InputStream;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 키보드로 부터 데이터를 입력받아 처리하는 방법
		 * 2. InputStream 객체를 사용하여 1Byte 단위로 입력 데이터를 처리하지 않고
		 *    배열을 사용하여 한번에 여러 Byte를 모아서 처리하는 방법
		 *    	- read(byte[] b) 메서드를 호출하여 입력데이터를 배열크기만큼 읽어와서 저장
		 *    	- 아무리 많은 데이터가 입력되어도 배열 크기만큼만 다룰 수 있기 때문에
		 *    	  더 많은 데이터나 더 큰 단위 처리가 불가능
		 * */
		System.out.println("데이터를 입력하세요.");
		
		try(InputStream is = System.in){
			// 1Byte 씩 묶음으로 처리할 byte[] 배열을 생성
			byte[] bArr = new byte[20]; // 10Byte 단위로 묶을 경우
			
			// 배열에 저장된 데이터 크기(읽어들인 바이트 수)를 리턴
			int n = is.read(bArr);
			System.out.println("입력 데이터 크기: " + n + "바이트");
			
			// 반복을 사용하여 배열 (b)에 저장된 데이터를 출력
//			for(byte b : bArr) {
//				System.out.println("입력 데이터: " + b + ", 문자로 변환: " + (char)b);
//			}
			
			// String 클래스를 활용하면 byte[] 배열 데이터를 문자열로 변환 가능
			String str = new String(bArr);
			System.out.println(str);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
