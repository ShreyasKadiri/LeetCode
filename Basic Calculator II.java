public class Solution {
    public int calculate(String s) {
        int length = 0;
        if(s == null || (length = s.length()) == 0){
             return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0;
        char operator = '+';
        for(int i=0; i<length; i++){
            if(Character.isDigit(s.charAt(i))){
                number = number*10 + s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==length-1){
                if(operator=='-'){
                    stack.push(-number);
                }
                if(operator=='+'){
                    stack.push(number);
                }
                if(operator=='*'){
                    stack.push(stack.pop()*number);
                }
                if(operator=='/'){
                    stack.push(stack.pop()/number);
                }
                operator = s.charAt(i);
                number = 0;
            }
        }
        int result = 0;
        for(int element : stack){
            result += element;
        }
        return result;
    }
}
