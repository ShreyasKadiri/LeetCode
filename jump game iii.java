class Solution {
    public boolean canReach(int[] arr, int start) {
        return start >= 0 && start < arr.length && arr[start] >= 0 && ((arr[start] = -arr[start]) == 0 || canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]));
    }
}
