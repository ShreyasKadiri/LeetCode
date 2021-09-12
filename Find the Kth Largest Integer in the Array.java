import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (str1, str2) -> (new BigInteger(str2)).compareTo(new BigInteger(str1)));
        return nums[k-1];
    }
}
