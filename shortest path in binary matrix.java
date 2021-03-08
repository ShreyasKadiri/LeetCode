class Solution {
private final int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};

public int shortestPathBinaryMatrix(int[][] grid) {
	if (grid==null || grid.length==0 || grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1){
		return -1;
    }

	Queue<int[]> queue = new LinkedList<>();
	queue.add(new int[]{0, 0});
	int k=1;
	while (!queue.isEmpty()) {
		int size=queue.size();
		for (int i=0 ; i<size; i++) {
			int[] curr=queue.poll();
			if(curr[0]==grid.length-1 && curr[1]==grid[0].length-1) {
				return k;
			}
			for(int[] direction : directions) {
				int X=curr[0]+direction[0];
				int Y=curr[1]+direction[1];
			if(X<0 || X>=grid.length || Y<0 || Y>=grid[0].length || grid[X][Y]!=0) {
					continue;
				}
				queue.offer(new int[]{X,Y});
				grid[X][Y] = 1;
			}
		}
		k++;
	}
	return -1;
 }
}
