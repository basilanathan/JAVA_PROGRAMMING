package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 */

/*
 * Each day, we can have three operations: do nothing, sell or buy.
The initial status for day one can be either buy one share and have a balance of -prices[0] or do nothing.
Then starting from day 2, to reach the hold status, we can either do nothing (maintain the hold), or if yesterday is “cash” status, we can buy one and hold it (cash-prices[i]).
To reach the sell status, we can either do nothing (maintain cash), or if yesterday is “hold”, which means we have something to sell, then cash it (hold+prices[i]-fee)
Thus we have the status transition from previous one to the next one.
 * 
 * 
 * At the end of the i-th day, we maintain cash, the maximum profit we could have if we did not have a share of stock, and hold, the maximum profit we could have if we owned a share of stock.

To transition from the i-th day to the i+1-th day, we either sell our stock cash = max(cash, hold + prices[i] - fee) or buy a stock hold = max(hold, cash - prices[i]). At the end, we want to return cash.
 * 
 * */

/*
 * Time Complexity: O(N), where N is the number of prices.
Space Complexity: O(1), the space used by cash and hold.
 * */

public class BestTimeBuySellStockTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int cash = 0;
		int own = -prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			cash = Math.max(cash, own + prices[i] - fee);
			own = Math.max(own, cash - prices[i]);
		}
		return cash;
	}

}
