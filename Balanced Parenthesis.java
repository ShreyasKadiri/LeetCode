public class Solution {
    public int solve(String A) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : A.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else if(c==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }
            else{
                return 0;
            }
        }
        return stack.isEmpty()==true ? 1 :0;
    }
}
