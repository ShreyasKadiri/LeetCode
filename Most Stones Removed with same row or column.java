//Number of stones= Total number of stones - Number of connected components
//Approach: Disjoint set or DFS(also possible)
class Solution {
    public int removeStones(int[][] stones) {
         HashSet<int[]> visited = new HashSet<int[]>();
        int numOfConnectedComponents=0;
        for(int[] stone:stones){
            if (!visited.contains(stone)){
               dfs(stone,visited,stones); 
               numOfConnectedComponents++;
            }
        }
        return stones.length-numOfConnectedComponents;
    }
    
    private void dfs(int[] stone, HashSet<int[]> visited, int[][] stones){
        visited.add(stone);
        for (int[] Stone: stones){
            if (!visited.contains(Stone)){
                if (stone[0]==Stone[0] ||stone[1]==Stone[1])
                    dfs(Stone,visited,stones);
            }
        }
    }
    
}