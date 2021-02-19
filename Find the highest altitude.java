class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int prefix[] = new int[gain.length+1];
        prefix[0] = 0;
        
        for(int i=0; i<gain.length; i++){
            prefix[i+1] = gain[i]+prefix[i];
        }
        
        for(int i=0; i<prefix.length; i++){
            maxAltitude = Math.max(prefix[i], maxAltitude);
        }
        
        return maxAltitude;
    }
}
