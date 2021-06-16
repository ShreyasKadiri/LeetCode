class Solution {
    List<String> generatedParenthesis= new ArrayList<>();
    public List<String> generateParenthesis(int n){
        recursion(n, n, "");
        return generatedParenthesis;
    }
    
    public void recursion(int open, int close, String parenthesis){
        if(open ==0 && close>=0){
            while(close!=0){
                parenthesis = parenthesis + ")";
                close--;
            }
        }
        if(open==0 && close==0){
            generatedParenthesis.add(parenthesis);
            return;
        }
        if(open<close)
            recursion(open, close-1, parenthesis+")");
            recursion(open-1, close, parenthesis+"(");
    }
}
