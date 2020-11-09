class Solution {
    public int consecutiveNumbersSum(int N) {
    int count=0;
        for(int k=1; k<sqrt(2*N); k++){
            int numerator=N-(k*(k-1)/2) , denominator=k;
            if(numerator%denominator==0)
                count++;
        }
        return count;
    }
}