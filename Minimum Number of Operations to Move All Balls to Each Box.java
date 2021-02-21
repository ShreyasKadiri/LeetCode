class Solution {
    public int[] minOperations(String boxes) {
        int cost[] = new int[boxes.length()]; 
        int costLeft = 0;
        int countLeft = 0;

        for(int i=0; i<boxes.length(); i++){
        costLeft+=countLeft;
         cost[i]+=costLeft;
         if (boxes.charAt(i) == '1') {
            countLeft++;
        }
    }
        
    int countRight=0;
    int costRight=0;
    for(int i=boxes.length()-1; i>=0; i--){
        costRight+=countRight;
        cost[i]+=costRight;
         if (boxes.charAt(i) == '1'){
            cntRight++;
        }
    }
           return cost;
    }
}
