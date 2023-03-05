import java.util.*;
import java.io.*;

public class cbarn {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(new File("src/cbarn.in"));
		int rooms = in.nextInt();
		int[] counts = new int[rooms];
		int numCows = 0;
		for(int i = 0; i <= rooms-1; i++) {
			counts[i] = in.nextInt();
			numCows = numCows + counts[i];
		}
		in.close();
		int farthestRoomDist = rooms-1;
		
		int minCollectiveSteps = farthestRoomDist*numCows;
		
		for(int unlock = 0; unlock < rooms; unlock++) {
			// assume we unlock the door at index "unlock"
			//compute the distance all cows travel
			int currentDistance = 0;
				for(int offset = 0; offset < rooms; offset++) {
					// count how many cows have to walk a distance of "offset"
					currentDistance += offset * counts[(unlock+offset)%rooms];
				}
				if(currentDistance < minCollectiveSteps) {
					minCollectiveSteps = currentDistance;
				}
		}
		
		PrintWriter out = new PrintWriter(new File("cbarn.out"));
		out.println(minCollectiveSteps);
		System.out.println(minCollectiveSteps);
		
		// Given number of rooms and number of cows to end up each room
		// Find min  number of steps the cows need to walk.
		/* 
		 * 5 number of rooms
		 * 4 number of cows wanted in room a
		 * 7 number of cows wanted in room b
		 * 8 number of cows wanted in room c
		 * 6 number of cows wanted in room d
		 * 4 number of cows wanted in room e
		 
		 |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
		 
		 a	b	c	d	e	<-- room ids
		 4	7	8	6	4  <-- room counts
		 
		 Entering Room a:
		 4 cows would walk 0 steps
		 Room b:
		 7 cows would walk 1 step
		 Room c:
		 8 cows would walk 2 steps
		 Room d: 
		 6 cows would walk 3 steps
		 Room e:
		 4 cows would walk 4 steps
		 
		 4(0) + 7(1) + 8(2) + 6(3) + 4(4) = 57 steps
	
		 Entering room b: 
    	7(0) + 8(1) + 6(2) + 4(3) + 4(4) = 48 steps 
		
		Entering room c:
		8(0) + 6(1) + 4(2) + 4(3) + 7(4) = 54 steps
		
		
		Entering room d:
		6(0) + 4(1) + 4(2) + 7(3) + 8(4) = 65 steps
		
		Entering room e:
		4(0) + 4(1) + 7(2) + 8(3) + 6(4) = 66 steps
		
		Use %
		total_steps = 0
		steps = 0 --> 4
		total_steps=total_steps + steps(cows_in_room)
		
		 */
	}
}