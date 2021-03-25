class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def DFS(i, j):
            if 0 <= i < len(board) and 0 <= j < len(board[i]) and board[i][j] == 'O':
                board[i][j] = 'A'
                DFS(i-1, j)
                DFS(i+1, j)
                DFS(i, j-1)
                DFS(i, j+1)
        
        m, n = len(board), len(board[0])
        for i in range(n):
            DFS(0, i)
            DFS(m - 1, i)
        for i in range(m):
            DFS(i, 0)
            DFS(i, n-1)
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'A':
                    board[i][j] = 'O'
                elif board[i][j] == 'O':
                    board[i][j] = 'X'
