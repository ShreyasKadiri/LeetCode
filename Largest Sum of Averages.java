class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        if (K==0 || A.length==0 ) {
            return 0; }
        int len= A.length;
        double[][] dp1=new double[len][K+1];
        double[] dp2=new double[len+1];
        for (int i=1; i<=len; i++) {
            dp2[i]=dp2[i-1]+A[i-1];
            dp1[i-1][1]=dp2[i]/i;
        }
        for (int j=2; j<=K; j++) {
            for (int i=0; i<len; i++) {
                double max = Double.MIN_VALUE;
                for (int p=0; p<i; p++) {
                    double sum=dp1[p][j-1]+(dp2[i+1]-dp2[p+1])/(i-p);
                    max=Double.max(sum, max);
                }
                f[i][j] = max;
            }
        }
        return f[len-1][K];
    }
}