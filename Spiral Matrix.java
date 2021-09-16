class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        int direction = 0;
        
        while(top <= bottom && left <= right){
            if(direction == 0){
                for(int i=left; i<=right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
            }
            
            if(direction == 1){
                for(int i=top; i<=bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
            }
            
             if(direction == 2){
                for(int  i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if(direction == 3){
                for(int i=bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            direction++;
            direction = direction % 4;
        }
        
        return  result;
    }
}
