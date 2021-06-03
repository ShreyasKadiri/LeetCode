class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maximumHorizontalDifference = 0;
        for(int i=1; i<horizontalCuts.length; i++){
            maximumHorizontalDifference = Math.max(maximumHorizontalDifference, (horizontalCuts[i] - horizontalCuts[i-1]));
        }
        
         int maximumVerticalDifference = 0;
        for(int i=1; i<verticalCuts.length; i++){
            maximumVerticalDifference = Math.max(maximumVerticalDifference, (verticalCuts[i] - verticalCuts[i-1]));
        }
        
        return maximumHorizontalDifference*maximumVerticalDifference;
    }
}
