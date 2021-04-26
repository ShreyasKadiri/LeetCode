class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> lad = new PriorityQueue<>();
    int cur = Integer.MAX_VALUE;
    int usedBricks = 0;
    for (int i = 0; i < heights.length; i++) {
        int next = heights[i];
        if (next <= cur) {
            cur = next;
            continue;
        }
        int dif = next - cur;
        cur = next;
        lad.offer(dif);
        if (lad.size() > ladders) {
            Integer candidate = lad.poll();
            usedBricks += candidate;
            if (usedBricks > bricks) {
                return i - 1;
            }
        }
    }
    return heights.length - 1;
    }
}
