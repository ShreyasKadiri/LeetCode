class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int x= x_center;
        int y= y_center;
        if(x_center<x1)x=x1;
        else if(x_center>x2) x=x2;
         if(y_center<y1) y=y1;
        else if(y_center>y2) y=y2;
        int x_dist= x-x_center;
        int y_dist=y-y_center;
        return x_dist*x_dist + y_dist*y_dist <= radius*radius;
    }
}