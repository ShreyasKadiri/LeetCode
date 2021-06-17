class Solution {
    public int minElements(int[] A, int limit, int goal) {
        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum+= A[i];
        }
        return (int)((Math.abs(goal - sum) + limit - 1) / limit);
    }
}
    
