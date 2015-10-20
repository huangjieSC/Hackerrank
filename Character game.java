import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            String line = s[0];
            
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < line.length(); i++) {
                
                if (map.containsKey(line.charAt(i))) {
                    map.put(line.charAt(i), map.get(line.charAt(i)) + 1);
                } else {
                    map.put(line.charAt(i), 1);
                }
            }
            
            for (int i = 0; i < line.length(); i++) {
                if (map.get(line.charAt(i)) == 1) {
                    System.out.println(line.charAt(i));
                    break;
                }
            }
        }
        sc.close();
    }
}
