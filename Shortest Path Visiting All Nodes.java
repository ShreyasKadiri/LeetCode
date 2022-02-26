class Solution {
    public int shortestPathLength(int[][] graph) {
        int target = (1 << graph.length) - 1;
        boolean[][] visited = new boolean[graph.length][target];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<graph.length; i++) {
            queue.offer(new int[]{i, 1 << i});
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] currentNode = queue.poll();
                int node = currentNode[0];
                int state = currentNode[1];
                if (state == target) {
                    return count;
                }
                if (visited[node][state]) {
                    continue;
                }
                visited[node][state] = true;
                for (int next : graph[node]) {
                    queue.offer(new int[]{next, state | (1 << next)});
                }
            }
            count++;
        }
        return -1;
    }
}
