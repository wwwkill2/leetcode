class Solution {
    public int findCircleNum(int[][] M) {
        // DFS
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                DFS(M, visited, i);
                count++;
            }
        }
        return count;
    }
    
    private void DFS(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                DFS(m, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        // BFS
        int[] visited = new int[M.length];
        int count = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                q.offerLast(i);
                while (!q.isEmpty()) {
                    int s = q.pollFirst();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            visited[j] = 1;
                            q.offerLast(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
