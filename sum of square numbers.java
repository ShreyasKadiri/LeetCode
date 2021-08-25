class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left <= right){
            if(left*left + right*right == c){
                return true;
            }else if(left*left + right*right < c){
                left+= 1;
            }else{
                right-=1;
            }
        }
        return false;
    }
}
