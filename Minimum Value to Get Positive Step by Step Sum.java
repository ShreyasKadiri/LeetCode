class Solution{
public int minStartValue(int[] nums) {
    int sum = 0, min_sum = 0;
    for (var n : nums) {
        sum += n;
        min_sum = Math.min(min_sum, sum);
    }
    return 1 - min_sum;
  }
}
