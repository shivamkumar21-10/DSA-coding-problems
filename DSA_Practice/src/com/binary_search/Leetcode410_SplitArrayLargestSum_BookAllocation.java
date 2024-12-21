package com.binary_search;

import java.util.Arrays;

public class Leetcode410_SplitArrayLargestSum_BookAllocation {

	/**
	 * Helper function to determine the number of students required to allocate
	 * books such that no student gets more than `mid` pages.
	 *
	 * @param nums Array of integers representing the number of pages in each book.
	 * @param mid  Maximum number of pages a student is allowed to read.
	 * @return The number of students required to satisfy this condition.
	 */
	public int isPossible(int nums[], int mid) {
		// Initialize the count of students required.
		int student = 1; // Start with one student.
		int sum = 0; // This will hold the sum of pages allocated to the current student.

		// Iterate through the array to allocate books.
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i]; // Add the current book's pages to the sum.

			// If the sum exceeds the allowed `mid` pages:
			if (sum > mid) {
				student++; // Allocate the next student.
				sum = nums[i]; // Reset the sum to the current book's pages (new student starts here).
			}
		}

		// Return the total number of students required for this allocation strategy.
		return student;
	}

	/**
	 * Function to find the minimum number of pages that can be allocated to a
	 * student such that no student reads more than that number, and the books are
	 * divided among `m` students.
	 *
	 * @param nums Array of integers representing the number of pages in each book.
	 * @param m    The number of students among whom the books need to be divided.
	 * @return The minimum number of pages that satisfies the condition, or -1 if
	 *         allocation is not possible.
	 */
	public int findPages(int[] nums, int m) {
		// **Base Case**: If there are more students than books, allocation is
		// impossible.
		if (m > nums.length)
			return -1;

		// **Low and High Boundaries for Binary Search**:
		// Low: The maximum number of pages in any single book (as no student can read
		// fewer than this).
		int low = Arrays.stream(nums).max().getAsInt();

		// High: The total number of pages in all books (in the worst case, one student
		// gets all books).
		int high = 0;
		for (int i = 0; i < nums.length; i++) {
			high += nums[i];
		}

		// Variable to store the final answer (minimum of the maximum pages).
		int ans = -1;

		// **Binary Search**:
		// The goal is to minimize the maximum pages a student has to read.
		while (low <= high) {
			int mid = (low + high) / 2; // Calculate the midpoint of the current search range.

			/**
			 * Check if it is possible to allocate books such that no student reads more
			 * than `mid` pages: - Use the `isPossible` function to determine the required
			 * number of students for this allocation. - If the number of required students
			 * is greater than `m`, it means `mid` is too small, and we need to search in
			 * the higher range (`low = mid + 1`). - Otherwise, update the answer to `mid`
			 * and search for a potentially smaller maximum in the lower range (`high = mid
			 * - 1`).
			 */
			if (isPossible(nums, mid) > m) {
				// Too many students required, so increase the maximum allowed pages.
				low = mid + 1;
			} else {
				// Fewer or equal students required, so this is a valid allocation.
				ans = mid; // Update the answer to the current midpoint.
				high = mid - 1; // Try to find a smaller valid allocation by searching the left half.
			}
		}

		// Return the minimum number of pages found for the optimal allocation.
		return ans;
	}
}
