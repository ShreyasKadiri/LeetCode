class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens){
            if(token == "+" || token == "-" || token == "*" || token == "/"){
                stack.push(calculate(stack.pop(), stack.pop(), token));
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    public int calculate(int firstOperand, int secondOperand, String operator){
        if(operator == "+"){
            return firstOperand + secondOperand;
        }else if(operator == "*"){
            return firstOperand * secondOperand;
        }else if(operator == "/"){
            return  secondOperand / firstOperand;
        }else if(operator == "-"){
            return secondOperand - firstOperand;
        }
        return -1;
    }
}
