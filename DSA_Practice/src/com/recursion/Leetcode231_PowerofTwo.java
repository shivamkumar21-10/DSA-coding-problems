package com.recursion;

public class Leetcode231_PowerofTwo {
	
    public static boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        if(n<=0){
            return false;
        }

        return n%2 ==0 && isPowerOfTwo(n/2);

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(16));

	}

}
