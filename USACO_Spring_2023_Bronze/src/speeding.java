// "Fence Painting"

// http://usaco.org/index.php?page=viewproblem2&cpid=567



import java.util.*;

import java.io.*;

public class speeding {

  static final String FILE_NAME = "paint";



  public static void main(String[] args) throws FileNotFoundException {

    // INPUT //

    // TODO: Complete this section!

    Scanner in = new Scanner(new File(FILE_NAME + ".in"));

    int n = in.nextInt();

    in.close();



    // CALCULATION //

    // TODO: Set up any additional data structures you'll need

    //   to solve the problem!

    int result = 0;



    // OUTPUT //

    PrintWriter out = new PrintWriter(new File(FILE_NAME + ".out"));

    out.println(result);

    System.out.println(result);

    out.close();

  }

}
