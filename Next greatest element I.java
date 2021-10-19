class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=nums2.length-1; i>=0; i--) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                stack.pop();
            }

            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
            stack.push(i);
        }

        for (int i=0; i<nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
