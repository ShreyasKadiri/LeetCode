class Solution {
    public String getSmallestString(int n, int k) {
        char result [] = new char[n];
        Arrays.fill(result, 'a');
        k-=n;
        while(k>0){
            result[--n]+=Math.min(k, 25);
            k-=Math.min(25, k);
        }
        return String.valueOf(result);
    }
}
