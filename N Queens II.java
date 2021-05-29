class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        dfs(0, n, 0, 0, 0);
        return count;
    }
    
    public void dfs(int row, int n, int column, int diagonal, int antiDiagonal) {
        if (row == n) {
            ++count;
            return;
        }
        for (int i=0; i<n; i++){
            boolean isColumnSafe = ((1 << i) & column) == 0;
            boolean isDiagonalSafe = ((1 << (n-1+row-i)) & diagonal) == 0;
            boolean isAntiDiagonalSafe = ((1 << (row + i)) & antiDiagonal) == 0;
            if (isColumnSafe && isDiagonalSafe && isAntiDiagonalSafe){
                dfs(row+1, n, (1 << i) | column, (1 << (n - 1 + row - i)) | diagonal, (1 << (row + i)) | antiDiagonal);
            }
        }
    }
}
