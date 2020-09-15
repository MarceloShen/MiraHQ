/*
 * Template file for Assignment Binary Search 
 * Author: Caogang Shen
 * Period: 7th Period
 */
public class BinarySearch {

	public static void main(String[] args) {
		// sample tests
		// test for binarySearch()
		int[] inputArray1 = { 1, 2, 3, 4, 5 };
		int result1 = binarySearch(inputArray1, 3);
		System.out.println("result1: " + result1); // expect 2

		int result2 = binarySearch(inputArray1, 6);
		System.out.println("result2: " + result2); // expect -1

		int[] inputArray2 = { 1, 2, 2, 2, 3, 4 };
		int result3 = binarySearch(inputArray2, 2);
		System.out.println("result3: " + result3); // expect 1 or 2 or 3

		// test(s) for searchInMatrix()
		int[][] inputMatrix1 = { { 1, 2, 3 }, { 5, 7, 11 }, { 13, 17, 19 } };
		int[] resultMatrix1 = searchInMatrix(inputMatrix1, 11);
		System.out.println("resultMatrix1: " + resultMatrix1[0] + ", " + resultMatrix1[1]);
		// test(s) for closest()
		int[] inputClosest1 = { 1, 2, 4, 8, 16 };
		int resultClosest1 = closest(inputClosest1, 7);
		System.out.println("resultClosest1: " + resultClosest1); // expect 3

		// test(s) for firstOccur()
		int resultFirstOccur = firstOccur(inputArray2, 2);
		System.out.println("resultFirstOccur: " + resultFirstOccur); // expect 1

	}

	// Practice #1 Classical Binary Search
	public static int binarySearch(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int mid = (array.length - 1) / 2;
		int low = 0;
		int high = array.length - 1;
		while (array[mid] != target) {
			if (array[mid] < target) {
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

	// Practice #2 Classical Binary Search in 2D Space
	public static int[] searchInMatrix(int[][] matrix, int target) {
		int[] err = { -1, -1 };
		if (matrix == null || matrix.length == 0) {
			return err;
		}
		int mid = (matrix.length * matrix[0].length - 1) / 2;
		int low = 0;
		int high = matrix.length * matrix[0].length - 1;
		while (matrix[mid / matrix[0].length][mid % matrix[0].length] != target) {
			if (matrix[mid / matrix[0].length][mid % matrix[0].length] < target) { // the target
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			if (low > high) {
				return err;
			}
			mid = (low + high) / 2;
		}
		int[] result = new int[2];
		result[0] = mid / matrix[0].length;
		result[1] = mid % matrix[0].length;
		return result;
	}

	// Practice #3 Closest In Sorted Array
	public static int closest(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int mid = (array.length - 1) / 2;
		int low = 0;
		int high = array.length - 1;
		while (array[mid] != target) {
			if (array[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			if (low > high) {
				int betweener;
				if (array[mid] < target) {
					betweener = mid + 1;
					if (betweener > array.length - 1) {
						return mid;
					}
				} else {
					betweener = mid - 1;
					if (betweener < 0) {
						return mid;
					}
				}
				return (Math.abs(array[mid] - target) > Math.abs(array[betweener] - target)) ? mid : betweener;
			}
			mid = (low + high) / 2;
		}
		return mid;
	}

	// Practice #4 First Occurrence
	public static int firstOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int mid = (array.length - 1) / 2;
		int low = 0;
		int high = array.length - 1;
		while (array[mid] != target) {
			if (array[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			if (low > high) {
				return -1;
			}
			mid = (low + high) / 2;
		}
		while (mid > 0 && (array[mid] == array[mid - 1])) {
			mid--;
		}
		return mid;
	}

}
