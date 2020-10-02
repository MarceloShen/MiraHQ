import java.util.Arrays;

/*
 * Assignment: Binary Search 
 * Author: Ashley Mead
 * Period: 7
 */
public class ST_P7_BinarySearch_Ashley_Mead {
	public static void main(String[] args) {

        // Additional tests
        // invalid input
        int[] inputArrayInvalid = null;
        // 1 element, 2 element, 3 elements in array
        int[] inputArray1Element = {2};
        int[] inputArray2Elements = {1, 4};
        int[] inputArray3Elements = {0, 4, 7};
        // for 2D: empty, 1D array (1 row), regular
        int[][] empty = {};
        int[][] oneDinput = {{1, 4, 6, 7, 9}};

		// sample tests
        // test for binarySearch()
        System.out.println("-- Binary Search --");

		int[] inputArray1 = {1, 2, 3, 4, 5};
		int result1 = binarySearch(inputArray1, 3);
        System.out.println("result1: " + result1); // expect 2
		
		int result2 = binarySearch(inputArray1, 6);
		System.out.println("result2: " + result2); // expect -1
		
		int[] inputArray2 = {1, 2, 2, 2, 3, 4};
		int result3 = binarySearch(inputArray2, 2);
        System.out.println("result3: " + result3); // expect 1 or 2 or 3
        
        int testInvalidBinarySearch = binarySearch(inputArrayInvalid, 4); // expect -1
        int test1ElementBinarySearch = binarySearch(inputArray1Element, 3); // expect -1
        int test2ElementsBinarySearch = binarySearch(inputArray2Elements, 4); // expect 1
        int test3ElementsBinarySearch = binarySearch(inputArray3Elements, 7); // expect 2
        System.out.println("TestInvalid: " + testInvalidBinarySearch + ", Test1Element: " + test1ElementBinarySearch
        + ", Test2Elements: " + test2ElementsBinarySearch + ", Test3Elements: " + test3ElementsBinarySearch);
		
        // test(s) for searchInMatrix()
        System.out.println("\n-- Search In Matrix --");
        int[][] matrix = {{1, 2, 3}, {4, 5, 7}, {8, 9, 10}};
        int[] result4 = searchInMatrix(matrix, 7); 
        System.out.println("result 4: " + Arrays.toString(result4)); // expect [1, 2]

        int[] result5 = searchInMatrix(matrix, 6); 
        System.out.println("result 5: " + Arrays.toString(result5)); // expect [-1, -1]

        int[] testEmpty = searchInMatrix(empty, 0); // expect [-1, -1]
        int[] test1D = searchInMatrix(oneDinput, 7); // expect [0, 3]
        System.out.println("TestEmpty: " + Arrays.toString(testEmpty) + ", Test1D: " + Arrays.toString(test1D));
        
        // test(s) for closest()
        System.out.println("\n-- Closest --");
        int[] inputArray3 = {1, 2, 3};
        int result6 = closest(inputArray3, 2);
        System.out.println("result 6: " + result6); // expect 1
        
        int[] inputArray4 = {1, 4, 6};
        int result7 = closest(inputArray4, 3);
        System.out.println("result 7: " + result7); // expect 1

        int result8 = closest(inputArray4, 5);
        System.out.println("result 8: " + result8); // expect 1 or 2
        
        int[] inputArray5 = {1, 3, 3, 4};
        int result9 = closest(inputArray5, 2);
        System.out.println("result 9: " + result9); // expect 0 or 1 or 2

        int testInvalidClosest = closest(inputArrayInvalid, 4); // expect -1
        int test1ElementClosest = closest(inputArray1Element, 3); // expect 0
        int test2ElementsClosest = closest(inputArray2Elements, 4); // expect 1
        int test3ElementsClosest = closest(inputArray3Elements, 5); // expect 1
        System.out.println("TestInvalid: " + testInvalidClosest + ", Test1Element: " + test1ElementClosest
        + ", Test2Elements: " + test2ElementsClosest + ", Test3Elements: " + test3ElementsClosest);

        // test(s) for firstOccur()
        System.out.println("\n-- First Occur --");
        int[] inputArray6 = {1, 2, 3};
        int result10 = firstOccur(inputArray6, 2);
        System.out.println("result 10: " + result10); // expect 1

        int result11 = firstOccur(inputArray6, 4);
        System.out.println("result 11: " + result11); // expect -1

        int[] inputArray7 = {1, 2, 2, 2, 3};
        int result12 = firstOccur(inputArray7, 2);
        System.out.println("result 12: " + result12); // expect 1

        // Different tests for firstOccur()
        // 1 element, 2 element, 3 elements in array
        int[] inputArray1ElementFirstOccur = {4};
        int[] inputArray2ElementsFirstOccur = {4, 4};
        int[] inputArray3ElementsFirstOccur = {5, 5, 8};

        int testInvalidFirstOccur = firstOccur(inputArrayInvalid, 4); // expect -1
        int test1ElementFirstOccur = firstOccur(inputArray1ElementFirstOccur, 3); // expect -1
        int test2ElementsFirstOccur = firstOccur(inputArray2ElementsFirstOccur, 4); // expect 0
        int test3ElementsFirstOccur = firstOccur(inputArray3ElementsFirstOccur, 5); // expect 0
        System.out.println("TestInvalid: " + testInvalidFirstOccur + ", Test1Element: " + test1ElementFirstOccur
        + ", Test2Elements: " + test2ElementsFirstOccur + ", Test3Elements: " + test3ElementsFirstOccur);


	}
	
    //Practice #1 Classical Binary Search
    // Assumption: There can be duplicate elements in the array and any indices i such that A[i] == T can be returned
    // BigO Notation: O(log n) 
	public static int binarySearch(int[] array, int target) {
        // If the array is null or has zero length, return -1
        if(array == null || array.length == 0) {
            return -1;
        }
        // Initialize variables
        int maxIndex = array.length - 1;
        int minIndex = 0;
        int midIndex = (int)(maxIndex/2);
        // Loop while we haven't found the target
        while(array[midIndex] != target){ // begin <= end
            if(array[midIndex] == target) {
                return midIndex;
            }
            // If the value at the mid is greater than the target, adjust the max to be lower than the mid
            else if(array[midIndex] > target) {
                maxIndex = midIndex - 1;
            }
            // If the value at the mid is less than the target, adjust the min to be larger than the mid
            else if(array[midIndex] < target) {
                minIndex = midIndex + 1;
            }
            // If the min gets to be greater than the max, then we could not find the target in the array. Return -1
            if(minIndex > maxIndex) {
                return -1;
            }
            // Reset the mid based on the adjustments in the else-ifs above
            midIndex = (int)((maxIndex + minIndex)/2);
    
        }
        // If we had exited out of the loop, then we have found the target. Return the index at which the target was found
        return midIndex; // return -1
	}
	
    //Practice #2 Classical Binary Search in 2D Space
    // Assumption: The given matrix is not null, and has a size of N*M, where N >= 0 and M >= 0
    // BigO Notation: O(log n)
	public static int[] searchInMatrix(int[][] matrix, int target) {
        // Edge cases
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        // Index of bottom right corner element in matrix
        int right = rows * cols - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            // row that mid is in
            int row = mid / cols;
            // column that mid is in
            int col = mid % cols;
            
            // Found, return the target indices
            if (matrix[row][col] == target) {
                return new int[] {row, col};
            // Adjust left and right based on whether the current value is greater than or less than the target
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Target not found
        return new int[] {-1, -1};
	}
	
    //Practice #3 Closest In Sorted Array
    // Assumption: There can be duplicate elements in the array, and any of the indices with the same value can be returned
    // BigO Notation: O(log n)
	public static int closest(int[] array, int target) {
        // If the array is null or has zero length, return -1
        if(array == null || array.length == 0) {
            return -1;
        }
        // closest using binary search
        // Same algorithm from binarySearch() with some modifications below
        int maxIndex = array.length - 1;
        int minIndex = 0;
        int midIndex = (int)(maxIndex/2);
        // update this variable everytime to the most recently checked value
        int closestSoFar = midIndex;
        // The difference between the previously checked value and the target
        int prevDifference = Integer.MAX_VALUE;
        // Index of the previously checked value
        int prevIndex = midIndex;
        // Loop until we find the target (if we find the target, the target is the closest possible value to itself)
        // Note: In this version (closest), we are likely to return out of the function before we reach this condition.
        while(array[midIndex] != target){
            // Binary search checks and adjustments
            if(array[midIndex] == target) {
                return midIndex;
            }
            else if(array[midIndex] > target) {
                maxIndex = midIndex - 1;
            }
            else if(array[midIndex] < target) {
                minIndex = midIndex + 1;
            }
            // If the min is greater than the max, we did not find the target in the array. Instead of returning -1 like in the
            // binary search method, we determine which value is closest to the target.
            if(minIndex > maxIndex) {
                // Check to see which value is closer to the target: the current value or the previous value,
                // and return the closest value
                if(Math.abs(array[closestSoFar] - target) < prevDifference) {
                    return closestSoFar;
                }
                return prevIndex;
            }
            // Adjust variables before the next iteration:
            // set the variables for the previous iteration to the current values and adjust the current values for the next iteration
            prevDifference = Math.abs(array[closestSoFar] - target);
            prevIndex = midIndex;
            midIndex = (int)((maxIndex + minIndex)/2);
            closestSoFar = midIndex;
    
        }

        // If we exit the loop, then we have found the target. The target is the closest possible value to itself
        return midIndex;
	}
	
    // Practice #4 First Occurrence
    // Assumption: There can be duplicate elements in the array
    // BigO Notation: O(log n)
	public static int firstOccur(int[] array, int target) {
        // If the array is null or has zero length, return -1
        if(array == null || array.length == 0) {
            return -1;
        }
        // Check to see if the target exists in the array first. If it doesn't exist in the array, there is no first occurence. Return -1
        int binarySearchResult = binarySearch(array, target);
        if(binarySearchResult == -1) {
            return -1;
        }
        // At this point, we know the target exists in the array at index searchResult, but it may or may not be the first occurence.
        // Adjust the array to be everything before the index searchResult so we can check the new array for occurences before the one we found previously.
        int[] resultArray = Arrays.copyOfRange(array, 0, binarySearchResult);
        // Keep track of the previous occurence of the target
        int lastResult = binarySearchResult;
        // Loop while we find occurences of the target in the array
        while(binarySearchResult != -1) {
            binarySearchResult = binarySearch(resultArray, target);
            // If we can't find another occurence, the previous occurence we found was the first occurence
            if(binarySearchResult == -1) {
                return lastResult;
            }
            // Adjust the array and update the last result variable for the next iteration
            resultArray = Arrays.copyOfRange(array, 0, binarySearchResult);
            lastResult = binarySearchResult;
        }
        // Exiting the loop means we can't find another occurence. The previous occurence we found was the first occurence
        return lastResult;
	}

}
