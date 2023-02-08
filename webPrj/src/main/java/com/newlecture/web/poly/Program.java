package com.newlecture.web.poly;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	
	public static void main(String args[]) {
		
		List list = new ArrayList();
		
//		list.add("3");
//		list.add("5");
//		list.add("15");
//		list.add(3);
//		list.add(5);
//		list.add(15);
		
		list.add(new Exam(1,3,2));
		list.add(new Exam(10,30,20));
		list.add(new Exam(60,50,40));
		list.add(new Exam(3,4,5));
		
		//양수냐 0이냐 음수이냐
		list.sort((x, y)-> ((Exam)x).getEng() - ((Exam)y).getEng());
		System.out.println(list);
		
		// 인터페이스를 구현하기 위해서 계속 클래스를 생성하는 것이 부담스러워 지면서 람다함수가 사용되게 되었다.
		
		// 따로 클래스 파일을 만들 필요 없이 인터페이스 사용한 클래스 한에서만 함수 안에서 선언 가능
		class AAA implements Banner{

			@Override
			public void print() {
				// TODO Auto-generated method stub
				
			}
			
		}
		// 익명 클래스 : 클래스 자체도 선언을 안하면 어떨까
		Banner banner1 = new Banner() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("     ICT교육센터");
			}
			
		};
		
		// 더 줄여. 람다로. 함수의 형태만. 구현해야 할 함수가 1개일때
		ExamConsole.printIntro(()->{
			System.out.println("     LamdaICT교육센터");
		});
		
		
//		Exam.printIntro(new AAA());
	}
}
