// "Fence Painting"

// http://usaco.org/index.php?page=viewproblem2&cpid=567



import java.util.*;

import java.io.*;



public class fpainting {

  static final String FILE_NAME = "src/paint";



  public static void main(String[] args) throws FileNotFoundException {

    // INPUT //

    // TODO: Complete this section!

    Scanner in = new Scanner(new File(FILE_NAME + ".in"));

    int[] allNum = new int[4];
    
    for(int i = 0; i < allNum.length; i++) {
    	allNum[i] = in.nextInt();
    }
    
    
    in.close();



    // CALCULATION //

    // TODO: Set up any additional data structures you'll need
    //   to solve the problem!
    
    int result = 0;
    int min = allNum[0]; 
    int max = allNum[0];
    // loop to find max 
    for(int i = 0; i < allNum.length; i++) {
    	 if (allNum[i] > max) {
             max = allNum[i];
    	 }
    }
    // loop to find min
    for(int i = 0 ; i < allNum.length; i++) {
    	 if (allNum[i] < min)
             min = allNum[i];
    }
    result = Math.abs(min-max);

    // OUTPUT //

    PrintWriter out = new PrintWriter(new File(FILE_NAME + ".out"));

    out.println(result);

    System.out.println(result);

    out.close();

  }

}
