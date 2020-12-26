class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int result[] = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<nums.length*2; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){
                result[stack.pop()] = nums[i%n];
            }
            if(i<nums.length) stack.push(i);
        }
        
        return result;
}