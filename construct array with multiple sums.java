class Solution {
     public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        long total = 0;
        for (int i=0; i<target.length; i++) {
            total += target[i];
            maxHeap.add(target[i]);
        }
         
         while (true) {
             int popped = maxHeap.poll();
             total = total - popped;
             if (popped == 1 || total == 1){
                 return true;
             }
             if (popped < total || total == 0 ||  popped% total == 0){
                 return false;
             }
             popped%= total;
             total = total + popped;
             maxHeap.add(popped);
         }
     }
}
