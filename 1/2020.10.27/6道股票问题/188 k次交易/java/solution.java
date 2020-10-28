class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                sell[i] = Math.max(sell[i], buy[i] + price);
                buy[i] = Math.max(buy[i], sell[i+1] - price);
            }
        }
        return sell[0];
    }
}
