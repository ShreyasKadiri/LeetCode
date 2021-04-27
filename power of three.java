class Solution {
    public boolean isPowerOfThree(int n) {
        for(int i=0; i<31; i++){
            if(Math.pow(3, i) == n){
                return true;
            }
        }
        return false;
    }
}

//One liner 
class Solution {
    public boolean isPowerOfThree(int n) {
            return n>0 && 1162261467%n == 0;
    }
}
