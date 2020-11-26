/**
 * 
 */
package com.intuit;

/**
 * @author Sachin Garg
 *
 */
public class IntuitTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {2,3,10, 2, 4, 8,1};
		int[] arr2 = {7,9,5,6,3,2};
		//System.out.println(minDiff(arr1));// 1, 12, 3, 4, 28, 1 }));
		System.out.println(minDiff(arr2));//,3,10, 2, 4, 8,1}));
		
		int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
	    int n = arr2.length/arr2[0];
	    int maxDiff = maxIndexDiff(arr2, n);
	    System.out.println(maxDiff);
	}
	
	
	static int maxIndexDiff(int arr[], int n)
	{
	    int maxDiff = -1;
	    int i, j;
	 
	    for (i = 0; i < n; ++i)
	    {
	        for (j = n-1; j > i; --j)
	        {
	            if(arr[j] > arr[i] && maxDiff < (j - i))
	                maxDiff = j - i;
	        }
	    }
	 
	    return maxDiff;
	}

	private static int minDiff(int[] a) {
		int iDiff = 0;
		int iResult = 0;
		for (int i = 0; i < a.length;) {
			int iMaxIndex = maximumIndex(a, i);
			int iMinIndex = minimumIndex(a, i, iMaxIndex);
			if(a[iMaxIndex] < a[iMinIndex]){
				iResult = -1;
			}else{
				iDiff = a[iMaxIndex] - a[iMinIndex];
				if (iResult < iDiff)
					iResult = iDiff;
				i = iMaxIndex + 1;
			}
		}
		return iResult;
	}

	private static int minimumIndex(int[] array, int start, int end) {
		int min = start;
		for (int i = start + 1; i < end; i++) {
			if (array[i] < array[min]) {
				min = i;
			}
		}
		return min;
	}

	private static int maximumIndex(int[] array, int start) {
		int max = start;
		for (int i = start + 1; i < array.length; i++) {
			if (array[i] >= array[max]) {
				max = i;
			}
		}
		return max;
	}

}
