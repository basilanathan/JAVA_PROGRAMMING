package fb.LIS;

/**
 * Date 11/20/2017
 * @author Basila Nathan
 * 
 * 
 * Find a subsequence in given array in which the subsequence's elements are 
 * in sorted order, lowest to highest, and in which the subsequence is as long as possible
 * 
 * Solution : 
 * Dynamic Programming is used to solve this question. DP equation is 
 * if(arr[i] > arr[j]) { T[i] = max(T[i], T[j] + 1 }
 * 
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 * 
 * Reference 
 * http://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    /**
     * DP way of solving LIS
     */
    public int longestSubsequenceWithActualSolution(int arr[]){
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length]; //temp array as the same size as the ooriginal array
        for(int i=0; i < arr.length; i++){
            T[i] = 1; //you know that the longest subsequence is at least length one
            actualSolution[i] = i;
        }
        
        for(int i=1; i < arr.length; i++){ //stat i at 1
            for(int j=0; j < i; j++){ //start j at 0
                if(arr[i] > arr[j]){ //if element j is less than element i the longest subsequence at i will be longest subs at j plus one
                    if(T[j] + 1 > T[i]){ // has to meet two requierements, current > previous ending and size is increasing!!
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }
        
        //find the index of max number in T 
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }
        
        //lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();
 
        return T[maxIndex];
    }
    
    /**
     * Recursive way of solving LIS
     */
    public int longestSubsequenceRecursive(int arr[]){
        int maxLen = 0;
        for(int i=0; i < arr.length-1; i++){
            int len = longestSubsequenceRecursive(arr,i+1,arr[i]);
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen + 1;
    }
    
    private int longestSubsequenceRecursive(int arr[], int pos, int lastNum){
        if(pos == arr.length){
            return 0;
        }
        int t1 = 0;
        if(arr[pos] > lastNum){
            t1 = 1 + longestSubsequenceRecursive(arr, pos+1, arr[pos]);
        }
        int t2 = longestSubsequenceRecursive(arr, pos+1, lastNum);
        return Math.max(t1, t2);
    }
    
    public static void main(String args[]){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        //int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
        int result = lis.longestSubsequenceWithActualSolution(arr);
        int result1 = lis.longestSubsequenceRecursive(arr);
        System.out.println(result);
        System.out.println(result1);
    }
}
