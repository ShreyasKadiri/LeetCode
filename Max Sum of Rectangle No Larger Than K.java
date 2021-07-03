class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            int columnSum[] = new int[matrix[0].length];
            for(int j=i; j<matrix.length; j++){
                for(int l=0; l<matrix[0].length; l++){
                    columnSum[l]+= matrix[j][l];
                }
                maximum = Math.max(maximum, solve(columnSum, k));
            }
        }
        return maximum;
    }
    
    
    private int solve(int[] sum, int k) {
        int result = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int prefixSum = 0;
        
        for(int i=0; i<sum.length; i++) {
            prefixSum += sum[i];
            Integer target = set.ceiling(prefixSum - k);
            if(target != null) {
                result = Math.max(result, prefixSum - target);
            }
            set.add(prefixSum);
        }
    return result;
    }
}
