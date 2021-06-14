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


//Bucketing
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize){
        int [] unitCount = new int[1001];
        int count = 0;
        for (int [] boxType : boxTypes){
            unitCount[boxType[1]] += boxType[0];
        }
        for (int i=unitCount.length-1; i>=0; i--){
            if (unitCount[i] == 0){
                continue;
            }
            int num = Math.min(unitCount[i], truckSize);
            count += num * i;
            truckSize -= num;
            if (truckSize == 0){
                break;
            }
        }
        return count;
    }
}
