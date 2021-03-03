class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int possibleDimensions[] = new int[rectangles.length];
        int i=0;
        for(int rectangle[] : rectangles){
        int minimumDimension = rectangle[0] > rectangle[1] ? rectangle[1] : rectangle[0];
            possibleDimensions[i++] = minimumDimension;
        }
        
        //Find the maximum among these dimensions
        int maximumDimension=0;
        for(int j=0; j<possibleDimensions.length; j++){
            maximumDimension =  Math.max(maximumDimension, possibleDimensions[j]);
        }
        
        int count = 0;
        for(int j=0; j<possibleDimensions.length; j++){
           if(possibleDimensions[j] >= maximumDimension){
               count+=1;
           } 
        }
        
        return count;
    }
}
