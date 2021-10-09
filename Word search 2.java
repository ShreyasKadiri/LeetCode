
class Solution {
     public List<String> findWords(char[][] board, String[] words) {
         Set<String> hashSet = new HashSet<>();
         int n = board.length;
         int m = board[0].length;
         if(n==0 || m ==0){
             return new ArrayList<>();
         }

         for(String word: words){

             for(int i=0;i<n;i++){
                 for(int j=0;j<m;j++){
                     boolean[][] visited = new boolean[n][m];
                     if(word.charAt(0) == board[i][j]){
                         if(dfs(word, 0, i, j, visited, board)){
                             hashSet.add(word);
                         }
                     }
                 }
             }
         }
         return new ArrayList<>(hashSet);
     }

     private boolean dfs(String word, int len, int i, int j, boolean[][] visited, char[][] board){
         if(len==word.length()){
             return true;
         }
         if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(len)!=board[i][j] || visited[i][j]){
             return false;
         }
         boolean res = false;
         visited[i][j] = true;
         res = dfs(word, len+1, i-1, j, visited, board) ||
             dfs(word, len+1, i+1, j, visited, board) ||
             dfs(word, len+1, i, j+1, visited, board) ||
             dfs(word, len+1, i, j-1, visited, board);

         visited[i][j] = false;

         return res;
     }
 }
