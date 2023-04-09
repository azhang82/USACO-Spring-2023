import java.util.*;
import java.io.*;

/*
 AAA
 AAA
 AAA
 
 1 1cow team to claim victory
 2 2cow teams to claim victory
 */
public class tttt {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner (new File("tttt.in"));
		PrintWriter out = new PrintWriter(new File("tttt.out"));
        
        char[][] board = new char[3][]; // new roll is null
        for(int i = 0; i < 3; i++) {
        	String row = in.next();
        	char[] rowArray = row.toCharArray();
        	board[i] = rowArray;
        }
        
        int count = 0;
        int countSingle = 0;
        int countDouble = 0;
        // loop through the diff possible assignments of teamA and teamB of 'A' through 'Z'
        for(char teamA = 'A'; teamA <= 'Z'; teamA++) {
            for(char teamB = teamA; teamB <= 'Z'; teamB++) {
                if(win(board, teamA, teamB)) {
                    if(teamA == teamB) {
                        countSingle++;
                    }
                    else {
                        countDouble++;
                    }
                }
            }
        }
        
        System.out.println(countSingle);
        System.out.println(countDouble);
        
        out.println(countSingle);
        out.println(countDouble);
        
        in.close();
        out.close();
	}
	
	// win(board, 'A', 'A' )
	// can the given team win on the board
	static boolean win(char[][] board, char teamA, char teamB) {
		// 3 rows, 3 columns, 2 diagonals 
		
	    int[][][] checks = {
	            {{0, 0}, {0, 1}, {0, 2}}, // indices of row 0
	            {{1, 0}, {1, 1}, {1, 2}}, // indices of row 1
	            {{2, 0}, {2, 1}, {2, 2}}, // indices of row 2
	            
	            {{0, 0}, {1, 0}, {2, 0}}, // indices of col 0
	            {{0, 1}, {1, 1}, {2, 1}}, // indices of col 1
	            {{0, 2}, {1, 2}, {2, 2}}, // indices of col 2
	            
	            {{0, 0}, {1, 1}, {2, 2}}, // diag \
	            {{0, 2}, {1, 1}, {2, 0}}, // diag /
	    };
	    for(int[][] check : checks) {
	    	// check is 3x2
	    	int count = 0;
	    	for(int[] cell : check) {
                int r = cell[0];
                int c = cell[1];
                
                if(board[r][c] == teamA || board[r][c] == teamB) {
                    count++;
                }
            }
	    		if(count == 3) {
	    			return true;
	    		}
        	}	 
	    	return false;	
	}
}
