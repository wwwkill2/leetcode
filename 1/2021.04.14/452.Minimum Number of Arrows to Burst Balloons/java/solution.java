class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[1] > b[1] ? 1 : -1;
        });
        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
