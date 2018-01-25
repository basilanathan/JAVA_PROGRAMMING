package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * If you were only permitted to complete at most one buy and at most one sell 
 * during the whole period of days, design an algorithm such that your profit, 
 * i.e., sell price minus buy price, is maximized. Note that you can only not 
 * sell a stock before you buy one.
	For example:
	
	[1,2,3,4] ==> returns 3 (buy at 1 and sell at 4)
	
	[4,3,2,1] ==> returns 0 (don't buy)
	
	[4,10,25,2,10] ==> returns 21 (buy at 4 and sell at 25)
	
 * Time: O(N)
 * Space: O(1)
 */


//Kadane's Algorithm
public class BestTimeToBuyAndSellStock {
	
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		
		int min = prices[0];
		int profit = 0;
		
		for(int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}
	
    public static int maxProfitDiff(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		System.out.println(maxProfit(prices));
		System.out.println(maxProfitDiff(prices));
	}

}
