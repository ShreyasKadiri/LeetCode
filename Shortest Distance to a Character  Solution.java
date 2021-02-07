class Solution {
    public int[] shortestToChar(String s, char c) {

        int[] leftDistance = new int[ s.length()];
        int[] rightDistance =new int[ s.length()];

        Arrays.fill(leftDistance, Integer.MAX_VALUE);
        Arrays.fill(rightDistance, Integer.MAX_VALUE);

        int runningDistance = Integer.MAX_VALUE;

        //left to right direction
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == c){
                runningDistance = 0;
                rightDistance[i] = runningDistance;
            } else{

                if(runningDistance != Integer.MAX_VALUE) {
                    runningDistance++;
                    rightDistance[i] = runningDistance;
                }
            }
        }
        runningDistance = Integer.MAX_VALUE;

        // right to left direction

        for(int i= s.length()-1; i>=0; i--){
            if(s.charAt(i) == c){
                runningDistance= 0;
                leftDistance[i] = runningDistance;
            } else{
                if(runningDistance != Integer.MAX_VALUE) {
                    runningDistance++;
                    leftDistance[i] = runningDistance;
                }
            }
        }

        int[] result = new int[ s.length()];

        for(int i=0; i< s.length(); i++){
            result[i] = Math.min(rightDistance[i], leftDistance[i]);
        }
        return result;
    }
}
