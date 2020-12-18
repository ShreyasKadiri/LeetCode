class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
      if(arr.length==0){
          return false;
      }
        int count=0;
        int i=0;
       for(i=0; i<arr.length; i++){
           if(arr[i]%2==0){
               count = 0;
           }else if(++count==3){
               return true;
           }
       }
        return false;
    }
}
