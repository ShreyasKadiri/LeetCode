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
