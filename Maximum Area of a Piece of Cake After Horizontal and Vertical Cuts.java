class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long horizontalMaximumDifferenceCut = getMaximumDifferenceCuts(horizontalCuts,h);
        long verticalMaximumDifferenceCut = getMaximumDifferenceCuts(verticalCuts,w);
        return (int)((horizontalMaximumDifferenceCut * verticalMaximumDifferenceCut)%1000000007);
    }  
    
    public long getMaximumDifferenceCuts(int[] dimensions, int cutDimension) {
        Arrays.sort(dimensions);
        int maximumDifference = 0;
        int startingDimension = 0;
        
        for(int i=0; i<dimensions.length; i++){
            maximumDifference = Math.max(dimensions[i]-startingDimension,maximumDifference);
            startingDimension = dimensions[i];
        }
        
        maximumDifference = Math.max(maximumDifference,cutDimension-startingDimension);
        return maximumDifference;
    }
}
