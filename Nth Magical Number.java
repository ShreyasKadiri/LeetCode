class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        long a = A;
        long b = B;
        long temp;
        long low = 2;
        long high = (long)1e14;
        long mod= (long)1e9 + 7;
        
        while(b > 0) {
            temp = a;
            a = b;
            b = temp % b;
        }
        //Binary Search
        while (low < high){
            long mid = (low + high)/2;
            if ((mid/A) +  (mid/B) - (mid/(A*B/a))<N){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return (int)(low % mod);
    }
}
