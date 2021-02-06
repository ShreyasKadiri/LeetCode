class Solution{
public int maxAbsoluteSum(int[] A) {
        int s = 0;
		int min = 0;
		int max = 0;
        for (int a: A) {
            s += a;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max - min;
    }
}
