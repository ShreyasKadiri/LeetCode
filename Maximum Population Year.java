class Solution {
    public int maximumPopulation(int[][] logs) {
        int maximum = -1;
        TreeMap<Integer, Integer> treeSet = new TreeMap<Integer,Integer>();
        for(int[] log : logs){
            while(log[0] < log[1]){
                treeSet.put(log[0], treeSet.getOrDefault(log[0], 0) + 1);
                maximum = Math.max(maximum, treeSet.get(log[0]));
                log[0]++;
            }
        }
        
        for(int key : treeSet.keySet()){
            if(treeSet.get(key) == maximum){
                return key;
            }
        }
        return -1;
    }
}
