class Solution {
    public int numSpecial(int[][] mat) {
        //1ST Step: Count the number of ones in every row and columns
         int rows[] = new int[mat.length];
         int columns[] = new int[mat[0].length];
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    rows[i]++;
                    columns[j]++;
                }
            }
        }
        
        
//2nd pass: Check at (i,j) where there's 1, if number of 1's at this row and column is 1 and hence increment count
       int count=0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1 && rows[i] == 1 && columns[j] == 1){
                    count+=1;
                }
            }
        }
        return count;
    }
}
