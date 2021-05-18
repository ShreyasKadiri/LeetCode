class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder("");
        int opendParentheses = 0;
        for(char c : S.toCharArray()){
            if(c == '(' && opendParenthesis++ > 0){
                result.append(c);
            }if(c == ')' && openedParenthesis-- > 1){
                result.append(c);
            }
        }
        return sb.toString();
    }
}
