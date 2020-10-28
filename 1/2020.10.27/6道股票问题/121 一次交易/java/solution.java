class Solution {
    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, -price);
        }
        return dp0;
    }
}
