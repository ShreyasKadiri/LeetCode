class Solution {
    public int cherryPickup(int[][] grid) {
    int C = grid[0].length;
    int[][] dp = new int[C][C], old = new int[C][C];
    for(int r = grid.length - 1; r >= 0; r--) {
        for(int c1 = Math.min(r, C - 1); c1 >= 0; c1--) {
            for(int c2 = Math.max(c1, C - 1 - r); c2 < C; c2++) {
                int max = 0;
                for(int i = c1 - 1; i <= c1 + 1; i++) {
                    for(int j = c2 - 1; j <= c2 + 1; j++) {
                        if(i >= 0 && i < C && j >= 0 && j < C && i <= j) max = Math.max(max, old[i][j]);
                    }
                }
                dp[c1][c2] = max + grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
            }
        }
      int[][] temp = dp; dp = old; old = temp;
    }
      return old[0][C - 1];
    }
}
