class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char currentDigit = board[i][j];
                if(currentDigit != '.'){
                    if(set.contains(currentDigit + "_R_" + i) || set.contains(currentDigit + "_L_" + j) || set.contains(currentDigit + "_subgrid_" + i/3 + "_" + j/3)){
                        return false;
                    }else{
                        set.add(currentDigit + "_R_" + i);
                        set.add(currentDigit + "_L_" + j);
                        set.add(currentDigit + "_subgrid_" + i/3 + "_" + j/3);
                    }
                }
            }
        }   
        return true;
    }
}
