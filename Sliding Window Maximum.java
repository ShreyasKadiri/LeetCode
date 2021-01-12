class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque=new ArrayDeque<Integer>();
    int j=0;
    int[] result=new int[nums.length-k+1]; 
    for(int i=0;i<nums.length;i++){
        while(deque.size()>0 && deque.peek()<=i-k) 
            deque.poll(); 
        while(deque.size()>0 && nums[deque.peekLast()]<=nums[i]) 
            deque.pollLast();
        deque.add(i);
        if(i>=k-1){
            result[j++]=nums[deque.peek()];
        }
    }
    return result;
    }
}