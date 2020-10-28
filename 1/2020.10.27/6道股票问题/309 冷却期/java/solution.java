class Solution {
    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        int dpPrev0 = 0;
        for (int price : prices) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, dpPrev0 - price);
            dpPrev0 = tmp;
        }
        return dp0;
    }
}
