package cci.ch8;

public class Coins {
	
	public static int makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0);
	}
	
	public static int makeChange(int[] coins, int money, int index) {
		if(money == 0) return 1;
		if (index >= coins.length) {
			return 0;
		}
		
		int amountWithCoins = 0;
		int ways = 0;
		while(amountWithCoins <= money) {
			int remaining = money - amountWithCoins;
			ways += makeChange(coins, remaining, index + 1);
			amountWithCoins += coins[index];
		}
		return ways;
	}
	
	public static void main(String[] args) {
		int[] coins = {50, 25, 10, 5, 1};
		//int money = 27;
		int ways = makeChange(coins, 10);
		System.out.println(ways);
	}

}
