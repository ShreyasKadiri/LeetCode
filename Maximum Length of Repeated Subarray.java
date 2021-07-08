class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length+1][nums2.length+1];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                maximum = Math.max(maximum, dp[i][j]);
            }
        }
        return maximum;
    }
}
