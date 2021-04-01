class CustomStack {

    int n;
    int top;
    int stack[];
    public CustomStack(int maxSize) {
       n = maxSize;
       top=-1;
       stack = new int[n];
    }
    
    public void push(int x) {
        if(top<n-1){
            top+=1;
            stack[top]=x;
        }
    }
    
    public int pop() {
        if(top<=-1)
            return -1;
            int ele=top;
            top--;
        return stack[ele];
    }
    
    public void increment(int k, int val) {
        int min=Math.min(k-1,top);
        for(int i=0;i<=min;i++){
            stack[i]=stack[i]+val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */