class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int lastIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= res[lastIndex][1]) {
                res[lastIndex][1] = Math.max(interval[1], res[lastIndex][1]);
            } else {
                lastIndex++;
                res[lastIndex] = interval;
            }
        }
        return Arrays.copyOf(res, lastIndex + 1);
    }
}
