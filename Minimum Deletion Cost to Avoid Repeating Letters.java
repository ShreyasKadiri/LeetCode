class Solution {
    public int minCost(String s, int[] cost) {
        int result = 0;
        int i = 0;
        int j = 1;
        while(j < s.length()){
            if(s.charAt(i) != s.charAt(j)){
                i=j;
                j++;
                continue;
            }
            
            if(cost[i] <= cost[j]){
                result+= cost[i];
                i=j; 
                j++;
            }
            
            else if(cost[i] > cost[j]){
                result += cost[j];
                j++;
            }
        }
        return result;
    }
}
