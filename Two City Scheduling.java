class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;
        Arrays.sort(costs,(a,b)->((a[0]-a[1])-(b[0]-b[1])));
        for (int i=0; i<costs.length; i++) {
            totalCost += (i < costs.length/2)  ?  costs[i][0] : costs[i][1];   
        }
        return totalCost;
    }
}
