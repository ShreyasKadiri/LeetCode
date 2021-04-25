class Solution {
    public void rotate(int[][] matrix){
        int temp=-1;
        for (int i=0; i<matrix.length/2; i++){ 
        for (int j=i; j<matrix.length-i-1; j++){ 
            temp = matrix[i][j]; 
            matrix[i][j] = matrix[matrix.length-1-j][i]; 
            matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j]; 
            matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i]; 
            matrix[j][matrix.length-1-i] = temp;
        } 
      }     
        return ;
    }
}
