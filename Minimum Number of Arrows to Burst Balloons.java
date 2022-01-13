class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[1]));
        int result = 1;
        int last = points[0][1];
        for(int i=1; i<points.length; i++) {
            if(last < points[i][0]) {
                last=points[i][1];
                result++;
            }
        }
        return result;
    }
}
