package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex8 {

	public static void main(String[] args) {
		/*
		 * 자바의 기본 데이터 입출력
		 * - DataInputStream, DataOutputStream 사용
		 * - 자바의 기본데이터타입 8가지 + 문자열(String) 타입 처리 가능
		 *   => readXXX(), writeXXX() 메서드 사용하며 XXX은 기본데이터타입의 이름 사용
		 *      ex) int형 데이터 출력시 : writeInt()
		 *      	double형 데이터 입력 시 : readDouble()
		 *   => 주의! String 타입 XXX 부분에 String 대신 UTF 사용
		 *   	ex) readString() (X) -> readUTF() (O)   
		 * */
		
		// 자바 기본 데이터를 파일로 출력하기
		// 1. FileOutputStream 객체를 생성하여 출력할 파일 위치 및 파일명 지정
//		FileOutputStream fos = new FileOutputStream("C:\\temp\\data.txt");
		// 2. DataOutputStream 객체를 생성하여 FileOutputStream 객체를 전달
//		DataOutputStream dos = new DataOutputStream(fos);
		
//		try (FileOutputStream fos = new FileOutputStream("C:\\temp\\data.txt");
//			 DataOutputStream dos = new DataOutputStream(fos)){
//			
//			// DataOutputStream 객체를 통해 출력되는 데이터는
//			// C 드라이브 temp 폴더 내의 data.txt 파일에 출력됨
//			// dos.writeXXX() 메서드를 호출하여 기본데이터 출력하기
//			dos.writeInt(100);
//			dos.writeDouble(3.14);
//			dos.writeUTF("홍길동");
//			
//		} catch (FileNotFoundException e) {
//			// FileOutputStream 에서 지정한 경로가 존재하지 않을 경우 예외 발생
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("=========================================");
		
		// 파일에 출력된 자바 기본데이터를 읽어와서 화면에 출력하기
		try(DataInputStream dis = new DataInputStream(
				new FileInputStream("C:\\temp\\data.txt"))){
			
			// dis.readXXX() 메서드 호출하여 데이터 읽어오기
			// 읽어들일 데이터는 반드시 출력된 데이터 순으로 읽어야 한다!
			// => 출력 순서: int -> double -> String 이므로, 입력순서도 동일해야함
			// => 순서가 바뀔 경우 EOFException 예외가 발생하므로 주의!
			int num = dis.readInt();
			double dNum = dis.readDouble();
			String str = dis.readUTF();
			
			// 입력받은 데이터 출력
			System.out.println(num);
			System.out.println(dNum);
			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			// 읽어들일파일이 존재하지 않거나 경로가 존재하지 않을 경우 예외 발생
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
