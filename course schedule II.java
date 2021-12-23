class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> currentTraversedNodes = new ArrayList<>();
        int[] visited = new int[numCourses];
        
        //Initialising the graph
        for (int i=0; i<numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        
        //Building the graph
        for(int edge[] : prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }       
        
        for (int i=0; i<numCourses; i++) {
            if (visited[i] == 0 && checkIfLoopExists(i, visited, graph, currentTraversedNodes)){
                return new int[0]; 
            }
        }
        int[] result = new int[currentTraversedNodes.size()];
        for (int i=0; i<currentTraversedNodes.size(); ++i) {
            result[i] = currentTraversedNodes.get(currentTraversedNodes.size()-i-1);
        }
        return result;
    }
    
    private boolean checkIfLoopExists(int currentNode, int[] visited, List<List<Integer>> graph, List<Integer> currentTraversedNodes) {
        visited[currentNode] = -1; 
        for (int adjacentNode : graph.get(currentNode)) {
            if (visited[adjacentNode] == -1) { 
                return true;
            }else if (visited[adjacentNode] == 0 && checkIfLoopExists(adjacentNode, visited, graph, currentTraversedNodes)) {
                    return true;
            }
        }
        visited[currentNode] = +1;
        currentTraversedNodes.add(currentNode); 
        return false;
    }
}
