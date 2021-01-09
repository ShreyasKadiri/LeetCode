class Solution {
    
    //O(n) time
    public int arrangeCoins(int n) {
        int i=1;
        int result=0;
        while(n>=i){
            n-=i;
            result+=1;
            i++;
        }
        return result;
    }
    
    
    //O(logn) time
   public int arrangeCoins(int n) {
        int low = 0;
        int high = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid*(mid+1))/2 <=n){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return low-1;
    }
    
    
    //O(1) time
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}
