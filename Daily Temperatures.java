class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int warmTemperatures[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                warmTemperatures[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return warmTemperatures;
    }
}
