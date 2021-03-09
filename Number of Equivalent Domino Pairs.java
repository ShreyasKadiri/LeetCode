class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        for(int i=0; i<dominoes.length; i++){
            for(int j=i+1; j<dominoes.length; j++){
                if(dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]
                            ||
                  dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]
                  ){
                    count+=1;
                }
            }   
        }
        return count;
    }
}
