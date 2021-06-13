class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return productFind(nums1, nums2) + productFind(nums2, nums1);
    }
    
    private int productFind(int nums1[], int nums2[]){
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        int count = 0;
        for(long number : nums1){
            map.put(number*number, map.getOrDefault(number*number, 0)+1);
        }
        
        for(int j=0; j<nums2.length-1; j++){
            for(int k=j+1; k<nums2.length; k++){
                long product = (long)nums2[j] * nums2[k];
                if(map.containsKey(product)){
                    count+= map.get(product);
                }
            }
        }
        return count;
    }
}
