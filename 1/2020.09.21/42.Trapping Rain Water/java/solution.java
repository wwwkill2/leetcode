class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int max_left = 0, max_right = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= max_left) {
                    max_left = height[left];
                } else {
                    sum += max_left - height[left];
                }
                left++;
            } else {
                if (height[right] >= max_right) {
                    max_right = height[right];
                } else {
                    sum += max_right - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
