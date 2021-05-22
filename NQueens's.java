class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        initializeBoard(board);
        backTrack(board, res, 0);
        return res;
    }
    
    private void initializeBoard(char[][] board) {
        for (int i=0; i<board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }
    
    private List<String> generate(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder("");
            for (char c: row) {
                sb.append(c);
            }
            result.add(sb.toString());
        }
        return list;
    }
    
    private void backTrack(char[][] board, List<List<String>> res, int index) {
        if (index == board.length) {
            result.add(generate(board));
            return;
        }
        
        for (int i=0; i<board.length; i++) {
            if (isValid(board, index, i)) {
                board[rowIndex][i] = 'Q';
                backTrack(board, result, index+1);
                board[index][i] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        for (int i=rowIndex-1; i>=0; i--) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
        
        for (int i=x-1, j=y-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        
        for (int i=x-1, j=y+1;  i>=0 && j<board.length; i--, j++) {
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
