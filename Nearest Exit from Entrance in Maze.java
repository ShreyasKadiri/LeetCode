class Solution {
    public int nearestExit(char[][] grid, int[] entrance) {
        if (grid.length == 0 || grid[0].length == 0){
            return-1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[][] directions = {{1,0}, {-1,0}, {0,1}, { 0,-1}};
        queue.addLast( entrance[0] * grid[0].length +  entrance[1]);
        grid[ entrance[0]][ entrance[1]] = '+';
        int level=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int index = queue.removeFirst();
                int sourceRow = index / grid[0].length;
                int sourceColumn = index % grid[0].length;
                for (int i=0; i<directions.length; i++) {
                    int row = sourceRow + directions[i][0];
                    int column = sourceColumn + directions[i][1];
                    if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && grid[row][column] == '.') {
                        if(row ==0 || row == grid.length-1 || column == 0 || column == grid[0].length-1){
                            return level;
                        }
                        grid[row][column]='+';
                        queue.addLast(row * grid[0].length + column);
                    }
                }
            }
        }
        return -1;
    }
}
