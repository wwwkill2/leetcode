class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        if len(heightMap) <= 2 or len(heightMap[0]) <= 2:
            return 0
        m, n = len(heightMap), len(heightMap[0])
        heap = []
        for j in range(n):
            heappush(heap, (heightMap[0][j], j))
            heightMap[0][j] = -1
            heappush(heap, (heightMap[m - 1][j], (m - 1) * n + j))
            heightMap[m - 1][j] = -1
        for i in range(1, m - 1):
            heappush(heap, (heightMap[i][0], i * n))
            heightMap[i][0] = -1
            heappush(heap, (heightMap[i][n - 1], i * n + n - 1))
            heightMap[i][n - 1] = -1
        res = 0
        dirs = [-1, 0, 1, 0, -1]
        while heap:
            height, cur = heappop(heap)
            for k in range(4):
                nx, ny = cur // n + dirs[k], cur % n + dirs[k + 1]
                if 0 <= nx < m and 0 <= ny < n and heightMap[nx][ny] != -1:
                    if height > heightMap[nx][ny]:
                        res += height - heightMap[nx][ny]
                    heappush(heap, (max(height, heightMap[nx][ny]), nx * n + ny))
                    heightMap[nx][ny] = -1
        return res
