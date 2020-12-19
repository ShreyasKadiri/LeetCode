class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int sortedRows[] = new int[k];
        //HashMap to store row number and corresponding number of ones
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<mat.length; i++){
            int count=0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    count+=1;
                }
            }
            map.put(i, count);
        }
      
    //MinHeap to keep track of rows with minimum number of ones
PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey() - (b.getKey()) : a.getValue() - b.getValue() );
        
//Insert all elements from hashmap to minHeap
for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    minHeap.offer(entry);
}
        
//Populating the sortedRows array with respective count of ones
for(int i=0; i<k; i++){
    Map.Entry<Integer,Integer> entry = minHeap.poll();
    sortedRows[i] =  entry.getKey();
}
      return sortedRows;
    }
}
