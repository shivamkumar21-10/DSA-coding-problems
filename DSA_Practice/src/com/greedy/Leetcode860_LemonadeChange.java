package com.greedy;

public class Leetcode860_LemonadeChange {
	

	    public boolean lemonadeChange(int[] bills) {
	        // Variables to track the number of $5 and $10 bills we have
	        int five = 0;
	        int ten = 0;

	        // Loop through each customer's payment
	        for (int i = 0; i < bills.length; i++) {
	            // Case 1: The customer pays with a $5 bill
	            if (bills[i] == 5) {
	                // Increment the count of $5 bills as no change is needed
	                five++;
	            }

	            // Case 2: The customer pays with a $10 bill
	            else if (bills[i] == 10) {
	                // Check if we have a $5 bill to give as change
	                if (five >= 1) {
	                    // Give one $5 as change and add the $10 bill to our count
	                    five--;
	                    ten++;
	                } else {
	                    // If we don't have a $5 bill, we can't give change
	                    return false;
	                }
	            }

	            // Case 3: The customer pays with a $20 bill
	            else {
	                // Prioritize giving one $10 bill and one $5 bill as change
	                if (ten >= 1 && five >= 1) {
	                    ten--; // Use one $10 bill
	                    five--; // Use one $5 bill
	                }
	                // If we don't have a $10 bill, give three $5 bills as change
	                else if (five >= 3) {
	                    five -= 3; // Use three $5 bills
	                } 
	                // If we can't give the required change, return false
	                else {
	                    return false;
	                }
	            }
	        }
	        // If we successfully provide change to all customers, return true
	        return true;
	    }



}
