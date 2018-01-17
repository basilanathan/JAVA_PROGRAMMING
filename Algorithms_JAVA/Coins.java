package algosJava;

import java.util.HashMap;

public class Coins {
	
	public static int makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Integer>());
	}
	
	public static int makeChange(int[] coins, int money, int index, HashMap<String, Integer> memo) {
		if(money == 0) return 1;
		if (index >= coins.length) {
			return 0;
		}
		String key = money + "-" + index;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int amountWithCoins = 0;
		int ways = 0;
		while(amountWithCoins <= money) {
			int remaining = money - amountWithCoins;
			ways += makeChange(coins, remaining, index + 1, memo);
			amountWithCoins += coins[index];
		}
		memo.put(key, ways);
		return ways;
	}
	
	public static long makeChangeDP(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long) 1; 	// n == 0 case.
        for(int coin : coins) {
            for(int j = coin; j < DP.length; j++) {
            // The only tricky step.
                DP[j] += DP[j - coin];
            }
        }       
        return DP[money];
    }
	
	/*Space complexity is O(N) and O(m * n ) Run time. The key idea is that at every iteration you 
	 * just need the previous value and the value at money - coin location.*/
	// space n
	public static int getChange2(int n, int[] coins) {
		int m = coins.length;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		// dp
		//coins array
		for(int j = 0; j < m; j++) {
			//dp array
			for(int i = coins[j]; i <= n; i++) {
				dp[i] += dp[i - coins[j]];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int[] coins = {50, 25, 10, 5, 1};
		//int money = 27;
		int ways = makeChange(coins, 10);
		int ways2 = (int) makeChangeDP(coins, 10);
		int way3 = getChange2(100, coins);

		System.out.println(ways);
		System.out.println(ways2);
		System.out.println(way3);

	}

}
