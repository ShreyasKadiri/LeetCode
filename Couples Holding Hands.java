class Solution {
    public class UnionFind {
        int[] connectedComponents;
        int count;
        UnionFind(int n)
        {
            connectedComponents=new int[n];
            for(int i=0; i<n; i++) {
                connectedComponents[i]=i;
            }
            count=n;
        }
       
        private int find(int i){
            if (connectedComponents[i]==i) {
                return i;
            }
            connectedComponents[i]=find(connectedComponents[i]);
            return connectedComponents[i];
        }
       
        public void union(int i, int j) {
            int a=find(i);
            int b=find(j);
            if (a!=b) {
                connectedComponents[a]=b;
                count--;
            }
        }
    }
    
    public int minSwapsCouples(int[] row) {
        int N=row.length/ 2;
        UnionFind unionFind=new UnionFind(N);
        for (int i=0; i<N; i++) {
            int a=row[2*i];
            int b=row[2*i + 1];
            unionFind.union(a/2,b/2);
        }
        return N-unionFind.count;
    }
} 
