class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];
        for(int i=0; i<nums.length; i++){
            map[i] = new HashMap<>(i);
            for(int j=0; j<i; j++){
                long difference = (long)(nums[j]) - nums[i];
                if(difference <= Integer.MIN_VALUE || difference > Integer.MAX_VALUE){
                    continue;
                }
                int n2 = map[i].getOrDefault((int)difference, 0);
                int n1 = map[j].getOrDefault((int)difference, 0);
                result+= n1;
                map[i].put((int)difference,n1+n2+1);
            }
        }
        return result;
    }
}
