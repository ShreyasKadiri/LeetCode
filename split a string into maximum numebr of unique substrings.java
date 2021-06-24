class Solution {
    public int maxUniqueSplit(String s) {
        return backTrack(s, new HashSet<>());
    }
    
    private int backTrack(String s, HashSet<String> set){
        int maximum = 0;
        for(int i=1; i<=s.length(); i++){
            String currentString = s.substring(0,i);
            if(!set.contains(currentString)){
                set.add(currentString);
                maximum = Math.max(maximum, 1 + backTrack(s.substring(i), set));
                set.remove(currentString);
            }
        }
        return maximum;
    }
}
