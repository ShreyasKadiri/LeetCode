class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int directions[][] = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                     queue.offer(new int[] {i,j,0});
                }
            }
        }
        
        while (!queue.isEmpty()){
            int[] currentNode = queue.poll();
            int i = currentNode[0];
            int j = currentNode[1];
            int distance = currentNode[2];
            if (visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            if(matrix[i][j] != 0){
                matrix[i][j] = distance;
            }
            for (int[] direction : directions){
                int X = direction[0]+i;
                int Y = direction[1]+j;
                if (X<0 || Y<0|| X>=matrix.length || Y>=matrix[0].length || visited[X][Y]|| matrix[X][Y] == 0){
                    continue;
                }
                queue.offer(new int[] {X, Y, distance+1});
            }
        }
        return matrix;
    }
}
