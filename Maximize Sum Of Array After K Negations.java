class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum=0;
        Arrays.sort(A);
        int minimumIndex=0;
        while (K>0) {
		A[minimumIndex]*=-1;
		K--;
		if (minimumIndex+1 < A.length && A[minimumIndex] > A[minimumIndex+1]) 
            minimumIndex++;
	  } 
        for(int i=0; i<A.length; i++){
            sum+=A[i];
        }
        return sum;
    }
}
