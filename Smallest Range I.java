class Solution {
    public int smallestRangeI(int[] A, int K) {
        int minimumValue = A[0];
        int maximumValue = A[0];
        for(int i=0; i<A.length; i++){
            minimumValue = Math.min(minimumValue, A[i]);
            maximumValue = Math.max(maximumValue, A[i]);
        }
        if(minimumValue + K >= maximumValue - K){
            return 0;
        }else {
            return (maximumValue - K) - (minimumValue + K); 
        }
    }
}
