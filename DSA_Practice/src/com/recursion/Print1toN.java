package com.recursion;

public class Print1toN {
	
	public static void print1ton(int n) {
//		System.out.println(n);
		if(n == 0) {
			return;
		}
		
		
		print1ton(n-1);
		System.out.println(n);
	}
	public static void printnto1(int n) {
//		System.out.println(n);
		if(n == 0) {
			return;
		}
		
		System.out.println(n);
		printnto1(n-1);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print1ton(5);
		System.out.println("-------------------------------------");
		printnto1(5);
	}

}
