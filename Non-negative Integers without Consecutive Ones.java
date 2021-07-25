class Solution {
    public int findIntegers(int n) {
        int count = 0;
        for(int i=0; i<=n; i++){
            String number = Integer.toBinaryString(i);
            if(!containsContinuousOnes(number)){
                count++;
            }
        }
        return count;
    }
    
    private boolean containsContinuousOnes(String number){
        for(int i=1; i<number.length(); i++){
            if(number.charAt(i) == '1' && number.charAt(i-1) == '1'){
                return true;
            }
        }     
        return false;
    }
}
