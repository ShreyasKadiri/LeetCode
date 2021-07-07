//Brute Force
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int matrixElements[] = new int[matrix.length * matrix[0].length];
        int index = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrixElements[index++] = matrix[i][j];
            }
        }
        Arrays.sort(matrixElements);
        
        return matrixElements[k-1];
    }
}
