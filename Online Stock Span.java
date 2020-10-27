class StockSpanner {
   Stack<Integer> stack = new Stack();
    public StockSpanner() {}
    
    public int next(int price) {
        int num=1;
        while(!stack.isEmpty() && stack.peek()%100_000<=price) 
            num+=stack.pop()/100_000;
        stack.push(100_000*num+price);
        return num;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */