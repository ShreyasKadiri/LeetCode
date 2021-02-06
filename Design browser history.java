class BrowserHistory {

    Stack<String> stack1 = new Stack<String>();
    Stack<String> stack2  = new Stack<String>();
    
    public BrowserHistory(String homepage) {
        while(!stack1.isEmpty()){
            stack1.pop();
        }
         while(!stack2.isEmpty()){
            stack2.pop();
        }
        stack1.push(homepage);
    }
    
    public void visit(String url) {
        stack1.push(url);
        while(!stack2.isEmpty()){
            stack2.pop();
        }
    }
    
    public String back(int steps) {
        while(steps-- >0  && stack1.size()>1){
            stack2.push(stack1.top());
            stack1.pop();
        }
        return stack1.top();
    }
    
    public String forward(int steps) {
        while(steps-- >0 && stack2.size()>0){
            stack1.push(stack2.top());
            stack1.pop();
        }
        return stack1.top();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
