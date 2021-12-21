class Solution{
    public boolean isPowerOfTwo(int n){
        if(n <= 0){
             return false;
        }
        if(n == 1){
            return true;
        }
            
        int shift = 0;
        for (int i=0; i<32; i++) {
            shift+= (n >> i)&1;                      //  >>=1 right shift by 1 means dividing by 2
        }
        return shift == 1;
    }
}
