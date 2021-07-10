class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> Math.abs(a[0]-a[1]) - Math.abs(b[0]-b[1]));
        
        for(int i=0; i<nums.length-1; i++){
            minHeap.add(new int[]{nums[i], nums[i+1], i+1});
        }
        
        int index = 0;
        while(!minHeap.isEmpty()){
            int[] poppedElement = minHeap.poll();
            if(++index==k){
                return  Math.abs(poppedElement[0] - poppedElement[1]);
            }
            
            if(poppedElement[2] == nums.length-1){
                continue;
            }
            minHeap.add(new int[]{poppedElement[0], nums[poppedElement[2]+1], poppedElement[2]+1});
        }
        return 0;
    }
}

//Binary Search
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1] - nums[0];
        while(low < high){
            int mid = low + (high - low)/2;
            if(issmallpairs (nums, k, mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    
    private boolean issmallpairs(int[] nums, int k, int mid){
        int count = 0, low = 0;
        for(int i=1; i<nums.length; i++){
            while(nums[i] - nums[low] > mid){
                low++;
            }
            count+= i - low;
        }
        return (count>=k);
    }
}
