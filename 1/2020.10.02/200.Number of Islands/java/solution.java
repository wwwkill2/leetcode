class Solution {
    public int numIslands(char[][] grid) {
        int nr = grid.length;
        if (nr == 0) {
            return 0;
        }
        int nc = grid[0].length;
        int islands = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, nr, nc, i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int nr, int nc, int r, int c) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, nr, nc, r-1, c);
        dfs(grid, nr, nc, r+1, c);
        dfs(grid, nr, nc, r, c-1);
        dfs(grid, nr, nc, r, c+1);
    }
}
