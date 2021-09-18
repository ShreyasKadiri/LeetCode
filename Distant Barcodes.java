class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result[] = new int[barcodes.length];
        int index = 0;
        for(int i=0; i<barcodes.length; i++){
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0 )+ 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        maxHeap.addAll(map.keySet());
        
        
        while(!maxHeap.isEmpty()){
            int firstCommonElement = maxHeap.poll();
            result[index++] = firstCommonElement;
            if(maxHeap.size() == 0){
                break;
            }
            int secondCommonElement = maxHeap.poll();
            result[index++] = secondCommonElement;
            updateFrequencies(map, maxHeap, firstCommonElement);
            updateFrequencies(map, maxHeap, secondCommonElement);
        }
        return result;
    }
    
    private void updateFrequencies(HashMap<Integer, Integer>map, PriorityQueue<Integer>maxHeap, int element){
        if(map.get(element) == 1) {
            map.remove(element);
        }else {
			map.put(element, map.get(element) - 1);
            maxHeap.offer(element);
        }
        return ;
    }
}
