class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (a,b) -> (b[0] - a[0]));
        for(int boxType[] : boxTypes){
            if(result <= truckSize){
                result+= boxType[1];
            }
        }
        return result;
    }
}
