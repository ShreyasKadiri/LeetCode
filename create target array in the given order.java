class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> store = new ArrayList<Integer>();
        int target[] = new int[nums.length];
        for(int  i=0; i<nums.length; i++){
            store.add(index[i], nums[i]);
        }
        
        for(int i=0; i<nums.length; i++){
            target[i] = store.get(i);
        }
        return target;
    }
}
