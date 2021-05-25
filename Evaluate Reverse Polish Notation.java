class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens){
            if("+-*/".contains(token)){
                stack.push(calculate(stack.pop(), stack.pop(), token));
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    public int calculate(int firstOperand, int secondOperand, String operator){
        if("+".equals(operator)){
            return firstOperand + secondOperand;
        }else if("*".equals(operator)){
            return firstOperand * secondOperand;
        }else if("/".equals(operator)){
            return  secondOperand / firstOperand;
        }else {
            return secondOperand - firstOperand;
        }
    }
}
