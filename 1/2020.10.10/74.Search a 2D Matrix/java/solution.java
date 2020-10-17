class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int pivot = matrix[mid/n][mid%n];
            if (target == pivot) {
                return true;
            } else if (target < pivot) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
