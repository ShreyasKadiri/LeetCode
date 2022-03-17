class Solution {
    public int scoreOfParentheses(String S) {
        int score=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(char c: S.toCharArray()){
            if(c=='('){
                stack.push(score);
                score=0;
            }
            else{
                score= Math.max(2*score,1)+stack.pop();
            }
        }
        return score;
    }
}
