package util;

import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) {
		String data = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
		// 1. 각 항목별 분리(StringTokenizer 클래스 사용)
		// 2. 각 항목에서 실제 데이터를 분리하여 출력
		StringTokenizer st = new StringTokenizer(data, ",");
		
		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
			
			// 1. StringTokenizer 사용 시
			// [Address | 부산광역시 부산진구 동천로109]
//			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
//			st2.nextToken(); // Address, Floor, Tel 항목들은 그대로 내보내기
//			System.out.println(st2.nextToken());
			
//			String key = st2.nextToken();
//			String value = st2.nextToken();
//			System.out.println(key + " : " + value);
			
			// 2. String 클래스의 split() 메서드 사용시
			// Address:부산광역시 부산진구 동천로109
//			String str = st.nextToken();
//			String[] strArr = str.split(":");
//			System.out.println(strArr[1]);
			
			System.out.println(st.nextToken().split(":")[1]); 
		}
		
		System.out.println("=========================================");
		
//		String data = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
		StringTokenizer st2 = new StringTokenizer(data, ",:");
		
//		int index = 0;
//		while(st2.hasMoreTokens()) {
//			String str = st2.nextToken();
//			if(index % 2 == 1) System.out.println(str);
//			index++;
//			
////			if(index % 2 == 1) System.out.println(st2.nextToken());
////			index++;
//			
//		}
		
//		String data = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
//		while(st2.hasMoreTokens()) {
//			String str = st2.nextToken();
//			if(st2.countTokens() % 2 == 0) System.out.println(str);
//		}
		
		System.out.println("================================================");
		// 횟수를 알 수 있으므로 for문 활용
		int count = st2.countTokens();
		for(int i = 0; i < count; i++) {
			String str = st2.nextToken();
			if(i % 2 == 1) System.out.println(str);
		}
		
		System.out.println("===============================================");
		
//		String data = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
		String result = "";
//		String[] arr = data.split(",");
		for(String str : data.split(",")) {
			result += str.split(":")[1] + " "; 
		}
		System.out.println(result);
		
		
		
		
	}

}
