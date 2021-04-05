class Solution {
    public boolean isIdealPermutation(int[] A) {
        int maximum = 0;
        for (int i=0; i<A.length-2; i++) {
            maximum = Math.max(maximum, A[i]);
            if (maximum > A[i+2]){
                return false;
            }          
        }
        return true;
    }
}
