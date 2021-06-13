class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int result[] = new int[adjacentPairs.length+1];
        
        //Building the graph
        for(int i=0; i<adjacentPairs.length; i++){
            int node1 = adjacentPairs[i][0];
            int node2 = adjacentPairs[i][1];
            if(map.containsKey(node1)){
                ArrayList<Integer> neighbors = map.get(node1);
                neighbors.add(node2);
                map.put(node1, neighbors);
            }else {
                ArrayList<Integer> neighbors = new ArrayList<>();
                neighbors.add(node2);
                map.put(node1, neighbors);
            }
            
             if(map.containsKey(node2)){
                ArrayList<Integer> neighbors = map.get(node2);
                neighbors.add(node1);
                map.put(node2, neighbors);
            }else {
                ArrayList<Integer> neighbors = new ArrayList<>();
                neighbors.add(node1);
                map.put(node2, neighbors);
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> values = entry.getValue();
            if(values.size() == 1){
                result[0] = entry.getKey();
                break;
            }
        }
            int start = 1;
            int parent = -1;
            while(start < result.length){
                ArrayList<Integer> current = map.remove(result[start-1]);
                for(int i=0; i<current.size(); i++){
                    if(current.get(i)!= parent){
                        parent = result[start-1];
                        result[start++] = current.get(i);
                        break;
                    }
                }
        }
        return result;
    }
}
