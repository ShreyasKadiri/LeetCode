class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int low=1;
        int high=n;
        for(int i=0; i<n; i++){
            result[i] = k%2 !=0 ? low++ : high--;
            if(k>1)
                k--;
        }
                
        return result; 
    }
}
