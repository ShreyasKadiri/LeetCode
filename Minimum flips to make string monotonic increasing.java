
class Solution {
    public int minFlipsMonoIncr(String s) {
        int minimumFlips = 0;
        int onesCount = 0;
        int zeroesCount = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zeroesCount+=1;
                minimumFlips = Math.min(onesCount, minimumFlips+1);
            }else{
                onesCount+=1;
            }
        }
        return minimumFlips;
    }
}
