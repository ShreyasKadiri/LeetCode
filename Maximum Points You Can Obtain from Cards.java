class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum[] = new int[k+1];
        int rightSum[] = new int[k+1];
        int maximum = 0;
        leftSum[0]=0;
        rightSum[0]=0;
        for(int i=1; i<=k; i++){
            leftSum[i] = cardPoints[i-1] + leftSum[i-1];
        }   
        
        for(int i=1; i<=k; i++){
            rightSum[i] = rightSum[i-1] + cardPoints[cardPoints.length-i];
        }   
        for(int i=0; i<=k; i++){
            maximum= Math.max(leftSum[i] + rightSum[k-i], maximum);
        }
        return maximum;
    }
}
