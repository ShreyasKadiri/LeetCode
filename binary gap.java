//String manipulation

class Solution {
    public int binaryGap(int n) {
        String binaryString  = Integer.toBinaryString(n);
        int gap = 0;
        int previousOneIndex = binaryString.indexOf("1"); 
        
        for(int i=previousOneIndex+1; i<binaryString.length(); i++){
            if(binaryString.charAt(i) == '1'){
                gap = Integer.max(gap, i-previousOneIndex);
                previousOneIndex = i;
            }
        }
        return gap;
    }
}


//Bitwise
class Solution {
    public int binaryGap(int n) {
      int maximumGap = 0;
      for(int gap=-32; n>0;  n/=2, gap++){
          if(n%2 == 1){
            maximumGap = Math.max(maximumGap, gap);
              gap = 0;
          }
      }
        return maximumGap;
    }
}
