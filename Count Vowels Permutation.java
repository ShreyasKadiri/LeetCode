class Solution {
    int mod = (int)(1e9) + 7;
    HashMap<String, Long> map = new HashMap<>();
    
    public int countVowelPermutation(int n) {
        long a = solve(n, 'a');
        long i = solve(n, 'i');
        long u = solve(n, 'u');
        long e = solve(n, 'e');
        long o = solve(n, 'o');
        return (int)((a+i+u+e+o) % mod);
    }
    
    public long solve(int n, char c){
        if(map.containsKey(n+","+c)){
            return map.get(n+","+c);
        } 
        if(n == 1) {
            return 1;
        }
        long result;
        if(c == 'a') {
            result = (solve(n-1, 'e')) % mod;
        } else if(c == 'e') {
            result = (solve(n-1, 'a') + solve(n-1, 'i')) % mod;
        } else if(c == 'i') {
            result = (solve(n-1, 'e') + solve(n-1, 'o') + solve(n-1, 'u') + solve(n-1, 'a')) % mod;
        } else if(c == 'o') {
            result = (solve(n-1, 'i') + solve(n-1, 'u')) % mod;
        } else {
            result = (solve(n-1, 'a')) % mod;
        }
        map.put(n+","+c, result);
        return result;
    }   
}
