class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp.set(j, triangle.get(i).get(j) + Math.min(dp.get(j), dp.get(j+1)));
            }
        }
        return dp.get(0);
    }
}
