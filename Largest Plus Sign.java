class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] inputGrid = new int[n][n];
        for(int[] row: inputGrid){
            Arrays.fill(row, 1);
        }
        for(int[] mine : mines){
            inputGrid[mine[0]][mine[1]] = 0;
        }
        int[][] leftToRight = new int[n][n];

        for(int i=0; i<n; i++){
            int runningSum = 0;
            for(int j=0; j<n; j++){
                if(inputGrid[i][j] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[i][j]+runningSum;
                }
                leftToRight[i][j]  = runningSum;
            }
        }
        int[][] rightToLeft = new int[n][n];
        for(int i=0; i<n; i++){
            int runningSum = 0;
            for(int j=n-1; j>=0; j--){
                if(inputGrid[i][j] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[i][j]+runningSum;
                }
                rightToLeft[i][j] = runningSum;
            }
        }

        int[][] topToBottom = new int[n][n];
        for(int i=0; i<n; i++){
            int runningSum = 0;
            for(int j=0; j<n; j++){
                if(inputGrid[j][i] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[j][i]+runningSum;
                }
                topToBottom[j][i]  = runningSum;
            }
        }

        int[][] bottomToTop = new int[n][n];
        for(int i=0; i<n; i++){
            int runningSum = 0;
            for(int j=n-1; j>=0; j--){
                if(inputGrid[j][i] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[j][i]+runningSum;
                }
                bottomToTop[j][i]  = runningSum;
            }
        }
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int minimumLength = Math.min(Math.min(leftToRight[i][j], rightToLeft[i][j]) , Math.min(bottomToTop[i][j], topToBottom[i][j]));
                result = Math.max(result, minimumLength);
            }
        }
        return result;
    }
}
