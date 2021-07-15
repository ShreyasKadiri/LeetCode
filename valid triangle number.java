class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int  j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]>nums[k] && nums[i]+nums[k]>nums[j] && nums[j]+nums[k]>nums[i] ){
                        count+=1;
                    }
                }
            }
        }
        return count;
    }
}


//O(n2)
class Solution {
    public int triangleNumber(int[] nums) {
        int result  = 0;
        if (nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i=2; i<nums.length; i++) {
            int left = 0;
            int right = i-1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result+= (right - left);
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
