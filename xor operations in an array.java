class Solution {
    public int xorOperation(int n, int start) {
     int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i]=start + 2*i;
        }
        int xor= 0;
        for(int i=0; i<n; i++){
            xor^=a[i];
        }

        return  xor;
    }
}
