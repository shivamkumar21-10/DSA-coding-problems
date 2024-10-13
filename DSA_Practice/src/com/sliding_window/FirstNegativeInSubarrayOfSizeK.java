package com.sliding_window;

import java.util.*;

public class FirstNegativeInSubarrayOfSizeK {
	
	static void printNegative(int[] arr, int k) {
		int i=0; 
		int j=0;
		List<Integer> lst = new ArrayList<>();
		
		
		while(j<arr.length) {
			lst.add(arr[j]);
			if(j-i+1 < k) {
				j++;
			}
			else if(j-i+1 == k){
				for(int p=0; p<k; p++) {
					if(lst.get(p) < 0) {
						System.out.println("Window " + lst + "  "+lst.get(p));
						break;
					}
				}
				lst.remove(Integer.valueOf(arr[i]));
				i++;
				j++;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {12,-1,-7,8,-15,30,16,28,-9};
		printNegative(arr,3);
	}

}
