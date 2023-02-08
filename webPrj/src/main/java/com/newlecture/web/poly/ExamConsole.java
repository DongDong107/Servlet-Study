package com.newlecture.web.poly;

public class ExamConsole {
	static void printIntro(Banner banner) {
		System.out.println("┌────────────────────────┐");
		// 특정 교육센터 이름이 들어간 부분을 분리하자.
		banner.print();		
		
		System.out.println("메인 메뉴 항목들...");
	}
}
