class Solution {
    public int specialArray(int[] nums) {
        for(int i=1; i<1001; i++){
            int count = 0;
            for(int num : nums){
                if(num>=i){
                    count++;
                }
            }
             if(i == count){
                    return i;
                }
        }
        return -1;
    }
}


//O(n)
class Solution {
    public int specialArray(int[] nums) {
        int buckets[] = new int[1001];
        for(int i=0; i<nums.length; i++){
            buckets[nums[i]]++;
        }
            int total = nums.length;        
        for(int i=0; i<1001; i++){
            if(i == total){
                return i;
            }else {
                total = total - buckets[i];
            }
        }
        return -1;
    }
}
