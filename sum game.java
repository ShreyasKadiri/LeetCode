class Solution {
   public boolean sumGame(String s) {
       double result = 0;
       for (int i=0; i<s.length(); i++){
           result+= (i<s.length()/2 ? 1 : -1) * (s.charAt(i) == '?' ? 4.5 : s.charAt(i) - '0');
       }
       return result != 0;
    }
}
