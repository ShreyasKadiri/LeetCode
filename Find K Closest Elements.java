class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>( (a,b) -> (a[0]==b[0]) ? a[1]-b[1] : a[0]-b[0] );
        for(int i=0; i<arr.length; i++){
            int[] cache = new int[] {Math.abs(x-arr[i]), i};
            heap.add(cache);
        }
        while(k > 0){
            int[] popped = heap.poll();
            result.add(arr[popped[1]]);
            k--;
        }
        Collections.sort(result);
        return result;
    }
}
