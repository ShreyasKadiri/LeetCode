class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i=0; i<matchsticks.length; i++){
            sum+= matchsticks[i];
        }
        if(sum%4 !=0){
            return false;
        }
        int side = sum / 4;
        int sides[] = new int[]{side, side, side, side};
    
        return backTrack(matchsticks, 0, sides);
    }
    
    private boolean backTrack(int matchsticks[], int i, int sides[]){
        if(i == matchsticks.length){
            return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
        }
        
        for(int j=0; j<4; j++){
            if(matchsticks[i] > sides[j]){
                continue;
            }
            sides[j]-= matchsticks[i];
            if(backTrack(matchsticks, i+1, sides)){
                return true;
            }
            sides[j]+= matchsticks[i];
        }
        return false;
    }
}
