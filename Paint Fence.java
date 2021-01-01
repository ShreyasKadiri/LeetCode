class Solution{
    public int paintFence(int n, int k){
        int same = k;
        int different = k*(k-1);
        int total = same + different;
        for(int i=2; i<=n; i++){
         same=different * 1;
         different =  total* (k-1);
         total = same + different;
        }
        return total;
    }
}
