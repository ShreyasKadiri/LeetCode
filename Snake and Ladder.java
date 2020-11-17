import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadder {
	
	static class Cell {
		int cellNumber;
		int hopCount;
	}

	public static int getMinDiceThrows(int [] moves,int N) {
		boolean visited[]=new boolean[N];
		Arrays.fill(visited, false);
		Queue<Cell> q=new LinkedList<SnakesAndLadder.Cell>();
		
		Cell cell=new Cell();
		cell.cellNumber=0;
		cell.hopCount=0;
		visited[0]=true;
		q.offer(cell);
		
		Cell currentCell=null;
		while(!q.isEmpty()) {
			currentCell=q.poll();
			int index=currentCell.cellNumber;
			
			if(index==N-1)
				break;
			
			for(int i=index+1;i<=(index+6) && i<N;i++) {
				if(visited[i]==false) {
					Cell newCell=new Cell();
					newCell.hopCount=currentCell.hopCount+1;
					visited[i]=true;
					if(moves[i]!=-1)
						newCell.cellNumber=moves[i];
					else
						newCell.cellNumber=i;
					
					q.offer(newCell);
					
				}
			}	
		}
		
		return currentCell.hopCount;
	}
	public static void main(String[] args) {
		
		// Let us construct the board given in above diagram 
        int N = 30; 
        int moves[] = new int[N]; 
        for (int i = 0; i < N; i++) 
            moves[i] = -1; 
  
        // Ladders 
        moves[2] = 21; 
        moves[4] = 7; 
        moves[10] = 25; 
        moves[19] = 28; 
  
        // Snakes 
        moves[26] = 0; 
        moves[20] = 8; 
        moves[16] = 3; 
        moves[18] = 6; 
  
        System.out.println("Min Dice throws required is " +  
                          getMinDiceThrows(moves, N)); 

	}

}
