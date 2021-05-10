//Brute Force

class Solution{
    public int countPrimes(int n){
        if(n < 3){
            return 0;
        }
        int count = 1;
        for(int i=3 ; i<n ; i+=2){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(int n){
        for(int i=2 ; i*i<=n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}


class Solution {
    public int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
        boolean[] primes = new boolean[n];
        for (int i=2; i<n; i++){
            primes[i] = true;
        }
        
        for (int i=2; i<=Math.sqrt(n-1); i++) {
            if (primes[i]) {
                for (int j=2*i; j<n; j+=i){
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i=2; i<n; i++) {
            if (primes[i]){
                count++;
            }
        }
        return count;
    }
}
