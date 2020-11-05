class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows;
    int cols;
    public int cutOffTree(List<List<Integer>> forest) {
        rows = forest.size();
        cols = forest.get(0).size();
        int[][] matrix = new int[rows][cols];
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                matrix[r][c] = forest.get(r).get(c);
                if (matrix[r][c] > 1) {
                    map.put(matrix[r][c], new int[]{r, c});
                }
            }
        }
        int x = 0, y = 0, res = 0;
        for (int t : map.keySet()) {
            int[] pos = map.get(t);
            boolean[][] visited = new boolean[rows][cols];
            int step = bfs(x, y, pos[0], pos[1], matrix, visited);
            if (step == -1) {
                return -1;
            }
            res += step;
            matrix[x][y] = 1;
            x = pos[0];
            y = pos[1];
        }
        return res;
    }
    
    private int bfs(int r, int c, int x, int y, int[][] matrix, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                if (cur[0] == x && cur[1] == y) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nr = dir[0] + cur[0];
                    int nc = dir[1] + cur[1];
                    if (0 <= nr && nr < rows && 0 <= nc && nc < cols && matrix[nr][nc] > 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}