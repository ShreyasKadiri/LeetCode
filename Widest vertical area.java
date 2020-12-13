class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int verticalPoints[] = new int[points.length];
        for(int i=0; i<points.length; i++){
            verticalPoints[i] = points[i][0];
        }
        Arrays.sort(verticalPoints);
        int max=0;
        for(int i=1; i<points.length; i++){
            max = Math.max(max, Math.abs(verticalPoints[i] - verticalPoints[i-1]));
        }
        return max;
    }
}
