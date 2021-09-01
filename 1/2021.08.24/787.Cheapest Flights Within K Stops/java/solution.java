class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[src] = 0;
        int res = -1;
        for (int t = 1; t < k + 2; t++) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, -1);
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                if (dp[j] != -1) {
                    if (ndp[i] == -1) {
                        ndp[i] = dp[j] + cost;
                    } else {
                        ndp[i] = Math.min(ndp[i], dp[j] + cost);
                    }
                }
            }
            dp = ndp;
            if (res == -1) {
                res = dp[dst];
            } else if (dp[dst] != -1){
                res = Math.min(dp[dst], res);
            }
        }
        return res;
    }
}
