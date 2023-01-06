package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * Stack 객체 1개 생성(stack)
		 * => 웹사이트 주소 4 ~ 5개 추가
		 * => 반복문 사용하여 Top 에서부터 하나씩 객체를 꺼내서 출력 후 제거 (pop())
		 * */
		Stack stack = new Stack();
		stack.push("1 - www.itwillbs.co.kr");
		stack.push("2 - www.naver.com");
		stack.push("3 - www.youtube.com");
		stack.push("4 - www.nate.com");
		stack.push("5 - www.google.com");
		
		// 추천!
		int count = stack.size();
		for(int i = 0; i < count; i++) {
			System.out.println(stack.pop()); 
		}
		
//		for(int i = stack.size(); i > 0; i--) {
//			System.out.println(stack.pop());
//		}
		
		// 추천!
//		while(stack.size() > 0) {
//			System.out.println(stack.pop());
////			if(stack.size() == 0) break;
//		}
		
		// 향상된 for문은 어울리지 않음
//		for(Object o : stack) {
//			System.out.println(stack.pop());
////			System.out.println(o);
//		}
//		System.out.println(stack);
		
		System.out.println("===================================");
		
		/*
		 * Queue 객체 1개 생성
		 * => 파일 4 ~ 5개 추가
		 * => 반복문을 사용하여 하나씩 객체를 꺼내서 출력 후 제거(poll())
		 * */
		Queue q = new LinkedList();
		
		q.offer("1 - Ex.java");
		q.offer("2 - main.jsp");
		q.offer("3 - a.txt");
		q.offer("4 - windows.jpg");
		q.offer("5 - talk.wav");
		
		// 일반적인 for문 (추천!)
//		int length = q.size();
//		for(int i = 0; i < length; i++) {
//			System.out.println(q.poll());
//		}
		
		// while문 (추천!)
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		// 향상된 for문
//		for(Object o : q) {
//			System.out.println(q.poll());
//		}
		
		// 향상된 for문은 원본데이터가 유지되면서
		// 요소 하나씩 꺼내서 어떠한 작업을 할때
		// 즉, 데이터를 읽기(read)만 할때 사용하면 좋다!
		
		
		
	}

}
