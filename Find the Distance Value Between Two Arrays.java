class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;
        for(int i=0; i<arr1.length; i++){
            int count = 1;
            for(int j=0; j<arr2.length; j++){
                if(Math.abs(arr1[i] - arr2[j]) <=d){
                    count = 0;
                    break;
                }
            }
            distance+=count;
        }
        return distance;
    }
}


//Binary search
class Solution {
    public int findTheDistanceValue(int [] arr1, int [] arr2, int d) {
        Arrays.sort(arr2);  
        int count = arr1.length;
        
        for (int i=0; i<arr1.length; i++) {
            int index = searchNeighbors(arr2, arr1[i]);
            int difference = 0;
            if (index == 0) {
                difference = Math.abs(arr1[i] - arr2[index]);
            } else {
                difference = Math.min(Math.abs(arr1[i] - arr2[index-1]), Math.abs(arr1[i] - arr2[index]));
            }
            if (difference <= d) {
                count--;
            }
        }
        return count;
    }
    
    
    public int searchNeighbors(int nums[],  int target){
        int low = 0 ;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < target){
                low = mid +1 ;
            }else if (nums[mid] > target){
                high =  mid -1;
            }
        }
        return high;
    }   
}
