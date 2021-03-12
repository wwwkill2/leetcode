class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> row = new ArrayList<>();
        List<Map<Character, Integer>> col = new ArrayList<>();
        List<Map<Character, Integer>> box = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            row.add(new HashMap<>());
            col.add(new HashMap<>());
            box.add(new HashMap<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row.get(i).put(board[i][j], row.get(i).getOrDefault(board[i][j], 0) + 1);
                    if (row.get(i).get(board[i][j]) > 1) {
                        return false;
                    }
                    col.get(j).put(board[i][j], col.get(j).getOrDefault(board[i][j], 0) + 1);
                    if (col.get(j).get(board[i][j]) > 1) {
                        return false;
                    }
                    int boxIndex = (j / 3) * 3 + i / 3;
                    box.get(boxIndex).put(board[i][j], box.get(boxIndex).getOrDefault(board[i][j], 0) + 1);
                    if (box.get(boxIndex).get(board[i][j]) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
