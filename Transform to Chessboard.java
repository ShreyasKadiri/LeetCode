class Solution{
public int movesToChessboard(int[][] b) {
        int rowSum=0;
        int colSum=0,rowSwap=0,colSwap=0;
    
        for (int i=0; i<b.length; i++){
            for (int j=0; j<b.length; j++){
                if ((b[0][0]^b[i][0] ^ b[0][j]^b[i][j])==1)
                    return -1;
            }
        }
    
        for (int i=0; i<b.length; i++){
            rowSum+=b[0][i];
            colSum+=b[i][0];
            if(b[i][0]==i%2)
                rowSwap ++;
            if(b[0][i]==i%2)
                colSwap ++ ;
        }
    
        if(rowSum!=b.length/2 && rowSum!=(b.length+1)/2)
            return -1;
        if(colSum!=b.length/2 && colSum!=(b.length+1)/2)
            return -1;
        if(b.length%2==1)
        {
            if(colSwap%2==1)
                colSwap=b.length-colSwap;
            if(rowSwap%2==1)
                rowSwap=b.length-rowSwap;
        } 
       else{
            colSwap=Math.min(b.length-colSwap,colSwap);
            rowSwap=Math.min(b.length-rowSwap,rowSwap);
        }
        return (colSwap+rowSwap)/2;
    }
}
