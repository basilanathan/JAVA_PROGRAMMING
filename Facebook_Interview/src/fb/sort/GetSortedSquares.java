package fb.sort;

//given a sorted list of integers, square the elements and give the output in sorted order
public class GetSortedSquares {

	public static void main(String[] args) {
		int[] arr = {-6,-3,2,3,4};
		int[] arr1= {1,2,3,4};
		
		int[] result = getSortedSquares(arr);
		int[] result1 = getSortedSquares(arr1);
		
		printArr(result);
		System.out.println("~~~~~~~~~~~~");
		printArr(result1);
		
	}
// The function to get the Squares in Sorted order
	private static int[] getSortedSquares(int[] arr) {
		int[] result = new int[arr.length];
		int low =0 , high = arr.length-1, i = arr.length-1;
			while(low <= high && i >= 0){
				if(Math.abs(arr[low]) >= Math.abs(arr[high])){ // absolute value of array element on the left is greater than the array element on right
					result[i]= arr[low]*arr[low];
					i--;
					low++;
				}else if (Math.abs(arr[low]) < Math.abs(arr[high])){
					result[i]= arr[high]*arr[high];
					i--;
					high--;
				}		
			}
		
		return result;
	}

	private static void printArr(int[] result) {
		for(int n : result)
			System.out.println(n);
		
	}

}