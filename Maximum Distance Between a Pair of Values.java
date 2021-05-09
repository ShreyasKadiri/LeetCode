class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        int i=0;
        for (int j=0; j<nums2.length; j++) {
            while (i<nums1.length && nums1[i] > nums2[j])
                i++;
            if (i == nums1.length){
                break;
            }
            result = Math.max(result, j - i);
        }
        return result;
    }
}
