class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int openedParentheses = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                openedParentheses++;
            }else if(c == ')'){
                openedParentheses--;
            }
            depth = Math.max(openedParentheses, depth);
        }
        return depth;
    }
}
