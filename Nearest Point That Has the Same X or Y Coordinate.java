class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minimum = Integer.MAX_VALUE;
        int count = -1;
        int i = 0;
        for (int[] point: points){
            int X = point[0];
            int Y = point[1];
            if ((X == x) || (Y == y)){
                int distance = Math.abs(X-x) + Math.abs(Y-y);
                if (distance < minimum){ 
                    minimum = distance;
                    count = i;        
                }
            }
            i++;
        }
        return count;
    }
}
