class Solution {
    public String reverseOnlyLetters(String s) {
        String result = "";
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c>='a' && c<='z' || c>='A' && c<= 'Z'){
                stack.push(c);
            }
        }
            
             for(char C : s.toCharArray()){
                if(C>='a' && C<='z' || C>='A' && C<= 'Z'){
                        result+= stack.pop();
                }else{
                    result+= C;
                }
             }
        return result;
    }
}
