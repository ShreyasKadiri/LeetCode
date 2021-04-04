class MyCircularQueue {
    int front = -1;
    int read = -1;
    int queue[];
    int size = 0;
    
    public MyCircularQueue(int k) {
        queue[] = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            rear = (rear + 1)%queue.length;
            queue[rear] = value;
            rear++;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            front = (front + 1)%queue.length;
            size--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        
    }
    
    public int Rear() {
        
    }
    
    public boolean isEmpty() {
        return queue.length == 0;
    }
    
    public boolean isFull() {
        return queue.length == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
