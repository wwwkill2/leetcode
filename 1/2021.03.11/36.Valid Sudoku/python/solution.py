class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [{} for _ in range(9)]
        col = [{} for _ in range(9)]
        box = [{} for _ in range(9)]
        for i in range(9):
            for j in range(9):
                if '1' <= board[i][j] <= '9':
                    row[i][board[i][j]] = row[i].get(board[i][j], 0) + 1
                    if row[i][board[i][j]] > 1:
                        return False
                    col[j][board[i][j]] = col[j].get(board[i][j], 0) + 1
                    if col[j][board[i][j]] > 1:
                        return False
                    box_index = (j // 3) * 3 + i // 3
                    box[box_index][board[i][j]] = box[box_index].get(board[i][j], 0) + 1
                    if box[box_index][board[i][j]] > 1:
                        return False 
        return True
