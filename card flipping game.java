class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<fronts.length; i++){
            if(fronts[i] == backs[i]){
                set.add(fronts[i]);
            }
        }
        
        int minimum = Integer.MAX_VALUE;
        for(int i=0; i<fronts.length; i++){
            if(!set.contains(backs[i])){
                minimum = Math.min(minimum, backs[i]);
            }
            if(!set.contains(fronts[i])){
                minimum = Math.min(minimum, fronts[i]);
            }
        }
        
        return minimum == Integer.MAX_VALUE ? 0 : minimum;
    }
}
