package lang;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 주민등록번호(jumin)를 문자열로 입력받아 성별(남 또는 여) 판별
		 * 입력 형식 : "XXXXXX-XXXXXXX"
		 * 판별 조건 
		 * 1) 뒷자리 첫번째 숫자가 1 또는 3 : "남성" 출력
		 * 2) 뒷자리 첫번째 숫자가 2 또는 4 : "여성" 출력
		 * 3) 뒷자리 첫번째 숫자가 5 또는 6 : "외국인" 출력
		 * */
		String jumin = "901111-5122333";
//		int index = jumin.indexOf('-') + 1;
//		char ch = jumin.charAt(index);
		
//		String[] arr = jumin.split("-");
//		char ch = arr[1].charAt(0);

		char ch = jumin.split("-")[1].charAt(0);
		
		if(ch == '1' || ch == '3') {
			System.out.println("남성");
		} else if(ch == '2' || ch == '4') {
			System.out.println("여성");
		} else if(ch == '5' || ch == '6') {
			System.out.println("외국인");
		} else {
			System.out.println("괴물");
		}

		System.out.println("=========================================");
		
		// 주소부분만 출력 (부산광역시 부산진수 동천로:109)
		String data1 = "Address:부산광역시 부산진수 동천로:109";
		System.out.println(data1.substring(data1.indexOf(":") + 1)); 
		
		// 이름 부분만 출력 (홍길동)
		String data2 = "이름: 홍길동, 나이: 20";
		System.out.println(data2.substring(4, 7));
		System.out.println(data2.substring(data2.indexOf(":") + 1, data2.indexOf(",")).trim());
		System.out.println(data2.split(",")[0].split(":")[1].trim());
		
		// 주소부분만 출력 (서울특별시 용산구 24번길, 210동 702호)
		String data3 = "Address:서울특별시 용산구 24번길, 210동 702호,Tel:0518030909";
		int begin = data3.indexOf(":") + 1;
		int end = data3.lastIndexOf(",");
		System.out.println(data3.substring(begin, end));
		
		// 필요한 데이터만 추출
		// 부산광역시 부산진구 동천로109
		// 7층
		// 051-803-0909
		String data4 = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
//		String[] data = data4.split(",");
//		for(String str : data) {
//			String[] arr = str.split(":");
//			System.out.println(arr[1]); 
//		}
		
		for(String str : data4.split(",")) {
			System.out.println(str.split(":")[1].replace("-", "").trim()); 
		}
		
		
				
				
				
				
		
	}

}
