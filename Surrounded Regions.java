class Solution {
public void solve(char[][] board) {
for(int i=0; i<board.length; i++){
 	for(int j=0; j<board[0].length; j++){
 	if(board[i][j]=='O' && (i==0 || i==board.length-1 || j==0 || j==board[0].length-1))
 			solve(i,j,board);
 			}
 		}
 		for(int i=0; i<board.length; i++){
 			for(int j=0; j<board[0].length; j++){
 				if(board[i][j]=='O')
 					board[i][j]='X';
 				else if(board[i][j]=='1')
 					board[i][j]='O';
 			}
 		}
 	}

public void solve(int i, int j, char[][] board){
 	if(i<0 || i>=board.length || j<0  || j>=board[0].length || board[i][j]!='O') return;
 	if(board[i][j]=='O')  board[i][j]='1';
 	solve(i-1,j,board);
 	solve(i+1,j,board);
 	solve(i,j-1,board);
 	solve(i,j+1,board);
  }
 }