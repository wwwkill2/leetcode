class Solution {
    public int findLength(int[] A, int[] B) {
        // dp
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >=0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }
}
