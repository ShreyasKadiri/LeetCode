class FreqStack {
    PriorityQueue<Node> maxHeap;
    HashMap<Integer,Integer> map;
    int index = 0;
    public FreqStack() {
        maxHeap = new PriorityQueue<Node>();
        map = new HashMap<Integer,Integer>();
    }
    
    public void push(int x) {
        if(map.containsKey(x)){
            map.put(x, map.get(x)+1);
        }else{
            map.put(x,1);
        }
        maxHeap.offer(new Node(x, map.get(x), index++));
    }
    
    
    public int pop() {
        int pop = maxHeap.remove().value;
        int frequency = map.get(pop);
        if(frequency == 1){
            map.remove(pop);
        }else{
            map.put(pop, map.get(pop)-1);
        }
        return pop;
    }
    
    
    class Node implements Comparable<Node>{
        int value;
        int frequency;
        int index;
        
        public Node(int v, int f, int index){
            this.value = v;
            this.frequency = f;
            this.index = index;
        }
        
        public int compareTo(Node node){
            if(this.frequency == node.frequency)
                return node.index-this.index;
            return node.frequency- this.frequency;
        }
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
