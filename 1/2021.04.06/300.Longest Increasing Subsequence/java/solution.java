class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            if (dp.isEmpty() || num > dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                // find first bigger element and replace it by num
                int left = 0, right = dp.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (dp.get(mid) < num) {
                        left = mid + 1;
                    } else if (dp.get(mid) > num) {
                        right = mid - 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp.set(left, num);
            } 
        }
        return dp.size();
    }
}
