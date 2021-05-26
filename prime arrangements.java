class Solution{
    public int numPrimeArrangements(int n) {
        int MOD = (int) (1e9 + 7);
        int count = 0;
        boolean[] primes = new boolean[n+1]; 
        Arrays.fill(prime, 2, n+1, true); 
        for(int i=2; i*i<=n; i++) {
            if (primes[i]) { 
                for(int j=i*i; j<=n; j+=i) {\
                    primes[j] = false;
                }
            }
        }
        long result = 1;
        for (boolean value : prime){
            count += (value ? 1 : 0);
        }
        for (int i=2; i<=count; i++) {
            result = (result * i) % MOD;
        }
        for (int i=2; i<=n-count; i++) {
            result = (result * i) % MOD;
        }
        return (int) result;
    }

}
