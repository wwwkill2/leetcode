class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def valid(row, col, c):
            for i in range(9):
                if board[row][i] == c:
                    return False
                if board[i][col] == c:
                    return False
                if board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] == c:
                    return False
            return True
        
        def solve():
            for i in range(9):
                for j in range(9):
                    if board[i][j] == '.':
                        for c in '123456789':
                            if valid(i, j, c):
                                board[i][j] = c
                                if solve():
                                    return True
                                else:
                                    board[i][j] = '.'
                        return False
            return True
        
        solve()
