class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A.length==0 || B.length==0)
            return new int[0][0];
        
        ArrayList<Integer> start= new ArrayList<Integer>();
        ArrayList<Integer> end= new ArrayList<Integer>();
        
        int i=0;
        int j=0;
        
        while(i<A.length && j<B.length){
            if(A[i][0]>B[j][1]){
                j++;
                continue;
            }
            
            if(B[j][0]>A[i][1]) {
                i++;
                continue;
            }
            
            int startA=A[i][0];
            int endA=A[i][1];
            
            int startB=B[j][0];
            int endB=B[j][1];
            
            if(startA==endB) {
                start.add(startA);
                end.add(endB);
                j++;
                continue;
            }
            
            else if(endA==startB) {
                start.add(startB);
                end.add(endA);
                i++;
                continue;
            }
            
            int interval_start=Math.max(A[i][0],B[j][0]);
            int interval_end=Math.min(A[i][1],B[j][1]);
            
            start.add(interval_start);
            end.add(interval_end);
            
            if(A[i][1]<=B[j][1])
                i++;
            else
                j++;
            
        }
        
        int size= start.size();
        int list[][]= new int[size][2];
        
        for(int k=0; k<size; k++) {
            list[k][0]=start.get(k);
            list[k][1]=end.get(k);
        }
        return list;
    }
}
