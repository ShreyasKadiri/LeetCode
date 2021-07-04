class Solution {
    public int countGoodNumbers(long n) {
        return (int)(calculatePower(5, (n+1)/2) * calculatePower(4, n/2) % 1000000007);
    }
    
    public long calculatePower(long a, long b){
        if (b == 0){
            return 1;
        }
        long result = calculatePower(a, b/2);
        return result * result * (b % 2 > 0 ? a : 1) % 1000000007;
    }
}
