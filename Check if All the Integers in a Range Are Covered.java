class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int[] range : ranges) {
            for(int i=range[0]; i<=range[1]; i++) {
                set.add(i);
            }
        }
        
        for(int i=left; i<=right; i++){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}
