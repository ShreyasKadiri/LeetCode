class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int low=0;
        int high=piles[piles.length-1];
        while(low<high){
            int mid=(low+high)/2;
            int count=0;
            for(int pile: piles) 
                count+=Math.ceil((double)pile/mid);
            if (count>H) 
                low=mid+1;
            else 
                high=mid;
        }
        return low;
    }
}