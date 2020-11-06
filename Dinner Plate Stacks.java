/*
Approach:
1. Use a list stacks to save all stacks.
2. Use a heap queue q to find the leftmost available stack.
https://leetcode.com/problems/dinner-plate-stacks/discuss/366331/C%2B%2BPython-Two-Solutions
*/

class DinnerPlates {

    private final int capacity;
    private final TreeMap<Integer, Deque<Integer>> stacks;
    private final Treeset<Integer> available;
    
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new TreeMap<>();
        this.available= new TreeSet<Integer>();
    }
    
    
    public void push(int val) {
        int index=0;
        if(available.isEmpty()){
            Map.Entry<Integer, Deque<Integer>> entry = stacks.lastEntry();
            if(entry!=null){
                index = entry.get() + 1;
                available.add(index);
            }
            else{
                index = available.first();
            }
            Deque<Integer> stack = stacks.getOrDefault(index, new ArrayDeque());
            stack.push(val);
            if(stack.size()==capacity){
                available.remove(index);
            }
            stacks.put(index, stack);
        }
    }
    
    
    public int pop() {
        if(stacks.isEmpty()){
            return -1;
        }else{
            return popAtStack(stacks.lastKey());
        }
    }
    
    
    public int popAtStack(int index) {
        if(!stacks.containsKey(index)){
            return -1;
        }
        Deque<Integer> stack = stacks.get(index);
        int result = stack.pop();
        if(stack.size()==0)
            stacks.remove(index);
            available.add(index);
           return result;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */