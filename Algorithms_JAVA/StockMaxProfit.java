package fb.careercup;

/**
 * 
 * @author basila
 * 
 * you have an array with the ith element is the price of a given stock on day i
 * you can buy stock at any day but can only buy once a day. but if you see the stock
 *  you must sell all of them at once.
 *  
 *  return max profit
 *
 */

public class StockMaxProfit {
	
	public int maxProfit(int[] prices) {
		int[] max = new int[prices.length];
		max[prices.length - 1] = prices[prices.length - 1];
		
		for(int i = prices.length - 2; i >= 0; i--) {
			max[i] = (prices[i] < max[i + 1] ? max[i + 1] : prices[i]);
		}
		
		int result = 0;
		for(int i = 0; i < prices.length; i++) {
			if (max[i] > prices[i]) {
				result += max[i] - prices[i];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		StockMaxProfit test = new StockMaxProfit();
		
		int[] array = {4, 4, 7, 4, 4, 9, 1, 8};
		
		System.out.println(test.maxProfit(array));
	}

}
