class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        m, n = len(matrix), len(matrix[0])
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        x = y = di = 0
        res = []
        top, bottom, left, right = 0, m - 1, 0, n - 1
        while top <= bottom and left <= right:
            res.append(matrix[x][y])
            if y + dy[di] > right:
                di = (di + 1) % 4
                top += 1
            elif y + dy[di] < left:
                di = (di + 1) % 4
                bottom -= 1
            elif x + dx[di] > bottom:
                di = (di + 1) % 4
                right -= 1
            elif x + dx[di] < top:
                di = (di + 1) % 4
                left += 1
            x += dx[di]
            y += dy[di]
        return res
