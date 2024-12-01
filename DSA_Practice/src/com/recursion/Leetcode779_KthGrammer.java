package com.recursion;

public class Leetcode779_KthGrammer {
	
	public static int kthGrammar(int n, int k) {
	    // Base case: If we are at the first row (n == 1) and first position (k == 1),
	    // the value is always 0 as per the problem definition.
	    if (n == 1 && k == 1) {
	        return 0;
	    }

	    // Calculate the middle index of the current row.
	    // The length of the nth row is 2^(n-1), and mid is half of that.
	    int mid = (int) Math.pow(2, n - 1) / 2;

	    // If k is in the first half of the row (k <= mid), the value is the same as
	    // the value at the same position in the previous row (n-1).
	    if (k <= mid) {
	        return kthGrammar(n - 1, k);
	    }
	    // If k is in the second half of the row (k > mid), the value is the complement
	    // (0 becomes 1, 1 becomes 0) of the value at the position (k-mid) in the previous row.
	    else {
	        return kthGrammar(n - 1, k - mid) == 1 ? 0 : 1;
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = kthGrammar(2, 2);
		System.out.println(ans);

	}

}
