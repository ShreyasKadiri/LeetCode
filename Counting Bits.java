class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        int start = 1;
        for (int i=1; i<=num; i++){
            if (i/start > 1) {
                start = start * 2;
            }
            result[i] = 1 + result[i - start];
        }
        return result;
    }
}
