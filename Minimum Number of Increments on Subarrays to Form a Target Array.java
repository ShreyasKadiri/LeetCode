class Solution {
    public int minNumberOperations(int[] A) {
        int res = 0, pre = 0;
        for (int a: A) {
            res += Math.max(a - pre, 0);
            pre = a;
        }
        return res;
    }
}