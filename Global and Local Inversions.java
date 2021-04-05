class Solution {
    public boolean isIdealPermutation(int[] A) {
        int globalInversions = 0;
        int localInversions = 0;
        
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                     if(i<j && A[i] > A[j]){
                         globalInversions++;
                     }
                }
            }
        
            for(int i=1; i<A.length; i++){
                if(A[i]  < A[i-1]){
                    localInversions++;
                }
            }
        return globalInversions == localInversions;
    }
}
