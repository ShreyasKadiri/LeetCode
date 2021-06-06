class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maximumSequence = 0;
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])){
                continue;
            }
            int previous = map.getOrDefault(nums[i]-1, 0);
            int next = map.getOrDefault(nums[i]+1, 0);
            int totalSequenceCount = previous + next + 1;
            map.put(nums[i], totalSequenceCount);
            map.put(nums[i] + next, totalSequenceCount);
            map.put(nums[i] - previous, totalSequenceCount);
            maximumSequence = Math.max(totalSequenceCount, maximumSequence);
        }
        return maximumSequence;
    }
}
