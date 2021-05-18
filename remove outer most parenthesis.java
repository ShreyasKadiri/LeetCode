class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder("");
        int openedParentheses = 0;
        for(char c : S.toCharArray()){
            if(c == '(' && openedParentheses++ > 0){
                sb.append(c);
            }if(c == ')' && openedParentheses-- > 1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
