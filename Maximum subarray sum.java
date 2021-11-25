class Solution{
    public static int maxSubArray(int[] nums){
        int meh = 0;
        int msf = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            meh = meh + nums[i];
            if(msf<meh)
                msf=meh;
            if(meh<0)
                meh=0;
        }
        return msf;
    }
}
