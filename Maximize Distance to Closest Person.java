class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int maximumDistance = 0;
        for(int i=0; i<seats.length; i++){
            if(seats[i] == 1){
                if(left == -1){
                    maximumDistance = i;
                }else{
                    maximumDistance = Math.max(maximumDistance, (i - left)/2);
                }
                left = i;
            }
        }
        
        if(seats[seats.length-1] == 0){
            maximumDistance = Math.max(maximumDistance, seats.length-1-left);
        }
        return maximumDistance;
    }
}
