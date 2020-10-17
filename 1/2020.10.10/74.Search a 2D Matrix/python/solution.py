class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def binary_search(start, end):
            if start > end:
                return False
            mid = start + (end - start) // 2
            row, col = mid // n, mid % n
            if target == matrix[row][col]:
                return True
            elif target < matrix[row][col]:
                return binary_search(start, mid-1)
            else:
                return binary_search(mid+1, end)
        if len(matrix) == 0:
            return False
        m, n = len(matrix), len(matrix[0])
        return binary_search(0, m*n-1)
