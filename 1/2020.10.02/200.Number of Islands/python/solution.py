class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(r, c):
            grid[r][c] = '0'
            for x, y in [(r-1, c), (r+1, c), (r, c-1), (r, c+1)]:
                if 0 <= x < nr and 0 <= y < nc and grid[x][y] == '1':
                    dfs(x, y)
        nr = len(grid)
        if nr == 0:
            return 0
        nc = len(grid[0])
        islands = 0
        for i in range(nr):
            for j in range(nc):
                if grid[i][j] == '1':
                    islands += 1
                    dfs(i, j)
        return islands

    def numIslands(self, grid: List[List[str]]) -> int:
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                list(map(sink, (i-1, i+1, i, i), (j, j, j-1, j+1)))
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))
