class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int edge[] : edges){
            map.put(edge[0], map.getOrDefault(edge[0],0)+1);
            map.put(edge[1], map.getOrDefault(edge[1],0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == edges.length){
                return entry.getKey();
            }
        }
        return -1;
    }
}


//One Liner
class Solution {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
