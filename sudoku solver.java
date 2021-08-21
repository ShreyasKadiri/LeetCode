class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return ;
        }
        solveSudokuBoard(board);
    }
    
    private boolean solveSudokuBoard(char board[][]){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    //Try placing the below characters
                    for(char c='1'; c<='9'; c++){
                        if(isBoardValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solveSudokuBoard(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isBoardValid(char board[][], int i, int j, char c){
        int currentRow = 3 * (i/3);
        int currentColumn = 3 * (j/3);
        for(int x=0; x<9; x++){
            if(board[x][j] == c || board[i][x] == c || board[currentRow + x/3][currentColumn + x%3] == c){
                return false;
            }
        }
        return true;
    }
}
