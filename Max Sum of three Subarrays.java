class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len=nums.length;
        int n=len-k+1;
        int[] dp=new int[n];
        int sum=0;
       
        for(int i=0; i<len; i++){
            sum+=nums[i];
            if(i>=k)
                sum=sum-nums[i-k];
            if(i>=k-1)
                dp[i-k+1]=sum;
        }

        int[] left=new int[n];
        int[] right=new int[n];
        int maxIndex=0;

        for(int i=0; i<n; i++) {
            if(dp[i]>dp[maxIndex])
                maxIndex=i;
            left[i]=maxIndex;
        }

        maxIndex=n-1;
        for (int i=n-1; i>=0; i--)
        {
            if (dp[i]>=dp[maxIndex])
                maxIndex=i;
            right[i]=maxIndex;
        }

        int[] result=new int[3];
        Arrays.fill(result,-1);

        for (int i=k;i<n-k;i++)
        {
            if (result[0]==-1 || dp[result[0]]+dp[result[1]]+dp[result[2]] <
                dp[left[i-k]]+dp[i]+dp[right[i+k]])
            {
                result[0]=left[i-k];
                result[1]=i;
                result[2]=right[i+k];
            }
        }
        return result;
    }
}
