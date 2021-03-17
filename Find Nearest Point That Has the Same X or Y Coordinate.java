class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index=-1;
        int distance=0;
        int  i =0;
        int min=0;
        for(int point[] : points){
            i++;
            if( (point[0] == x) || (point[1] == y)){
                distance = Math.abs(x-point[0]) + Math.abs(y-point[1]);
                min = Math.min(min, distance);
                index = i;
            }
        }
            return index;
    }
}
