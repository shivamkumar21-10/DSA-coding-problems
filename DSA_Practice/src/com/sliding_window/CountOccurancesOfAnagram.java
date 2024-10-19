package com.sliding_window;

import java.util.HashMap;

public class CountOccurancesOfAnagram {
	
	static int countAnagram(String s, String ptr) {
		int i=0;
		int j=0;
		int ans  = 0;
		
		HashMap<Character,Integer> map = new  HashMap<>();
		for(int k=0; k<ptr.length(); k++) {
			map.put(ptr.charAt(k), map.getOrDefault(ptr.charAt(k), 0) + 1);
		}
		int cnt = map.size();
		
		while(j<s.length()) {
			if(map.containsKey(s.charAt(j))) {
				map.put(s.charAt(j), map.get(s.charAt(j))-1);
				if(map.get(s.charAt(j)) == 0) {
					cnt--;
				}
			}
			
			if(j+1 >= ptr.length()) {
				if(cnt == 0) {
					ans++;
				}
				if(map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), map.get(s.charAt(i))+1);
					if(map.get(s.charAt(i)) == 1) {
						cnt++;
					}
				}
				i++;	
			}
			j++;
			
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAnagram("aabaabaa", "aaba"));
	}

}
