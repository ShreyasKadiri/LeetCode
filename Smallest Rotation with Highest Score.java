class Solution {
    public int bestRotation(int[] A) {
        int[] result= new int[A.length];  
        for (int i=0; i<A.length; i++) {
            result[(i+1)%A.length]++;             
            result[(i+1 - A[i]+A.length) % A.length]--;  
        }
        int count=0;
        int maxCount=-1;
        int res=0;
        for (int i=0; i<A.length; i++) { 
            count+=result[i];
            if (count> max) {
                res=i;
                max=count;
            }
        }
        return res;
    }
}