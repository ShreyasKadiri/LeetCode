class Solution {
    public int findKthPositive(int[] A, int k) {
        int l=0;
        int h=A.length;
        int m;
        while (l<h){
            m=(l+h)/2;
            if (A[m]-1-m<k)
                l=m+1;
            else
                h=m;
        }
        return l+k;
    }
}
