class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int j=0;
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i=0; i<nums.length; i++) {
            j=(j<< 1 | nums[i]) % 5; 
            result.add(j==0); 
        }
        return result;
    }
}
