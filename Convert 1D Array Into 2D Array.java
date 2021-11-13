class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[][]{};
        }
        int twoD[][] = new int[m][n];
        int k = 0;
        if(m*n == original.length){
          for(int i=0; i<m; i++){
              for(int j=0; j<n; j++){
                  twoD[i][j] = original[k++];
              }
          }  
        }
        return twoD;
    }
}
