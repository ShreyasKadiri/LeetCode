class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.add(Arrays.asList(0));
        int target = graph.length-1;
        while(!queue.isEmpty()){
            List<Integer>path=queue.poll();
            int prev=path.get(path.size()-1);
            if(prev==target){
                result.add(new ArrayList<>(path));
            }
            else{
                int neighbors[] = graph[prev];
                for(int neighbor : neighbors){
                    List<Integer> list = new ArrayList<Integer>(path);
                    list.add(neighbor);
                    queue.add(list);
                }
            }  
        }
        return result;
    }
}
