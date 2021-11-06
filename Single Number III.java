class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> elements = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                elements.add(entry.getKey());
            }
        }
        i = 0;
        int result[] = new int[elements.size()];
        for(int element : elements){
            result[i++] = element;
        }
        return result;
    }
}
