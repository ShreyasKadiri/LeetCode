class Solution{
    public int minCostToMoveChips(int[] chips){
        int oddCount = 0;
        int evenCount = 0;
        for(int i=0; i<chips.length; i++){
            if(chips[i]%2 == 0){
                evenCount+=1;
            }else{
                oddCount++;
            }
        }
        return Math.min(evenCount, oddCount);
    }
}
