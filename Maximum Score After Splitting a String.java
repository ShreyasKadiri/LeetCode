class Solution {
    public int maxScore(String s) {
     int maximumScore = Integer.MIN_VALUE;
        int zeroesCount = 0;
        int onesCount=0;
      for(int i=0; i<s.length(); i++){
          if(s.charAt(i) == '0'){
              zeroesCount+=1;
          }else {
              onesCount+=1;
          }
          
          if(i!=s.length()-1){
            maximumScore = Math.max(zeroesCount - onesCount, maximumScore);  
          } 
      }
        return maximumScore+onesCount;
    }
}
