package thread;

public class Ex1 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 10; i++) {
					System.out.println("A작업");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 10; i++) {
					System.out.println("B작업");
				}
			}
		});
		
		t1.start();
		t2.start();
		
		System.out.println("현재 쓰레드명 : " + Thread.currentThread().getName());
		System.out.println("t1 쓰레드명: " + t1.getName());
		System.out.println("t2 쓰레드명: " + t2.getName());
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i <= 10; i++) {
					Thread t = Thread.currentThread();
					System.out.println("C작업 현재 쓰레드명: " + t.getName());
				}
			}
		});
		t3.setName("t3 쓰레드");
		t3.start();
		System.out.println("t3.getName() : " + t3.getName());
		
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i <= 10; i++) {
					Thread t = Thread.currentThread();
					System.out.println("D작업 현재쓰레드: " + t.getName());
				}
			}
		}, "t4 쓰레드");
		t4.start();
		
		// 람다식
		Thread t5 = new Thread(() -> {
			for(int i=1; i <= 10; i++) {
				Thread t = Thread.currentThread();
				System.out.println("E작업 현재쓰레드: " + t.getName());
			}
		}, "t5 쓰레드");
		t5.start();

		System.out.println("===============================");
		
		MyThread mt = new MyThread("<<< 내 쓰레드 >>>" ,10);
		mt.start();
	}
}
class MyThread extends Thread {
	int count;

	public MyThread(String threadName , int count) {
//		super.name = threadName; // name 멤버변수가 private 이기때문에 접근 불가
		
//		super();
//		setName(threadName);
		
		super(threadName);
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 1; i < count; i++) {
			System.out.println(i + " : " + getName());
		}
	}
	
}











