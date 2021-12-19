class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == ']'){
                StringBuilder current = new StringBuilder();
                while(stack.peek() != '['){
                    current.append(stack.pop());
                }
                stack.pop();
                StringBuilder digit = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    digit.append(stack.pop());
                }
                int frequency = Integer.parseInt(String.valueOf(digit.reverse()));
                                
                String currentString = current.reverse().toString();
                
                for(int i=1; i<frequency; i++){
                    current.append(currentString);
                }
                
                for(char ch : current.toString().toCharArray())
                    stack.push(ch); 
            } else {
                stack.push(c);    
            } 
        }
        
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
