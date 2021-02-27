class Solution {
    public boolean hasAlternatingBits(int n) {
        String binaryResult = Integer.toBinaryString(n);
        for(int i=1; i<binaryResult.length(); i++){
            if( (binaryResult.charAt(i) == '0' && binaryResult.charAt(i-1)=='1')  || (binaryResult.charAt(i-1) == '0' && binaryResult.charAt(i)=='1')){
                   continue;
               }else {
                   return false;
               }
        }
        return true;
    }
}



class Solution {
    public boolean hasAlternatingBits(int n) {
        int currentBit=0;
        int previousBit=-1;
        while(n!=0) {
            currentBit=n&1;
            if(currentBit==previousBit){
                return false;
            } 
            n >>>= 1;
            previousBit = currentBit;
        }
        return true;
    }
}
