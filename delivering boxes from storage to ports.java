class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int[] dp = new int[boxes.length+1]; 
        int currentWeight = 0; 
        int trips = 2; 
        int k = 0;  
        for (int i=0; i<boxes.length; i++){ 
            currentWeight += boxes[i][1];
            if (i!=0 && boxes[i][0] != boxes[i-1][0]){
                trips++;
            }
            while(i-k>=maxBoxes || currentWeight > maxWeight || (k<i && dp[k] == dp[k+1])){
                currentWeight -= boxes[k][1];
                if (boxes[k+1][0] != boxes[k][0]){
                    trips--;
                }
                k++;
            }
            dp[i+1] = trips + dp[k];
        }
        return dp[boxes.length];
    }
}
