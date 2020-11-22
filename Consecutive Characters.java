class Solution {
    public int maxPower(String s) {
        int maxLen=0;
        int count=0;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count+=1;
            }else{
                count=0;
            }
            maxLen = Math.max(count, maxLen);
        }
        return maxLen+1;
    }
}
