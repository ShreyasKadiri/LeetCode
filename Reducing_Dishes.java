class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int prod=1;
        int maxSatisfaction=0;
        int zeroOrPositiveIdx=-1;
        boolean zeroOrPositiveIdxFound=false;
        int cumulativeSum=0;
        
        for(int i=0;i<satisfaction.length;i++)
        {
            if(!zeroOrPositiveIdxFound && satisfaction[i]>=0)
            {
                zeroOrPositiveIdx=i-1;
                zeroOrPositiveIdxFound=true;
            }
            
            if(satisfaction[i]<0)
                continue;
            
            maxSatisfaction+=satisfaction[i]*prod;
            prod++;
            cumulativeSum+=satisfaction[i];
        }
        while(zeroOrPositiveIdx>=0)
        {
            int curSatisfaction=satisfaction[zeroOrPositiveIdx]+maxSatisfaction+cumulativeSum;
            if(curSatisfaction>maxSatisfaction){
                maxSatisfaction=curSatisfaction;}
            cumulativeSum+=satisfaction[zeroOrPositiveIdx];
            zeroOrPositiveIdx--;
        }
        return maxSatisfaction;
    }
}