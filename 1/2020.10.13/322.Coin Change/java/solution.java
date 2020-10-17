class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return 0;
        }
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] amount) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (amount[rem-1] != 0) {
            return amount[rem-1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem-coin, amount);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        amount[rem-1] = min == Integer.MAX_VALUE ? -1 : min;
        return amount[rem-1];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i-coin] != -1) {
                    int temp = dp[i-coin] + 1;
                    min = min < 0 ? temp : Math.min(temp, min);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
