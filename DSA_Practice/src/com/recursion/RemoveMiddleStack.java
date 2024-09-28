package com.recursion;

import java.util.Stack;

public class RemoveMiddleStack {
	
	public static void remove(Stack<Integer> s, int k) {
		
		if(k==1) {
			s.pop();
			return;
		}
		int temp = s.pop();
		remove(s,k-1);
		s.push(temp);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		
		int k = s.size()/2 + 1;
		remove(s, k);
		
		System.out.println(s);
	}

}
