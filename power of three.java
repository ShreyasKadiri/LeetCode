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


//Time complexity O(log(n)), space complexity O(1)
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n%3 == 0) {
            n/=3;
        }
        return n==1;
    }
}

//Time complexity: O(1), space complexity: O(1)
class Solution {
    public boolean isPowerOfThree(int n) {
            return n>0 && 1162261467%n == 0;
    }
}
