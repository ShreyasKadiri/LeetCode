class Solution {
    public List<String> braceExpansionII(String expression) {
        List<String> currList = new ArrayList<>();
        currList.add("");
        Stack<List<String>> stack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        char sign = '*';
        for (char c : expression.toCharArray()) {
            stack.push(new ArrayList<>(currList));
            currList.clear();
            currList.add("");
            
            if (c == '{' ) {
                while (!opStack.empty() && opStack.peek() != ','  && opStack.peek() != '{')
                    doOp(stack, opStack);
                opStack.push(sign);
                opStack.push('{');
                sign = '*';
            }
            
            else if (c == '}') {
                while (opStack.peek() != '{')
                    doOp(stack, opStack);
                opStack.pop();
                opStack.push(sign);
                sign = '*';
            }
            
            else if (c == ',') {
                while (!opStack.empty() && opStack.peek() != '{')
                    doOp(stack, opStack);
                opStack.push(sign);
                sign = ',';
            }
            
            else {
                currList.set(0, ""+c);
                while (!opStack.empty() && opStack.peek() != ','  && opStack.peek() != '{')
                    doOp(stack, opStack);
                opStack.push(sign);
                sign = '*';
            }
        }
        
        stack.push(currList);
        while (!opStack.empty())
            doOp(stack, opStack);
        
        List<String> res = stack.pop();
        Collections.sort(res);
        return res;
    }
    

    private List<String> multi(List<String> list1, List<String> list2) {
        List<String> res = new ArrayList<>();
        for (String s1 : list1) 
            for (String s2 : list2)
                res.add(s1 + s2);
        return res;
    }
    
    private List<String> plus(List<String> list1, List<String> list2) {
        Set<String> set = new HashSet<>(list1);
        set.addAll(list2);
        return new ArrayList<>(set);
    }
    
    private void doOp(Stack<List<String>> stack, Stack<Character> opStack) {
        List<String> list2 = stack.pop(), list1 = stack.pop();
        char c = opStack.pop();
        
        if (c == ',') stack.push(plus(list1, list2));
        else stack.push(multi(list1, list2));
    }
}
