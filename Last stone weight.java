class Solution {
    public int lastStoneWeight(int[] stones) {
       if(stones.length == 0){
           return -1;
       }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++){
            maxHeap.add(stones[i]);
        }
        
        int firstElement=0;
        int secondElement=0;
        while(maxHeap.size() > 1){
            firstElement=maxHeap.poll();
            secondElement = maxHeap.poll();
        
        if(secondElement <= firstElement){
            maxHeap.add(firstElement - secondElement);
        }
    }
        return maxHeap.size()==0 ? 0 : maxHeap.poll();
    }
}
