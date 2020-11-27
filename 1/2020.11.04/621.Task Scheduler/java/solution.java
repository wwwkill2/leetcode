class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int maxVal = map[25] - 1;
        int slots = maxVal * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            slots -= Math.min(map[i], maxVal);
        }
        return slots > 0 ? slots + tasks.length : tasks.length;
    }
}
