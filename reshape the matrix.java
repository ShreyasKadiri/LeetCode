class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c){
        if(r*c == (mat.length * mat[0].length)){
            int[][] result = new int[r][c];
            int startingRow = 0;
            int startingColumn = 0;
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    result[i][j] = mat[startingRow][startingColumn];
                    startingColumn++;
                    if(startingColumn == mat[0].length){
                        startingRow++;
                        startingColumn = 0;
                    }
                }
            }
            return result;
        }else{
            return mat;
        }
    }
}
