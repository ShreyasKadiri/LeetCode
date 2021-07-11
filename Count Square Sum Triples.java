class Solution {
    public int countTriples(int n) {
        int result  = 0;
        for (int i=1; i<=n; i++){
            for (int j=i; j<=n; j++){
                int x = i*i + j*j;
                int y =(int) Math.sqrt(x);
                if (y*y == x && y<=n){
                    ++result;
                }
            }
        }
        return result*2;
    }
}
