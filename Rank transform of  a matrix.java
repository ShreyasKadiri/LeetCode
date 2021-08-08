class Solution {
    public int[][] matrixRankTransform(int[][] m) {
        int[][] rankTransform = new int[m.length][m[0].length];
        int[] maximumRankRow = new int[m.length];
        int[] maximumRankColumn = new int[m[0].length];
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                map.putIfAbsent(m[i][j], new ArrayList<>());
                map.get(m[i][j]).add(new int[] { i, j });
            }
        }
        
        // go from the lowest value key to the highest
        for (int k : map.keySet()) {
            // repeat for each value until we used all cells with the same number
            // on each step we find cells connected by row/column and calculate their rank
            while (map.get(k).size() > 0) {
                Set<Integer> rowsUsed = new HashSet<>();
                Set<Integer> columnsUsed = new HashSet<>();
                List<int[]> allSame = map.get(k);
                
                // get the first cell as the root and find all connected cells
                int[] root = allSame.get(0);
                rowsUsed.add(root[0]);
                columnsUsed.add(root[1]);
                boolean[] used = new boolean[allSame.size()];
                used[0] = true;
                // continue until we found all connected 
                while (true) {
                    int added = 0;
                    for (int i = 1; i < allSame.size(); i++) {
                        int[] n = allSame.get(i);
                        if (used[i]) continue;
						// if the cell is in the same row or column with the root or any one that is already connected with the root
                        if (rowsUsed.contains(n[0]) || columnsUsed.contains(n[1])) {
                            rowsUsed.add(n[0]);
                            columnsUsed.add(n[1]);
                            used[i] = true;
                            added++;
                        }
                    }
                    if (added == 0) break;
                }
                List<int[]> connected = new ArrayList<>();
                List<int[]> left = new ArrayList<>();
                for (int i = 0; i < allSame.size(); i++) {
                    if (used[i]) connected.add(allSame.get(i));
                    else left.add(allSame.get(i));
                }
                // put all that are not connected back to the map
                map.put(k, left);

                int rank = Integer.MIN_VALUE;
                
                // calculate the maximum rank of all connected cells
                for (int[] n : connected) {
                    rank = Math.max(rank, Math.max(maximumRankRow[n[0]], maximumRankColumn[n[1]]) + 1);
                }
                // update maxRank for all cols and rows and set the rank as answer for each connected cell
                for (int[] n : connected) {
                    maximumRankRow[n[0]] = maximumRankColumn[n[1]] = rank;
                    rankTransform[n[0]][n[1]] = rank;
                }
            }
        }
        return rankTransform;
    }
}
