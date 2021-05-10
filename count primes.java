class Solution {
    public int countPrimes(int n) {
        int count = 0;
        if(n == 0 || n == 1){
            return count;
        }
        
        boolean[] primes = new boolean[n+1];
        for (int i=2; i<=n; i++) {
            primes[i] = true;
         }
        int sqrt = (int) Math.sqrt(n);
        int num = 2;
        while (num <= sqrt) {
            if (primes[num]) {
                int mul = num;
                while (mul * num <= n) {
                    primes[mul * num] = false;
                    mul++;
                }
            }
            num++;
        }
        for(int i=2; i<=n; i++){
            if(primes[i] == true){
                count+=1;
            }
        }
        return count;
    }
}
