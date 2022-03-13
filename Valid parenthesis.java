
class Solution {
    public boolean isValid(String s) {
        if(s.length()==0 || s==""){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='[' || c=='{' || c=='('){
                stack.push(c);
            }
            else if(!stack.isEmpty() && stack.peek()=='[' && c==']'){
                stack.pop();
            }
             else if(!stack.isEmpty() && stack.peek()=='{' && c=='}'){
                stack.pop();
            }
             else if(!stack.isEmpty() && stack.peek()=='(' && c==')'){
                stack.pop();
            }   
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
