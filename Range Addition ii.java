class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minimumRow = m;
        int minimumColumn = n;
        for(int op[] : ops){
            minimumRow = Math.min(minimumRow, op[0]);
            minimumColumn = Math.min(minimumColumn, op[1]);
            
        }
        return minimumRow * minimumColumn;
    }
}
