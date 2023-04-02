import java.util.*;
import java.io.*;

public class circularCross {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("circlecross.in"));
		String circle = in.next();
		// when we read integers, we use in.next();
		// in.nextString() doesn't exist
		in.close();
		int result = 0;
		
		for (char first = 'A'; first <= 'Z'; first++) {
            // how can we loop through chars using operations like <= and ++?
            // because they are NUMBERS!   www.asciitable.com
            
            // goal: count how many other letters are between two instances
            //    of our chosen "first letter in the pair"
            //    (each of those other letters occurring one time, could each
            //     be the second letter in a crossing pair with the first letter)
            
            int firstLeft = circle.indexOf(first);
            int firstRight = circle.lastIndexOf(first);
            //                     .indexOf(first, firstLeft+1)
            
            int[] counts = new int[26];
            // index: 0-25 representing A-Z
            // value: how many times does that letter occur b/w firstLeft & firstRight
            
            for (int i = firstLeft+1; i < firstRight; i++) {
                int countIndex = circle.charAt(i) - 'A';
                
                counts[countIndex]++;
            }
            
            // count how many letters (cows) occurred once b/w first cow's letters
            for (int i = 0; i < 26; i++) {
                if (counts[i] == 1) result++;
            }
        }
        // converting number of cows to the number of paths crossed
        result /= 2;
        
		
		
		PrintWriter out = new PrintWriter(new File("circlecross.out"));
		out.println(result);
		System.out.println(result);
		out.close();
		
	}
	
}
/*
 
 
 Algorithm: 
 BRUTE FORCE OUTLINE
for every first letter in the pair  - 26
    for every second letter that could be pair with it - 25
        for every letter in circle, if it's one of those two, put it into a string - 52
        check if it's alternating (check if 1st and 3rd are same), if so count it
        
    TOTAL: 26*25*(52+2) = 35,100 < 1 million
    
    
    OPTIMIZATION
    for every letter of alphabet - 26
        ex:   ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ and letter A is chosen
                        how many crossing pairs is letter A part of?
              ^   ^
              
              
        ex:   ABCACBDDEEFF    chosen letter is A again
                        how many crossing pairs is letter A part of?
              ^  ^
              
        ex:   ABCXYXYACBDDEEFF
              ^      ^
    
        set up some kind of array/map/set to track counts per letter
        for every letter in circle sequence - 52
            count that letter if it's in b/w two instances of chosen letter
            
        follow up with the data found in inner loop, to draw conclusions
            count every other letter that occurred once b/w two instances of chosen letter


    1 billion rule
    - 1 billion steps is TOO SLOW
    - 100 million steps is in danger zone
    - 10 million steps probably fine
    - 1 million steps is almost definitely great
        

Analysis: 

SAMPLE INPUT:
ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ


mini-sample data:
ABCCABDD

        A       B
    D   \       /   C
    |        x      |
    D    /      \   C
        B       A
        
       exactly 1 pair crosses
       
       => output must be 1 
        
*/
