class Solution {
    public int numTimesAllBlue(int[] light) {
      int result=0; int right=0;
        for(int i=0; i<light.length; i++){
            right = Math.max(right, light[i]);
            if(right==i+1){
                result+=1;
            }
        }
        return result;
    }
}