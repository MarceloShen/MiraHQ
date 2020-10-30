/*
 * Binary Search HW
 * Author: Eashver Elango
 * Period: 7
 */

import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		// sample tests
		// test for binarySearch()
		int[] inputArray1 = {1, 2, 3, 4, 5};
		int result1 = binarySearch(inputArray1, 2);
		System.out.println("result1: " + result1); // expect 1
		
		int result2 = binarySearch(inputArray1, 6);
		System.out.println("result2: " + result2); // expect -1
		
		int[] inputArray2 = {1, 2, 2, 2, 3, 4};
		int result3 = binarySearch(inputArray2, 2);
		System.out.println("result3: " + result3); //expect 1, 2, or 3
		
		// test(s) for searchInMatrix()
		int[][] inputArray3 = {{1, 2, 3}, {4, 5, 7}, {8, 9, 10}};
		int[] result4 = searchInMatrix(inputArray3, 7);
		System.out.println("result4: " + Arrays.toString(result4)); // expect [1, 2]

		int[] result5 = searchInMatrix(inputArray3, 6);
		System.out.println("result5: " + Arrays.toString(result5)); // expect [-1,-1]

		// test(s) for closest()
		int[] inputArray4 = {1, 2, 3};
		int result6 = closest(inputArray4, 1);
		System.out.println("result6: " + result6); // expect 0

		int[] inputArray5 = {1, 4, 6};
		int result7 = closest(inputArray5, 3);
		System.out.println("result7: " + result7); // expect 1

		int result8 = closest(inputArray5, 5);
		System.out.println("result8: " + result8); // expect 1 or 2

		int[] inputArray6 = {1, 3, 3, 4};
		int result9 = closest(inputArray6, 2);
		System.out.println("result9: " + result9); // expect 0, 1, or 2
		
		// test(s) for firstOccur()
		int result10 = firstOccur(inputArray4, 2); // expect 1
		System.out.println("result10: " + result10);

		int result11 = firstOccur(inputArray4, 4); // expect -1
		System.out.println("result11: " + result11);

		int[] inputArray7 = {1, 2, 2, 2, 3};
		int result12 = firstOccur(inputArray7, 2);
		System.out.println("result12: " + result12); // expect 1
	}
	
	//Practice #1 Classical Binary Search
	public static int binarySearch(int[] array, int target) {
		// corner case if target is null or array is length 0
		if(array==null || array.length==0){
			return -1;
		}

		// O(n) = log(n)
		// Basically, we're doing the basic splitting of binary search and constricting 
		// the search space by half every time
		int low = 0;
		int high = array.length - 1;
		int mid;
		while(low <= high) {
			mid = low+(high-low)/2;
			if(array[mid] == target){
				return mid;
			} else if(target < array[mid]){
				high = mid - 1;
			} else if(target > array[mid]) {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//Practice #2 Classical Binary Search in 2D Space
	public static int[] searchInMatrix(int[][] matrix, int target) {
		// corner case if target is null or matrix dimensions are length 0
		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			return new int[] {-1, -1};
		}

		// Binary search for the row and then Binary search that row
		// O(n) = log(NM)
		int lowrow = 0, highrow = matrix.length - 1;
		int R = matrix[0].length - 1;
		while(lowrow<=highrow) {
			int mid = lowrow+(highrow-lowrow)/2;
			if(target >= matrix[mid][0] && target <= matrix[mid][R]){
				int loc = binarySearch(matrix[mid], target);
				if(loc == -1){
					return new int[] {-1, -1};
				} else{
					return new int[] {mid, loc};
				}
			} else if(target < matrix[mid][0]){
				highrow = mid - 1;
			} else if(target > matrix[mid][R]) {
				lowrow = mid + 1;
			}
		}
		return new int[] {-1, -1};
	}
	
	//Practice #3 Closest In Sorted Array
	public static int closest(int[] array, int target) {
		// corner case if target is null or array is length 0
		if(array==null || array.length==0){
			return -1;
		}

		// Find the two the values that are the closest and 
		// then check which one is closer, return that index
		// O(n) = log(n)
		int low=0, high=array.length-1;
		while(low <= high){
			int mid=low+(high-low)/2;
			if(array[mid] <= target){
				low=mid+1;
			} else {
				high = mid-1;
			}
		}
		int left=Math.abs(array[low]-target);
		int right=Math.abs(array[high]-target);
		return Math.min(left, right);
	}
	
	//Practice #4 First Occurrence
	public static int firstOccur(int[] array, int target) {
		// corner case if target is null or array is length 0
		if(array==null || array.length==0){
			return -1;
		}

		// Do Binary search except when you find the value
		// restrict the upper bound of the search by one everytime
		// This will automatically find the earliest index of the 
		// target and we return that.
		// O(n) = log(n)
		int low=0, high=array.length-1,return_val=-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(array[mid] == target){
				return_val = mid;
				high = mid-1;
			} else if(target < array[mid]){
				high = mid-1;
			} else {
				low = mid + 1;
			}
		}
		return return_val;
	}
}
