class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        for (int i=1; i<height.length-1; i++){
			int maximumLeft = 0;
            int maximumRight = 0;
            
			for(int j=i; j>=0; j--){
                maximumLeft = Math.max(maximumLeft, height[j]);
            }
            for(int j=i; j<height.length; j++){
                maximumRight = Math.max(maximumRight, height[j]);
            }				
			totalWater += Math.min(maximumLeft, maximumRight) - height[i];
		}
        return totalWater;
    }
}
