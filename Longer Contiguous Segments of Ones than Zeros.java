class Solution {
    public boolean checkZeroOnes(String s) { 
        return longestSegmentOnes(s) > longestSegmentZeroes(s);
    }
    
    public int longestSegmentOnes(String s){
        int maximum = Integer.MIN_VALUE;
        int currentLength = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                currentLength+=1;
            }else {
                maximum = Math.max(currentLength, maximum);
                currentLength = 0;
            }
        }
        return maximum;
    }
    
    public int longestSegmentZeroes(String s){
        int maximum = Integer.MIN_VALUE;
        int currentLength = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                currentLength+=1;
            }else {
                maximum = Math.max(currentLength, maximum);
                currentLength = 0;
            }
        }
        return maximum;
    }
}
