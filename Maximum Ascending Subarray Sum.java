class Solution {
    public int maxAscendingSum(int[] arr) {
        int max_sum = arr[0];
        int n = arr.length;
        int current_sum = arr[0];
 
      for (int i=1; i<n; i++){
            if (arr[i-1] < arr[i]){
                current_sum = current_sum + arr[i];
                max_sum = Math.max(max_sum, current_sum);
            }
            else {
                max_sum = Math.max(max_sum, current_sum);
                current_sum = arr[i];
            }
        }
        return Math.max(max_sum, current_sum);
    }
}
