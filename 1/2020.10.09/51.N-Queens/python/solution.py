class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def DFS(queens, xy_dif, xy_sum):
            p = len(queens)
            if p == n:
                res.append(queens)
                return
            for q in range(n):
                if q not in queens and p - q not in xy_dif and p + q not in xy_sum:
                    DFS(queens + [q], xy_dif + [p-q], xy_sum + [p+q])
        res = []
        DFS([], [], [])
        return [['.'*i + 'Q' + '.' * (n-i-1) for i in sol] for sol in res]
