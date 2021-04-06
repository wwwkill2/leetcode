class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
            } else if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }
}
