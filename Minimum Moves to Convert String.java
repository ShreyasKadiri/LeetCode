class Solution {
    public int minimumMoves(String s) {
        int count = 0;
        int  i = 0;
        while(i < s.length()){
            if(s.charAt(i) == 'X'){
                count+=1;
                i+=3;
            }else{
                i++;
            }
        }
        return count;
    }
}
