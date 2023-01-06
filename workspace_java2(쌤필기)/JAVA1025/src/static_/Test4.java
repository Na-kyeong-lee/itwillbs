package static_;

class Road { // 북쪽도로 남쪽도로
	// 도로 교통상황 정보
	int[] arr = new int[10];
	
	// 생성자
	public Road(int...nums) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = nums[i];
		}
	}
	
	// 도로정보를 출력하는 roadInfo()
	public void roadInfo() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// 정수형 index 2개를 전달받아
	// 시작index ~ 끝index(끝 포함) 까지 합을 리턴하는 sum() 메서드 정의
	public int sum(int start, int end) {
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += arr[i];
		}
		return sum;
	}
}

class Bridge {
	int index;
	int total;
	
	public Bridge(int index) {
		this.index = index;
	}
	
	// 다리정보를 출력하는 bridgeInfo()
	public void bridgeInfo() {
		System.out.println("다리번호: " + index);
		System.out.println("최소시간: " + total);
	}
	
	// 다리배열(Bridge[])을 전달받아 total 값이 가장작은 
	// 다리(Bridge)를 리턴하는 min() 메서드 정의
	public static Bridge min(Bridge[] bridges) {
		Bridge min = bridges[0];
		for(int i=1; i < bridges.length; i++) {
//			min = total[i] > min ? min : total[i];
			if(min.total > bridges[i].total) {
				min = bridges[i];
			}
		}
		return min;
	}
}


public class Test4 {

	public static void main(String[] args) {
		/*
		 * 도로 교통상황이 숫자로 주어진다.
		 * 
		 * 출발 70 80 60 20 30 50 10 80 77 89
		 * 			 ||	   ||	 ||
		 * 	   70 60 40 50 55 65 23 44 37 88 도착
		 * 
		 * 북쪽도로에서 남쪽도로로 건널수 있는 다리는 index번호로 주어진다.
		 * 이때, 가장 최소시간이 소요되는 다리는 몇번 다리인지 출력하고 최소시간을 함께 출력!
		 * 
		 * 출력예시) 다리번호: 6
		 * 		   최소시간: 512
		 * 
		 * 주의사항.
		 * 1. 무조건 다리를 1번 건너야함 (도착지점이 남쪽이기 때문에)
		 * 2. 다리를 여러번 건널수 없고 딱, 한번만 가능
		 * 3. 다리를 건널때에는 남쪽, 북쪽 소요시간이 같이 소요됨. (즉, 같이 합산해야함)
		 * 4. 소요시간이 같은 경우가 발생하면 낮은 다리번호를 출력
		 * */
		Road north = new Road(70, 80, 60, 20, 30, 50, 10, 80, 77, 89);
		//							  ||      ||      ||
		Road south = new Road(70, 60, 40, 50, 55, 65, 23, 44, 37, 88);
		
		north.roadInfo();
		south.roadInfo();
		
//		Bridge b1 = new Bridge(2);
//		Bridge b2 = new Bridge(4);
//		Bridge b3 = new Bridge(6);
//		
//		b1.total = north.sum(0, b1.index) + south.sum(b1.index, south.arr.length - 1);
//		b1.bridgeInfo();
//		
//		b2.total = north.sum(0, b2.index) + south.sum(b2.index, 9);
//		b2.bridgeInfo();
//		
//		b3.total = north.sum(0, b3.index) + south.sum(b3.index, 9);
//		b3.bridgeInfo();
		
//		int[] arr = {10, 20, 30};
//		String[] strs = {"abc", "def", "ghi"};
//		Bridge[] bridges = { b1, b2, b3 };
		Bridge[] bridges = { new Bridge(2), new Bridge(4), new Bridge(6) };
		
		for(int i=0; i < bridges.length; i++) {
			bridges[i].total = north.sum(0, bridges[i].index) + south.sum(bridges[i].index, 9);
//			bridges[i].bridgeInfo();
		}
		
		Bridge minBridge = Bridge.min(bridges);
		minBridge.bridgeInfo();
		
		
		
	}

}
