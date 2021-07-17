class Solution {
    public int[] threeEqualParts(int[] arr) {
        int[] result = new int[] {-1,-1};
        int numberOfOnes = 0;
        for (int i=0; i<arr.length; i++) {
            numberOfOnes+= arr[i];
        }
        if (numberOfOnes == 0) {
            return new int[]{0, 2};
        }
        if (numberOfOnes%3 != 0) {
            return result;
        }
        int numberOfOnesInEachPart = numberOfOnes / 3;
        int indexOfFirstOneInPartZero = -1;
        int indexOfFirstOneInPartOne = -1;
        int indexOfFirstOneInPartTwo = -1;
        numberOfOnes = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                numberOfOnes++;
                if (numberOfOnes == numberOfOnesInEachPart+1) {
                    indexOfFirstOneInPartOne = i;
                }else if (numberOfOnes == 2*numberOfOnesInEachPart+1) {
                    indexOfFirstOneInPartTwo = i;
                }else if (numberOfOnes == 1) {
                    indexOfFirstOneInPartZero = i;
                }
            }
        }
        while (indexOfFirstOneInPartTwo < arr.length) {
            if (arr[indexOfFirstOneInPartTwo] == arr[indexOfFirstOneInPartZero] && arr[indexOfFirstOneInPartTwo] == arr[indexOfFirstOneInPartOne]) {
                indexOfFirstOneInPartTwo++;
                indexOfFirstOneInPartOne++;
                indexOfFirstOneInPartZero++;
            }else {
                return result;
            }
        }
        return new int[]{indexOfFirstOneInPartZero-1, indexOfFirstOneInPartOne};
    }
}
