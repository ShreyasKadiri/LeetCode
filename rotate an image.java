class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[j][i] = matrix[i][j];
            }
        }
        
        //Reverse row by row
        /*for(int j = 0; j < array.length; j++){
            for(int i = 0; i < array[j].length / 2; i++) {
                int temp = array[j][i];
                array[j][i] = array[j][array[j].length - i - 1];
                array[j][array[j].length - i - 1] = temp;
            }
        }*/
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
        return ;
    }
}
