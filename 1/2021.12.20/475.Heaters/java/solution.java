class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int j = 0;
        for (int i = 0; i < houses.length; ++i) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j + 1 < heaters.length && Math.abs(houses[i] - heaters[j + 1]) <= curDistance) {
                ++j;
                curDistance = Math.abs(houses[i] - heaters[j]);
            }
            res = Math.max(res, curDistance);
        }
        return res;
    }
}
