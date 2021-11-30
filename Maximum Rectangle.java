public class Solution{
    public int maximalRectangle(char[][] matrix) {
        int[][] grid = new int[matrix.length][matrix[0].length];
        buildHistogram(matrix, grid);
        int maximum = 0;
        for (int i=0; i<grid.length; i++) {
            maximum = Math.max(maximum, maxRec(grid, i, matrix[i].length));
        }
        return maximum;
    }

    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int j=0; j<matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                grid[i][j]+= matrix[i][j] == '0' ? 0 : grid[i - 1][j] + 1;
            }
        }
    }

    private int maxRec(int[][] grid, int bottom, int n) {
        int maximum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int currentIndex = 0;
        while (currentIndex < n) {
            while (stack.peek() != -1 && grid[bottom][currentIndex] <= grid[bottom][stack.peek()]) {
                maximum = Math.max(maximum, grid[bottom][stack.pop()] * (currentIndex - stack.peek() - 1));
            }
            stack.push(currentIndex++);
        }

        while (stack.peek() != -1) {
            maximum = Math.max(maximum, grid[bottom][stack.pop()] * (currentIndex - stack.peek() - 1));
        }

        return maximum;
    }
}
