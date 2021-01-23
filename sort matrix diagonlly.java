class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>>map = new HashMap<>();
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++){
                if(!map.containsKey(i-j)) 
                    map.put(i-j, new PriorityQueue<>());
                map.get(i-j).add(mat[i][j]);
            }
        }
        
        for(int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                mat[i][j]=map.get(i-j).poll();
            }
        }
        return mat;
    }
}
