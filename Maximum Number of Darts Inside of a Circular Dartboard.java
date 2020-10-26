class Solution {
    public int numPoints(int[][] points, int r) {
        int result=1;
        for (int i=0; i<points.length-1; i++) {
            for (int j=i+1; j<points.length; j++) {
                int x1=points[i][0], y1=points[i][1];
                int x2=points[j][0], y2=points[j][1];
                
                double distance= (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) / 4.0;
                
                //Stay within the dart
                if (distance>r*r) {
                    continue;
                }
                
                
                double x0=(x1+x2)/2.0 + (y2-y1) * Math.pow((r*r-distance),0.5) / Math.pow((distance*4),0.5);
                double y0=(y1+y2)/2.0 - (x2-x1) * Math.pow((r*r-distance),0.5) / Math.pow((d*4),0.5);
            
                int count=0;
                
                for (int[] point : points) {
                    double X=point[0];
                    double Y=point[1];
                    if (Math.pow((X-x0),2) + Math.pow((Y-y0), 2)<=(double)(r*r)+0.00001) {
                        count++;
                    }
                }
                
                result=Math.max(result,count);
                
                x0=(x1+x2)/2.0 - (y2-y1)*Math.pow((r*r-distance),0.5);
                y0=(y1+y2)/2.0 + (x2-x1) * Math.pow((r*r-distance),0.5);
                count=0;
                
                for (int[] point:points) {
                    double X=point[0];
                    double Y=point[1];
                    if (Math.pow((X-x0),2) + Math.pow((Y-y0), 2) <= (double)(r*r)+0.00001) {
                        count++;
                    }
                }
                result=Math.max(result,count);
            }
        }
        return result; 
    }
}


/*
Approach:
1. If there exists a circle C that encloses M points, then by slightly moving C it will touch at least two points.
2. So, essentially we just need to check all circles which touch (at least) 2 points:
3. For each pair of points in the given set, construct a circle with radius R that touches both points. 
4. For each point pair there are at most two such circles.
5. For each constructed circle, check for each of the given points is inside it.
6. Return the circle that encloses the maximum number of points.
7.The runtime of this algorithm is  O(N3)  because there are at most  O(N2)  such circles in step 1, and the linear scan at step 2 takes  O(N)  time.

Better Approach:
1. Pick an arbitrary point P from the given set. We rotate a circle C with radius R using P as the "axis of rotation" (by convention, in the counter-clockwise direction), i.e. we keep C to touch P any time during the rotation. While C is being rotated, we maintain a counter to count the number of points C encloses.

2. Note that this counter only changes when some point Q enters (or leaves) the region of the circle C. Our goal is to come up with an algorithm that will increment (or decrement) this counter, whenever some other point Q ≠ P enters (or leaves) the region of C.

3. The state of the (rotating) circle C can be described by a single parameter  θ , where  (r,θ)  are the polar coordinates of the center of the circle C, if we pick P as the fixed point of the polar coordinate system. With this system, rotating C means increasing  θ .

4. For each other point Q (≠ P), we can actually compute the range of θ  for which C covers Q. Put more formally, C encloses Q whenever (iff)  θ∈[α,β]

5. So, up to this point, the original problem has been reduced to:
The reduced problem can be solved with a pretty standard  O(NlogN)  algorithm. 
This reduced problem has to be solved N times (one for each point P), hence the time complexity  O(N2logN) .

Time Complexity : OI(N2logN)

https://www.quora.com/What-is-an-algorithm-for-enclosing-the-maximum-number-of-points-in-a-2-D-plane-with-a-fixed-radius-circle

*/