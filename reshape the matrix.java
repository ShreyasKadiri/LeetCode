class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length!= r*c)  {
            return mat;
        }
        int[][] result = new int[r][c];
        int startingRow = 0;
        int startingColumn = 0;
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(startingColumn == c){
                    startingRow++;
                    startingRow = 0;
                }
                result[startingRow][startingColumn] = mat[i][j];
                startingColumn++;
            }
        }
        return result;
    }
}
