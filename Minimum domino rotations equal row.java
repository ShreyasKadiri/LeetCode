class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=6;i++) {
            int max=0;
            for(int j=0;j<tops.length;j++){
            if(tops[j]==i)
                continue;
            else if(bottoms[j]==i)
                max++;
            else{
                max=-1;
                break;
            }
        }
        if(max!=-1)
            ans=Math.min(ans,max);
    }
    for(int i=1;i<=6;i++){
        int max=0;
        for(int j=0;j<tops.length;j++){
            if(bottoms[j]==i)
                continue;
            else if(tops[j]==i)
                max++;
            else{
                max=-1;
                break;
            }
        }
        if(max!=-1)
            ans=Math.min(ans,max);
    }
    return ans==Integer.MAX_VALUE?-1:ans;
}
}
