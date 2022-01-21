class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int start = 0;
        int difference = 0;
        for(int i=0; i<gas.length; i++){
            sum = sum + gas[i] - cost[i];
            if(sum < 0){
                start = i + 1;
                difference+= sum;
                sum = 0;
            } 
        } 
        return sum + difference >=0 ? start : -1 ;
    }
}
