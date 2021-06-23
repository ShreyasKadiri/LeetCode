class SeatManager {
    PriorityQueue<Integer> minHeap;
    int n;
    
    public SeatManager(int n) {
        this.n = n;
        minHeap = new PriorityQueue<Integer>();
        for(int i=n; i>=1; i--){
            minHeap.add(i);
        }
    }
    
    public int reserve() {
        return minHeap.poll();
    }
    
    public void unreserve(int seatNumber) {
        minHeap.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
