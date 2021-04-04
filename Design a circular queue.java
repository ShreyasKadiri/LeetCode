class MyCircularQueue {
        int[] queue;
        int front = 0;
        int rear = -1;
        int size = 0;

        public MyCircularQueue(int k) {
            queue = new int[k];
        }

        public boolean enQueue(int value) {
            if (!isFull()) {
                rear = (rear + 1) % queue.length;
                queue[rear] = value;
                size++;
                return true;
            } 
            return false;
        }

        public boolean deQueue() {
            if (!isEmpty()) {
                front = (front + 1) % queue.length;
                size--;
                return true;
            } 
            return false;
        }

        public int Front() {
             return isEmpty() ? -1 : queue[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
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
