package com.newlecture.web.entity;

// 콜렉션 리스트는 가변길이 배열이라 고정길이 배열에 비해 속도가 느릴 수 있으나
// 가변적이라는 장점 하나로 모든 단점을 상쇄한다.

public class NList {
	// List 콜렉션 직접 만들어보기
	
	private Object[] data;
	private int index;
	private int max;
	
	// 초기 콜렉션 선언시 (맥스값이 3인 배열을 만듦)
	public NList() {
		index = 0;
		max = 3;
		data = new Object[max];
	}
	
	// 데이터를 넣을 때 이 함수를 실행시켜주는데 늘어나는 값이 정해져있으면 고정배열을 가지고 배열 크기를 늘리고 있기때문에
	// max값을 두고 index가 max값을 찍을때 max+3 길이인 배열을 만들고 전에참조하던 공간의 내용을 옮겨담아 다시 그 배열을
	// 참조하게 만드는 식으로 늘린다.
	public void add(Object n) {
		
		if(index == max) {
			Object[] temp = new Object[max+3];
			for(int i=0; i<max; i++)
				temp[i] = data[i];
			
			data = temp;
			max = max+3;
		}
		data[index] = n;
		index++;
	}
	
	// 콜렉션 리스트 값 가져오는 것.
	public Object get(int idx) {
		return data[idx];
	}
	
	// 지금 현제 콜렉션 안에 몇개의 데이터가 쌓여있는지 불러오는 함수
	public int size() {
		return index;
	}
}
