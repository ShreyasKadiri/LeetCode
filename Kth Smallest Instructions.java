class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        StringBuilder sb = new StringBuilder("");
        solve(destination[0], destination[1], k, sb);
        return sb.toString();
    }
    
    void solve(int row, int col, int k, StringBuilder sb) {
        if(k==1 || row==0 || col==0) {
            for(int i=0; i<col; i++) {
                sb.append('H');     //Lets first append "H"
            }
            for(int i=0; i<row; i++) {
                sb.append('V');      //Lets first append "V"
            }
            return;
        }
        
        int add=combinations(row+col-1,row);
        if(k<=add) {
            sb.append('H');
            solve(row,col-1,k,sb);
        }
        else {
            sb.append('V');
            solve(row-1, col, k-add, sb);
        }
    }
    
    int combinations(int n, int k) {
        double result=1;
        for (int i=1; i<=k; ++i)
            result=result*(n-k+i)/i;
        return (int)(result+0.01);
    }
}