class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] graph = new int[n][n];
        for (int[] edge : graph) {
            Arrays.fill(edge, -1);
        }
        for (int[] edge: edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        int result  = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        heap.add(new int[] {0, maxMoves});
        while (!heap.isEmpty()) {
            int[] nearestElement = heap.poll();
            int nearestNodeId = nearestElement[0];
            int maxMovesRemaining = nearestElement[1];
            if (visited[nearestNodeId]) {
                continue;
            }
            visited[nearestNodeId] = true;
            result++;
            for (int i=0; i<n; i++) {
                if (graph[nearestNodeId][i] != -1) {
                     if (!visited[i] && maxMovesRemaining >= graph[nearestNodeId][i] + 1) {
                        heap.add(new int[]{i, maxMovesRemaining - graph[nearestNodeId][i] - 1});
                     }
                    int movesCost = Math.min(maxMovesRemaining, graph[nearestNodeId][i]);
                    graph[i][nearestNodeId] -= movesCost;
                    graph[nearestNodeId][i] -= movesCost;
                    result+= movesCost;
                }
            }
        }
        return result;
    }
}
