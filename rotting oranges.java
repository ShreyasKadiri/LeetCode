class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i=0; i<grid.length ; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if(freshCount == 0){
            return 0;
        }
        int count = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] node = queue.poll();
                for(int direction[] : directions) {
                    int x = node[0] + direction[0];
                    int y = node[1] + direction[1];
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? count-1 : -1;
    }
}
