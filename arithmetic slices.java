class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int result=0;
        int count=0;
        int dp[] = new int[A.length];
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                count+=1;
                result+=count;
            }else{
                count=0;
            }
        }
        return result;
    }
}
