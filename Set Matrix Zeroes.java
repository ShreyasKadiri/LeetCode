class Solution {
     public void setZeroes(int[][] matrix) {
         List<Integer> rows = new ArrayList<>();
         List<Integer> columns = new ArrayList<>();

         for(int i=0; i<matrix.length; i++){
             for(int j=0; j<matrix[0].length; j++){
                 if(matrix[i][j] == 0){
                     rows.add(i);
                     columns.add(j);
                 }
             }
         }

         for(int rowIndex : rows){
             makeRowZero(matrix, rowIndex);
         }

         for(int columnIndex : columns){
             makeColumnsZero(matrix, columnIndex);
         }

         return;
     }

     private void makeRowZero(int[][] matrix, int rowIndex){
         for(int j=0; j<matrix[0].length; j++) {
             matrix[rowIndex][j] = 0;
         }
     }


     private void makeColumnsZero(int[][] matrix, int columnIndex){
         for(int i=0; i<matrix.length; i++) {
             matrix[i][columnIndex] = 0;
         }
     }
 }
