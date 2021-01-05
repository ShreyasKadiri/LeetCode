class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        for (int num: nums)
            map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(map.keySet());
        while (!maxHeap.isEmpty()) {
            int curr=maxHeap.poll();
            int count=map.get(curr);
            if(count==0)  continue;
            for (int i=0; i<k; i++) {
                Integer nextCount=map.get(curr+i);
                if (nextCount==null || nextCount<count) {
                    return false;
                }
                map.put(curr+i, nextCount-count);
            }
        }
        return true;
    }
}