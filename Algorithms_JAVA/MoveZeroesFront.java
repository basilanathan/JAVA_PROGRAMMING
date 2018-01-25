package fb.glassdoor;

//Time: O(N)
//Space: O(1)

//https://www.careercup.com/question?id=5731103635668992
//https://stackoverflow.com/questions/3004793/move-all-zero-values-in-a-big-array-to-its-front-portion-in-a-time-efficiency-wa
//https://www.educative.io/collection/page/5642554087309312/5679846214598656/180002
public class MoveZeroesFront {
	
	public static int[] moveZeroesFront(int[] nums) {
		
		int j = nums.length - 1;
		
		for (int i = nums.length - 1 ; i >=0 ; i--)
		{
			//Skip over zero elements
			if(nums[i] == 0)
				continue;

			//i landed on index where there is a non-zero element, 
			//thus copy it back to position j, and move j to next spot to fill.
			nums[j] = nums[i];
			j--; //only decrement j when you encounter a non zero
		}

		//Zero fill remaining leading spots in array.
		while( j >= 0 ) 
		{
			nums[j]=0;
			j--;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int [] myArray = moveZeroesFront(new int[] {0, 1, 0, 3, 12});
			for (int i = 0; i < myArray.length; i++) {
				System.out.print(myArray[i] + " ");
			
		}
	
	}
}


