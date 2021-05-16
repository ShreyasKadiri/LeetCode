class Solution {
    public int minSwaps(String s) {
        int numOnes = 0, numZeros = 0;
        char[] arr = s.toCharArray();
        
        char one = '1', zero = '0';
        int cntOnes = 0, cntZeros = 0;
        
        for(char c : arr){
            if(c == '1')
                numOnes++;
            if(c == '0')
                numZeros++;
            
            if(c != one)
                cntOnes++;
            if(c != zero)
                cntZeros++;
				
            one = one == '1' ? '0' : '1';
            zero = zero == '1' ? '0' : '1';
        }
        
        if(Math.abs(numOnes-numZeros) > 1)
            return -1;
        
        if(cntOnes % 2 == 1 && cntZeros % 2 == 1)
            return -1;
        
        if(cntOnes % 2 == 1)
            return cntZeros / 2;
        
        if(cntZeros % 2 == 1)
            return cntOnes / 2;
        
        return Math.min(cntOnes / 2, cntZeros / 2);
    }
}
