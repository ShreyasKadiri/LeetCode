class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=10001;
        int[] values=new int[n];
        for (int i:nums)
            values[i]+=i;
        int pick=0;
        int dontPick=0;
        for (int i=0; i<n; i++) {
            int picki=dontPick+values[i];
            int dontPicki=Math.max(dontPick,pick);
            pick=picki;
            dontPick=dontPicki;
        }
        return Math.max(pick,dontPick);
    }
}