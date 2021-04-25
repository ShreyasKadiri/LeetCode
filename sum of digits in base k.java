class Solution {
    public int sumBase(int n, int k) {
        int units=0;
        int sum=0;
        while (n>0){
            units = n%k;
            sum+=units;
            n=n/k;
        }
        return sum;
    }
}
