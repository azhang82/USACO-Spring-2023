import java.util.*;
import java.io.*;
public class dCollector {
		  static final String FILE_NAME = "diamond";

		  public static void main(String[] args) throws FileNotFoundException {
		    // INPUT
		    Scanner in = new Scanner(new File(FILE_NAME + ".in"));
		    int n = in.nextInt();
		    int k = in.nextInt();

		    int[] diamonds  = new int[n];
		    for (int i=0; i<=n-1; i++){
		      diamonds[i] = in.nextInt();
		    }
		    in.close();

		    int max_diamonds = 0;
		    for (int i=0; i<=n-1; i++){
		      //diamonds[i] is smallest diamond in case
		      int amt  = 0;
		      for (int j=0; j<=n-1; j++){
		        if (diamonds[j] >= diamonds[i] && diamonds[j] <= diamonds[j] + k){
		          amt++;
		        }
		      }
		      if (amt > max_diamonds){
		        max_diamonds  = amt;
		      }
		    }

		    // OUTPUT //
		    PrintWriter out = new PrintWriter(new File(FILE_NAME + ".out"));
		    out.println(max_diamonds);
		    System.out.println(max_diamonds);
		    out.close();
		  }
		/*
		 Analysis:
		 5 3 
		 1
		 6
		 4
		 3
		 1
		 */
}
