class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    int currentBuilding = Integer.MAX_VALUE;
    int totalBricks = 0;
        
    for (int i=0; i<heights.length; i++) {
        int nextBuilding = heights[i];
        if (nextBuilding <= currentBuilding) {
            currentBuilding = nextBuilding;
            continue;
        }
        int difference = nextBuilding - currentBuilding;
        currentBuilding = nextBuilding;
        heap.offer(difference);
        if (heap.size() > ladders) {
            int popped = heap.poll();
            totalBricks += popped;
            if (totalBricks > bricks) {
                return i - 1;
            }
        }
    }
    return heights.length - 1;
    }
}
