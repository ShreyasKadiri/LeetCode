class Solution {
    public int getWinner(int[] arr, int k) {
        int winner=arr[0];
        int winnerTimes=0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]> winner){
                winner=arr[i];
                winnerTimes=1;
            }else{
                winnerTimes+=1;
            }
            if(winnerTimes>=k){
                return winner;
            }
        }
        return winner;
    }
}