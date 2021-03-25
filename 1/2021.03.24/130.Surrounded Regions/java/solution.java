class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            DFS(board, i, 0);
            DFS(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            DFS(board, 0, i);
            DFS(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void DFS(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 'O') {
            board[i][j] = 'A';
            DFS(board, i - 1, j);
            DFS(board, i + 1, j);
            DFS(board, i, j - 1);
            DFS(board, i, j + 1);
        }
    }
}
