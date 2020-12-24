class UF {
    int[] parent;
    
    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        return parent[x] = parent[x] == x ? x : find(parent[x]);
    }
    
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UF uf = new UF(n);
        boolean[] res = new boolean[queries.length];
        int m = edgeList.length;
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));
        int i = 0;
        for (int[] query : queries) {
            while (i < m && edgeList[i][2] < query[2]) {
                uf.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            res[query[3]] = uf.find(query[0]) == uf.find(query[1]);
        }
        return res;
    }
}
