class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        if (rectangles.length == 0 || rectangles[0].length == 0) return false;

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        HashSet<String> set = new HashSet<String>();
        int area = 0;
        
        for (int[] rectangle : rectangles) {
            x1 = Math.min(rectangle[0], x1);
            y1 = Math.min(rectangle[1], y1);
            x2 = Math.max(rectangle[2], x2);
            y2 = Math.max(rectangle[3], y2);
            
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            
            String s1 = rectangle[0] + " " + rectangle[1];
            String s2 = rectangle[0] + " " + rectangle[3];
            String s3 = rectangle[2] + " " + rectangle[3];
            String s4 = rectangle[2] + " " + rectangle[1];
            
            if (!set.add(s1))
                set.remove(s1);
            if (!set.add(s2)) 
                set.remove(s2);
            if (!set.add(s3)) 
                set.remove(s3);
            if (!set.add(s4))
                set.remove(s4);
        }
        
if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) return false;
        
        return area == (x2-x1) * (y2-y1);
    }
}


/*
My Approach:

1st Step:
1. Find minimum of all lower left (x,y) co-ordinates and take this as lower left coordinate of outer rectangle
2. Find maximum of all upper right (x,y) co-ordinates and take this as upper right coordinate of outer rectangle
3. Find area of this outer reactangle
4. Find the sum of all given rectangles
5. check if this sum is == outer large rectangle
            
2nd Step:
1. count of all the points should be even, and that of all the four corner points should be one

*/