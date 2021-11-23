class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int maximum;
        public UnionFind (int n){
            parent = new int[n];
            size = new int[n];
            maximum = 1;
            for (int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int node){
            if (node == parent[node]){
                return node;
            }
            return parent[node] = find(parent[node]);
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                maximum = Math.max(maximum, size[rootY]);
            }
        }
    }
    public int largestComponentSize(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        UnionFind unionFind = new UnionFind(A.length);
        for (int i=0; i<A.length; i++){
            int currentNode = A[i];
            for (int j=2; j*j<=currentNode; j++){
                if (currentNode % j == 0){
                    if (!map.containsKey(j)){
                        map.put(j, i);
                    }else{
                        unionFind.union(i, map.get(j));
                    }
                    if (!map.containsKey(currentNode/j)){
                        map.put(currentNode/j, i);
                    }else{
                        unionFind.union(i, map.get(currentNode/j));
                    }
                }
            }
            if (!map.containsKey(currentNode)){
                map.put(currentNode, i);
            }else{
                unionFind.union(i, map.get(currentNode));
            }
        }
        return unionFind.maximum;
    }
}
