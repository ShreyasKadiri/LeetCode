class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> (b-a));
        int total = 0;
        for(int i=0; i<target.length; i++){
            total+= target[i];
            maxHeap.add(total);
        }
        while(!maxHeap.isEmpty()){
            int popped = maxHeap.poll();
            total-=popped;
            if(popped == 1 || total == 1){
                return true;
            }
            if(total ==0 || popped<total || popped%total == 0){
                return false;
            }
            popped = popped % total;
            total = total + popped;
            maxHeap.add(popped);
        }
        return true;
    }
}
