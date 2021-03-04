class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        while (top <= bottom && left <= right) {
            res.add(matrix[x][y]);
            if (y + dy[di] > right) {
                top++;
                di = (di + 1) % 4;
            } else if (y + dy[di] < left) {
                bottom--;
                di = (di + 1) % 4;
            } else if (x + dx[di] > bottom) {
                right--;
                di = (di + 1) % 4;
            } else if (x + dx[di] < top) {
                left++;
                di = (di + 1) % 4;
            }
            x += dx[di];
            y += dy[di];
        }
    }
}
