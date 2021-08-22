class Solution {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int[][] ndp = new int[2][3];
            // end with P
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    ndp[j][0] = (ndp[j][0] + dp[j][k]) % MOD;
                }
            }
            // end with A
            for (int k = 0; k < 3; k++) {
                ndp[1][0] = (ndp[1][0] + dp[0][k]) % MOD;
            }
            // end with L
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    ndp[j][k] = (ndp[j][k] + dp[j][k - 1]) % MOD;
                }
            }
            dp = ndp;
        }
        int sum = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                sum = (sum + dp[j][k]) % MOD;
            }
        }
        return sum;
    }
}
