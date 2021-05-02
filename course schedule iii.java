class Solution {
    public int scheduleCourse(int[][] courses) {
        int totalDuration = 0;
        Arrays.sort(courses, (a,b)-> (a[1]-b[1]));
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)-> (b-a));
        for (int[] course : courses) {
            totalDuration+=course[0];
            maxHeap.add(course[0]);
            if (totalDuration>course[1]){
                totalDuration-=maxHeap.poll();
            }
        }        
        return maxHeap.size();
    }
}
