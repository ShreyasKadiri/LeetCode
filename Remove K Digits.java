class Solution {
    public String removeKdigits(String num, int k) {
        if( k == num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<Character>();
        for(char c : num.toCharArray()){
            while(k > 0 && !stack.empty() && stack.peek() > c){
                k--;
                stack.pop();
            }
            if(stack.empty() && c == '0'){ 
                continue;
            }
            stack.push(c);
        }
        while(!stack.empty() && k > 0){
            stack.pop();
            k--;
        }
         if(stack.isEmpty()) {
             return "0";
         }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }      
        return sb.reverse().toString();
    }
}
