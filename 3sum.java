class Solution {
    public List<List<Integer>> threeSum(int[] nums) {    
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0 ; i<=nums.length-1 ;i++){
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                int twoSum = nums[low] + nums[high];
                if(twoSum < 0 - nums[i]){
                    low++;
                }else if(twoSum > 0 - nums[i]){
                    high--;
                }else{
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[low]);
                    triplets.add(nums[high]);
                    result.add(triplets);
                    while(low < high && nums[low] == triplets.get(1)){
                        low++;
                    }
                        while(low < high && nums[high] == triplets.get(2)){
                            high--;
                        }
                }
            }
            while( i+1<=nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }
}
