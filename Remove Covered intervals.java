class Solution {
public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = intervals.length, res = 0, end = Integer.MIN_VALUE;  
        for (int[] i : intervals) {
            if (i[1] > end) end = i[1];
            else res++;
        }
        return n - res;
    }
 }
