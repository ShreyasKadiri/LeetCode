class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0 ; i<nums2.length; i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i]) > 0){
                    result.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
