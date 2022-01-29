class Solution{
    public int largestRectangleArea(int heights[]){
        if(heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        int maximumArea = Integer.MIN_VALUE;
        stack.push(heights[0]);
        for(int i=1; i<heights.length; i++){
            if(stack.peek() <= heights[i]){
                stack.push(i);
            }else {
                if(!stack.isEmpty()){
                    int top = stack.pop();
                    area = heights[top] * (stack.peek() -i - 1);
                }else {
                    area = heights[top];
                }
                maximumArea = Math.max(area, maximumArea);
            }
        }
        return maximumArea;
    }
}
