/*
 * Template file for Assignment Binary Search 
 * Author: Caogang Shen
 * Period: 7th Period
 */
public class BinarySearch {

	public static void main(String[] args) {
		// sample tests
		// test for binarySearch()
		int[] inputArray1 = {1, 2, 3, 4, 5};
		int result1 = binarySearch(inputArray1, 3);
		System.out.println("result1: " + result1); // expect 2
		
		int result2 = binarySearch(inputArray1, 6);
		System.out.println("result2: " + result2); // expect -1
		
		int[] inputArray2 = {1, 2, 2, 2, 3, 4};
		int result3 = binarySearch(inputArray2, 2);
		System.out.println("result3: " + result3); // expect 1 or 2 or 3
		
		// test(s) for searchInMatrix()
		
		// test(s) for closest()
		
		// test(s) for firstOccur()
		

	}
	
	//Practice #1 Classical Binary Search
	public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int mid = (array.length - 1) / 2;
        int low = 0;
        int high = array.length - 1;
        while (array[mid] != target) {
            if (array[mid] < target) { // the target
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (low > high) {
                return -1;
            }
            mid = (low + high) / 2;
        }
        return mid;
	}
	
	//Practice #2 Classical Binary Search in 2D Space
	public static int[] searchInMatrix(int[][] matrix, int target) {
		return null;
	}
	
	//Practice #3 Closest In Sorted Array
	public static int closest(int[] array, int target) {
		return 0;
		
	}
	
	//Practice #4 First Occurrence
	public static int firstOccur(int[] array, int target) {
		return 0;
	}

}
