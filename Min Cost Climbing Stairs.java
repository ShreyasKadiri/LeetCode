//Recursion
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return findMinimumCost(cost.length, cost);
    }

    private int findMinimumCost(int i, int[] cost) {
        if (i == 0 || i == 1) {
            return 0;
        }
        int first = findMinimumCost(i-2, cost) + cost[i-2];
        int second = findMinimumCost(i-1, cost) + cost[i-1];
        return Math.min(first, second);
    }
}


//Greedy
class Solution {
    public int minCostClimbingStairs(int[] cost){
        for (int i=2; i<cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}
