class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aliceSum = 0;
        int bobSum = 0;
        int result[] = new int[2];
        for(int i=0; i<A.length; i++){
            aliceSum+= A[i];
        }
        for(int i=0; i<B.length; i++){
            bobSum+= B[i];
        }
        
        int target = (aliceSum - bobSum)/2;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                if(A[i] == B[j] + target){
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return new int[]{0,0};
    }
}
