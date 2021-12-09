class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    heap.offer(new int[]{i * n + j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            for (int k = 0; k < 4; ++k) {
                int nx = cur[0] / n + dirs[k];
                int ny = cur[0] % n + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (cur[1] > heightMap[nx][ny]) {
                        res += cur[1] - heightMap[nx][ny];
                        visited[nx][ny] = true;
                    }
                    heap.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], cur[1])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
