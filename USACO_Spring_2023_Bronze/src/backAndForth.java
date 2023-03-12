import java.util.*;
import java.io.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=857
public class backAndForth {
		  public static void main(String[] args) throws Exception {
			  	Scanner in = new Scanner(new File("src/backforth.in"));
			  	int[] bucksA = new int[10];
			  	int[] bucksB = new int[11];
			  	//stores carrying capacity of buckets in each barn 
			  	
			  	for(int i  = 0; i < 10; i++ ) {
			  		bucksA[i] = in.nextInt();
			  	}
			  	for(int i = 0; i < 10; i++) {
			  		bucksB[i] = in.nextInt();
			  	}
			  	in.close();
			  	boolean[] possQuants = new boolean[2000];
			  	//index quantity of milk that may be possible in tank A after
			  	// Friday, value : true if possible, false if not known to be possible
			  	int tankA = 1000;
			  	
			  	 for (int tue = 0; tue < 10; tue++){
			            int tueAmt = bucksA[tue]; 
			            
			            bucksA[tue] = 0;
			            bucksB[10] = tueAmt; 
			            tankA -= tueAmt; 
			            
			            for (int wed  = 0; wed < 11; wed++) {
			            		int wedAmt = bucksB[wed];
			            		
			            		bucksB[wed] = 0;
			            		bucksB[tue] = wedAmt;
			            		tankA += wedAmt;
			            		
			            		for(int thu = 0; thu < 10; thu++) {
			            			int thuAmt = bucksA[thu];
			            			
			            			bucksA[thu] = 0;
			            			bucksB[wed] = thuAmt;
			            			tankA -= thuAmt;
			            			
			            		
			            			for(int fri = 0; fri < 11; fri++) {
			            				int friAmt = bucksB[fri];
			            				tankA += friAmt;
			            				possQuants[tankA] = true;
			            				
			            				tankA -= friAmt; // undoing friday
			            				
			            				}		
			            			
		            			// Undo Thursday
			            			bucksA[thu] = thuAmt;
			            			bucksB[wed] = 0;
			            			tankA += thuAmt;
			            			
			            		}
			            		// Undo Wednesday
			            		bucksB[wed]  = wedAmt;
			            		bucksA[tue] = 0;
			            		tankA  -= wedAmt;
			            }
			            // Undo Tuesday
			            bucksA[tue] = tueAmt;
			            bucksB[10] = 0;
			            tankA += tueAmt;
			  	 }
			  	 int result = 0;
			  	 for(int i = 0; i < 2000; i++) {
			  		 if(possQuants[i]) {
			  			 result++;
			  		 }
			  	 }
			  	 PrintWriter out = new PrintWriter(new File("backforth.out"));
			  	 System.out.println(result);
			  	 out.println(result);
			  	 out.close();
	  	}		
}


/*
ANALYSIS: 

sample data:
1 1 1 1 1 1 1 1 1 2
5 5 5 5 5 5 5 5 5 5

choices across 4 days: 10 * 11 * 10 * 11  = 12,100

alternate data with only 3 buckets per barn: 

buckets in A: 1 1 2
buckets in B: 5 5 5

keep track of possible quantities of milk in barn A at end of day on Friday

Simulation:

tankA = 1000 gal

tues: pick A[0], which carries 1 gal 
		A = 1 2
		B = 5 5 5 1
	tankA = 1000 - 1 gal = 999 gal
	
Wed: pick B[0], which carries 5 gal
		A = 1 2 5
		B = 5 5 1
		tankA = 999 + 5 = 1004
		
Thurs: pick A[0], which carries 1 gal
		A = 2 5 
		B = 5 5 1 1
		tankA = 1004 - 1 = 1003
Fri: pick B[0], which carries 5 gal
		A = 2 5 5
		B = 5 1 1
		tankA = 1003 + 5 = 1008
		possibleQuantities[1008] = true
		
		undo Friday
		undo Thursday
		undo Wednesday 
		undo Tuesday
		
	 Check how many values are true in possibleQuantities
	 
	 indexing into an array is very fast
	 indexting from 0 to 1; same as 0 to 1008
	 
*/
