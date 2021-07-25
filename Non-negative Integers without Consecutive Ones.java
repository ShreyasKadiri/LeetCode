//Brute Force  --- TLE
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


class Solution {
    public int findIntegers(int n) {
        if (n < 2) {
            return n + 1;
        }
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        int[] cache = new int[sb.length()];
        cache[0] = 1;
        cache[1] = 2;
        for (int i=2; i<sb.length(); i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        int result = 0;
        for (int i=sb.length()-1; i>=0; i--) {
            if (sb.charAt(i) == '1'){
                result+= cache[i];
                if (i<sb.length()-1 && sb.charAt(i+1) == '1') { 
                    return result;
                }
            }
        }
        return result+1;
    }
}
