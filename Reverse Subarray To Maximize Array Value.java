class Solution {
     int min=-1000000000;

    public int maxValueAfterReverse(int[] a) {
        int base=0;
        int n=a.length;
        
        for (int i=0; i<n-1; i++) {
            base+=Math.abs(a[i]-a[i+1]);
        }
        
        int result=0;
        int[][] dp = new int[n][4];
        
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], min);
        }
        
        for (int i=0; i+1<n; i++) {
            int first_last=Math.abs(a[i]-a[i+1]);
    
            if (i-2>=0) {
                int value1=a[i]-a[i+1]-first_last;
                int c1=dp[i-2][0];
                int value2=-(a[i]+a[i+1])-first_last;
                int c2=dp[i-2][1];
                int value3=a[i]+a[i+1]-first_last;
                int c3=dp[i-2][2];
                int value4=-(a[i]-a[i+1])-first_last;
                int c4=dp[i-2][3];
                int m1=value1+c1;
                int m2=value2+c2;
                int m3=value3+c3;
                int m4=value4+c4;
                int cmax=Math.max(m1,Math.max(m2,Math.max(m3,m4)));
                result=Math.max(result, cmax);
            }
            
            dp[i][0] = Math.max((i == 0 ? min : dp[i - 1][0]), -(a[i] - a[i + 1]) - first_last);
            dp[i][1] = Math.max((i == 0 ? min : dp[i - 1][1]), (a[i] + a[i + 1]) - first_last);
            dp[i][2] = Math.max((i == 0 ? min : dp[i - 1][2]), -(a[i] + a[i + 1]) - first_last);
            dp[i][3] = Math.max((i == 0 ? min : dp[i - 1][3]), (a[i] - a[i + 1] - first_last));
        }
		// to cover reversing on the two ends
        for (int i=1; i+1<n; i++) {
            int m1=Math.abs(a[0]-a[i + 1]) - Math.abs(a[i]-a[i + 1]);
            int m2=Math.abs(a[n-1] - a[i-1]) - Math.abs(a[i]-a[i-1]);
            int cmax=Math.max(m1,m2);
            result=Math.max(result,cmax);
        }
        return base+result;
    }
}





/*
Refer: https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/discuss/489968/O(n)-Java-with-Mathematical-Proof

*/