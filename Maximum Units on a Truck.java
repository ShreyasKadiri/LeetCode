class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        for (int i=0; i<boxTypes.length && truckSize > 0; i++) {
            int currentBoxType = boxTypes[i][0];
            int unitsCount = boxTypes[i][1];
            truckSize = truckSize - currentBoxType;
            result+= currentBoxType * unitsCount;   //Total capacity
            if (truckSize < 0) {
                result += truckSize * unitsCount;
                break;
            }
        }
        return result;
    }
}
