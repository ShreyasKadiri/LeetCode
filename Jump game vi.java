class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            int currentMax=deque.isEmpty() ? 0 : nums[deque.peekFirst()];
            nums[i] = nums[i] + currentMax;
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.add(i);
            while (!deque.isEmpty() && i-deque.peekFirst()+1 > k)
                deque.pollFirst();
        }
        return nums[nums.length-1];
    }
}
