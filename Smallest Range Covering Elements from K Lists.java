class Solution{
public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> nums.get(o1[0]).get(o1[1]) - nums.get(o2[0]).get(o2[1]));
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            max = Math.max(nums.get(i).get(0), max);
            heap.add(new int[]{i, 0});
        }
        int[] result = new int[]{nums.get(heap.peek()[0]).get(0), max};
        while (heap.size() > 0) {
            int[] node = heap.poll();
            if(result[1] - result[0] > max - nums.get(node[0]).get(node[1])) {
                result[0] = nums.get(node[0]).get(node[1]);
                result[1] = max;
            }
            if(node[1] + 1 == nums.get(node[0]).size()) break;
            max = Math.max(max, nums.get(node[0]).get(node[1] + 1));
            heap.add(new int[]{node[0], node[1] + 1});
        }
        return result;
    }
}