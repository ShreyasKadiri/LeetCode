class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int result = 2; 
        // in Increasing order of END Time and if END TIME is same then Decreasing order of START time as well
        Arrays.sort(intervals, (a,b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        
        int highestValueInSet = intervals[0][1]; // max value of first interval
        int secondHighestValueInSet = intervals[0][1] - 1; // second max value from first interval
        
        for(int i=1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if(start > highestValueInSet) { // means ther is no common between curr interval and intervals before this
                // add 2 new values
                // end - 1 first and then end to make the SET SORTED
                result+= 2;
                highestValueInSet = intervals[i][1];
                secondHighestValueInSet = intervals[i][1] - 1;
            } else if(start > secondHighestValueInSet && start <= highestValueInSet) { // atleast 1 value from current interval matches with previosu sets
                // just add 1 max value
                result+= 1;
                secondHighestValueInSet = highestValueInSet; // now second max becomes previous max
                highestValueInSet = intervals[i][1]; // new max for current interval
            }
        }
        return result;
    }
}
