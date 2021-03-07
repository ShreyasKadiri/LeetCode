class Solution {
    public boolean checkOnesSegment(String s) {
        int contiguous = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                contiguous++;
                 while(i+1 < s.length() && s.charAt(i+1) == '1'){
                i++;
              }
            }
        }
        return contiguous==1;
    }
}
