class KthSmallestPair{
    public int kthSmallestPair(int numbers[], int k){
        if(numbers.length==0 || numbers==null){
            return -1;
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
            (a,b) -> ( Math.abs(a[0] - a[1]) - Math.abs(b[0] - b[1])));
            
            for(int i=0; i<numbers.length-1; i++){
                minHeap.offer(new int[]{numbers[i], numbers[i+1], i+1});
            }
        
        int index=0;
        while(!minHeap.isEmpty()){
            int poppedElement[] = minHeap.poll();
            if(++index==k){
                return Math.abs(poppedElement[0] - poppedElement[1]);
            }
            else if(poppedElement[2]==numbers.length-1){
                continue;
            }else{
                minHeap.add(new int[]{poppedElement[0], nums[poppedElement[2]+1], poppedElement[2]+1});
            }
        }
        return 0;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////
class KthSmallestPair{
    public int kthSmallestPair(int numbers, int k){
        Arrays.sort(numbers);
        int low = 0;
        int maxPossibleDifferece =numbers[0] - numbers[numbers.length-1];
        int high = maxPossibleDifferece;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(checkValid(numbers, mid, k)){
                high = mid;
            }else {
                low = mid+1;
            }
    }
        return low;
    }
    
    public boolean checkValid(int numbers, int mid, int k){
        int j=1;
        int total=0;
        for(int i=0; i<numbers.length; i++){
            while(j<numbers.length && numbers[j]-numbers[i]<=mid){
                j+=1;
            }
            j-=1;
            int netCount = j-i;
            total+=netCount;
        }
        return total>=k;
    }
}
