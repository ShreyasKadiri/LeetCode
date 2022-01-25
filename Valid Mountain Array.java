class Solution {
    public boolean validMountainArray(int[] A){
        if(A.length < 3){
            return false;
        }
        
        int low = 0;
        int high = A.length-1;
        while(low < high){
            if(A[low] < A[low+1]){
                low++;
            }else if(A[high] < A[high-1]){
                high--;
            }else{
                return false;
            }
        }
        if(low == high && low != A.length-1 && high != 0){
            return true;
        }else{
            return false;
        }
    }
}
