class Solution {
    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        return dfs(dp, boxes, 0, boxes.length-1, 0);
    }

    private int dfs(int[][][] dp, int[] boxes, int left, int right, int streak) {
        if (left > right) {
            return 0;
        } else if (left == right) {
            return (streak +1)* (streak+1);
        } else if (dp[left][right][streak] != 0) {
            return dp[left][right][streak];
        } else {
            int maximum = dfs(dp, boxes, left+1, right, 0) + (streak+1) *(streak+1);
            for (int i=left+1; i<=right; i++) {
                if (boxes[left] == boxes[i]) {
                    maximum = Math.max(maximum, dfs(dp, boxes, left+1, i-1, 0) + dfs(dp, boxes, i, right, streak+1));
                }
            }
            dp[left][right][streak]  = maximum;
            return maximum;
        }
    }
}
