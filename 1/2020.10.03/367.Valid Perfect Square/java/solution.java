class Solution {
    public boolean isPerfectSquare(int num) {
        // binary search
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2;
        while (left <= right) {
            long x = left + (right - left) / 2;
            long multy = x * x;
            if (multy == num) {
                return true;
            } else if (multy < num) {
                left = x + 1;
            } else {
                right = x - 1;
            }
        }
        return false;
    }
}
