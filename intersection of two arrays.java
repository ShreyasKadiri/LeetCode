class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(nums2);
        for(int  num : nums1){
            if(checkIfPresent(nums2, num)){
                set.add(num);
            }
        }
        
        for(int num : set){
            result.add(num);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public boolean checkIfPresent(int nums[], int num){
        int low  = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid  = low + (high - low)/2;
            if(nums[mid] == num){
                return true;
            }else if(nums[mid] < num){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }
}
