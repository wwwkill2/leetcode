class Solution {

    public int[] recoverArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[0] || (nums[i] - nums[0]) % 2 != 0) {
                continue;
            }
            boolean[] used = new boolean[n];
            int[] ans = new int[n / 2];
            int k = (nums[i] - nums[0]) / 2;
            ans[0] = nums[0] + k;
            used[0] = used[i] = true;
            int left = 0, right = i;
            for (int j = 1; j < n / 2; ++j) {
                while (used[left]) {
                    ++left;
                }
                while (right < n && (used[right] || (nums[right] - nums[left] != k * 2))) {
                    ++right;
                }
                if (right == n) {
                    break;
                }
                ans[j] = nums[left] + k;
                used[left] = used[right] = true;
            }
            if (right != n) {
                return ans;
            }
        }

        // can not reach here
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 10, 6, 4, 8, 12};
        System.out.println(Arrays.toString(solution.recoverArray(nums)));
        nums = new int[]{5, 435};
        System.out.println(Arrays.toString(solution.recoverArray(nums)));
    }
}
