class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        int maxWealth = 0;
        for(int i=0; i<accounts.length; i++){
            for(int j=0; j<accounts[0].length; j++){
                wealth+=accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, wealth);
            wealth = 0;
        }
        return maxWealth;
    }
}
