class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i=0, j=0, n1=nums1.length, n2=nums2.length;
        long sa=0, sb=0, mod=(long)1e9 + 7;
        
        while (i<n1 || j<n2) {
            if (i<n1 && (j==n2 || nums1[i]<nums2[j])) {
                sa+=nums1[i++];
            } else if (j<n2 && (i==n1 || nums1[i]>nums2[j])) {
                sb+=nums2[j++];
            } else {
                sa=sb=Math.max(sa,sb)+nums1[i];
                i++; 
                j++;
            }
        }
        return (int)(Math.max(sa,sb) % mod);
    }
}
