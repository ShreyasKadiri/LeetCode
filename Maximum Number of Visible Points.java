class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int currentAngle=0;
        int X=location.get(0);
        int Y=location.get(1);
        List<Double> angles = new ArrayList<>();

        for (List<Integer> point : points) {
            if (point.get(0)==X && point.get(1)==Y) {
                currentAngle++;
                continue;
            }

            double rotatedAngle=(Math.atan2(point.get(1)-Y, point.get(0)-X)*180 / Math.PI+360)%360;
            angles.add(rotatedAngle);
            angles.add(rotatedAngle+ 360.0);
        } 
        Collections.sort(angles);
        int max=0;
        Queue<Double> queue= new LinkedList<>();
        for(Double currAngle:angles) {
            queue.add(currAngle);
            while (currAngle>queue.peek()+angle) {
                queue.poll();
            }
            max=Math.max(max,queue.size());
        }
        return max+currentAngle;
    }
}

/*
Approach:
1. We could imagine that there must be a unique line get through ourselves and any target point, so we could get lots of lines from all target points.

2. And then, if the angle of rotating between 2 lines is smaller than angle, we could say that we can see them both in the field of view.

3. So right now, we know that we could calculate the angles for all points and how to check whether they in the same field of view. The last question is that in which view we could see the most points.

4. We could write down all the angles in sorted order, and draw a field of view. It's easy to find out the view is just like a box and changing the view is just moving the 2 edges of the box.

5.It's a typical sliding window. So we could solve it via sliding window solution
*/