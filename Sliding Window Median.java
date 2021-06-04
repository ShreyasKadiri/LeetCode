class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue queue = new Queue();
        double[] result=new double[nums.length-k+1];
        int index=0;
        for(int i=0; i<nums.length; i++){
            queue.offer(nums[i]);
            if(queue.size()==k){
                result[index++]=queue.getMedian();
                queue.remove(nums[i+1 - k]);
            }
        }
        return result;
    }
    
    class Queue{
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>(); 
        void offer(int num){
            maxHeap.offer(num);            
            minHeap.offer(maxHeap.poll());   
            if(maxHeap.size() < minHeap.size()){ 
                maxHeap.offer(minHeap.poll());
            }
        }
        double getMedian(){
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : ((long)maxHeap.peek() + minHeap.peek()) * 0.5;
        }
        
        int size(){
            return maxHeap.size()+minHeap.size();
        }
        
        boolean remove(int ele){
            return maxHeap.remove(ele) || minHeap.remove(ele);
        }
     
    }
}