package ex05_09;

import java.util.ArrayList;

public class Ex7 {

	public static void main(String[] args) {
		// 230p
		
		// Q1) 정답: 같은
		// 배열은 XXX 자료형을 순서대로 관리할때 사용하는 자료구조 입니다.
		
		// Q3)
		// 배열의 길이가 5인 정수형 배열을 선언하고,
		// 1 ~ 10 중 짝수만을 배열에 저장한 후 그 합을 출력하세요.
		int[] nums = new int[5];
		
		int index = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) { // 짝수면
				nums[index] = i;
				index++;
			}
		}
		
		int total = 0;
		for(int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		System.out.println(total);
		
		// Q4) 정답
		System.out.println("========================");
//		int[] arr 		= new int[5];
//		String[] strs 	= new String[5];
//		Dog[] dogs = { new Dog("뽀삐", "시추"), new Dog("배추", "푸들") };
		Dog[] dogs 		= new Dog[5];
		dogs[0] = new Dog("뽀삐", "시추");
		dogs[1] = new Dog("배추", "푸들");
		dogs[2] = new Dog("토토", "말티즈");
		dogs[3] = new Dog("누렁이", "진돗개");
		dogs[4] = new Dog("똥개", "잡종");
		
		for(int i = 0; i < dogs.length; i++) {
//			String str = dogs[i].showDogInfo(); 
//			System.out.println(str);
			System.out.println(dogs[i].showDogInfo());
		}
		
//		for(int i = 0; i < dogs.length; i++) {
//			Dog dog = dogs[i];
//		}
		// 향상된 for문 version
		for(Dog dog : dogs) {
			System.out.println(dog.showDogInfo()); 
		}
		
		// Q5)
		// ArrayList를 활용하여 위로직을 구현
		ArrayList<Dog> arr = new ArrayList<Dog>();
		arr.add(new Dog("뽀삐", "시추"));
		arr.add(new Dog("배추", "푸들"));
		arr.add(new Dog("토토", "말티즈"));
		arr.add(new Dog("누렁이", "진돗개"));
		arr.add(new Dog("똥개", "잡종"));
		
		// 일반 for문
		for(int i = 0; i < arr.size(); i++) {
//			Dog dog = arr.get(i);
//			System.out.println(dog.showDogInfo());
			System.out.println(arr.get(i).showDogInfo());
		}
		
		// 향상된 for문
		for(Dog dog : arr) {
			System.out.println(dog.showDogInfo());
		}
		
	}
}


// Q4)
// 다음과 같이 Dog 클래스가 있습니다.
// 배열 길이가 5인 Dog[] 배열을 만든 후 Dog 인스턴스를 5개 생성하여
// 배열에 추가합니다. for문과 향상된 for문에서 Dog 클래스의
// showDogInfo() 메서드를 사용하여 배열에 추가한 Dog 정보를 모두 출력하세요.
// < 출력 예시 >
// 뽀삐, 시추
// 배추, 푸들
// 토토, 말티즈
// 누렁이, 진돗개
// 똥개, 잡종
class Dog {
	private String name;
	private String type;
	
	// Alt + Shift + S -> O
	public Dog(String name, String type) {
		this.name = name;
		this.type = type;
	}

	// Alt + Shift + S -> R
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String showDogInfo() {
		return name + ", " + type;
	}
}



















