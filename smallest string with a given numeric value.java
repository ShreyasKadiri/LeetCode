class Solution {
    public String getSmallestString(int n, int k) {
        char frequency[] = new char[n];
        for(int i=0; i<n; i++){
            frequency[i] = 'a';
        }
        
        k = k - n;
        int j = n - 1;
        while(k > 0){
            if(k < 25){
                frequency[j] = (char)('a' + k);
                k = 0;
            }else {
                frequency[j] = 'z';
                k = k - 25;
            }
            j--;
        }
        return new String(frequency);
    }
}
