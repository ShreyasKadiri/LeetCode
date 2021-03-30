class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : nums1){
            set1.add(num);
        }
        
        for(int num : nums2){
            set2.add(num);
        }
        

        for(int num : set1){
            if(set2.contains(num)){
                result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

