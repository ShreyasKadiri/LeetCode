class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = getLowerNumbersThanMid(m, n, mid);
            if(count < k){
                low = mid + 1;
            } 
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    private int getLowerNumbersThanMid(int m, int n, int target){
        int row = m - 1;
        int column = 0;
        int result = 0;
        while(row >= 0 && column < n){
            if((row+1) * (column+1) > target){
                row--;
            }
            else{
                result+= row + 1;
                column++;
            }
        }
        return result;
    }
}
