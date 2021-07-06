class Solution {
    public int smallestRangeI(int[] A, int K) {
        return (A[A.length-1] - K) - (A[0]+K); 
    }
}
