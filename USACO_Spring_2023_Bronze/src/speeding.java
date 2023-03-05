import java.util.*;
import java.io.*;
// (remember to look up official documentation on any classes you use if needed)

public class speeding {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("src/speeding.in"));
        int n = in.nextInt();   // number of sections of speed limit data
        int m = in.nextInt(); // number of sections of tractor speed data

        //TODO: Read more Data
        int[] limits  = new int[100];
        int[] speeds  = new int[100];
        //index of each array: starting mile marker on the roadway
        //        index 0 has data for the mile of road from 0 to 1
        //        index 99 has data for the mile of road from 99 to 100

        //Populating limits array
        int mi = 0; //track progress along road
        for (int i=0; i < n; i++){
            //i represented one section of rd
            int len  = in.nextInt();
            int limit  = in.nextInt();

            for (int j=0; j<len; j++){
                //j represents the data for each mile in this section
                limits[mi] = limit;
                mi++;
            }
        }


        //Populate the speeds array
        mi  = 0; //tracks progress along road
        for (int i=0; i<m; i++){
            int len  = in.nextInt();
            int tractor_speed = in.nextInt();
            for (int j=0; j<len; j++){
                speeds[mi] = tractor_speed;
                mi++;
            }
        }

        in.close();

        int result = 0;
        for (int i = 0; i < 100; i++) {
            int over = speeds[i] - limits[i];
            result = Math.max(result, over);
        }

        PrintWriter out = new PrintWriter(new File("speeding.out"));
        out.println(result);

        System.out.println(result);
        out.close();
    }
  }



/* ANALYSIS

3 3       N=3 sections of speed limit data, M=3 sections of tractor speed data
40 75     40 miles of speed limit 75mph
50 35     50 miles of speed limit 35mph
10 45     10 miles speed limit 45mph

40 76     40 miles where tractor drove 76mph
20 30     20 miles where tractor drove 30mph
40 40     40 miles where tractor drove 40mph

FOR NEXT TIME: propose a way to picture this data clearly so we can see
    how the answer can be determined


*/