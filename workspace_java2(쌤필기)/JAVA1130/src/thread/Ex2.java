package thread;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 멀티 쓰레딩 (Multi Threading)
		 * - 하나의 프로세스 내에서 두 가지 이상의 작업을 동시에 처리하는 것
		 * - 실제로 두가지 이상의 작업을 동시에 수행하는 것이 아니며
		 *   CPU가 빠른 속도로 여러 작업을 번갈아가며 수행하기 때문에
		 *   동시에 수행하는 것처럼 느껴짐 = Round Robin 방식 이라고 함
		 * - 멀티쓰레딩으로 처리되는 작업 순서는 고정이 아닌 계속 바뀌므로
		 *   항상 실행결과가 달라질 수 있다!  
		 * 
		 * < 멀티 쓰레딩 구현 방법 >
		 * 1. Thread 클래스를 상속 받는 서브클래스를 정의하는 방법
		 * 		1) 멀티쓰레딩 코드가 포함될 서브클래스에서 Thread 클래스를 상속
		 * 		2) Thread 클래스의 run() 메서드를 오버라이딩하여
		 * 			멀티쓰레딩으로 처리할 코드를 기술
		 * 		3) 멀티쓰레딩 클래스 인스턴스 생성
		 * 		4) start() 메서드를 호출하여 멀티쓰레딩 시작 
		 * 
		 * 2. Runnable 인터페이스를 구현하는 서브클래스를 정의하는 방법
		 * 
		 * */
		MyThread nt1 = new MyThread("★★A작업★★", 100000);
		MyThread nt2 = new MyThread("○○B작업○○", 100000);
		MyThread nt3 = new MyThread("◆◆C작업◆◆", 100000);
		
		// run() 메서드를 호출하면 멀티쓰레딩이 아닌 싱글쓰레딩으로 처리되므로 주의!
//		nt1.run();
//		nt2.run();
//		nt3.run();
		
		nt1.start();
		nt2.start();
		nt3.start();
		
	}

}

class MyThread extends Thread {
	String str;
	int count;
	
	public MyThread(String str, int count) {
		this.str = str;
		this.count = count;
	}

	@Override
	public void run() {
		// 멀티쓰레딩으로 처리할 코드를 기술
		for(int i=1; i <= count; i++) {
			System.out.println(i + " : " + str);
		}
	}
	
}



