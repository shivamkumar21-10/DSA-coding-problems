package com.recursion;

public class Print1toN {
	
	public static void print(int n) {
//		System.out.println(n);
		if(n == 0) {
			return;
		}
		
		
		print(n-1);
		System.out.println(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print1toN.print(5);
	}

}
