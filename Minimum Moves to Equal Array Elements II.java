//Sorting  O(nlogn)
class Solution {
    public int minMoves2(int[] nums) {
        int minimumMoves = 0;
        Arrays.sort(nums);
        int middle = nums.length/2;
        for(int i=0; i<nums.length; i++){
           minimumMoves+= Math.abs(nums[middle] - nums[i]); 
        }
        return minimumMoves;
    }
}


//Sorting
class Solution {
    public int minMoves2(int[] nums) {
        int minimumMoves = 0;
        Arrays.sort(nums);
        int i=0;
        int j = nums.length-1;
        while(i < j){
            minimumMoves+= nums[j] - nums[i];
            i++;
            j--;
        }
        return minimumMoves;
    }
}
