//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Scanner;
import java.util.*;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * import 문
		 * - 특정 패키지 또는 패키지 내의 클래스를 현재 클래스 내에 포함시키는 키워드
		 * - 자신과 동일한 패키지에 존재하는 클래스가 아닌 다른 패키지의 클래스는
		 *   직접 이름만으로 접근이 불가능하며, 반드시 패키지명을 포함하여 지정해야함
		 *   => 원래 클래스명을 지정할 때 패키지명.클래스명 형태로 지정해야하지만
		 *      패키지명을 생략하고 싶은 경우 해당 패키지명을 import문으로 등록 시키면
		 *      해당 패키지명을 생략하고 클래스명만으로 사용 가능해짐
		 * - package문과 달리 여러번 사용할 수 있으며
		 *   pakcage문 아래쪽, 다른 코드들보다 윗쪽에 위치해야함
		 *   (= package문을 제외하면 가장 윗쪽 라인에 위치해야함)
		 * - 클래스명 지정 시 자동완성 기능을 사용하여 import문을 자동 생성하거나  
		 *   단축키를 사용하여 import문을 자동 생성 가능 (Ctrl + Shift + O)
		 *   => 동일한 이름의 클래스가 여러 패키지에 존재할 경우 선책창 표시됨     
		 * 
		 * */
		
		// String 클래스 사용방법
		String s1 = "홍길동"; // 클래스명만으로 사용했었음
		
		// 정상적인 String 클래스 사용 방법 -> java.lang 패키지명을 포함하여 기술함
		java.lang.String s2 = "홍길동";
		// => String 클래스가 포함된 java.lang 패키지는 기본적으로 포함된 패키지이므로
		//    패키지명을 생략한 채 클래스 명만으로 객체 사용 가능하다!
		
		// java.util 패키지의 Random 클래스 인스턴스 생성
//		Random r = new Random(); // 패키지명을 포함하지 않을 경우 클래스를 찾지 못하므로
		// 존재하지 않는 클래스 지정으로 인한 오류 발생!
		
		// 패키지명을 포함하여 클래스 지정해야함
		java.util.Random r = new java.util.Random();
		
		Scanner sc = new Scanner(System.in);
		
		// java.util 패키지의 Date 클래스에 접근하려면
		// 기본적으로 java.util.Date 형식으로 지정해야하지만
		// import문을 통해 java.util 패키지의 Date 클래스를 지정하면
		// 패키지명 없이 Date 클래스 이름만으로 사용 가능해짐
		Date d = new Date();
		ArrayList list;
		// 특정 패키지 내의 모든 클래스파일을 import 하려면
		// 패키지명.클래스명 대신 패키지명.* 형식으로 지정
		// ex) java.io 패키지의 모든 클래스를 import 하는 경우
		//     import java.io.*;
		
//		Person p;
//		Consumer c;
//		java.util.function.Consumer
		
		// Date 클래스를 둘다 쓰고싶은경우 (sql, util)
		// 기존의 import 구문을 통해 java.util.Date 클래스가 포함되어 있는 경우
		// 다른 패키지인 java.sql.Date 클래스를 사용하려면 import문 중복이 불가능하므로
		// 패키지명을 포함하여 클래스명을 지정해야한다!
		java.sql.Date date;
		
	}

}
