package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
	
	public static int solve(List<Integer> a, int index, int k) {
		
		if(a.size() == 1) {
			System.out.println(a.get(0));
			return a.get(0);
		}
		index = (index+k)%a.size();
		a.remove(index);
		solve(a, index,k);
		return a.get(0);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=40;
		int k=7;
		List<Integer> a = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			a.add(i);
		}
		
		System.out.println(solve(a,1,k-1));

	}

}
