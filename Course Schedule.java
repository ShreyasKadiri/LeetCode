/*
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        //Initialising an adjacency list with initial nodes 
        for(int i=0; i<numCourses; i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int edge[] : prerequisites){
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        boolean temporaryMarked[] = new boolean[numCourses];
        boolean permanentMarked[] = new boolean[numCourses];
        
        //Check if cycle / loop exists
        for(int i=0; i<numCourses; i++){
            if(checkIfLoopExists(i, temporaryMarked, permanentMarked, adjacencyList)){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkIfLoopExists(int currentNode, boolean temporaryMarked[], boolean permanentMarked[], List<List<Integer>> adjacencyList){
        if(temporaryMarked[currentNode]){
            return true;
        }
        if(permanentMarked[currentNode]){
            return false;
        }
        temporaryMarked[currentNode] = true;
        //Check the loop by visiting the adjacent nodes
        for(int adjacentNode : adjacencyList.get(currentNode)){
            if(checkIfLoopExists(adjacentNode, temporaryMarked, permanentMarked, adjacencyList)){
                return true;
            }
        }
        temporaryMarked[currentNode] = false;
        permanentMarked[currentNode] = true;
        return false;
    }
}
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int[] visited = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int edge[] : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        for (int i=0; i<numCourses; i++) {
            if (visited[i] == 0 && checkIfLoopExists(graph, visited, i)){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkIfLoopExists(List<List<Integer>> graph, int[] visited, int currentNode) {
        visited[currentNode] = -1; 
        for (int adjacentNode : graph.get(currentNode)) {
            if (visited[adjacentNode] == -1){
                return true;
            }
            else if (visited[adjacentNode] == 0 && checkIfLoopExists(graph, visited, adjacentNode)){
                 return true;
            }
        }
        visited[currentNode] = 1; 
        return false;
    }
}
